/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Negocio.Usuario;
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
        
        /*falta agregar codigo*/
        
        
        
        return usuarioActual;
    }  
    
         
}
