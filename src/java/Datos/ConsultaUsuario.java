/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Negocio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author Usuario
 */
public class ConsultaUsuario extends Conexion{
    
    private String error= null;
    
    public String getError(){
        return error;
    }
    
    public void setError(String error){
        this.error = error;
    }
   
    public Usuario login(String usuario, String pass){
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuarioActual = new Usuario();
        
         try {
            String query = "SELECT * FROM usuario WHERE usuario = ? AND pass = ?";
            Connection conexion = getConexion();
            pst = conexion.prepareStatement(query);
            pst.setString(1, usuario);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            
            if (rs.absolute(1)){
                usuarioActual.setUsuario(rs.getString("usuario"));
                usuarioActual.setPassword(rs.getString("pass"));
                usuarioActual.setNombre(rs.getString("nombre"));
                usuarioActual.setApellido(rs.getString("apellido"));
                usuarioActual.setTipoUsuario(rs.getString("tipo_usuario"));
                usuarioActual.setTelefono(rs.getString("telefono"));
                usuarioActual.setMail(rs.getString("email"));
                usuarioActual.setDireccion(rs.getString("direccion"));
                
                return usuarioActual;
            }
        } catch (Exception e) {
            error = "Error: "+e;
        } finally{
            try {
                 if (getConexion()!= null) getConexion().close();
                 if (pst!=null) pst.close();
                 if (rs!= null) rs.close();
            } catch (Exception e) {
                error = "Error: "+e;
            }   
        }
        usuarioActual=null;     
        return usuarioActual;
    }  
    
    public boolean agregarCliente(String usuario, String nombre, String apellido, String email, String pass, String telefono, String direccion, String tipo_usuario) {
        PreparedStatement pst= null;
        try {
            getConexion().setAutoCommit(false);
            String query= "INSERT INTO usuario (usuario,nombre,apellido,email,pass,telefono,direccion,tipo_usuario) VALUES (?,?,?,?,?,?,?,?);";
            pst = getConexion().prepareStatement(query);
            pst.setString(1, usuario);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setString(4, email);
            pst.setString(5, pass);
            pst.setString(6, telefono);
            pst.setString(7, direccion);
            pst.setString(8, tipo_usuario);
            int ban=pst.executeUpdate();
            
            getConexion().commit();
            if(ban==1){
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            error = "Error: Nombre de usuario existente";
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
    public boolean modifUsuario(String usuario, String nombre, String apellido, String telefono, String mail, String pass, String tipoUsuario, String direccion) {
        PreparedStatement pst = null;
        ResultSet rs= null;
        try {
            pst = getConexion().prepareStatement("UPDATE Usuario SET pass=?, tipo_usuario = ? , nombre =?, apellido=?, telefono=?,email=?, direccion=? WHERE usuario = ?");
            pst.setString(1,pass);
            pst.setString(2,tipoUsuario);
            pst.setString(3,nombre);
            pst.setString(4,apellido);
            pst.setString(5,telefono);
            pst.setString(6,mail);
            pst.setString(7,direccion);
            pst.setString(8,usuario);
            
            
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
      
     public boolean existeCuenta(String email){
        PreparedStatement pst = null;
        ResultSet rs = null;
       
        
         try {
            String query = "SELECT * FROM usuario WHERE email = ?";
            Connection conexion = getConexion();
            pst = conexion.prepareStatement(query);
            pst.setString(1, email);
            rs = pst.executeQuery();
            
            if (rs.absolute(1)){
                
                return true;
            }
        } catch (Exception e) {
            error = "Error: "+e;
        } finally{
            try {
                 if (getConexion()!= null) getConexion().close();
                 if (pst!=null) pst.close();
                 if (rs!= null) rs.close();
            } catch (Exception e) {
                error = "Error: "+e;
            }   
        }
        return false;
    }   
     
     public boolean existeUsuario(String usuario){
        PreparedStatement pst = null;
        ResultSet rs = null;
                
         try {
            String query = "SELECT * FROM usuario WHERE usuario = ?";
            Connection conexion = getConexion();
            pst = conexion.prepareStatement(query);
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            
            if (rs.absolute(1)){
                                
                return true;
            }
        } catch (Exception e) {
            error = "Error: "+e;
        } finally{
            try {
                 if (getConexion()!= null) getConexion().close();
                 if (pst!=null) pst.close();
                 if (rs!= null) rs.close();
            } catch (Exception e) {
                error = "Error: "+e;
            }   
        }
          
        return false;
    } 
    
         
}
