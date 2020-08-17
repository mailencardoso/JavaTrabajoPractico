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
    
    public boolean agregarCliente(String usuario, String contraseña, String tipoUsuario, String nombre, String apellido, String telefono, String mail, String direccion) {
        PreparedStatement pst= null;
        try {
            getConexion().setAutoCommit(false);
            String query= "INSERT INTO Usuario (usuario,pass,tipo_usuario,nombre,apellido,telefono,email, direccion) VALUES (?,?,?,?,?,?,?,?);";
            pst = getConexion().prepareStatement(query);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            pst.setString(3, tipoUsuario);
            pst.setString(4, nombre);
            pst.setString(5, apellido);
            pst.setString(6, telefono);
            pst.setString(7, mail);
            int ban=pst.executeUpdate();
            
            getConexion().commit();
            if(ban==1){
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            error = "Error: Nombre de usuario existente";
        } catch(SQLException e){
            error= "Error: "+e;
        }finally {
            try {
                if (getConexion()!=null) getConexion().close();
                if (pst!=null) pst.close();
            } catch (SQLException e) {
                error = "Error: "+e;
            }
        }
        return false;
                
    }
    public boolean modifUsuario(String usuario, String nombre, String apellido, String telefono, String mail, String contraseña, String tipoUsuario) {
        PreparedStatement pst = null;
        ResultSet rs= null;
        try {
            pst = getConexion().prepareStatement("UPDATE Usuario SET pass=?, tipo_usuario=?, nombre =?, apellido=?, telefono=?,email=? WHERE usuario = ?");
            pst.setString(1,contraseña);
            pst.setString(2,tipoUsuario);
            pst.setString(3,nombre);
            pst.setString(4,apellido);
            pst.setString(5,telefono);
            pst.setString(6,mail);
            pst.setString(7,usuario);
            
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
