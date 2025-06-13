package com.gp.nut.usermanagement.auth.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}
