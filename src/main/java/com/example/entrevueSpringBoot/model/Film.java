package com.example.entrevueSpringBoot.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "film")
@Setter
@Getter
@ToString
public class Film  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigDecimal id;
	private String titre;
	private String description;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private Set<Acteur> acteurs = new HashSet();
}
