package com.ordinario.App.controllers;

import com.ordinario.App.entities.Usuario;
import com.ordinario.App.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }


    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String nombre,
                        @RequestParam("password") String password,
                        Model model){
        if(usuarioService.login(nombre, password)){
            return "redirect:/peliculas";
        }
        else{
            model.addAttribute("error", "Usuario o Contraseña incorrectos");
            return "login";
        }

    }


    @RequestMapping("/changepassword")
    public String showChangePass(Model model) {
        return "changepassword";
    }



    @RequestMapping(value="/changepassword", method = RequestMethod.POST)
    public String changePassword(@RequestParam("nombre") String nombre,
                                 @RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 Model model){
        if(usuarioService.changePassword(nombre, oldPassword, newPassword)){
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "no se pudo cambiar la contraseÃ±a");
            return "changepassword";
        }
    }

    @RequestMapping("/createuser")
    public String showCreateUser(Model model) {
        return "createuser";
    }


    @RequestMapping(value="/createuser", method = RequestMethod.POST)
    public String createUsuario(@RequestParam("nombre") String nombre,
                                  @RequestParam("password") String password,
                                  @RequestParam("email") String email,
                                  Model model){
        if(usuarioService.createUser(nombre, password, email)){
            return "redirect:/login";
        }else {
            model.addAttribute("error", "Usuario o Correo ya existen");
            return "createuser";
        }
    }

}
