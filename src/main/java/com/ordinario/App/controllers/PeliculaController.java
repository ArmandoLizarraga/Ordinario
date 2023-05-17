package com.ordinario.App.controllers;

import com.ordinario.App.entities.Pelicula;
import com.ordinario.App.services.PeliculaService;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeliculaController {

	@Autowired
	private PeliculaService peliculaService;

    @RequestMapping(value = "pelicula", method = RequestMethod.POST)
    public String savePelicula(@RequestParam("titulo") String titulo,
				    		@RequestParam("fecha") LocalDate fecha,
				    		@RequestParam("hora") LocalTime hora,
				    		@RequestParam("categoria") String categoria,
				    		@RequestParam("sinopsis") String sinopsis,
				    		Model model) {
        peliculaService.savePelicula(titulo, fecha, hora, categoria, sinopsis);
        System.out.println(">>>Save pelicula");
        return "redirect:/peliculas";
    }

    @RequestMapping("/peliculas")
    public String list(Model model) {
        model.addAttribute("peliculas", peliculaService.listAllPeliculas());
        System.out.println("Returning peliculas:");
        return "peliculas";
    }

    @RequestMapping(value="peliculas/{id}")
    public String showPelicula(@PathVariable Integer id, Model model) {
        model.addAttribute("peliculas", peliculaService.getPeliculaById(id));
        return "peliculashow";
    }

    @GetMapping(value="peliculas/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("peliculas", peliculaService.getPeliculaById(id));
        return "peliculasform";
    }


    @RequestMapping(value="pelicula/new")
    public String newPelicula(Model model) {
        model.addAttribute("peliculas", new Pelicula());
        return "peliculasform";
    }

    @GetMapping(value="peliculas/delete/{id}")
    public String delete(@PathVariable Integer id) {
        peliculaService.deletePelicula(id);
        return "redirect:/peliculas";
    }
    
    /*@GetMapping(value="peliculas/estrenos")
    public String estrenos(Model model)
    {
    	model.addAttribute("peliculas", peliculaService.estrenos());
    	return "estrenos";
    }*/
}
