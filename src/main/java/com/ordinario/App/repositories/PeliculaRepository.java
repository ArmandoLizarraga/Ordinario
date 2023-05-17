package com.ordinario.App.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ordinario.App.entities.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
	
	//List<Pelicula> estrenos();
}
