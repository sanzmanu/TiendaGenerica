package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO usuDao = new UsuarioDAO();
		
		if(request.getParameter("crear")!=null) {
			
			int cedula;
			String email,nombre,password,usuario;
			cedula=Integer.parseInt(request.getParameter("cedula"));
			email=request.getParameter("correo");
			nombre=request.getParameter("nombre");
			password=request.getParameter("clave");
			usuario=request.getParameter("usuario");
			UsuarioDTO usu =new UsuarioDTO(cedula,email,nombre,password,usuario);
			if(usuDao.Inserta_Usuario(usu)) {
				//JOptionPane.showMessageDialog(null, "Se registro el usuario exitosamente!!");
				response.sendRedirect("usuarios.jsp?men=Usuario Creado exitosamente!!");
			}else {
				//JOptionPane.showMessageDialog(null, "No se registro el usuario!!");
				response.sendRedirect("usuarios.jsp?men=No se registro el usuario!!");
			}
		}
		
		if(request.getParameter("consultar")!=null) {
			int cedula=Integer.parseInt(request.getParameter("id"));
			UsuarioDTO usu = usuDao.Buscar_Usuario(cedula);
			if(usu!=null) {
				String email, nombre, password,usuario;
				cedula=usu.getCedula_usuario();
				email=usu.getEmail_usuario();
				nombre=usu.getNombre_usuario();
				password=usu.getPassword();
				usuario=usu.getUsuario();
				response.sendRedirect("usuarios.jsp?cedula="+cedula+"&&nombre="+nombre+"&&password="+
						password+"&&email="+email+"&&usuario="+usuario);
			}else {
				JOptionPane.showMessageDialog(null, "Usuario Inexistente");
				response.sendRedirect("usuarios.jsp");
			}
		}
		
		if(request.getParameter("actualizar")!=null) {
			
			int cedula;
			String email,nombre,password,usuario;
			cedula=Integer.parseInt(request.getParameter("ced"));
			email=request.getParameter("correo");
			nombre=request.getParameter("nombre");
			password=request.getParameter("clave");
			usuario=request.getParameter("usuario");
			UsuarioDTO usu =new UsuarioDTO(cedula,email,nombre,password,usuario);
			if(usuDao.Actualiza_Usuario(usu)) {
				//JOptionPane.showMessageDialog(null, "Se registro el usuario exitosamente!!");
				response.sendRedirect("usuarios.jsp?men=Datos del Usuario Actualizados");
			}else {
				//JOptionPane.showMessageDialog(null, "No se registro el usuario!!");
				response.sendRedirect("usuarios.jsp?men=No se actualizo el usuario!!");
			}
		}
		
		if(request.getParameter("borrar")!=null) {
			
			int cedula;
			cedula=Integer.parseInt(request.getParameter("ced"));
			int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el usuario cedula:"+cedula);
			if(op==0) {
				if(usuDao.Elimina_Usuario(cedula)) {
					response.sendRedirect("usuarios.jsp?men=Datos del Usuario Borrados");
				}else {
					response.sendRedirect("usuarios.jsp?men=No se elimino el Usuario!!");
				}
			}else {
				response.sendRedirect("usuarios.jsp?");
			}
		}
	}

}
