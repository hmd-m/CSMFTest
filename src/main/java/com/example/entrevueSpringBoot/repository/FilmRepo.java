package com.example.entrevueSpringBoot.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entrevueSpringBoot.model.Film;

@Repository
public interface FilmRepo extends JpaRepository<Film, BigDecimal> {
}
