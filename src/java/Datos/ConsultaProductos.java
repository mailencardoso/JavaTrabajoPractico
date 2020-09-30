/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import Negocio.Producto;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
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
                String nombre, desc, cat;
                Float precio;
                Blob img;
                id = rs.getInt("id_producto");
                nombre = rs.getString("nombre");
                desc= rs.getString("descripcion");
                precio=rs.getFloat("precio");
                cat=rs.getString("categoria");
                img = rs.getBlob("foto");
                prodActual = new Producto(id,nombre,desc,precio,img,cat);
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
    
    
    public boolean agregarProducto(int id_producto,String nombre, String descripcion, float precio, Blob foto,  String categoria) {
        PreparedStatement pst= null;
        try {
            getConexion().setAutoCommit(false);

            String query= "INSERT INTO producto(id_producto, nombre,descripcion,precio, foto,categoria) VALUES (?,?,?,?,?,?);";

            pst = getConexion().prepareStatement(query);
            pst.setInt(1,id_producto);
            pst.setString(2, nombre);
            pst.setString(3, descripcion);
            pst.setFloat(4, precio);
            pst.setBlob(5,foto);
            pst.setString(6, categoria);
            
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
    public Producto buscarCodigo(int id_producto){
        PreparedStatement pst = null;
        ResultSet rs = null;
        Producto productoActual = new Producto();
        
        
        try{
            String query = "SELECT * FROM producto WHERE id_producto = ?";
            Connection conexion = getConexion();
            pst = conexion.prepareStatement(query);
            pst.setInt(1, id_producto);
            rs = pst.executeQuery();
            
            if(rs.next()){
                productoActual = new Producto();
                int codigo = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float prec = rs.getFloat("precio");
                String categ = rs.getString("categoria");
                Blob blob = rs.getBlob("foto");
 
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
 
                byte[] imageBytes = outputStream.toByteArray();
 
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                          
                inputStream.close();
                outputStream.close();   
                
                productoActual.setID(codigo);
                productoActual.setNombre(nombre);
                productoActual.setDescripcion(descripcion);
                productoActual.setPrecio(prec);
                productoActual.setCategoria(categ);
                productoActual.setBase64Image(base64Image);
                
                return productoActual;
            }


        }
        
        catch(Exception e){
            error = "Error: Producto no existente "+e;
        }
        finally{
            try {
                 if (getConexion()!= null) getConexion().close();
                 if (pst!=null) pst.close();
                 if (rs!= null) rs.close();
            } catch (Exception e) {
                error = "Error de conexion "+e;
            }   
        }
        productoActual= null;
        return productoActual;
    }
    
    public boolean modifProduct(int id_producto, String nombre, String descripcion, Float precio, Blob foto, String categoria) {
        PreparedStatement pst = null;
        ResultSet rs= null;
        try {
            pst = getConexion().prepareStatement("UPDATE producto SET nombre = ? , descripcion =?, precio=?, foto=?, categoria=? WHERE id_producto = ?");
            pst.setString(1,nombre);
            pst.setString(2,descripcion);
            pst.setFloat(3,precio);
            pst.setBlob(4,foto);
            pst.setString(5,categoria);
            pst.setInt(6,id_producto);
            
            
            
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
    public boolean eliminarProduct(int id_produc) {
        PreparedStatement pst = null;
        ResultSet rs= null;
        try {
            pst = getConexion().prepareStatement("DELETE FROM producto WHERE id_producto = ?");
            pst.setInt(1,id_produc);
            
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

 
  
  public ArrayList<Producto> buscarCategoria(String cat) throws IOException{
        PreparedStatement pst = null;
        ArrayList<Producto> productos = new ArrayList<>();
        Producto prodActual = null;
        ResultSet rs = null;
        String query;
        try {
            query = "SELECT * FROM producto where categoria = ?";
            Connection conexion = getConexion();
            pst = conexion.prepareStatement(query);
            pst.setString(1, cat);
            rs = pst.executeQuery();

            while (rs.next()){
                prodActual = new Producto();
                int codigo = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float prec = rs.getFloat("precio");
                String categ = rs.getString("categoria");
                Blob blob = rs.getBlob("foto");
 
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
 
                byte[] imageBytes = outputStream.toByteArray();
 
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                          
                inputStream.close();
                outputStream.close();   
                
                prodActual.setID(codigo);
                prodActual.setNombre(nombre);
                prodActual.setDescripcion(descripcion);
                prodActual.setPrecio(prec);
                prodActual.setCategoria(categ);
                prodActual.setBase64Image(base64Image);
                
                productos.add(prodActual);
                
                return productos;
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
  
   public ArrayList<Producto> devuelveProductos() throws IOException{
        PreparedStatement pst = null;
        ArrayList<Producto> productos = new ArrayList<>();
        Producto prodActual = null;
        ResultSet rs = null;
        String query;
        try {
            query = "SELECT * FROM producto";
            Connection conexion = getConexion();
            pst = conexion.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()){
                prodActual = new Producto();
                int codigo = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float prec = rs.getFloat("precio");
                String categ = rs.getString("categoria");
                Blob blob = rs.getBlob("foto");
 
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
 
                byte[] imageBytes = outputStream.toByteArray();
 
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                          
                inputStream.close();
                outputStream.close();   
                
                prodActual.setID(codigo);
                prodActual.setNombre(nombre);
                prodActual.setDescripcion(descripcion);
                prodActual.setPrecio(prec);
                prodActual.setCategoria(categ);
                prodActual.setBase64Image(base64Image);
                
                productos.add(prodActual);
                
                return productos;
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
