package com.almightyjava.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "user")
public class User {

	@Id
	private UUID id;
	private String userName;
	private String fullName;
	private String email;
	private String password;

}
