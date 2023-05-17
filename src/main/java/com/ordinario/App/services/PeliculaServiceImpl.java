package com.ordinario.App.services;

import com.ordinario.App.entities.Pelicula;
import com.ordinario.App.repositories.PeliculaRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImpl implements PeliculaService {
	@Autowired
	PeliculaRepository peliculaRepository;

	@Override
	public Iterable<Pelicula> listAllPeliculas() {
		return peliculaRepository.findAll();
	}

	@Override
	public Pelicula getPeliculaById(int id) {
		return peliculaRepository.findById(id).get();
	}

	
	@Override
	public void deletePelicula(int id) {
		peliculaRepository.deleteById(id);
		
	}

	@Override
	public boolean savePelicula(String titulo, LocalDate fecha, LocalTime hora, String categoria, String sinopsis) {
		
		Pelicula newpelicula = new Pelicula();
		newpelicula.setTitulo(titulo);
		newpelicula.setFecha(fecha);
		newpelicula.setHora(hora);
		newpelicula.setCategoria(categoria);
		newpelicula.setSinopsis(sinopsis);
		peliculaRepository.save(newpelicula);
		
		return true;
	}
	
	/*@Override
	public List<Pelicula> estrenos()
	{
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		PageRequest request = PageRequest.of(0, 3, sort);
		List<Pelicula> estrenos = peliculaRepository.findAll(request).getContent();
		return estrenos;
	}*/

}
