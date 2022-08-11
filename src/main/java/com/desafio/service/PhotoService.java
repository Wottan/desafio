package com.desafio.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.entities.Photo;

@Service
public class PhotoService {

	@Autowired
	RestTemplate restTemplate;

	public List<Photo> getPhotosByAlbum(Long idAlbum) {
		ResponseEntity<Photo[]> response = restTemplate
				.getForEntity("https://jsonplaceholder.typicode.com/photos?albumId=" + idAlbum, Photo[].class);
		Photo[] photos = response.getBody();
		List<Photo> m = Arrays.asList(photos);
		return m;
	}
}
