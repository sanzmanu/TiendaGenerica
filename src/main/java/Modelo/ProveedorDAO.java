package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProveedorDAO {

	Conexion cnn = new Conexion();
	Connection conec=cnn.conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Inserta_Proveedor(ProveedorDTO prov) {
		boolean resul=false;
		ProveedorDTO provEx=null;
		try {
			provEx=Buscar_Proveedor(prov.getNitproveedor());
			if(provEx==null) {
				String sql="insert into proveedores values(?,?,?,?,?)";
				ps=conec.prepareStatement(sql);
				ps.setInt(1, prov.getNitproveedor());
				ps.setString(2, prov.getCiudad_proveedor());
				ps.setString(3, prov.getDireccion_proveedor());
				ps.setString(4, prov.getNombre_proveedor());
				ps.setString(5, prov.getTelefono_proveedor());
				resul=ps.executeUpdate()>0;
			}else {
				JOptionPane.showMessageDialog(null, "El Proveedor ya existe");
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar proveedor"+ex);
		}
		return resul;
	}
	
	public ProveedorDTO Buscar_Proveedor(int nit) {
		
		ProveedorDTO prov =null;
		
		try {
			String sql="select * from proveedores where nitproveedor=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, nit);
			res=ps.executeQuery();
			while(res.next()) {
				prov=new ProveedorDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar"+ ex);
		}
		return prov;
	}
	
	public boolean Actualiza_Proveedor(ProveedorDTO prov) {
		boolean resul=false;
		try {
			String sql="update proveedores set ciudad_proveedor=?,direccion_proveedor=?,nombre_proveedor=?,telefono_proveedor=? where nitproveedor=?";
			ps=conec.prepareStatement(sql);
			ps.setString(1, prov.getCiudad_proveedor());
			ps.setString(2, prov.getDireccion_proveedor());
			ps.setString(3, prov.getNombre_proveedor());
			ps.setString(4, prov.getTelefono_proveedor());
			ps.setInt(5, prov.getNitproveedor());
			resul=ps.executeUpdate()>0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar Proveedor"+ex);
		}
		return resul;
	}
	
	public boolean Elimina_Proveedor(int nit) {
		boolean resul=false;
		try {
			String sql="delete from proveedores where nitproveedor=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, nit);
			resul=ps.executeUpdate()>0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar proveedor"+ex);
		}
		return resul;
	}
}
