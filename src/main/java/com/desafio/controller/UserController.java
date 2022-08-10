package com.desafio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.entities.Album;
import com.desafio.entities.Comment;
import com.desafio.entities.Photo;
import com.desafio.service.AlbumService;
import com.desafio.service.CommentService;
import com.desafio.service.PhotoService;
import com.desafio.service.PostService;
import com.desafio.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	AlbumService albumService;

	@Autowired
	PhotoService photoService;

	@Autowired
	PostService postService;

	@Autowired
	CommentService commentService;

	@GetMapping("")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/{idUser}/photo")
	public ResponseEntity<?> getPhotos(@PathVariable(value = "idUser") Long idUser) {
		List<Photo> photos = new ArrayList<Photo>();
		this.albumService.getAlbums(idUser).forEach((Album a) -> photos.addAll(this.photoService.getPhotos(a.getId())));
		return new ResponseEntity<>(photos, HttpStatus.OK);
	}

	@GetMapping("/{userId}/comments")
	public ResponseEntity<?> getComments(@PathVariable(value = "userId") Long userId,
			@RequestParam(required = false) String name, @RequestParam(required = false) String mail) {

		List<Comment> comments = new ArrayList<Comment>();
		Predicate<Comment> filtro = new Predicate<Comment>() {
			@Override
			public boolean test(Comment t) {
				return false;
			}
		};

		this.postService.getPosts(userId).forEach(p -> comments.addAll(this.commentService.getCommentss(p.getId())));

		if (name != null) {
			filtro = (c) -> c.getName().equals(name);
			return new ResponseEntity<>(comments.stream().filter(filtro), HttpStatus.OK);
		}

		if (mail != null) {
			filtro = (c) -> c.getEmail().equals(mail);
			return new ResponseEntity<>(comments.stream().filter(filtro), HttpStatus.OK);
		}

		return new ResponseEntity<>(comments, HttpStatus.OK);
	}

}
