package com.eureka.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eureka.auth.exception.UserNotFoundException;
import com.eureka.auth.model.UserApp;
import com.eureka.auth.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserApp findUser(String username) {

		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException("Usuario ou senha invalida."));
	}

	public List<UserApp> findAllUser() {
		return userRepository.findAll();
	}

}
