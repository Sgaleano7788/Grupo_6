<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scent of Victory</title>
<link rel="stylesheet" href="Login_2.css">
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
<%

if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script>alert('"+mensaje+"')</script>");

} 
%>

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
        
        <section class="panel important">
        
        <section class="panel important">
          <h2></h2>
            <form action="" method="post">
              <div class="twothirds">
              <br/>
              <br/>
              <h2 style="text-align: center;">MISION</h2><br/><br/>
              <h3 style="text-align: center;">Somos una empresa dedicada a la comercialización de perfumes y esencias<br/> 
              comprometida en ofrecer a nuestros socios de negocios una opción  <br/>
             personalizada, de excelente calidad y a un precio justo.<br/>
             </h3>
              <br/>             
              <br/>             
               <h2 style="text-align: center;">VISION</h2><br/><br/>
              <h3 style="text-align: center;">Consolidarnos como la empresa líder en la industria de la perfumería en<br/>  
              Centro y Sur América, garantizando las mejores y más innovadoras soluciones  <br/> 
              para nuestros socios de negocios a través de un servicio con el más alto estándar de calidad.<br/> 
             </h3><br/><br/><br/>
              </div>
            </form>
        </section>
      
      </main>
     
</body>
</html>