package com.example.entrevueSpringBoot.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="acteur")
@Setter
@Getter
@ToString	
public class Acteur implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigDecimal id;
	private String nom;
	private String prenom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="film_id")
    private Film film;
}
