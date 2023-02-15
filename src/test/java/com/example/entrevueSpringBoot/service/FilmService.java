package com.example.entrevueSpringBoot.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entrevueSpringBoot.dto.ReponseFilm;
import com.example.entrevueSpringBoot.dto.RequeteCreationFilm;
import com.example.entrevueSpringBoot.model.Film;
import com.example.entrevueSpringBoot.repository.FilmRepo;


@Service
public class FilmService {

	  @Autowired
	  private FilmRepo filmRepo;
	  
	  public ReponseFilm getFilmById(Integer id) {
		  
		    Optional<Film> film = filmRepo.findById(new BigDecimal(id));
			
			if (film.isPresent()) {
				ReponseFilm reponseFilm = FilmMapper.INSTANCE.toReponseFilm(film.get());
				return reponseFilm;
			}
			return null;
	  }
	  
	  public ReponseFilm save(RequeteCreationFilm requete) {
		  
		  	Film film = FilmMapper.INSTANCE.toFilm(requete);
		    film = filmRepo.save(film);
			return FilmMapper.INSTANCE.toReponseFilm(film);
	  }
}
