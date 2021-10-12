package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class UsuarioDAO {

	Conexion cnn = new Conexion();
	Connection conec=cnn.conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Login(String usuario,String clave) {
		boolean resul=false;
		try {
			String sql="select * from usuarios where usuario=? and password=?";
			ps=conec.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, clave);
			res=ps.executeQuery();
			while(res.next()) {
				resul=true;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al consultar"+e);
		}
		return resul;
	} 
	public int BuscarId(String usuario,String clave) {
		int id=0;
		try {
			String sql="select * from usuarios where usuario=? and password=?";
			ps=conec.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, clave);
			res=ps.executeQuery();
			while(res.next()) {
				id = res.getInt(1);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al consultar"+e);
		}
		return id;
	} 
	
	public boolean Inserta_Usuario(UsuarioDTO usu) {
		boolean resul=false;
		UsuarioDTO usuEx=null;
		try {
			usuEx=Buscar_Usuario(usu.getCedula_usuario());
			if(usuEx==null) {
				String sql="insert into usuarios values(?,?,?,?,?)";
				ps=conec.prepareStatement(sql);
				ps.setInt(1, usu.getCedula_usuario());
				ps.setString(2, usu.getEmail_usuario());
				ps.setString(3, usu.getNombre_usuario());
				ps.setString(4, usu.getPassword());
				ps.setString(5, usu.getUsuario());
				resul=ps.executeUpdate()>0;
			}else {
				JOptionPane.showMessageDialog(null, "El usuario ya existe");
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar usuario"+ex);
		}
		return resul;
	}
	
	public UsuarioDTO Buscar_Usuario(int cedula) {
		
		UsuarioDTO usu =null;
		
		try {
			String sql="select * from usuarios where cedula_usuario=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, cedula);
			res=ps.executeQuery();
			while(res.next()) {
				usu=new UsuarioDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar"+ ex);
		}
		return usu;
	}
	
	public boolean Actualiza_Usuario(UsuarioDTO usu) {
		boolean resul=false;
		try {
			String sql="update usuarios set email_usuario=?,nombre_usuario=?,password=?,usuario=? where cedula_usuario=?";
			ps=conec.prepareStatement(sql);
			ps.setString(1, usu.getEmail_usuario());
			ps.setString(2, usu.getNombre_usuario());
			ps.setString(3, usu.getPassword());
			ps.setString(4, usu.getUsuario());
			ps.setInt(5, usu.getCedula_usuario());
			resul=ps.executeUpdate()>0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar usuario"+ex);
		}
		return resul;
	}
	
	public boolean Elimina_Usuario(int cedula) {
		boolean resul=false;
		try {
			String sql="delete from usuarios where cedula_usuario=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, cedula);
			resul=ps.executeUpdate()>0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar usuario"+ex);
		}
		return resul;
	}
	
	public ArrayList<UsuarioDTO> cargarUsuarios(){
		UsuarioDTO usu = null;
		ArrayList<UsuarioDTO> lista = new ArrayList<>();
		try {
			String sql="select * from usuarios";
			ps=conec.prepareStatement(sql);
			res=ps.executeQuery();
			while(res.next()) {
				usu=new UsuarioDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
						lista.add(usu);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar Usuarios" + ex);
		}
		return lista;	
	}
}
