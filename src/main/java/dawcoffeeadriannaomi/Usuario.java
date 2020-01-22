/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawcoffeeadriannaomi;

/**
 *
 * @author adrip
 */
public class Usuario {

//Atributos 
    private String usuario;
    private String password;

//Constructor parametrizado
    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

//Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//Constructor por defecto
    public Usuario() {
        this.usuario = "admin";
        this.password = "admin";
    }

//toString
    @Override
    public String toString() {
        return "Usuarios: " +"\n -Usuario: " +usuario + "\n -Contraseña: " + password;
    }

}
