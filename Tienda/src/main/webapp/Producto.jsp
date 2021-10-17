<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRODUCTO</title>
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
int codigo=0, precioCompra=0, iva=0, precioVenta=0, nitProveedor=0, cantidad=0;
String nombre=""; 
String inicio="", registro="1", estado="";
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script>alert('"+mensaje+"')</script>");
	registro="1";
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
        <form action="Producto" method="post"  enctype="multipart/form-data">
        
         <section class="panel important">
        <h2 style="text-align: center;">Producto</h2>
          <div class="twothirds">
             Archivo:<br/>
             <input type="file" name="archivo" value="Examinar">
              </div>
             <input type="submit" name="Subir" value="Subir">
        </section>
      
        
        <section class="panel important">
          <div class="twothirds">
          Codigo:<br/>
          <input type="number" name="codigo1" size="10">    
          </div>
          <input type="submit" name="Buscar" value="Buscar">
        </section>
        
          <%
  
 if(request.getParameter("codigo")!=null){
	codigo=Integer.parseInt(request.getParameter("codigo"));
	nombre=request.getParameter("nombre");
	precioCompra=Integer.parseInt(request.getParameter("precioCompra"));
	iva=Integer.parseInt(request.getParameter("iva"));
	precioVenta=Integer.parseInt(request.getParameter("precioVenta"));
	cantidad=Integer.parseInt(request.getParameter("cantidad"));
	nitProveedor=Integer.parseInt(request.getParameter("nitProveedor"));;
	inicio="1";
	registro="";
	estado="disabled";
 }
%>
        
        <section class="panel important">
          <h2></h2>
       
              <div class="twothirds">
              <% 
              if(inicio=="1")
            		{
			 %>
                Codigo:<br/>    
               <input type="number" id="name" name="codigo" value="<%=codigo%>"size="30"><br/><br/>
              <%
              }
              %>
                Nombre:<br/>    
               <input type="text" id="name" name="nombre" value="<%=nombre%>"size="30"><br/><br/>
               Precio Compra:<br/>
               <input type="number" id="cedula" name="precioCompra" value="<%=precioCompra%>" size="40"><br/><br/>
               Iva %:<br/>    
               <input type="number" name="iva" value="<%=iva%>"size="30"><br/><br/>  
               Precio Venta:<br/>
                <input type="number" name="precioVenta" value="<%=precioVenta%>" size="30"><br/><br/>
               Cantidad:<br/>
               <input type="number" name="cantidad" value="<%=cantidad%>" size="30"><br/><br/>
               Nit Proveedor:<br/>
               <input type="number" name="nitProveedor" value="<%=nitProveedor%>" size="30">
               
               
                    <% 
            if(registro=="1")
            {
            %>
			<input type="submit" name="Registro" value="Registrar"><br>
			<% 
            }    
            		if(inicio=="1")
            		{
			%>
			<input type="submit" name="Actualizar" value="Actualizar">
            <input type="submit" name="Eliminar" value="Eliminar" onclick="return confirm('Seguro que desea eliminar?')">
            <%
            		}
            %>
              </div>

              

        </section>
         
       </form>
      </main>
     
</body>
</html>