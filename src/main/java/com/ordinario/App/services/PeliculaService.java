package com.ordinario.App.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.ordinario.App.entities.Pelicula;


public interface PeliculaService {
	 Iterable<Pelicula> listAllPeliculas();
	
	 Pelicula getPeliculaById(int id);
	 
	 boolean savePelicula(String titulo, LocalDate fecha, LocalTime hora, String categoria, String sinopsis);
	 
	 void deletePelicula(int id);
	 
	 //List<Pelicula> estrenos();
}
