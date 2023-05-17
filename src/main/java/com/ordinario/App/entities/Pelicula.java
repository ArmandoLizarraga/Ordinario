 package com.ordinario.App.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;



@Entity
@Table(name="Pelicula")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String titulo;
	private LocalDate fecha;
	private LocalTime hora;
	private String categoria;
	private String sinopsis;
	
	public Pelicula(int id, String titulo, LocalDate fecha, LocalTime hora, String categoria, String sinopsis) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.hora = hora;
		this.categoria = categoria;
		this.sinopsis = sinopsis;
	}

	public Pelicula() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	
	
	
}
