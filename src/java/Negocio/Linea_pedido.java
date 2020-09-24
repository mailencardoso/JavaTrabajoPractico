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
    private Producto producto;
    private int numeroLinea;
    
    public Linea_pedido(int cant, Producto prodAct,int num){
        
        this.cantidad = cant;
        this.producto = prodAct;
        this.numeroLinea = num;
          
        }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cant){
        this.cantidad = cant;
    }
    
    public void setProducto(Producto prodAct) {
        this.producto=prodAct;
    }
    
    public Producto getProducto(){
        return producto;
    }

    public void setNumeroLinea(int num) {
        this.numeroLinea=num;
    }
    
    public int getNumeroLinea(){
        return numeroLinea;
    }
    
    
}
