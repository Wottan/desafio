package com.desafio.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.entities.User;

@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;

	public List<User> getUsers() {
		User[] user = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", User[].class);
		List<User> users = Arrays.asList(user);
		return users;
	}

}
