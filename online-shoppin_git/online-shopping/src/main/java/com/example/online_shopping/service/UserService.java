package com.example.online_shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.online_shopping.constants.Role;
import com.example.online_shopping.dao.entity.User;
import com.example.online_shopping.dao.repository.UserRepository;
import com.example.online_shopping.helper.UserHelper;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserHelper userHelper;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User getUserById(Long userId) {
		User user = userHelper.getUserById(userId);
		return user;
	}

	public User createAdmin(User user) {
		user.setRole(Role.ADMIN);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public User createUser(User user) {
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public User updateUser(Long userId, User newUser) {
		User existigUser = userHelper.getUserById(userId);
		existigUser.setUsername(newUser.getUsername());
		existigUser.setPassword(newUser.getPassword());
		existigUser.setEmail(newUser.getEmail());
		userRepository.save(existigUser);
		return existigUser;

	}

	public void deleteUser(Long userId) {
		User user = userHelper.getUserById(userId);
		userRepository.deleteById(user.getId());
	}

}
