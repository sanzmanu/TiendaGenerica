package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.ProductosDAO;
import Modelo.ProductosDTO;
import Modelo.VentasDAO;
import Modelo.VentasDTO;

/**
 * Servlet implementation class Ventas
 */
@WebServlet("/Ventas")
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ventas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VentasDAO ventDao = new VentasDAO();
		ClienteDAO cliDao = new ClienteDAO();
		ProductosDAO prodDao = new ProductosDAO();

		if (request.getParameter("consultar") != null) {

			int cedula_cliente = Integer.parseInt(request.getParameter("cedula"));
			ClienteDTO cli = cliDao.Buscar_Cliente(cedula_cliente);
			if (cli != null) {
				String nombre;
				cedula_cliente = cli.getCedula_cliente();
				nombre = cli.getNombre_cliente();
				response.sendRedirect("ventas.jsp?cedula=" + cedula_cliente + "&&nombre=" + nombre);
			} else {
				JOptionPane.showMessageDialog(null, "Cliente Inexistente");
				response.sendRedirect("ventas.jsp");
			}
		}

		if (request.getParameter("consultar1") != null) {

			int codigo_producto = Integer.parseInt(request.getParameter("codProd1"));
			ProductosDTO prod = prodDao.Buscar_Producto(codigo_producto);
			if (prod != null) {
				String nombre1;
				codigo_producto = prod.getCodigo_producto();
				nombre1 = prod.getNombre_producto();
				response.sendRedirect("ventas.jsp?codigo1=" + codigo_producto + "&&nombre1=" + nombre1);
				
			} else {
				JOptionPane.showMessageDialog(null, "Producto Inexistente");
				response.sendRedirect("ventas.jsp");
			}
		}

		if (request.getParameter("consultar2") != null) {

			int codigo_producto = Integer.parseInt(request.getParameter("codProd2"));
			ProductosDTO prod = prodDao.Buscar_Producto(codigo_producto);
			if (prod != null) {
				String nombre2;
				codigo_producto = prod.getCodigo_producto();
				nombre2 = prod.getNombre_producto();
				response.sendRedirect("ventas.jsp?codigo2=" + codigo_producto + "&&nombre2=" + nombre2);
			} else {
				JOptionPane.showMessageDialog(null, "Producto Inexistente");
				response.sendRedirect("ventas.jsp");
			}
		}

		if (request.getParameter("consultar3") != null) {

			int codigo_producto = Integer.parseInt(request.getParameter("codProd3"));
			ProductosDTO prod = prodDao.Buscar_Producto(codigo_producto);
			if (prod != null) {
				String nombre3;
				codigo_producto = prod.getCodigo_producto();
				nombre3 = prod.getNombre_producto();
				response.sendRedirect("ventas.jsp?codigo3=" + codigo_producto + "&&nombre3=" + nombre3);
			} else {
				JOptionPane.showMessageDialog(null, "Producto Inexistente");
				response.sendRedirect("ventas.jsp");
			}
		}

		if (request.getParameter("confirmar") != null) {
			
			int cedula_cliente, cedula_usuario, cant1,cant2, cant3;
			double precio1=0, precio2=0, precio3=0,subt1,subt2, subt3,ivaventa, total_venta=0, valor_venta;
			cedula_cliente = Integer.parseInt(request.getParameter("ced"));
			cedula_usuario = Integer.parseInt(request.getParameter("cedUsu"));
			cant1 = Integer.parseInt(request.getParameter("cantidad1"));
			cant2 = Integer.parseInt(request.getParameter("cantidad2"));
			cant3 = Integer.parseInt(request.getParameter("cantidad3"));
			int codigo_producto = Integer.parseInt(request.getParameter("cod1"));
			ProductosDTO prod = prodDao.Buscar_Producto(codigo_producto);
			if (prod != null) {
				precio1 = prod.getPrecio_venta();
			}
			int codigo_producto2 = Integer.parseInt(request.getParameter("cod2"));
			prod = prodDao.Buscar_Producto(codigo_producto2);
			if (prod != null) {
				precio2 = prod.getPrecio_venta();
			}
			int codigo_producto3 = Integer.parseInt(request.getParameter("cod3"));
			prod = prodDao.Buscar_Producto(codigo_producto3);
			if (prod != null) {
				precio3 = prod.getPrecio_venta();
			}
			subt1 = cant1*precio1;
			subt2 = cant2*precio2;
			subt3 = cant3*precio3;
			total_venta =subt1+subt2+subt3;
			ivaventa = (total_venta*1.19)-total_venta;
			valor_venta = total_venta+ivaventa;
			VentasDTO vent = new VentasDTO(cedula_cliente, cedula_usuario, ivaventa, total_venta, valor_venta);
			if (ventDao.Inserta_venta(vent)) {
				response.sendRedirect("ventas.jsp?subt1=subt1&&subt2=subt2&&subt3=subt3&&iva=ivaventa&&subtotal=total_venta&&valorTotal=valor_venta&&men=venta registrada exitosamente!!");
			} else {
				response.sendRedirect("ventas.jsp?men=No se registro la venta!!");
			}
		}
	}

}
