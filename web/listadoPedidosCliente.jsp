<%-- 
    Document   : listadoPedidosAdmin
    Created on : 04/10/2020, 15:52:54
    Author     : maiic
--%>

<%@page import="Negocio.Usuario"%>
<%@page import="Datos.ConsultaPedidos"%>
<%@page import="Negocio.Pedido"%>
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
            <a class="nav-link" href="listadoPedidosCliente.jsp">Lista de Pedidos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="perfil.jsp">Hola, <%=usuarioActual.getUsuario()%></a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

 <div class="container-profile">
      <a type="submit" class="btn btn-secondary" id="seguir-comprando" href="indexlogueado.jsp">← Volver</a>

    <div class ="row justify-content-center" >
            <h3 id="pedido">Mis Pedidos Realizados</h3>
            
            <table class="table table-striped" id="tablaListadoPedidos">
                <thead>
                    <tr>
                        <th scope="col">Datos del Cliente</th>
                        <th scope="col">Datos del pedido</th>
                        <th scope="col">Productos</th>
                    </tr>
                </thead>
                <tbody>
                    <% ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
                     ConsultaPedidos ped = new ConsultaPedidos();
                     pedidos = ped.listadoPedidosCliente(usuarioActual.getUsuario());
                    
                    for (int i=0;i<pedidos.size();i++){%>
                   <tr>
                     <td>Usuario: <%=pedidos.get(i).getUsuarioCliente()%>
                     <br><br>Nombre: <%=pedidos.get(i).getNombreCliente()%> <%=pedidos.get(i).getApellidoCliente()%>
                     <br><br>Teléfono: <%=pedidos.get(i).getTelefonoCliente()%>
                     <br><br>Mail: <%=pedidos.get(i).getMailCliente()%></td>
                     
                     <td>ID Pedido: <%=pedidos.get(i).getId()%>
                     <br><br>Fecha Pedido: <%=pedidos.get(i).getFechaPedido()%></td>
                     
                     <td><% for (int j=0;j<pedidos.get(i).getLineas().size();j++){%>
                         Nombre Producto: <%=pedidos.get(i).getLineas().get(j).getProducto().getNombre()%>
                     <br><br>Precio Unitario: <%=pedidos.get(i).getLineas().get(j).getProducto().getPrecio()%>
                     <br><br>Categoria: <%=pedidos.get(i).getLineas().get(j).getProducto().getCategoria()%>
                     <br><br>Cantidad: <%=pedidos.get(i).getLineas().get(j).getCantidad()%>
                     <%}%>
                     <br><br> Total <%pedidos.get(i).setPrecio();%>
                            $<%=pedidos.get(i).getPrecio()%></td>             
                        <br>
                   </tr>
                   <%}%>
                    
                </tbody>
            </table>
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