<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Login.css">
<title>Login</title>
</head>
<body>
<%
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script>alert('"+mensaje+"')</script>");
	
}
%>
<div class="login-pagina">
        <div class="form">
          <form class="formulario-registro">
            <input type="text" placeholder="name"/>
            <input type="password" placeholder="Contraseña"/>
            <input type="text" placeholder="Usuario"/>
          </form>
          <form action="Login" method="post" class="formulario-login">
            <input type="text" placeholder="Usuario"name="Usuario"/>
            <input type="password" placeholder="Contraseña"name="Pass"/>
            <button  name="enviar">Ingresar</button>
        </div>
      </div>
</body>
</html>
    
    
    
