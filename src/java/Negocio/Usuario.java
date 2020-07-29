/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Usuario
 */
public class Usuario {
    String usuario;
    String contraseña;
    String tipoUsuario;
    String nombre;
    String apellido;
    String telefono;
    String mail;
    String direccion;
    
    public Usuario(String usu, String con, String tipoUsu, String nombre, String apellido, String telefono, String mail, String dir) {
        this.usuario = usu;
        this.contraseña = con;
        this.tipoUsuario = tipoUsu;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.direccion = dir;
    }
    
    public Usuario (){
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getPassword(){
        return contraseña;
    }
    
    public void setPassword(String contraseña){
        this.contraseña = contraseña;
    }
    
    public String getTipoUsuario(){
        return tipoUsuario;
    }
    
    public void setTipoUsuario(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
}
