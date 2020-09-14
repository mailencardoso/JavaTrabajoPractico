/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.sql.Blob;



/**
 *
 * @author Usuario
 */
public class Producto {
    int id_producto;
    String nombre;
    String descripcion;
    Float precio;
    Blob foto;
    
    public Producto(int id, String nom, String desc, Float pre, Blob imag){
        this.id_producto = id;
        this.nombre = nom;
        this.descripcion = desc;
        this.precio = pre;
        this.foto = imag;
    }

    public Producto(){
        
    }

    
    public int getID(){
        return id_producto;
    }
    
    public void setID(int id){
        this.id_producto = id;
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
    
    public Blob getFoto(){
        return foto;
    }
    
    public void setFoto(Blob imag){
        this.foto = imag;
    }
    
}
