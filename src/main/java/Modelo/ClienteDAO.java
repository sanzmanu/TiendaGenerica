package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ClienteDAO {

	Conexion cnn = new Conexion();
	Connection conec=cnn.conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Inserta_Cliente(ClienteDTO cli) {
		boolean resul=false;
		ClienteDTO cliEx=null;
		try {
			cliEx=Buscar_Cliente(cli.getCedula_cliente());
			if(cliEx==null) {
				String sql="insert into clientes values(?,?,?,?,?)";
				ps=conec.prepareStatement(sql);
				ps.setInt(1, cli.getCedula_cliente());
				ps.setString(2, cli.getDireccion_cliente());
				ps.setString(3, cli.getEmail_cliente());
				ps.setString(4, cli.getNombre_cliente());
				ps.setString(5, cli.getTelefono_cliente());
				resul=ps.executeUpdate()>0;
			}else {
				JOptionPane.showMessageDialog(null, "El cliente ya existe");
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar cliente"+ex);
		}
		return resul;
	}
	
	public ClienteDTO Buscar_Cliente(int cedula) {
		
		ClienteDTO cli =null;
		
		try {
			String sql="select * from clientes where cedula_cliente=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, cedula);
			res=ps.executeQuery();
			while(res.next()) {
				cli=new ClienteDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar"+ ex);
		}
		return cli;
	}
	
	public boolean Actualiza_Cliente(ClienteDTO cli) {
		boolean resul=false;
		try {
			String sql="update clientes set direccion_cliente=?,email_cliente=?,nombre_cliente=?,telefono_cliente=? where cedula_cliente=?";
			ps=conec.prepareStatement(sql);
			ps.setString(1, cli.getDireccion_cliente());
			ps.setString(2, cli.getEmail_cliente());
			ps.setString(3, cli.getNombre_cliente());
			ps.setString(4, cli.getTelefono_cliente());
			ps.setInt(5, cli.getCedula_cliente());
			resul=ps.executeUpdate()>0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar cliente"+ex);
		}
		return resul;
	}
	
	public boolean Elimina_Cliente(int cedula) {
		boolean resul=false;
		try {
			String sql="delete from clientes where cedula_cliente=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, cedula);
			resul=ps.executeUpdate()>0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar cliente"+ex);
		}
		return resul;
	}
	
	public ArrayList<ClienteDTO> cargarClientes(){
		ClienteDTO cli = null;
		ArrayList<ClienteDTO> lista = new ArrayList<>();
		try {
			String sql="select * from clientes";
			ps=conec.prepareStatement(sql);
			res=ps.executeQuery();
			while(res.next()) {
				cli=new ClienteDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
						lista.add(cli);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar clientes" + ex);
		}
		return lista;	
	}
}
