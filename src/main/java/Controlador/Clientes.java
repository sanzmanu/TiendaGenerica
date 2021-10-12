package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;

/**
 * Servlet implementation class Clientes
 */
@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Clientes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClienteDAO cliDao = new ClienteDAO();

		if (request.getParameter("crear") != null) {

			int cedula;
			String email, nombre, direccion, telefono;
			cedula = Integer.parseInt(request.getParameter("cedula"));
			direccion = request.getParameter("direccion");
			email = request.getParameter("correo");
			nombre = request.getParameter("nombre");
			telefono = request.getParameter("telefono");
			ClienteDTO cli = new ClienteDTO(cedula, direccion, email, nombre, telefono);
			if (cliDao.Inserta_Cliente(cli)) {
				response.sendRedirect("clientes.jsp?men=Cliente Creado exitosamente!!");
			} else {
				response.sendRedirect("clientes.jsp?men=No se registro el Cliente!!");
			}
		}

		if (request.getParameter("consultar") != null) {
			int cedula = Integer.parseInt(request.getParameter("id"));
			ClienteDTO cli = cliDao.Buscar_Cliente(cedula);
			if (cli != null) {
				String direccion, email, nombre, telefono;
				cedula = cli.getCedula_cliente();
				direccion = cli.getDireccion_cliente();
				email = cli.getEmail_cliente();
				nombre = cli.getNombre_cliente();
				telefono = cli.getTelefono_cliente();
				response.sendRedirect("clientes.jsp?cedula=" + cedula + "&&nombre=" + nombre + "&&direccion="
						+ direccion + "&&email=" + email + "&&telefono=" + telefono);
			} else {
				JOptionPane.showMessageDialog(null, "Cliente Inexistente");
				response.sendRedirect("clientes.jsp");
			}
		}

		if (request.getParameter("actualizar") != null) {

			int cedula;
			String email, nombre, direccion, telefono;
			cedula = Integer.parseInt(request.getParameter("ced"));
			direccion = request.getParameter("direccion");
			email = request.getParameter("correo");
			nombre = request.getParameter("nombre");
			telefono = request.getParameter("telefono");
			ClienteDTO cli = new ClienteDTO(cedula, direccion, email, nombre, telefono);
			if (cliDao.Actualiza_Cliente(cli)) {
				response.sendRedirect("clientes.jsp?men=Datos del Cliente Actualizados");
			} else {
				response.sendRedirect("clientes.jsp?men=No se actualizo el cliente!!");
			}
		}

		if (request.getParameter("borrar") != null) {

			int cedula;
			cedula = Integer.parseInt(request.getParameter("ced"));
			int op = JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente cedula:" + cedula);
			if (op == 0) {
				if (cliDao.Elimina_Cliente(cedula)) {
					response.sendRedirect("clientes.jsp?men=Datos del Cliente Borrados");
				} else {
					response.sendRedirect("clientes.jsp?men=No se elimino el Cliente!!");
				}
			} else {
				response.sendRedirect("clientes.jsp?");
			}
		}

		// Manejo de formato Json con Gson
		ArrayList<ClienteDTO> lista = new ArrayList<>();
		lista = cliDao.cargarClientes();
		PrintWriter salida = response.getWriter();
		Gson datos = new Gson();
		salida.println(datos.toJson(lista));
	}

}
