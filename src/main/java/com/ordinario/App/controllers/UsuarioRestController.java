package com.ordinario.App.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ordinario.App.entities.Usuario;
import com.ordinario.App.entities.GetUsuarios;
import com.ordinario.App.entities.Login;
import com.ordinario.App.entities.PasswordRecovery;
import com.ordinario.App.services.UsuarioService;

@RestController
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/loginrest")
    public ResponseEntity<String> login(@RequestBody Login login){
        if(usuarioService.login(login.getNombre(), login.getPassword())){
            return new ResponseEntity<String>("SESION INICIADA CORRECTAMENTE", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("ERROR", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/changepassrest")
    public ResponseEntity<String> changePassword(@RequestBody PasswordRecovery changePassRequest){
        if(usuarioService.changePassword(changePassRequest.getNombre(), changePassRequest.getOldPass(), changePassRequest.getNewPass())){
            return new ResponseEntity<String>("PASSWORD UPDATED", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("ERROR", HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("getUsuariosrest")
    public ResponseEntity<String> getUsuarios(){
    	List<Usuario> usuarios = usuarioService.getUsuarios();
    	if(usuarioService.getUsuarios().isEmpty()) {
    		return new ResponseEntity<String>("ERROR", HttpStatus.NOT_FOUND);
    	}
    	else {
    		return new ResponseEntity<String>(usuarios.toString(), HttpStatus.OK);
    	}
    }

}