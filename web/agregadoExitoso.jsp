<%-- 
    Document   : registroNuevo
    Created on : 05-ago-2020, 14:59:25
    Author     : Diana
--%>
<%@page import="Negocio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion = request.getSession(false);
    Usuario usuarioActual = (Usuario) objSesion.getAttribute("userActual");
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

</head>

<body>

  <!-- Navigation -->
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
          <br><br><br><br><br>
    <div class="row justify-content-center" >
         <div class ="form-group justify-content-center" >
             <div class="alert alert-success" role="alert">
                       ¡Producto nuevo agregado <b>exitosamente</b>!
                        </div>              
             
              <a type="button"  class="btn btn-primary" href="productosABM.jsp">Volver</a>
             
            </div>
            
        
    </div>


  
</body>
</html>