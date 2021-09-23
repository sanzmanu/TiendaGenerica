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
<%!
int cedula=0;
String email="",nombre="",password="",usuario="",estado="";
%>
<%
if(request.getParameter("cedula")!=null){
	cedula=Integer.parseInt(request.getParameter("cedula"));
	email=request.getParameter("email");
	nombre=request.getParameter("nombre");
	password=request.getParameter("password");
	usuario=request.getParameter("usuario");
	estado="disabled";
}
%>
<header class="header">
		<nav class="nav">
			<a href="#" class="logo nav-link">TicWeb Solutions</a>
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

<div id="BDUsuario">
		<form action="Usuarios" method="post">
			<div>
			<h2>Datos Personales</h2>
				<div>
					<label class="entrada" >Cédula </label>
				</div>
				<div>
					<input class="entrada" type="text" placeholder="123456" name="cedula" required="required" value="<%=cedula%>" <%=estado%>>
					<input type="hidden"  name="ced" value="<%=cedula%>">
				</div>
				<div>
					<label class="entrada">Nombre Completo </label>
				</div>
				<div>
					<input class="entrada" type="text" placeholder="Juan Perez" name="nombre" required="required" value="<%=nombre%>">
				</div>
				<div>
					<label class="entrada" >Correo </label>
				</div>
				<div>
					<input class="entrada" type="email" placeholder="abc@ejemplo.com" name="correo" required="required" value="<%=email%>">
				</div>
				<h2>Datos de Acceso</h2>
				<div>
					<label class="entrada" >Usuario </label>
				</div>
				<div>
					<input class="entrada" type="text" placeholder="juanp" name="usuario" required="required" value="<%=usuario%>">
				</div>
				<div>
					<label class="entrada" >Contraseña </label>
				</div>
				<div>
					<input class="entrada" type="text" placeholder="****" name="clave" required="required" value="<%=password%>">
				</div>
			</div>
			<div class="botones">
				<input class="btonIngresar" type="submit" name="crear" value="Crear">
				<input class="btonIngresar" type="submit" name="actualizar" value="Actualizar">
				<input class="btonIngresar" type="submit" name="borrar" value="Borrar">
			</div>
		</form>
	</div>
	<hr>
<form action="Usuarios" method="post">
<fieldset>
<legend>Consultar</legend>
<div><label class="entrada">Cedula: </label><input class="entrada" type="text" name="id">
<input class="btonIngresar" type="submit" name="consultar" value="Consultar"></div>
</fieldset>
</form>
	<%
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script>alert('"+mensaje+"');</script>");
}
%>
</body>
</html>