package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;
import Modelo.VentasDAO;
import Modelo.VentasDTO;

/**
 * Servlet implementation class Reportes
 */
@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op=request.getParameter("opcion");
		//JOptionPane.showMessageDialog(null, op);
		PrintWriter salida= response.getWriter();
		Gson datos = new Gson();
		
		if(op.equals("Usuarios")) {
			UsuarioDAO usuDao= new UsuarioDAO();
			ArrayList<UsuarioDTO> lista = new ArrayList<>();
			lista=usuDao.cargarUsuarios();
			salida.println(datos.toJson(lista));
		}
		
		if(op.equals("Clientes")) {
			ClienteDAO cliDao= new ClienteDAO();
			ArrayList<ClienteDTO> lista = new ArrayList<>();
			lista=cliDao.cargarClientes();
			salida.println(datos.toJson(lista));
		}
		
		if(op.equals("Ventas")) {
			VentasDAO venDao= new VentasDAO();
			ArrayList<VentasDTO> lista = new ArrayList<>();
			lista=venDao.cargarVentas();
			salida.println(datos.toJson(lista));
		}
	}

}
