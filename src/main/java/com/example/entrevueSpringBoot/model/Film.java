package com.example.entrevueSpringBoot.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="film")
@Setter
@Getter
@ToString
public class Film {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;
	@OneToMany(mappedBy = "film")
	private Collection<Acteur> acteurs;
}
