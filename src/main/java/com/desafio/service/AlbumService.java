package com.desafio.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.entities.Album;

@Service
public class AlbumService {

	@Autowired
	RestTemplate restTemplate;

	public List<Album> getAlbumsByUser(Long idUser) {
		ResponseEntity<Album[]> response = restTemplate
				.getForEntity("https://jsonplaceholder.typicode.com/albums?userId=" + idUser, Album[].class);
		Album[] albums = response.getBody();
		List<Album> m = Arrays.asList(albums);
		return m;
	}
}
