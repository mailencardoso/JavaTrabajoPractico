/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Usuario
 */
public class Pedido {
    
    private int idpedido;
    private Date fecha_pedido;
    private String orden_completa;
    private Float precio;
    private Usuario cliente;
    private ArrayList<Linea_pedido> lineas;   
    private String usuarioAdministrador;
    
   
    
    
    public Pedido(int idped, Date fecha, String completa, Usuario cli, String adm, ArrayList<Linea_pedido> lin){
        
        this.idpedido = idped;
        this.fecha_pedido = fecha;
        this.orden_completa = completa;  
        this.cliente = cli;
        this.usuarioAdministrador = adm;
        this.lineas = lin;
    }

    public Pedido() {
      
    }

    
    
    public int getId() {
        return idpedido;
    }

    public void setId(int idped) {
        this.idpedido = idped;
        
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
    
    public String getUsuarioCliente() {
        return cliente.getUsuario();
    }
    
      public String getUsuarioAdministrador() {
        return usuarioAdministrador;
    }

    public void setUsuarioAdministrador(String usuarioAdm) {
        this.usuarioAdministrador = usuarioAdm;
    }
    
    public void setCliente(Usuario cli) {
        this.cliente = cli;
    }
    
    public ArrayList<Linea_pedido> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<Linea_pedido> lineas) {
        this.lineas = lineas;
    }
    
    public Float getPrecio() {
        return precio;
    }
    
    public void setPrecio() {
        Float total = 0f;
        if (lineas!=null){
            for (int i=0;i<lineas.size();i++){
                total= total+lineas.get(i).getCantidad()*lineas.get(i).getProducto().getPrecio();
            }
       
        }
        precio = total;
    }
    
}
