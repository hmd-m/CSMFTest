package com.example.entrevueSpringBoot.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * ReponseFilm
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-14T10:53:35.208341800-05:00[America/New_York]")

public class ReponseFilm   {
  @JsonProperty("id")
  private BigDecimal id;

  @JsonProperty("titre")
  private String titre;

  @JsonProperty("description")
  private String description;

  @JsonProperty("acteurs")
  private List<ReponseActeur> acteurs = null;

  public ReponseFilm id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Id du film
   * @return id
  */
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public ReponseFilm titre(String titre) {
    this.titre = titre;
    return this;
  }

  /**
   * Titre du film
   * @return titre
  */

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public ReponseFilm description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description du film
   * @return description
  */
 
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ReponseFilm acteurs(List<ReponseActeur> acteurs) {
    this.acteurs = acteurs;
    return this;
  }

  public ReponseFilm addActeursItem(ReponseActeur acteursItem) {
    if (this.acteurs == null) {
      this.acteurs = new ArrayList<ReponseActeur>();
    }
    this.acteurs.add(acteursItem);
    return this;
  }

  /**
   * Get acteurs
   * @return acteurs
  */
  public List<ReponseActeur> getActeurs() {
    return acteurs;
  }

  public void setActeurs(List<ReponseActeur> acteurs) {
    this.acteurs = acteurs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReponseFilm reponseFilm = (ReponseFilm) o;
    return Objects.equals(this.id, reponseFilm.id) &&
        Objects.equals(this.titre, reponseFilm.titre) &&
        Objects.equals(this.description, reponseFilm.description) &&
        Objects.equals(this.acteurs, reponseFilm.acteurs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, titre, description, acteurs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReponseFilm {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    titre: ").append(toIndentedString(titre)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    acteurs: ").append(toIndentedString(acteurs)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

