<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Index.css">
<title>Index</title>
</head>
<body>
    <form>
        <div class="menu-rel">
           <div class="menu">
              <div class="menu-opciones">
                 <div class="menu-hamburguer">
                    <input type="checkbox" value="selected" id="menu-hamburguer" class="menu-input">
                    <label for="menu-hamburguer" class="menu-label">
                    <img src="../imagenes/svg.png">
                    </label>
                    <div role="menu" id="menuid" class="menu-contenido">
                       <div class="menu-list">
                          <div class="menu-list-item fechar-lado"><button class="fechar" type="reset">
                             <i class="fa fa-times-circle fa-2x" aria-hidden="true"></i></button>
                          </div>
                          <div class="menu-list-item"><a href="#">Home</a></div>
                          <div class="menu-list-item"><a href="#">Usage</a></div>
                          <div class="menu-list-item"><a href="#">Getting Started</a></div>
                          <div class="menu-list-item"><a href="login.html">Templates</a></div>
                       </div>
                    </div>
                 </div>
              </div>
              <div class="menu-principal">
                 <ul>
                    <li><a class="botao-menu-atencao"  href="login.html">Subir Productos</a></li>
                    <li><a class="botao-menu-atencao" href="login.html">Proveedores</a></li>
                    <li><a class="botao-menu-atencao" href="login.html">Registro Clientes</a></li>
                    <li><a class="botao-menu-atencao" href="Usuario.jsp">Registro Usuarios</a></li>
                 </ul>
              </div>
           </div>
        </div>
     </form>
     <div class="fondo-degradado"></div>
</html>