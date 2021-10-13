<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROVEEDOR</title>
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
int nitProveedor=0;
String nombre="",ciudad="",direccion="",telefono="";
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
        <form action="Proveedor" method="post">
        <section class="panel important">
          <h2 style="text-align: center;">Proveedor</h2>
          <div class="twothirds">
          Nit Proveedor:<br/>
          <input type="number" id="nitProveedor1" name="nitProveedor1" size="10">    
          </div>
          <input type="submit" name="Buscar" value="Buscar">
        </section>
        
          <%
  
 if(request.getParameter("nitProveedor")!=null){
	nitProveedor=Integer.parseInt(request.getParameter("nitProveedor"));
	nombre=request.getParameter("nombre");
	ciudad=request.getParameter("ciudad");
	direccion=request.getParameter("direccion");
	telefono=request.getParameter("telefono");

	inicio="1";
	registro="";
	estado="disabled";
 }
%>
        
        <section class="panel important">
          <h2></h2>
           <div class="twothirds">
        
                Nit Proveedor:<br/>
               <input type="number" name="nitProveedor" value="<%=nitProveedor%>" size="40"><br/><br/>
                Nombre:<br/>
               <input type="text" name="nombre" value="<%=nombre%>" size="40"><br/><br/>                
                Ciudad:<br/>    
               <input type="text" name="ciudad" value="<%=ciudad%>"size="30"><br/><br/> 
                Direccion:<br/>    
               <input type="text"  name="direccion" value="<%=direccion%>"size="30"><br/><br/>
                Telefono:<br/>
                <input type="number"  name="telefono" value="<%=telefono%>" size="30"><br/><br/>
               
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
            
              <div>
            
              </div>

        </section>
       </form>
      </main>
     
</body>
</html>