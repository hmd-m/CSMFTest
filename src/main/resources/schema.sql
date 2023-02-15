DROP TABLE IF EXISTS film;
DROP TABLE IF EXISTS acteur;
CREATE TABLE acteur
(
    id  BIGINT PRIMARY KEY auto_increment,
    nom         VARCHAR(24),
    prenom      VARCHAR(18)
);
CREATE TABLE film
(
    id      BIGINT PRIMARY KEY auto_increment,
    acteur_id       BIGINT UNIQUE REFERENCES acteur (id),
    titre VARCHAR(128),
    description VARCHAR(256)
);

