<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VENTAS</title>
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

String mensaje="";
int canT1=0,canT2=0,canT3=0,consec=0;
float vlrT1=0,vlrT2=0,vlrT3=0, totalVenta=0, totalIva=0, totalConIva=0, vlrU1=0, vlrU2=0, vlrU3=0;
int cedulaCliente=0, cedulaUsuario=0, codigoProducto1=0, codigoProducto2=0, codigoProducto3=0;
String NombreProducto1="",NombreProducto2="",NombreProducto3="";
String estado="enabled",nombreCliente="",nombreUsuario="";
%>

<%

if(request.getParameter("cosecutivo")!=null){
	consec=Integer.parseInt(request.getParameter("consecutivo"));
	mensaje="";
	estado="enabled";
}
if(request.getParameter("totalventa")!=null){
	totalVenta=Float.parseFloat(request.getParameter("totalventa"));
	totalIva=Float.parseFloat(request.getParameter("totaliva"));
	totalConIva=Float.parseFloat(request.getParameter("totalconiva"));
	canT3=Integer.parseInt(request.getParameter("cantidad3"));
}
%>

<header role="banner">
        <h1>Modulo de Ventas</h1>
        <ul class="utilities">
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
 <%
  
 if(request.getParameter("cedula_usuario")!=null){
	cedulaUsuario=Integer.parseInt(request.getParameter("cedula_usuario"));
	nombreUsuario=request.getParameter("nombreUsuario");
	estado="disabled";
 }
 if(request.getParameter("cedula_cliente")!=null){
    cedulaCliente=Integer.parseInt(request.getParameter("cedula_cliente"));
	nombreCliente=request.getParameter("nombre_cliente");
	estado="disabled";
 }
 if(request.getParameter("cproducto1")!=null){
	 codigoProducto1=Integer.parseInt(request.getParameter("cproducto1"));
	 NombreProducto1=request.getParameter("nombreProducto1");
	 vlrU1=Float.parseFloat(request.getParameter("precioVenta1"));
	estado="disabled";
 }
 if(request.getParameter("cproducto2")!=null){
	 codigoProducto2=Integer.parseInt(request.getParameter("cproducto2"));
	 NombreProducto2=request.getParameter("nombreProducto2");
	 vlrU2=Float.parseFloat(request.getParameter("precioVenta2"));
	 canT1=Integer.parseInt(request.getParameter("cantidad1"));
	estado="disabled";
 }
 if(request.getParameter("cproducto3")!=null){
	 codigoProducto3=Integer.parseInt(request.getParameter("cproducto3"));
	 NombreProducto3=request.getParameter("nombreProducto3");
	 vlrU3=Float.parseFloat(request.getParameter("precioVenta3"));
	 canT2=Integer.parseInt(request.getParameter("cantidad2"));

	estado="disabled";
 }
 
%>
      <main role="main">
        <form action="Venta" method="post">
        <section class="panel important">
          <h2>Consulta</h2>
          <ul>
          <div class="twothirds">
          Cedula Usuario:<br/>
         <input type="number" id="cedula_usuario" name="cedula_usuario" size="10" value=<%=cedulaUsuario%>>   
          Usuario:
          <input type="text" id="nombre_usuario" name="nombre_usuario" size="10" value="<%=nombreUsuario%>"disabled>
          </div>
          <input type="submit" name="Consultar_usuario" value="Consultar Usuario">
          
         </ul>
         
         <ul>
          <div class="twothirds">
          Cedula Cliente:<br/>
          <input type="number" id="cedula_cliente" name="cedula_cliente" size="10" value=<%=cedulaCliente%>>  
           Usuario:
          <input type="text" id="nombre_cliente" name="nombre_cliente" size="10" value="<%=nombreCliente%>" disabled>
           </div>
          <input type="submit" name="Consultar_cliente" value="Consultar_Cliente">
          </ul>
        </section>
        

        
        <section class="panel important">
          <h2>Ventas</h2>
             
              </div>

        </section>
        <section class="panel important">
          <h2>Producto 1</h2>
       
          <ul>
          <div class="twothirds">
          Codigo del producto:<br/>
          <input type="number" id="cproducto1" name="cproducto1" value="<%=codigoProducto1%>">  
           Nombre del producto:
          <input type="text" id="nproducto1" name="nproducto1"value="<%=NombreProducto1%>" disabled>          
          Valor por Unidad:
          <input type="number" id="vunidad1" name="vunidad1"value="<%=vlrU1%>" disabled>
          Cantidad:
          <input type="number" id="cantidadp1" name="cantidadp1" value="<%=canT1%>">  
           </div>
          <input type="submit" name="Conproducto1" value="Consultar">
          </ul>
        </section>
        
          <section class="panel important">
          <h2>Producto 2</h2>
       
          <ul>
          <div class="twothirds">
          Codigo del producto:<br/>
          <input type="number" id="cproducto2" name="cproducto2" value="<%=codigoProducto2%>">  
           Nombre del producto:
          <input type="text" id="nproducto2" name="nproducto2"value="<%=NombreProducto2%>" disabled>
          Valor por Unidad:
          <input type="number" id="vunidad2" name="vunidad2" value="<%=vlrU2%>" disabled> 
          Cantidad:
          <input type="number" id="cantidadp2" name="cantidadp2" value="<%=canT2%>"> 
           </div>
          <input type="submit" name="Conproducto2" value="Consultar">
          </ul>
        </section>
        
        <section class="panel important">
          <h2>Producto 3</h2>
       
          <ul>
          <div class="twothirds">
          Codigo del producto:<br/>
          <input type="number" id="cproducto3" name="cproducto3" value="<%=codigoProducto3%>">  
           Nombre del producto:
          <input type="text" id="nproducto3" name="nproducto3"value="<%=NombreProducto3%>" disabled>
          Valor por Unidad:
          <input type="number" id="vunidad3" name="vunidad3" value="<%=vlrU3%>" disabled> 
           Cantidad:
          <input type="number" id="cantidadp3" name="cantidadp3" value="<%=canT3%>"> 
           </div>
          <input type="submit" name="Conproducto3" value="Consultar">
          </ul>
        </section>
       
       
       <section class="panel important">
          <h2>Total</h2>
       
          <ul>
          <div class="twothirds">
          Total venta:<br/>
          <input type="number" id="tventa" name="tventa" disabled value="<%=totalVenta%>">  
           Total IVA:
          <input type="number" id="tiva" name="tiva" disabled value="<%=totalIva%>">
          Total con IVA:
          <input type="number" id="totalciva" name="totalciva" value="<%=totalConIva%>"> 
           </div>
          <input type="submit" name="calcular" value="Calcular">
          <input type="submit" name="confirmar" value="Confirmar">
          </ul>
        </section>
        </form>
      </main>
     
</body>
</html>