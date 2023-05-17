package com.ordinario.App.repositories;

import com.ordinario.App.entities.Usuario;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.data.jpa.repository.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	List<Usuario> findByNombre(String nombre);
	List<Usuario> findByEmail(String email);
	
}
