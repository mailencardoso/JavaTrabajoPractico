<%-- 
    Document   : registroNuevo
    Created on : 05-ago-2020, 14:59:25
    Author     : Diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrate</title>
        <link rel="stylesheet" href="css/general.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    </head>
<!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="index.jsp">Compra Online!</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp">Home
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
            <a class="nav-link" href="login.jsp">Iniciar Sesión</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
    <div class="container-log" >
        <div class ="row" >
            <form action="Registro">
                <h3 class="registrar">Regístrate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3>
                        <div class="form-group">
                            <label for="exampleInputNombre">Nombre</label>
                            <input type="text" class="form-control" id="exampleInputNombre" name="nombre" aria-describedby="nombreHelp" placeholder="Nombre"><br>
                            <label for="exampleInputApellido">Apellido</label>
                            <input type="text" class="form-control" id="exampleInputApellido" name="apellido" aria-describedby="apellidoHelp" placeholder="Apellido"><br>
                            <label for="exampleInputUsuario">Usuario</label>
                            <input type="text" class="form-control" id="exampleInputUsuario" name="usuario" aria-describedby="usuarioHelp" placeholder="Usuario"><br>
                            <label for="exampleInputContraseña">Contraseña</label>
                            <input type="password" class="form-control" id="exampleInputContraseña" name="contraseña" aria-describedby="passHelp" placeholder="Contraseña"><br>
                            <label for="exampleInputCorreo">Email</label>
                            <input type="email" class="form-control" id="exampleInputCorreo" name="email" aria-describedby="emailHelp" placeholder="Correo electrónico"><br>
                            <label for="exampleInputTel">Telefono</label>
                            <input type="text" class="form-control" id="exampleInputTel" name="telefono" aria-describedby="telHelp" placeholder="Teléfono"><br>
                            <label for="exampleInputDireccion">Direccion</label>
                            <input type="text" class="form-control" id="exampleInputDireccion" name="direccion" aria-describedby="direccionHelp" placeholder="Dirección"><br>
                                        
                            <div class="form-group" >
                                <button type="submit" class="btn btn-primary">Crear cuenta</button>
                            </div> 
                        </div>
                                
            </form>
        </div>
    </div>

  
</body>
</html>
