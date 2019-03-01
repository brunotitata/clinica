package com.eureka.zuul.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eureka.zuul.configuration.jwt.JwtProvider;
import com.eureka.zuul.exceptions.ArgumentInvalidException;
import com.eureka.zuul.exceptions.ExistingEmailException;
import com.eureka.zuul.exceptions.IllegalRoleException;
import com.eureka.zuul.model.Role;
import com.eureka.zuul.model.Role.RoleName;
import com.eureka.zuul.model.User;
import com.eureka.zuul.repository.RoleRepository;
import com.eureka.zuul.repository.UserRepository;
import com.eureka.zuul.request.LoginData;
import com.eureka.zuul.request.RegisterData;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    public User registerUser(RegisterData registerData) throws Exception {

        verificationAndValidation(registerData);

        User user = new User(registerData.getName(), registerData.getLastName(),
                registerData.getEmail(),
                encoder.encode(registerData.getPassword()));

        Set<String> strRoles = registerData.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
            case "admin":
                Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                        .orElseThrow(() -> new IllegalRoleException(
                                "Fail! -> Cause: User Role not find."));
                roles.add(adminRole);

                break;
            case "support":
                Role supportRole = roleRepository
                        .findByName(RoleName.ROLE_SUPPORT)
                        .orElseThrow(() -> new IllegalRoleException(
                                "Fail! -> Cause: User Role not find."));
                roles.add(supportRole);

                break;
            case "user":
                Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                        .orElseThrow(() -> new IllegalRoleException(
                                "Fail! -> Cause: User Role not find."));
                roles.add(userRole);

                break;
            default:
                throw new IllegalRoleException(
                        "Fail! -> Cause: User Role invalid.");
            }
        });

        user.setRoles(roles);
        userRepository.save(user);
        return user;

    }

    private void verificationAndValidation(RegisterData registerData) {
        if (StringUtils.isBlank(registerData.getName())
                || StringUtils.isBlank(registerData.getLastName())
                || StringUtils.isBlank(registerData.getEmail())
                || StringUtils.isBlank(registerData.getPassword())) {

            throw new ArgumentInvalidException(
                    "Os campos de cadastro não pode ser nulos ou vazios.");
        }

        if (userRepository.existsByEmail(registerData.getEmail())) {
            throw new ExistingEmailException(
                    "Fail -> Email is already in use!");
        }
    }

    public String authenticateUser(LoginData loginData) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginData.getEmail(),
                        loginData.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateJwtToken(authentication);

    }
}
