package com.ordinario.App.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="Usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nombre;
	private String password;
	private String email;
	
	public Usuario(int id, String nombre, String password, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(String nombre2, String email2, String password2) {
		this.nombre = nombre2;
		this.password = password2;
		this.email = email2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
