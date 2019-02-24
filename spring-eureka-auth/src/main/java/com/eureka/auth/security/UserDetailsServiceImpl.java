package com.eureka.auth.security;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eureka.auth.model.UserApp;
import com.eureka.auth.service.UserService;

@Service // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserService userService;

	public UserDetailsServiceImpl(@Lazy UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// hard coding the users. All passwords must be encoded.
		for (UserApp appUser : userService.findAllUser()) {
			if (appUser.getUsername().equals(username)) {

				// Remember that Spring needs roles to be in this format: "ROLE_" + userRole
				// (i.e. "ROLE_ADMIN")
				// So, we need to set it to that format, so we can verify and compare roles
				// (i.e. hasRole("ADMIN")).
				List<GrantedAuthority> grantedAuthorities = AuthorityUtils
						.commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());

				// The "User" class is provided by Spring and represents a model class for user
				// to be returned by UserDetailsService
				// And used by auth manager to verify and check user authentication.
				return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
			}
		}

		// If user not found. Throw this exception.
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

}