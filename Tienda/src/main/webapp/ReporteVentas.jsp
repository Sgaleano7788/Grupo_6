<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/reporteVenta.js"></script>
<title>Reporte Ventas</title>

<link rel="stylesheet" href="Login_2.css">
<link rel="stylessheet" href="menu.css">
<style type="text/css">
.menu li a:hover{
background-color:black;
}
.menu li ul{
 display:none;
}
.menu li:hover > ul{
display:block;
}
</style>
</head>
<body>


<header role="banner">
        <h1>Scent of Victory</h1>
        <ul class="utilities">
          <li class="users"><a href="#">Mi cuenta</a></li>
          <li class="logout warn"><a href="Login.jsp">Salir</a></li>
        </ul>
      </header>
      
     <nav role='navigation'>
         <ul class="menu">
          <li class="dashboard"><a href="Usuario.jsp">Usuario</a></li>
          <li class="edit"><a href="Cliente.jsp">Cliente</a></li>
          <li class="write"><a href="Proveedor.jsp">Proveedor</a></li>
          <li class="write"><a href="Producto.jsp">Producto</a></li>     
           <li class="write"><a href="Venta.jsp">Ventas </a></li>
          <li ><a href="#">Reportes</a>
           <ul>
              <li><a href="ReporteUsuarios.jsp">Listar Usuarios</a></li>
              <li><a href="ReporteClientes.jsp">Listar Clientes</a></li>
              <li><a href="ReporteVentas.jsp">Listar Ventas Por Cliente</a></li>
            </ul>
          </li>
          
        </ul>
      </nav>
      
      <main role="main">
        <form  method="post">
        <section class="panel important">
        <br/>
          <h2 style="text-align: center;">Total De Ventas Por Cliente</h2>
          <br/>
     
          <table id="ListaVentas" >
          </table>
          <h2 id="total">
          </h2>
        </section>
    
       
       </form>
      </main>
     
</body>
</html>