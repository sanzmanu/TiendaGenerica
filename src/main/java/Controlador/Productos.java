package Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import Modelo.ProductosDAO;
import Modelo.ProductosDTO;

/**
 * Servlet implementation class Productos
 */
@WebServlet("/Productos")
@MultipartConfig // para manejar los archivos file
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductosDAO prodDao = new ProductosDAO();
		
		if (request.getParameter("cargar") != null) {

			Part archivo = request.getPart("archivo");
			String Url = "C:/Users/Dexcon/Desktop/Varios/Educacion/MinTic/Ciclo 3/Desarrollo de Software/ProgramasEclipse/TiendaGenerica/src/main/webapp/documentos/";
			try {
				InputStream file = archivo.getInputStream();
				File copia = new File(Url + "productos.csv");
				FileOutputStream escribir = new FileOutputStream(copia);
				int num = file.read();
				while (num != -1) {
					escribir.write(num);
					num = file.read();
				}
				escribir.close();
				file.close();
				JOptionPane.showMessageDialog(null, "Se cargo el Archivo correctamente");
				if (prodDao.Cargar_Productos(Url + "productos.csv")) {
					response.sendRedirect("productos.jsp?men=Se insertaron los productos correctamente");
				} else {
					response.sendRedirect("productos.jsp?men=No se insertaron los productos");

				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error de archivo..." + e);
			}
		}
		
		if(request.getParameter("consultar")!=null) {
			int codigo=Integer.parseInt(request.getParameter("id"));
			ProductosDTO prod = prodDao.Buscar_Producto(codigo);
			if(prod!=null) {
				int nit;
				String nombre;
				double iva,precioC,precioV;
				codigo=prod.getCodigo_producto();
				nombre=prod.getNombre_producto();
				nit=prod.getNitproveedor();
				iva=prod.getIvacompra();
				precioC=prod.getPrecio_compra();
				precioV=prod.getPrecio_venta();
				response.sendRedirect("productos.jsp?codigo="+codigo+"&&nombre="+nombre+"&&nit="+nit+"&&iva="+
						iva+"&&precioC="+precioC+"&&precioV="+precioV);
			}else {
				JOptionPane.showMessageDialog(null, "Producto Inexistente");
				response.sendRedirect("productos.jsp");
			}
		}
		
		if(request.getParameter("actualizar")!=null) {
			
			int codigo, nit;
			String nombre;
			double iva,precioC,precioV;
			codigo=Integer.parseInt(request.getParameter("cod"));
			nombre=request.getParameter("nombre");
			nit=Integer.parseInt(request.getParameter("nit"));
			iva=Double.parseDouble(request.getParameter("iva"));
			precioC=Double.parseDouble(request.getParameter("precioC"));
			precioV=Double.parseDouble(request.getParameter("precioV"));
			ProductosDTO prod =new ProductosDTO(codigo,nombre,nit,precioC,iva,precioV);
			if(prodDao.Actualiza_Producto(prod)) {
				response.sendRedirect("productos.jsp?men=Datos del Producto Actualizados");
			}else {
				response.sendRedirect("productos.jsp?men=No se actualizo el Producto!!");
			}
		}
		
		if(request.getParameter("borrar")!=null) {
			
			int codigo;
			codigo=Integer.parseInt(request.getParameter("cod"));
			int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el producto codigo: "+codigo);
			if(op==0) {
				if(prodDao.Elimina_Producto(codigo)) {
					response.sendRedirect("productos.jsp?men=Datos del Producto Borrados");
				}else {
					response.sendRedirect("productos.jsp?men=No se elimino el Producto!!");
				}
			}else {
				response.sendRedirect("productos.jsp?");
			}
		}
	}

}
