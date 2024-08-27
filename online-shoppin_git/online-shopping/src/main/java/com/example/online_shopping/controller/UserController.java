package com.example.online_shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_shopping.dao.entity.User;
import com.example.online_shopping.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/admin/create")
	public User createAdmin(@RequestBody User user) {
		return userService.createAdmin(user);
	}

	@PostMapping("/user/create")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		return userService.updateUser(userId, newUser);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
}
