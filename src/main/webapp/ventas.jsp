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

	<%!int cedula = 0, num = 0, codProd1 = 0,codProd2 = 0,codProd3 = 0,id=0;
	double precio1 = 0, precio2 = 0, precio3 = 0, subt1 = 0, subt2 = 0, subt3 = 0, subtotal = 0, iva = 0, valorTotal = 0;
	String producto1 = "", nombre = "",producto2 = "",producto3 = "", estado = "";%>
	<%
	if (request.getParameter("cedula") != null) {
		cedula = Integer.parseInt(request.getParameter("cedula"));
		nombre = request.getParameter("nombre");
		num=num++;
		estado = "disabled";
	}
	if (request.getParameter("codigo1") != null) {
		codProd1 = Integer.parseInt(request.getParameter("codigo1"));
		producto1 = request.getParameter("nombre1");
	}
	if (request.getParameter("codigo2") != null) {
		codProd2 = Integer.parseInt(request.getParameter("codigo2"));
		producto2 = request.getParameter("nombre2");
	}
	if (request.getParameter("codigo3") != null) {
		codProd3 = Integer.parseInt(request.getParameter("codigo3"));
		producto3 = request.getParameter("nombre3");
	}
	if (request.getParameter("id") != null) {
		id = Integer.parseInt(request.getParameter("id"));
	}
	if(request.getParameter("subtotal")!=null){
		subt1=Double.parseDouble(request.getParameter("subt1"));
		subt2=Double.parseDouble(request.getParameter("subt2"));
		subt3=Double.parseDouble(request.getParameter("subt3"));
		subtotal=Double.parseDouble(request.getParameter("subtotal"));
		iva=Double.parseDouble(request.getParameter("iva"));
		valorTotal=Double.parseDouble(request.getParameter("valorTotal"));
	}
	%>
	<header class="header">
		<nav class="nav">
			<a href="#" class="logo nav-link">TicWeb Solutions</a>
			<ul class="nav-menu">
				<li class="nav-menu-item"><a class="nav-menu-link nav-link"
					href="usuarios.jsp?id=<%=id%>">Usuarios</a></li>
				<li class="nav-menu-item"><a class="nav-menu-link nav-link"
					href="clientes.jsp?id=<%=id%>">Clientes</a></li>
				<li class="nav-menu-item"><a class="nav-menu-link nav-link"
					href="proveedores.jsp?id=<%=id%>">Proveedores</a></li>
				<li class="nav-menu-item"><a class="nav-menu-link nav-link"
					href="productos.jsp?id=<%=id%>">Productos</a></li>
				<li class="nav-menu-item"><a class="nav-menu-link nav-link"
					href="ventas.jsp?id=<%=id%>">Ventas</a></li>
				<li class="nav-menu-item"><a class="nav-menu-link nav-link"
					href="reportes.jsp?id=<%=id%>">Reportes</a></li>
			</ul>
		</nav>
	</header>
	<div id="BDUsuario">
		<form action="Ventas" method="post">
			<div>
				<div>
					<label class="entrada">Cédula </label> <input type="text"
						name="cedula"> <input class="btonIngresar" type="submit"
						name="consultar" value="Consultar"> <label class="entrada">Cliente
					</label> <input type="text" name="nombre" value="<%=nombre%>" <%=estado%>>
					<label class="entrada">Consec.</label> <input type="text"
						name="numero" disabled value="<%=num%>">
				</div>
			</div>
		</form>
		<hr>
		<form action="Ventas" method="post">
			<div>
				<table>
					<div>
						<td>
							<tr>
								<label class="entrada">Cod. Producto </label>
							</tr>
							<tr>
								<label></label>
							</tr>
							<tr>
								<label class="entrada">Nombre Producto </label>
							</tr>
							<tr>
								<label class="entrada">Cant.</label>
							</tr>
							<tr>
								<label class="entrada">Vlr. Total </label>
							</tr>
						</td>
					</div>
					<div>
						<td>
							<tr>
								<input type="text" name="codProd1">
								<input type="hidden" name="cod1" value="<%=codProd1%>">
							</tr>
							<tr>
								<input class="btonIngresar" type="submit" name="consultar1"
									value="Consultar">
							</tr>
							<tr>
								<input type="text" name="producto1" value="<%=producto1%>">
							</tr>
							<tr>
								<input type="text" name="cantidad1" value="">
							</tr>
							<tr>
								<input type="text" name="total1" value="<%=subt1%>">
							</tr>
						</td>
					</div>
					<div>
						<td>
							<tr>
								<input type="text" name="codProd2">
								<input type="hidden" name="cod2" value="<%=codProd2%>">
							</tr>
							<tr>
								<input class="btonIngresar" type="submit" name="consultar2"
									value="Consultar">
							</tr>
							<tr>
								<input type="text" name="producto2" value="<%=producto2%>">
							</tr>
							<tr>
								<input type="text" name="cantidad2" value="">
							</tr>
							<tr>
								<input type="text" name="total2" value="<%=subt2%>">
							</tr>
						</td>
					</div>
					<div>
						<td>
							<tr>
								<input type="text" name="codProd3">
								<input type="hidden" name="cod3" value="<%=codProd3%>">
							</tr>
							<tr>
								<input class="btonIngresar" type="submit" name="consultar3"
									value="Consultar">
							</tr>
							<tr>
								<input type="text" name="producto3" value="<%=producto3%>">
							</tr>
							<tr>
								<input type="text" name="cantidad3" value="">
							</tr>
							<tr>
								<input type="text" name="total3" value="<%=subt3%>">
							</tr>
						</td>
					</div>
					<div>
						<td>
							<tr></tr>
							<tr></tr>
							<tr></tr>
							<tr>
								<label class="entrada">Total Venta </label>
							</tr>
							<tr>
								<input type="text" name="subtotal" value="<%=subtotal%>">
							</tr>
						</td>
					</div>
					<div>
						<td>
							<tr></tr>
							<tr></tr>
							<tr></tr>
							<tr>
								<label class="entrada">Total IVA </label>
							</tr>
							<tr>
								<input type="text" name="iva" value="<%=iva%>">
							</tr>
						</td>
					</div>
					<div>
						<td>
							<tr></tr>
							<tr></tr>
							<tr>
								<input class="btonIngresar" type="submit" name="confirmar"
									value="Confirmar">
								<input type="hidden" name="ced" value="<%=cedula%>">
								<input type="hidden" name="cedUsu" value="<%=id%>">
							</tr>
							<tr>
								<label class="entrada">Total con IVA </label>
							</tr>
							<tr>
								<input type="text" name="total" value="<%=valorTotal%>">
							</tr>
						</td>
					</div>
				</table>
			</div>
		</form>
			<%
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script>alert('"+mensaje+"');</script>");
}
%>
	</div>
</body>
</html>