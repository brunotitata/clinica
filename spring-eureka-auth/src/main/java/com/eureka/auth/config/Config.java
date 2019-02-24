package com.eureka.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eureka.common.security.JwtConfig;

@Configuration
public class Config {

	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}

}
