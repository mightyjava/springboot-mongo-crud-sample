package com.almightyjava.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.almightyjava.domain.User;

public interface UserRepository extends MongoRepository<User, UUID> {

}
