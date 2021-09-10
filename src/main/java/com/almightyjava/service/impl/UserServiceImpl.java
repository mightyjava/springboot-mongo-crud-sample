package com.almightyjava.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almightyjava.domain.User;
import com.almightyjava.exception.DataException;
import com.almightyjava.repository.UserRepository;
import com.almightyjava.service.IService;

@Service
public class UserServiceImpl implements IService<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(UUID id) {
		return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new DataException("Invalid User ID")));
	}

	@Override
	public String deleteById(UUID id) {
		Optional<User> user = findById(id);
		userRepository.delete(user.get());
		return "User Deleted Successfully";
	}

	@Override
	public User save(User user) {
		user.setId(UUID.randomUUID());
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

}
