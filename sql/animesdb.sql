
-- create database animes;
-- use animes;

-- DROP TABLE IF EXISTS 'anime';
CREATE TABLE anime(
    idAnime int primary key not null AUTO_INCREMENT ,
    nombre varchar(30) not null,
    anioEstreno varchar(10) not null,
    genero varchar(30) not null,
    rating int not null
);

INSERT INTO anime(nombre, anioEstreno, genero, rating) 
values('Naruto', '2000', 'Shonen', 4);
INSERT INTO anime(nombre, anioEstreno, genero, rating) 
values('Gantz', '2004', 'Seinen', 3);
INSERT INTO anime(nombre, anioEstreno, genero, rating) 
values('Berserk', '2012', 'Seinen', 4);
INSERT INTO anime(nombre, anioEstreno, genero, rating) 
values('Tokyo Magnitude 8.0', '2012', 'Seinen', 5);
