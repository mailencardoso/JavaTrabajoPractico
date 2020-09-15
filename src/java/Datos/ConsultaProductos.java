/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import Negocio.Producto;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Gaston
 */
public class ConsultaProductos extends Conexion {
    
    private String error=null;

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
                Blob img;
                id = rs.getInt("id_producto");
                nombre = rs.getString("nombre");
                desc= rs.getString("descripcion");
                precio=rs.getFloat("precio");
                img = rs.getBlob("foto");
                prodActual = new Producto(id,nombre,desc,precio, img);
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
    
    
    public boolean agregarProducto(int id_producto,String nombre, String descripcion, float precio, Blob foto) {
        PreparedStatement pst= null;
        try {
            getConexion().setAutoCommit(false);

            String query= "INSERT INTO producto(id_producto, nombre,descripcion,precio,foto) VALUES (?,?,?,?,?);";

            pst = getConexion().prepareStatement(query);
            pst.setInt(1,id_producto);
            pst.setString(2, nombre);
            pst.setString(3, descripcion);
            pst.setFloat(4, precio);
            pst.setBlob(5, foto);
            int ban=pst.executeUpdate();
         
            getConexion().commit();
            if(ban==1){
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            error = "Error: Producto existente"+e;
        } catch(Exception e){
            error= "Error: "+e;
        }finally {
            try {
                if (getConexion()!=null) getConexion().close();
                if (pst!=null) pst.close();
            } catch (Exception e) {
                error = "Error: "+e;
            }
        }
        return false;
                
    }
    public boolean modifProduct(int id_produc, String nombre, String desc, Float precio, Blob img) {
        PreparedStatement pst = null;
        ResultSet rs= null;
        try {
            pst = getConexion().prepareStatement("UPDATE producto SET nombre = ? , descripcion =?, precio=?, foto=? WHERE id_producto = ?");
            pst.setString(1,nombre);
            pst.setString(2,desc);
            pst.setFloat(3,precio);
            pst.setBlob(4,img);
            pst.setInt(5,id_produc);
            
            if(pst.executeUpdate()==1){
                return true;
            }
        } catch (SQLException e) {
            error = "Error: "+e;
        } finally{
            try{
                if (pst!=null) pst.close();
                if (getConexion()!=null) getConexion().close();
                if (rs!= null) rs.close();
            } catch(SQLException e) {
                error = "Error: "+e;
                }
        }
        return false;
    }
    public boolean EliminarProduct(int id_produc, String nombre, String desc, Float precio, Blob img) {
        PreparedStatement pst = null;
        ResultSet rs= null;
        try {
            pst = getConexion().prepareStatement("DELETE * FROM producto WHERE id_producto = ?");
         
            if(pst.executeUpdate()==1){
                return true;
            }
        } catch (SQLException e) {
            error = "Error: "+e;
        } finally{
            try{
                if (pst!=null) pst.close();
                if (getConexion()!=null) getConexion().close();
                if (rs!= null) rs.close();
            } catch(SQLException e) {
                error = "Error: "+e;
                }
        }
        return false;
    }

  
    
    
}
