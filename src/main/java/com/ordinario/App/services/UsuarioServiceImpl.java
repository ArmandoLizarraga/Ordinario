package com.ordinario.App.services;

import com.ordinario.App.entities.Usuario;
import com.ordinario.App.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository userRepository;


    public boolean login(String user, String pass) {
        boolean result = false;
        List<Usuario> listUsuario = userRepository.findByNombre(user);
        if (!listUsuario.isEmpty()) {
            Usuario usuario = listUsuario.get(0);
            if (usuario.getPassword().equals(pass)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean changePassword(String user, String oldPass, String newPass) {
        boolean result=false;
        List<Usuario> listUsuario = userRepository.findByNombre(user);
        if(listUsuario.isEmpty()) return result;
        Usuario usuario = listUsuario.get(0);
        if(login(user, oldPass)){
            usuario.setPassword(newPass);
            userRepository.save(usuario);
            result = true;
        }
        return result;
    }
    
    @Override
    public List<Usuario> getUsuarios()
    {
    	List<Usuario> usuarios = userRepository.findAll();
    	return usuarios;
    }

	@Override
	public boolean createUser(String nombre, String password, String email) {
		boolean result = false;
        List<Usuario> usuario = userRepository.findByNombre(nombre);
        List<Usuario> correo = userRepository.findByEmail(email);

        if (usuario.isEmpty() && correo.isEmpty()){
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setEmail(email);
            nuevoUsuario.setPassword(password);
            userRepository.save(nuevoUsuario);
            result = true;

        }
        return result;
	}
	
	@Override
	public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
