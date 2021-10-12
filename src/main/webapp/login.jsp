<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css" />
<title>Tienda</title>

</head>
<body>
	<div id="cuadro">
		<form action="Login" method="post">
			<div>
				<h1>Bienvenidos</h1>
				<div>
					<label class="entrada">Usuario </label>
				</div>
				<div>
					<input class="entrada" type="text" placeholder="Usuario" name="usuario" required="required">
				</div>
				<div>
					<label class="entrada" >Contraseña </label>
				</div>
				<div>
					<input class="entrada" type="password" placeholder="Contraseña" name="clave" required="required">
				</div>
			</div>
			<div class="botones">
				<input class="btonIngresar" type="submit" name="ingresar" value="Iniciar sesión">
				<a href="index.jsp"><input class="btonCancelar" type="button" value="Cancelar"></a>
			</div>
		</form>
	</div>
</body>
</html>