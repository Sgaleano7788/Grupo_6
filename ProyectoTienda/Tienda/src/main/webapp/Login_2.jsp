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
        
        <section class="panel important">
          <h2>Unidades Guardadas</h2>
          <ul>
            <li>"listas de Unidades"</li>
          </ul>
        </section>
        
        <section class="panel important">
          <h2>Agregar Producto</h2>
            <form action="" method="post">
              <div class="twothirds">
                Nombre del producto:<br/>
                <input type="text" name="title" size="40"/><br/><br/>
                Precio del producto:<br/>    
                <input type="number"name="Precio"size="30"/><br/><br/>  
                Unidades disponibles:<br/>    
                <input type="number"name="Unidades"size="30"/><br/><br/>
                Descripcion del producto:<br/>
                <textarea name="newstext" rows="15" cols="67"></textarea><br/>  
                Imagen del producto:<br/>    
                <input type="file" accept="image/*"name="Imagen"size="30"/><br/><br/> 
              </div>
              <div>
                <input type="submit" name="submit" value="Guardar" />
              </div>
            </form>
        </section>
      
      </main>
     
</body>
</html>