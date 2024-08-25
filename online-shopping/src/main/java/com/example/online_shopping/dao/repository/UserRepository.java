package com.example.online_shopping.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_shopping.dao.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findById(Long id);

	Optional<User> findByEmail(String email);
}
