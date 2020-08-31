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
public class ModificarDatos extends HttpServlet {

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
        String contActual = request.getParameter("contrasenaActual");
        String contNueva = request.getParameter("passNueva");
        String contNueva2 = request.getParameter("passNueva2");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        
        ConsultaUsuario usu = new ConsultaUsuario();
       
              
         if (contActual.equals("")||nombre.equals("")||apellido.equals("")||
                email.equals("")||telefono.equals("")){
            usu.setError("Error: Complete todos los campos obligatorios (*)");
            sesion.setAttribute("error",usu.getError());
            response.sendRedirect("modificarDatos.jsp");
        }
        else if(!contActual.equals(contActual)){
            usu.setError("Error: Ingrese correctamente la contraseña actual");
            sesion.setAttribute("error",usu.getError());
            response.sendRedirect("modificarDatos.jsp");
        }
        else if(!contNueva.equals(contNueva2)){
            usu.setError("Error: Los dos campos de la nueva contraseña no coinciden");
            sesion.setAttribute("error",usu.getError());
            response.sendRedirect("modificarDatos.jsp");
        }
        else if(contNueva.length()<6 && !contNueva.equals("")){
            usu.setError("Error: La nueva contraseña debe tener por lo menos 6 caracteres");
            sesion.setAttribute("error",usu.getError());
            response.sendRedirect("modificarDatos.jsp");
        }
        else if(!nombre.matches("^[A-Za-z][a-z]+")){
            usu.setError("Error: Ingrese un nombre correcto");
            sesion.setAttribute("error",usu.getError());
            response.sendRedirect("modificarDatos.jsp");
        }
        else if(!apellido.matches("^[A-Za-z][a-z]+")){
            usu.setError("Error: Ingrese un apellido correcto");
            sesion.setAttribute("error",usu.getError());
            response.sendRedirect("modificarDatos.jsp");
        }
        else if(!email.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$")){
            usu.setError("Error: Ingrese un mail correcto");
            sesion.setAttribute("error",usu.getError());
            response.sendRedirect("modificarDatos.jsp");
        }
        else if ( !telefono.matches( "[0-9][0-9][0-9][0-9][0-9][0-9][0-9]+" )){
            usu.setError("Error: Ingrese un número de teléfono correcto (Sólo dígitos)");
            sesion.setAttribute("error",usu.getError());
            response.sendRedirect("modificarDatos.jsp");
        }
        else {
            if(contNueva.equals("") && contNueva2.equals("")){
                ban=usu.modifUsuario(usuario,nombre,apellido,telefono,email,contActual,direccion);
            }
            else{
                ban=usu.modifUsuario(usuario,nombre,apellido,telefono,email,contNueva,direccion);
                contActual = contNueva;
            }
            
            if(ban){
                Usuario userActual = (Usuario) sesion.getAttribute("usuarioActual");
                userActual = new Usuario(usuario,contActual,nombre,apellido,telefono,email, direccion);
                sesion.setAttribute("usuarioActual", userActual);
                sesion.setAttribute("notificacion", "Datos actualizados!");
                response.sendRedirect("perfil.jsp");
            }
            else{
                sesion.setAttribute("error",usu.getError());
                response.sendRedirect("modificarDatos.jsp");
            }  
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
