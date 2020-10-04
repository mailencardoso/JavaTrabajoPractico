<%-- 
    Document   : perfil
    Created on : 18/08/2020, 23:25:03
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
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Albicar</title>
  <link rel="stylesheet" href="css/general.css">
  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/shop-homepage.css" rel="stylesheet">
  
     <script type="text/javascript">
     function ConfirmDemo() {
    //Ingresamos un mensaje a mostrar
    var mensaje = confirm("¿Está seguro que desea cerrar sesión?");
    //Detectamos si el usuario acepto el mensaje
    if (mensaje) {
    document.getElementById('cerrarsesion').submit();    
    alert("¡Gracias por visitarnos!");
    
    }
    //Detectamos si el usuario denegó el mensaje
    else {
    alert("¡Gracias por quedarte con nosotros!");
    }
    }
    </script>
</head>

<body>

  <!-- Navigation -->
 <%if (usuarioActual.getTipoUsuario().equals("administrador")){ %>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="indexlogueado.jsp"><img class="logo-navbar" src="img/logo-abreviado.png"></img></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="indexlogueado.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="productosABM.jsp">Productos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="listadoPedidosAdmin.jsp">Pedidos</a>
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
      <a class="navbar-brand" href="indexlogueado.jsp"><img class="logo-navbar" src="img/logo-abreviado.png"></img></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="indexlogueado.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="listadoProductos.jsp">Productos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="carrito.jsp">Pedidos</a>
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
    <br><br>
    <div id="personal" class="row justify-content-center">
            <h3>Mis datos personales</h3>
    </div>
    <br>
    <div class="row justify-content-center">
        <div class="col-sm-4">
            Nombre de usuario: <label class="prof"><%=usuarioActual.getUsuario()%></label>
        </div>
        <div class="col-sm-4">
            Email: <label class="prof"> <%=usuarioActual.getMail()%></label>
        </div>
    </div>
    <div id="second-row" class="row justify-content-center">
        <div class="col-sm-4">
            Nombre: <label class="prof"> <%=usuarioActual.getNombre()%></label>
        </div>
        <div class="col-sm-4">
            Apellido: <label class="prof"><%=usuarioActual.getApellido()%></label>
        </div>
    </div>    
    <div class="row justify-content-center">
        <div class="col-sm-4">
            Telefono:<label class="prof"> <%=usuarioActual.getTelefono()%></label>
        </div>
        <div class="col-sm-4">
            Dirección:<label class="prof"> <%=usuarioActual.getDireccion()%></label>
        </div>
    </div> 
    <div id="update-button" class="row justify-content-center">
        <div class="col-sm-4">
            <a class="btn btn-primary" href="modificarDatos.jsp" role="button">Modificar datos</a> <br><br>
            <form id="cerrarsesion" action="Logout" method="post">
            <input type="button" style="background-color:red; border-color:red; color:white" onclick="ConfirmDemo()" value="Cerrar sesión" />
            </form>
        </div>   
        
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
