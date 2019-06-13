package io.swagger.dao;

import io.swagger.model.ApplicationUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserDAO extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}