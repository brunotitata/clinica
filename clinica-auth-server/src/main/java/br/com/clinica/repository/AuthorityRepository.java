package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {

}
