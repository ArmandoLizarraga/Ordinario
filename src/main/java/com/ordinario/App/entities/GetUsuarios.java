package com.ordinario.App.entities;

import java.util.List;
import com.ordinario.App.entities.Usuario;

public class GetUsuarios {

	List<Usuario> usuarios;

	public GetUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
