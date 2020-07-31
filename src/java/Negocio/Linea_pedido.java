/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Gaston
 */
public class Linea_pedido {
    
    int cantidad;
    
    public Linea_pedido(int cant){
        
        this.cantidad = cant;
             
          
        }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cant){
        this.cantidad = cant;
    }
    
    
    
    
}
