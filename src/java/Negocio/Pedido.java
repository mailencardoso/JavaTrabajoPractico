/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Date;
/**
 *
 * @author Usuario
 */
public class Pedido {
    
    Date fecha_pedido;
    String orden_completa;
    
    
    public Pedido(Date fecha, String completa){
        
        this.fecha_pedido = fecha;
        this.orden_completa = completa;  
    }
    
    
    public Date getFechaPedido(){
        return fecha_pedido;
    }
    
    public void setFechaPedido(Date fecha){
        this.fecha_pedido = fecha;
    }
    
    public String getOrdenCompleta(){
        return orden_completa;
    }
    
    public void setOrdenCompleta(String completa){
        this.orden_completa = completa;
    }
}
