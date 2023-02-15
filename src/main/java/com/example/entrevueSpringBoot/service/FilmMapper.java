package com.example.entrevueSpringBoot.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.entrevueSpringBoot.dto.ReponseActeur;
import com.example.entrevueSpringBoot.dto.ReponseFilm;
import com.example.entrevueSpringBoot.dto.RequeteCreationAuteur;
import com.example.entrevueSpringBoot.dto.RequeteCreationFilm;
import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;

@Mapper
public interface FilmMapper {
	
	 FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);
	 
	 @Mapping(target="id", source="entity.id")
	 @Mapping(target="titre", source="entity.titre")
	 @Mapping(target="description", source="entity.description")
	 public ReponseFilm toReponseFilm(Film entity);
	 
	 
	 @Mapping(target="id", source="dto.id")
	 @Mapping(target="titre", source="dto.titre")
	 @Mapping(target="description", source="dto.description")
	 public Film toFilm(RequeteCreationFilm dto);
	 
	 @Mapping(target="id", source="entity.id")
	 @Mapping(target="nom", source="entity.nom")
	 @Mapping(target="prenom", source="entity.prenom")
	 public ReponseActeur toReponseActeur(Acteur entity);
	 
	 @Mapping(target="id", source="dto.id")
	 @Mapping(target="nom", source="dto.nom")
	 @Mapping(target="prenom", source="dto.prenom")
	 public Acteur ToActeur(RequeteCreationAuteur dto);

}
