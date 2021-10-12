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
int nit=0,id=0;
String ciudad="",nombre="",direccion="",telefono="",estado="";
%>
<%
if(request.getParameter("nit")!=null){
	nit=Integer.parseInt(request.getParameter("nit"));
	ciudad=request.getParameter("ciudad");
	nombre=request.getParameter("nombre");
	direccion=request.getParameter("direccion");
	telefono=request.getParameter("telefono");
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
			     <a class="nav-menu-link nav-link" href="reportes?id=<%=id %>">Reportes</a></li>
			</ul>
		</nav>
</header>

<div id="BDUsuario">
		<form action="Proveedores" method="post">
			<div>
				<div>
					<label class="entrada" >NIT </label>
					<input class="entrada" type="text" placeholder="123456" name="nit" required="required" value="<%=nit%>" <%=estado%>>
					<input type="hidden"  name="ced" value="<%=nit%>">
					<label class="entrada" >Teléfono </label>
					<input class="entrada" type="text" placeholder="1234567" name="telefono" required="required" value="<%=telefono%>">
				
				</div>
				<div>
					<label class="entrada">Nombre Proveedor </label>
					<input class="entrada" type="text" placeholder="Juan Perez" name="nombre" required="required" value="<%=nombre%>">
					<label class="entrada" >Ciudad </label>
					<input class="entrada" type="text" placeholder="Bogotá" name="ciudad" required="required" value="<%=ciudad%>">
				</div>
				<div>
					<label class="entrada" >Dirección </label>
					<input class="entrada" type="text" placeholder="cll 12 No 12-54" name="direccion" required="required" value="<%=direccion%>">
				</div>
			</div>
			<div class="botones">
				<input class="btonIngresar" type="submit" name="crear" value="Crear" >
				<input class="btonIngresar" type="submit" name="actualizar" value="Actualizar">
				<input class="btonIngresar" type="submit" name="borrar" value="Borrar">
			</div>
		</form>
	</div>
	<hr>
<form action="Proveedores" method="post">
<fieldset>
<legend>Consultar</legend>
<div><label class="entrada">NIT: </label><input class="entrada" type="text" name="id" required="required">
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