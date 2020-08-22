/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Datos.ConsultaUsuario;
import Negocio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
public class Registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); /**Devuelve un objeto PrintWriter que puede enviar textos al cliente */
        HttpSession sesion = request.getSession(true); /** crea la sesion */
        
        boolean ban = true;
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("contrasena");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        
              
        if (nombre.equals("") || apellido.equals("") || usuario.equals("") ||
            pass.equals("") || email.equals("") || telefono.equals("") ||
            direccion.equals("")){
                sesion.setAttribute("error", "Error: Debe completar todos los campos");
                ban = false;
            }
        else if(!usuario.matches("^[^\\s]{8,16}")){
                sesion.setAttribute("error", "Error: El nombre de usuario debe contener entre 8 y 16 caracteres (sin espacios en blanco)");
                ban = false;
            }
        else if(pass.length()<8){
                sesion.setAttribute("error", "Error: La contraseña debe contener al menos 8 caracteres(sin espacios en blanco)");
                ban = false;
        }
        else if(!email.matches("[-\\w\\.]+@\\w+\\.\\w+")){
                sesion.setAttribute("error", "Error: Ingrese un email correcto");
                ban = false;
        }
        else if(telefono.matches("[0-9]")){
                sesion.setAttribute("error", "Error: Ingrese un telefono correcto (solo numeros)");
                ban = false; 
        }
        
        ConsultaUsuario usu = new ConsultaUsuario();

        
        if(ban==true){
                usu.agregarCliente(usuario, nombre, apellido, email, pass, telefono, direccion, "Cliente");
                sesion.setAttribute("exito", "Registro realizado");
                response.sendRedirect("login.jsp"); 
            }
            
        
        else{
            if(usu.getError()!=null){
                sesion.setAttribute("error", usu.getError());
            }
            response.sendRedirect("indexerror.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
