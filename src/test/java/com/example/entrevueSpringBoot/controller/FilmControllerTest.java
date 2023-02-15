package com.example.entrevueSpringBoot.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.entrevueSpringBoot.EntrevueSpringBootApplication;
import com.example.entrevueSpringBoot.dto.ReponseActeur;
import com.example.entrevueSpringBoot.dto.ReponseFilm;
import com.example.entrevueSpringBoot.dto.RequeteCreationAuteur;
import com.example.entrevueSpringBoot.dto.RequeteCreationFilm;
import com.example.entrevueSpringBoot.service.FilmService;
import com.fasterxml.jackson.databind.ObjectMapper;





/**
 * @author hamid
 *
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EntrevueSpringBootApplication.class)
@AutoConfigureMockMvc
public class FilmControllerTest {
   @Autowired
   private MockMvc mvc;
  
   @MockBean
   private FilmService  filmservice;
   

   
   @Test
   @DisplayName("GET /api/films/12")
   public void testObtenirFilm() throws Exception {
	  ReponseFilm film = getReponseFilm();
	  doReturn(film).when(filmservice).getFilmById(12);
      mvc.perform(get("/api/films/{id}" , film.getId()))
       .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON));
      
   }
 
   @Test
   @DisplayName("POST /api/films")
   public void testCreeFilm() throws Exception {
	  
	   RequeteCreationFilm requeteCreationFilm = getRequeteCreationFilm();
       doReturn( getReponseFilm()).when(filmservice).save(requeteCreationFilm);
        mvc.perform(post("/api/films")
              .contentType(MediaType.APPLICATION_JSON)
              .content(asJson(requeteCreationFilm)))
              // Validate the response code and content type
              .andExpect(status().isCreated())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON));
   }
  
   
  @Test
  @DisplayName("GET /api/films/1 - Not Found")
   void testGetWidgetByIdNotFound() throws Exception {
       // Setup our mocked service
       doReturn(null).when(filmservice).getFilmById(1);

       // Execute the GET request
       mvc.perform(get("/api/films/{id}", 1))
               // Validate the response code
               .andExpect(status().isNotFound());
   }
  
   private ReponseFilm getReponseFilm() {
	   
	   ReponseFilm reponseFilm = new ReponseFilm();
	   reponseFilm.setId(new BigDecimal(12));
	   reponseFilm.setTitre("Star Wars: The Empire Strikes Back");
	   reponseFilm.setDescription("Darth Vader is adamant about turning Luke Skywalker to the dark side.");
	   ReponseActeur reponseActeur = new ReponseActeur();
	   reponseActeur.setId(new BigDecimal(12));
	   reponseActeur.setNom("Harison");
	   reponseActeur.setPrenom("Ford");
	   reponseFilm.addActeursItem(reponseActeur);
       return reponseFilm;
   }
   
  private RequeteCreationFilm getRequeteCreationFilm() {
	   
	   RequeteCreationFilm requeteCreationFilm = new RequeteCreationFilm();
	   requeteCreationFilm.setTitre("Star Wars: The Empire Strikes Back");
	   requeteCreationFilm.setDescription("Darth Vader is adamant about turning Luke Skywalker to the dark side.");
	   RequeteCreationAuteur requeteCreationAuteur = new RequeteCreationAuteur();
	   requeteCreationAuteur.setNom("Harison");
	   requeteCreationAuteur.setPrenom("Ford");
	   requeteCreationFilm.addActeursItem(requeteCreationAuteur);
       return requeteCreationFilm;
   }
   
   private static String asJson(final Object obj) {
      try {
         return new ObjectMapper().writeValueAsString(obj);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
}