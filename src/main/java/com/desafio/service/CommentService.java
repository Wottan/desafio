package com.desafio.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.entities.Comment;

@Service
public class CommentService {

	@Autowired
	RestTemplate restTemplate;

	public List<Comment> getCommentsByPost(Long postId) {
		Comment[] comments = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments?postId=" + postId,
				Comment[].class);
		List<Comment> c = Arrays.asList(comments);
		return c;
	}

	public List<Comment> getComments() {
		Comment[] comments = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments",
				Comment[].class);
		List<Comment> c = Arrays.asList(comments);
		return c;
	}
}
