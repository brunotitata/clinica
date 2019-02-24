package com.eureka.auth.model;

import java.util.Optional;

public enum Role {

	USER, ADMIN;

	public static Role findByRole(String role) throws Exception {
		return Optional.ofNullable(Role.valueOf(role)).orElseThrow(() -> new Exception("Role não encontrada: " + role));
	}

}
