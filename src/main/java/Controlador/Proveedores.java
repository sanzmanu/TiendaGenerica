package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ProveedorDAO;
import Modelo.ProveedorDTO;

/**
 * Servlet implementation class Proveedores
 */
@WebServlet("/Proveedores")
public class Proveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proveedores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProveedorDAO provDao = new ProveedorDAO();
		
		if(request.getParameter("crear")!=null) {
			
			int nit;
			String ciudad,nombre,direccion,telefono;
			nit=Integer.parseInt(request.getParameter("nit"));
			direccion=request.getParameter("direccion");
			ciudad=request.getParameter("ciudad");
			nombre=request.getParameter("nombre");
			telefono=request.getParameter("telefono");
			ProveedorDTO prov =new ProveedorDTO(nit,ciudad,direccion,nombre,telefono);
			if(provDao.Inserta_Proveedor(prov)) {
				response.sendRedirect("proveedores.jsp?men=Proveedor Creado exitosamente!!");
			}else {
				response.sendRedirect("proveedores.jsp?men=No se registro el Proveedor!!");
			}
		}
		
		if(request.getParameter("consultar")!=null) {
			int nit=Integer.parseInt(request.getParameter("id"));
			ProveedorDTO prov = provDao.Buscar_Proveedor(nit);
			if(prov!=null) {
				String direccion,ciudad,nombre,telefono;
				nit=prov.getNitproveedor();
				direccion=prov.getDireccion_proveedor();
				ciudad=prov.getCiudad_proveedor();
				nombre=prov.getNombre_proveedor();
				telefono=prov.getTelefono_proveedor();
				response.sendRedirect("proveedores.jsp?nit="+nit+"&&nombre="+nombre+"&&direccion="+
						direccion+"&&ciudad="+ciudad+"&&telefono="+telefono);
			}else {
				JOptionPane.showMessageDialog(null, "Proveedor Inexistente");
				response.sendRedirect("proveedores.jsp");
			}
		}
		
		if(request.getParameter("actualizar")!=null) {
			
			int nit;
			String ciudad,nombre,direccion,telefono;
			nit=Integer.parseInt(request.getParameter("ced"));
			direccion=request.getParameter("direccion");
			ciudad=request.getParameter("ciudad");
			nombre=request.getParameter("nombre");
			telefono=request.getParameter("telefono");
			ProveedorDTO prov =new ProveedorDTO(nit,ciudad,direccion,nombre,telefono);
			if(provDao.Actualiza_Proveedor(prov)) {
				response.sendRedirect("proveedores.jsp?men=Datos del Proveedor Actualizados");
			}else {
				response.sendRedirect("proveedores.jsp?men=No se actualizo el Proveedor!!");
			}
		}
		
		if(request.getParameter("borrar")!=null) {
			
			int nit;
			nit=Integer.parseInt(request.getParameter("ced"));
			int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el proveedor nit: "+nit);
			if(op==0) {
				if(provDao.Elimina_Proveedor(nit)) {
					response.sendRedirect("proveedores.jsp?men=Datos del Proveedor Borrados");
				}else {
					response.sendRedirect("proveedores.jsp?men=No se elimino el Proveedor!!");
				}
			}else {
				response.sendRedirect("proveedores.jsp?");
			}
		}
	}

}
