package com.ordinario.App.services;

import java.util.List;
import com.ordinario.App.entities.Usuario;


public interface UsuarioService {
	
    public boolean login(String user, String pass);
    
    public boolean changePassword(String user, String oldPass, String newPass);
    
    public boolean createUser(String nombre, String password, String email);
    
    public List<Usuario> getUsuarios();
    
    public void deleteUser(int id);

}
