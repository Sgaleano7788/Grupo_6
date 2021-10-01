<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Login_2.css">
</head>
<body>
<%
int cedula=0;
String email="", nombre="",password="",usuario="";
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
        <ul class="main">
          <li class="dashboard"><a href="Usuario.jsp">Usuarios</a></li>
          <li class="edit"><a href="Cliente.jsp">Clientes</a></li>
          <li class="write"><a href="#">Productos </a></li>
          <li class="users"><a href="#">Registro proveedores</a></li>
        </ul>
      </nav>
      
      <main role="main">
        <form action="Usuario" method="post">
        <section class="panel important">
          <h2>USUARIOS</h2>
          <div class="twothirds">
          Cedula:<br/>
          <input type="number" id="cedula" name="cedula1" size="10">    
          </div>
          <input type="submit" name="Buscar" value="Buscar">
        </section>
        
          <%
  
 if(request.getParameter("cedula")!=null){
	cedula=Integer.parseInt(request.getParameter("cedula"));
	email=request.getParameter("email");
	nombre=request.getParameter("nombre");
	password=request.getParameter("password");
	usuario=request.getParameter("usuario");
	inicio="1";
	registro="";
	estado="disabled";
 }
%>
        
        <section class="panel important">
          <h2></h2>
       
              <div class="twothirds">
                Cedula:<br/>
               <input type="number" id="cedula" name="cedula" value="<%=cedula%>" size="40"><br/><br/>
                Email:<br/>    
               <input type="email" id="email" name="email" value="<%=email%>"size="30"><br/><br/>  
                Nombre:<br/>    
               <input type="text" id="name" name="nombre" value="<%=nombre%>"size="30"><br/><br/>
                Contraseña:<br/>
                <input type="password" id="password"   name="password" value="<%=password%>" size="30">
               
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
            <input type="submit" name="Eliminar" value="Eliminar">
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