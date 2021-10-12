package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO usuDao = new UsuarioDAO();
		
		if(request.getParameter("ingresar")!=null) {
			String usuario,password;
			int id;
			usuario=request.getParameter("usuario");
			password=request.getParameter("clave");
			if(usuDao.Login(usuario,password)) {
				JOptionPane.showMessageDialog(null,"Bienvenido!!");
				id = usuDao.BuscarId(usuario, password);
				response.sendRedirect("Menu.jsp?id="+id);
			
			// if(usuario.equals("admininicial")&& password.equals("admin123456")) {
				// JOptionPane.showMessageDialog(null,"Bienvenido!! Administrador");
				// response.sendRedirect("Menu.jsp?nom="+usuario);
			}else {
				JOptionPane.showMessageDialog(null,"Usuario o Contraseña errados, intente de nuevo");
				response.sendRedirect("login.jsp");
			}
		}
	}

}
