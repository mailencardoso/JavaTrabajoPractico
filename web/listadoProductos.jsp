<%-- 
    Document   : fiambres
    Created on : 28-sep-2020, 17:50:54
    Author     : Diana
--%>

<%@page import="Negocio.Usuario"%>
<%@page import="Datos.ConsultaProductos"%>
<%@page import="Negocio.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion = request.getSession(false);
    Usuario usuarioActual = (Usuario) objSesion.getAttribute("userActual");
   // objSesion.removeAttribute("error");
   // String tipoUsuario = userActual.getTipoUsuario();
   // if(userActual.getNombreUsuario().equals("")|| tipoUsuario.equals("Administrador")){
       // response.sendRedirect("index.jsp");
    //}
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

  <!-- Navigation  -->
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
 <div class="container">
     
     <% ArrayList<Producto> prod = new ArrayList<Producto>(); prod = null;
            ConsultaProductos productos = new ConsultaProductos();
            prod = productos.listadoProductos(); %>
            <br>
            <br>
            <br>
            
            
    <div class="row">
        <div class="col-lg-3">

        <h1 class="my-4"><img class="logo" src="img/logo.png"></img></h1>
        <div class="list-group">
          <a href="bebidas.jsp" class="list-group-item">Bebidas</a>
          <a href="carnes.jsp" class="list-group-item">Carnicería y pescadería</a>
          <a href="fiambres.jsp" class="list-group-item">Fiambres y salchichas</a>
          <a href="lacteos.jsp" class="list-group-item">Lácteos y quesos</a>
          <a href="panaderia.jsp" class="list-group-item">Panadería y bollería industrial</a>
          <a href="limpieza.jsp" class="list-group-item">Productos de limpieza</a>          
          <a href="perfumeria.jsp" class="list-group-item">Perfumería</a>          
        </div>
        </div>
        
        <div class="col-lg-9">
            
            <h3 class="listadoprod">Listado de Productos</h3>
            <div class="row justify-content-end">
        
                
                
            <%for(int i=0;i<prod.size();i++ ){%>
                <div class="col-lg-4 col-md-6 mb-4">
                  <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="data:image/jpg;base64,<%=prod.get(i).base64Image%>" alt=""></a>
                    <div class="card-body">
                         
                      <h4 class="card-title">
                        <a href="#"><%=prod.get(i).getNombre()%></a>
                      </h4>
                      <h5><%=prod.get(i).getPrecio()%></h5>
                      <p class="card-text"><%=prod.get(i).getDescripcion()%></p>
                    </div>
                    <form action="AgregarProducto" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="idProducto" value="<%=prod.get(i).getID()%>">
                            <input type="hidden" name="nombreProducto" value="<%=prod.get(i).getNombre()%>">
                            <input type="hidden" name="descripcionProducto" value="<%=prod.get(i).getDescripcion()%>">
                            <input type="hidden" name="precioProducto" value="<%=prod.get(i).getPrecio()%>">
                            <input type="hidden" name="imagenProducto" value="<%=prod.get(i).base64Image%>">
                            <input type="hidden" name="categoriaProducto" value="<%=prod.get(i).getCategoria()%>">
                            <label id="cantidad">Cantidad: </label>     <input type="text" name="cantidad" id="cantidad" size="1">
                            <div class="card-footer">    
                                <input type="submit" class="btn btn-primary" id="carrito-button" value="Agregar carrito">
                            </div>
                        </form>   
                    
                  </div>
                </div>
               <%}%>
              
             
          
            
            </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

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