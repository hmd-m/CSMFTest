/**
 * 
 */
package com.example.entrevueSpringBoot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.entrevueSpringBoot.dto.ReponseFilm;
import com.example.entrevueSpringBoot.dto.RequeteCreationFilm;
import com.example.entrevueSpringBoot.service.FilmService;

/**
 * @author hamid
 *
 */
public class FilmController implements FilmApi {
	
	 @Autowired
	 private FilmService filmService;

	@Override
	public ResponseEntity<ReponseFilm> creeFilm(RequeteCreationFilm requeteCreationFilm) {
		try {
			return new ResponseEntity<>(filmService.save(requeteCreationFilm), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ReponseFilm> obtenirFilm(Integer id) {
		
	   Optional<ReponseFilm> film  = Optional.ofNullable(filmService.getFilmById(id));
	   if (film.isPresent()) {
			return new ResponseEntity<>(film.get(), HttpStatus.OK);
	   }
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
