package com.eureka.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.eureka.zuul.filters.AccessLogFilter;
import com.eureka.zuul.filters.StaticFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy

public class SpringZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZuulApplication.class, args);
	}

	@Bean
	public AccessLogFilter accessLogFilter() {
		return new AccessLogFilter();
	}

	@Bean
	public StaticFilter staticFilter() {
		return new StaticFilter();
	}
}