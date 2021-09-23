<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link  rel="stylesheet" type="text/css" href="css/StylePage.css" />
<title>Tienda Generica</title>
</head>
<body>
<% //scriplets para insertar odigo java en html
String nombre=request.getParameter("nom");
%>
<header class="header">
		<nav class="nav">
			<a href="#" class="logo nav-link">TicWeb Solutions - <%=nombre %></a>
			<ul class="nav-menu">
				 <li class="nav-menu-item">
				 <a class="nav-menu-link nav-link" href="usuarios.jsp">Usuarios</a></li>
			     <li class="nav-menu-item">
			     <a class="nav-menu-link nav-link" href="#">Clientes</a></li>
			     <li class="nav-menu-item">
			     <a class="nav-menu-link nav-link" href="#">Provedores</a></li>
			     <li class="nav-menu-item">
			     <a class="nav-menu-link nav-link" href="#">Productos</a></li>
			     <li class="nav-menu-item">
			     <a class="nav-menu-link nav-link" href="#">Ventas</a></li>
			     <li class="nav-menu-item">
			     <a class="nav-menu-link nav-link" href="#">Reportes</a></li>
			</ul>
		</nav>
</header>
</body>
</html>