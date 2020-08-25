<%-- 
    Document   : modificarDatos
    Created on : 24/08/2020, 21:23:31
    Author     : Usuario
--%>
<%@page import="Negocio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion = request.getSession(false);
    Usuario usuarioActual = (Usuario) objSesion.getAttribute("userActual");
    objSesion.removeAttribute("error");
    String notificacion = "";
    if (objSesion.getAttribute("notificacion") != null){
        notificacion = (String) objSesion.getAttribute("notificacion");
    }
    if(usuarioActual == null){
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Datos</title>
        <link rel="stylesheet" href="css/general.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    </head>
    <body>
        <%if (usuarioActual.getTipoUsuario().equals("administrador")){ %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Compra Online!</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pedidos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="perfil.jsp">Hola, <%=usuarioActual.getUsuario()%></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <%}%>
 
    <%if (usuarioActual.getTipoUsuario().equals("Cliente")){ %>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Compra Online!</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contacto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="perfil.jsp">Hola, <%=usuarioActual.getUsuario()%></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <%}%> 
  <!-- Page Content -->
    <div class="container-profile">
        <div class ="row" >
            <form action="ModificarDatos" method="post">
                <h3>Mis datos Personales</h3>
                <%if (notificacion.equals("Modificaciòn realizada")){ %>
                <div class="alert alert-success" role="alert">
                    ¡Modificación realizada <b>con éxito</b>!
                </div>                 
                <%}%>
                <%objSesion.removeAttribute("exito");%>
                <%if (notificacion.equals("Usuario ingresado ya existe.")){ %>   
                <div class="alert alert-danger" role="alert">
                    Usuario ingresado <b>ya existe</b>. Ingrese uno diferente.
                </div>   
                <%}%>
                <%objSesion.removeAttribute("error");%>    
                <label for="exampleInputNombre">Nombre</label>
                <input type="text" class="form-control" id="exampleInputNombre" name="nombre" aria-describedby="nombreHelp" placeholder="Nombre" required><br>
                <label for="exampleInputApellido">Apellido</label>
                <input type="text" class="form-control" id="exampleInputApellido" name="apellido" aria-describedby="apellidoHelp" placeholder="Apellido" required><br>
                <label for="exampleInputUsuario">Usuario</label>
                <input type="text" class="form-control" id="exampleInputUsuario" name="usuario" aria-describedby="descripcionUsuario" placeholder="Usuario" required pattern="[a-zA-Z0-9]+" minlength="8" maxlength="16" title="Solo caracteres alfanuméricos sin espacios."><br>
                <label for="exampleInputContraseña">Contraseña</label>
                <input type="password" class="form-control" id="exampleInputContraseña" name="contrasena" aria-describedby="passHelp" placeholder="Contraseña" required minlength="8" maxlength="16"><br>
                <label for="exampleInputCorreo">Email</label>
                <input type="email" class="form-control" id="exampleInputCorreo" name="email" aria-describedby="emailHelp" placeholder="Correo electrónico" required><br>
                <label for="exampleInputTel">Teléfono</label>
                <input type="tel" class="form-control" id="exampleInputTel" name="telefono" aria-describedby="telHelp" placeholder="Teléfono" required pattern="[0-9]+" title="Ingrese solo números."><br>
                <label for="exampleInputDireccion">Dirección</label>
                <input type="text" class="form-control" id="exampleInputDireccion" name="direccion" aria-describedby="direccionHelp" placeholder="Dirección" required><br>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Crear cuenta</button>
                </div> 
                    
            </form>
        </div>
    </div>
  
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
