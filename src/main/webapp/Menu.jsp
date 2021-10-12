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
// String nombre=request.getParameter("nom");
int id=Integer.parseInt(request.getParameter("id"));
%>
<header class="header">
		<nav class="nav">
			<a href="#" class="logo nav-link">TicWeb Solutions</a>
			<ul class="nav-menu">
				 <li class="nav-menu-item">
				 <a class="nav-menu-link nav-link" href="usuarios.jsp?id=<%=id %>">Usuarios</a></li>
			     <li class="nav-menu-item">
			     <a class="nav-menu-link nav-link" href="clientes.jsp?id=<%=id %>">Clientes</a></li>
			     <li class="nav-menu-item">
			     <a class="nav-menu-link nav-link" href="proveedores.jsp?id=<%=id %>">Proveedores</a></li>
			     <li class="nav-menu-item">
			     <a class="nav-menu-link nav-link" href="productos.jsp?id=<%=id %>">Productos</a></li>
			     <li class="nav-menu-item">
			     <a class="nav-menu-link nav-link" href="ventas.jsp?id=<%=id %>">Ventas</a></li>
			     <li class="nav-menu-item">
			     <a class="nav-menu-link nav-link" href="reportes.jsp?id=<%=id %>">Reportes</a></li>
			</ul>
		</nav>
</header>
</body>
</html>