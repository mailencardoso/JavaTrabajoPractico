/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Negocio.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Diana
 */
public class ConsultaPedidos extends Conexion{
    
    private String error=null;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
     public boolean RegistroPedido(String id_usuario, Pedido pedido) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Calendar c2 = new GregorianCalendar();
        String fec = Integer.toString(c2.get(Calendar.YEAR))+"-"+Integer.toString(c2.get(Calendar.MONTH))+"-"+Integer.toString(c2.get(Calendar.DATE));
        java.sql.Date fecha = java.sql.Date.valueOf(fec);
        ArrayList<Linea_pedido> lineas = new ArrayList<Linea_pedido>();
        lineas = pedido.getLineas();
         
 
        try{
            getConexion().setAutoCommit(false);
            String consulta= "INSERT INTO pedidos (id_usuario,fecha_pedido,total,orden_completa) VALUES (?,?,?,?,?,?);";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, id_usuario);
            pst.setDate(2, fecha);
            pst.setFloat(3, pedido.getPrecio());
            pst.setString(4, pedido.getOrdenCompleta());
            int ban=pst.executeUpdate();
            
            String consulta2="select p.id_pedido from pedidos p where id_usuario=? and fecha_pedido = ?;";
            pst =getConexion().prepareStatement(consulta2);
            pst.setString(1, id_usuario);
            pst.setDate(2, fecha);
            rs = pst.executeQuery();
            int numPedido=0;
            while (rs.next()){
                numPedido=rs.getInt("id_pedido");
            }
            
            int ban2=1;
            for (int i=0;i<lineas.size();i++){
                String consulta3="insert into linea_pedido (id_producto,id_pedido,id_linea,cantidad) values (?,?,?,?)";
                pst = getConexion().prepareStatement(consulta3);
                pst.setInt(1, numPedido);
                pst.setInt(2, lineas.get(i).getNumeroLinea());
                pst.setInt(3, lineas.get(i).getProducto().getID());
                pst.setInt(4, lineas.get(i).getCantidad());
                int band=pst.executeUpdate();
                if (band==0){
                    ban2=0;
                }
            }
            
            getConexion().commit();
            if(ban==1 && ban2==1){
                return true;
            }

        }catch (Exception e) {
            error = "Error: "+e;
        } finally {
            try {
                if (getConexion()!=null) getConexion().close();
                if (pst!=null) pst.close();
                if (rs!=null) rs.close();
            } catch (SQLException e) {
                error = "Error: "+e;
            }
        }
        
        
        return false;  
    }

}