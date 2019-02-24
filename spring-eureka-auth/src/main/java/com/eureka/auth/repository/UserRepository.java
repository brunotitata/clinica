package com.eureka.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eureka.auth.model.UserApp;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Integer> {

	Optional<UserApp> findByUsername(String username);

	Optional<UserApp> findByUsernameAndPassword(String username, String password);

}
