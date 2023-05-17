package com.ordinario.App.entities;

public class PasswordRecovery {
    String nombre;
    String oldPass;
    String newPass;

    public PasswordRecovery(String nombre, String oldPass, String newPass) {
        this.nombre = nombre;
        this.oldPass = oldPass;
        this.newPass = newPass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
