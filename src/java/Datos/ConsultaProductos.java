/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Negocio.Producto;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Gaston
 */
public class ConsultaProductos extends Conexion {
    
     String error=null;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public ArrayList<Producto> listadoProductos(String condicionListado){
        PreparedStatement pst = null;
        ArrayList<Producto> productos = new ArrayList<>();
        Producto prodActual = null;
        ResultSet rs = null;
        String query;
        try {
            query = "SELECT * FROM productos where descripcion like ? order by nombre";
            pst= getConexion().prepareStatement(query);
            pst.setString(1,condicionListado);
            rs = pst.executeQuery();

            while (rs.next()){
                int id;
                String nombre, desc;
                Float precio;
                id = rs.getInt("id_producto");
                nombre = rs.getString("nombre");
                desc= rs.getString("descripcion");
                precio=rs.getFloat("precio");
                prodActual = new Producto(id,nombre,desc,precio);
                productos.add(prodActual);
            }
            
        } catch (SQLException e) {
            error = "Error: "+e;
        }finally{
           try {
                if (getConexion()!=null) getConexion().close();
                if (pst!=null) pst.close();
                if (rs!=null) rs.close();
            } catch (SQLException e) {
                error = "Error: "+e;
            }
        }
        return productos;
        
    }
    
}
