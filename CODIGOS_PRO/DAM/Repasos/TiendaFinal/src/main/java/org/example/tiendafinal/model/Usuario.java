package org.example.tiendafinal.model;

public class Usuario {

    private String correo, pass;

    public Usuario() {
    }

    public Usuario(String correo, String pass) {
        this.correo = correo;
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
