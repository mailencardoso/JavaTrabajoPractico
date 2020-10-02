<%-- 
    Document   : buscaProductoEliminar
    Created on : 21/09/2020, 21:09:32
    Author     : maiic
--%>

<%@page import="Negocio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion = request.getSession(false);
    Usuario usuarioActual = (Usuario) objSesion.getAttribute("userActual");
    if(usuarioActual == null){
        response.sendRedirect("index.jsp");
    }
    String notificacion = "";
   if (objSesion.getAttribute("estado") != null){
        notificacion = (String) objSesion.getAttribute("estado");
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
            <a class="nav-link" href="#">Pedidos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="perfil.jsp">Hola, <%=usuarioActual.getUsuario()%></a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

 
  <!-- Page Content -->
 <div class="container-profile">
    
    <div class ="row justify-content-center" >
        <form action="BuscarProductosDelete" method="post">
            <h3 id="modif">Buscar Productos</h3>
            
            <label for="exampleCodigoProd">Código</label>
            <input type="text" class="form-control" id="exampleCodigoProd" name="codigo" aria-describedby="codigoHelp" required><br>
        <%if (notificacion.equals("Eliminado correctamente")){ %>
                <div class="alert alert-success" role="alert">
                                ¡Producto eliminado <b>correctamente</b>!
                            </div>                 
                <%}%>
                 <%objSesion.removeAttribute("estado");%>
        <%if (notificacion.equals("Error: Codigo de producto no existe.")){ %>
                <div class="alert alert-danger" role="alert">
                                <b>¡ERROR!</b> Producto inexistente. <br>Ingrese de nuevo.
                            </div>              
                <%}%>
                 <%objSesion.removeAttribute("estado");%>
        <div class="form-group" id="modificar-datos-button"> 
            <a type="button"  class="btn btn-secondary" href="productosABM.jsp">Cancelar</a>
            <button type="submit"  class="btn btn-primary">Buscar</button>
                    
        </div>
        </form>
    </div>
  <!-- /.container -->
</div>
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


