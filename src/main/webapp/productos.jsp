<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/StylePage.css" />
<title>Tienda Generica</title>
</head>
<body>
<%!
int codigoP=0,nit=0,id=0;
String nombre="",estado="";
double iva=0.0, precioC=0.0,precioV=0.0;
%>
<%
if(request.getParameter("codigo")!=null){
	codigoP=Integer.parseInt(request.getParameter("codigo"));
	nombre=request.getParameter("nombre");
	iva=Double.parseDouble(request.getParameter("iva"));
	precioC=Double.parseDouble(request.getParameter("precioC"));
	precioV=Double.parseDouble(request.getParameter("precioV"));
	estado="disabled";
}
if(request.getParameter("id")!=null){
	id=Integer.parseInt(request.getParameter("id"));
}
%>
	<header class="header">
		<nav class="nav">
			<a href="#" class="logo nav-link">TicWeb Solutions</a>
			<ul class="nav-menu">
				<li class="nav-menu-item"><a class="nav-menu-link nav-link" href="usuarios.jsp?id=<%=id %>">Usuarios</a></li>
				<li class="nav-menu-item"><a class="nav-menu-link nav-link" href="clientes.jsp?id=<%=id %>">Clientes</a></li>
				<li class="nav-menu-item"><a class="nav-menu-link nav-link" href="proveedores.jsp?id=<%=id %>">Proveedores</a></li>
				<li class="nav-menu-item"><a class="nav-menu-link nav-link" href="productos.jsp?id=<%=id %>">Productos</a></li>
				<li class="nav-menu-item"><a class="nav-menu-link nav-link" href="ventas.jsp?id=<%=id %>">Ventas</a></li>
				<li class="nav-menu-item"><a class="nav-menu-link nav-link" href="reportes?id=<%=id %>">Reportes</a></li>
			</ul>
		</nav>
	</header>
	<div id="BDUsuario">
		<form action="Productos" method="post" enctype="multipart/form-data">
			<div>
				<label class="entrada">Nombre del Archivo</label><input
					class="entrada" type="file" value="Examinar" name="archivo">
			</div>
			<div class="botones">
				<input class="btonIngresar" type="submit" value="Cargar"
					name="cargar">
			</div>
		</form>
		<hr>
		<form action="Productos" method="post">
			<fieldset>
				<legend>Consultar</legend>
				<div>
					<label class="entrada">Código Producto: </label><input class="entrada"
						type="text" name="id" required="required"> <input
						class="btonIngresar" type="submit" name="consultar"
						value="Consultar">
				</div>
			</fieldset>
		</form>
		<hr>
		<form action="Productos" method="post">
			<fieldset>
			<legend>Datos</legend>
				<div>
					<div>
						<label class="entrada" >Código Producto </label>
						<input class="entrada" type="text" name="codigo" value="<%=codigoP%>" <%=estado%>>
						<input type="hidden"  name="cod" value="<%=codigoP%>">
						<input type="hidden"  name="nit" value="<%=nit%>">
						<label class="entrada">Nombre Producto </label>
						<input class="entrada" type="text" name="nombre" required="required" value="<%=nombre%>">
						</div>
						<div>
						<label class="entrada" >Iva </label>
						<input class="entrada" type="text" name="iva" required="required" value="<%=iva%>">
						<label class="entrada" >Precio Compra </label>
						<input class="entrada" type="text" name="precioC" required="required" value="<%=precioC%>">
						</div>
						<div>
						<label class="entrada" >Precio Venta </label>
						<input class="entrada" type="text" name="precioV" required="required" value="<%=precioV%>">
						</div>
				</div>
			</fieldset>
			<div class="botones">
				<input class="btonIngresar" type="submit" name="actualizar" value="Actualizar">
				<input class="btonIngresar" type="submit" name="borrar" value="Borrar">
			</div>
		</form>
		<%
		if (request.getParameter("men") != null) {
			String mensaje = request.getParameter("men");
			out.print("<script>alert('" + mensaje + "');</script>");
		}
		%>
	</div>
</body>
</html>