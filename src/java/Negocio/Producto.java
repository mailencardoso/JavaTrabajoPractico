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
public class Producto {
    
    String nombre;
    String descripcion;
    Float precio;
    
    public Producto(String nom, String desc, Float pre){
        this.nombre = nom;
        this.descripcion = desc;
        this.precio = pre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nom){
        this.nombre = nom;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String desc){
        this.descripcion = desc;
    }
    
    public Float getPrecio(){
        return precio;
    }
    
    public void setPrecio(Float pre){
        this.precio = pre;
    }
}
