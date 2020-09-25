package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
