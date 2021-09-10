package com.almightyjava.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almightyjava.domain.User;
import com.almightyjava.service.IService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IService<User> userService;

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") UUID id) {
		return ResponseEntity.ok(userService.deleteById(id));
	}

	@PutMapping
	public ResponseEntity<User> update(@RequestBody User user) {
		return ResponseEntity.ok(userService.update(user));
	}

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		return ResponseEntity.ok(userService.save(user));
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<User> findById(@PathVariable("id") UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id).get());
	}
}
