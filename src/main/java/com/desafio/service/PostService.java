package com.desafio.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.entities.Post;

@Service
public class PostService {

	@Autowired
	RestTemplate restTemplate;

	public List<Post> getPosts(Long userId) {
		Post[] posts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts?userId=" + userId,
				Post[].class);
		List<Post> p = Arrays.asList(posts);
		return p;
	}
}
