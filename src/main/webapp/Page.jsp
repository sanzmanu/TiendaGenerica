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
<header class="header">
		<nav class="nav">
			<a href="#" class="logo nav-link">TiWeb Solutions</a>
			<ul class="nav-menu">
				 <li class="nav-menu-item">
				 <a class="nav-menu-link nav-link" href="#">Usuarios</a></li>
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
<div id="BDUsuario">
	<form action="" method="get">
		<label id="titulo">Nombre y Apellidos: </label>
		<br/><br/>
		<input class="entrada" type="text" name="Usuario" value=""placeholder="Nombre y Apellido" />
		<br/><br/>
		<label id="titulo">Cedula: </label>
		<br/><br/>
		<input class="entrada" type="text" name="Contraseña" value="" placeholder="Cedula" />
		<br/><br/>
		<label id="titulo">Correo Electronico: </label>
		<br/><br/>
		<input class="entrada" type="text" name="Contraseña" value="" placeholder="Correo Electronico" />
		<br/><br/>
	</form>
</div>
</body>
</html>