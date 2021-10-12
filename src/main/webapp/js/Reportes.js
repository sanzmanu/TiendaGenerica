$(document).ready(function(){
	
	function listaUsuarios (){
		
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcion:"Usuarios"},
			success: function(result){
				console.log(result)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML =""
				tabla.innerHTML+=`<tr>
				<th>Cedula</th>
				<th>Nombre</th>
				<th>Correo Electronico</th>
				<th>Usuario</th>
				<th>Password</th>
				</tr>`
				for(let fila of result){
					
					tabla.innerHTML+=`<tr>
					<td>${fila.cedula_usuario}</td>
					<td>${fila.nombre_usuario}</td>
					<td>${fila.email_usuario}</td>
					<td>${fila.usuario}</td>
					<td>${fila.password}</td>
					</tr>`
				}
				
			}
		})
	}
	
		function listaClientes (){
		
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcion:"Clientes"},
			success: function(result){
				console.log(result)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML =""
				tabla.innerHTML+=`<tr>
				<th>Cedula</th>
				<th>Nombre</th>
				<th>Correo Electronico</th>
				<th>Direccion </th>
				<th>Telefono</th>
				</tr>`
				for(let fila of result){
					
					tabla.innerHTML+=`<tr>
					<td>${fila.cedula_cliente}</td>
					<td>${fila.nombre_cliente}</td>
					<td>${fila.email_cliente}</td>
					<td>${fila.direccion_cliente}</td>
					<td>${fila.telefono_cliente}</td>
					</tr>`
				}
				
			}
		})
	}
	
	function listaVentas (){
		
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcion:"Ventas"},
			success: function(result){
				console.log(result)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML =""
				tabla.innerHTML+=`<tr>
				<th>Cedula</th>
				<th>Nombre</th>
				<th>Valor Total Ventas</th>
				</tr>`
				for(let fila of result){
					
					tabla.innerHTML+=`<tr>
					<td>${fila.cedula_cliente}</td>
					<td>${fila.nombre_cliente}</td>
					<td>${fila.valor_venta}</td>
					<td></td>
					<td>Total Ventas $ ${fila.total}</td>
					</tr>`
				}
				
			}
		})
	}
	
	$('#listaUsuarios').on('click',function(){
			listaUsuarios();
		})
	
	$('#listaClientes').on('click',function(){
			listaClientes();
		})
	$('#listaVentas').on('click',function(){
			listaVentas();
		})
})