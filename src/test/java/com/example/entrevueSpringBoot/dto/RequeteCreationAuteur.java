package com.example.entrevueSpringBoot.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * RequeteCreationAuteur
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-14T10:53:35.208341800-05:00[America/New_York]")

public class RequeteCreationAuteur   {
  @JsonProperty("nom")
  private String nom;

  @JsonProperty("prenom")
  private String prenom;

  public RequeteCreationAuteur nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Nom de l'acteur
   * @return nom
  */
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public RequeteCreationAuteur prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * Description du film
   * @return prenom
  */

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequeteCreationAuteur requeteCreationAuteur = (RequeteCreationAuteur) o;
    return Objects.equals(this.nom, requeteCreationAuteur.nom) &&
        Objects.equals(this.prenom, requeteCreationAuteur.prenom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nom, prenom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequeteCreationAuteur {\n");
    
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
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

