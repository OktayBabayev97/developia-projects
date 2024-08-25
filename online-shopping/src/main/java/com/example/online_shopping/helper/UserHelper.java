package com.example.online_shopping.helper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.online_shopping.constants.ExceptionMessages;
import com.example.online_shopping.dao.entity.User;
import com.example.online_shopping.dao.repository.UserRepository;
import com.example.online_shopping.exceptions.NotFoundException;
@Component
public class UserHelper {
	@Autowired
	private UserRepository userRepository;

	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new NotFoundException(ExceptionMessages.USER_NOT_FOUND);
		}
		return user.get();
	}
}
