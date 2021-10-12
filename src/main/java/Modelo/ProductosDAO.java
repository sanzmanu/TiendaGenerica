package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProductosDAO {

	Conexion cnn = new Conexion();
	Connection conec=cnn.conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Cargar_Productos(String ruta) {
		boolean resul=false;
		try {
			String sql="load data infile '"+ruta+"' into table productos fields terminated by ',' lines terminated by '\r\n';";
			ps=conec.prepareStatement(sql);
			resul=ps.executeUpdate()>0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al cargar productos "+ex);
		}
		return resul;
	}
	
public ProductosDTO Buscar_Producto(int codigo) {
		
		ProductosDTO prod =null;
		
		try {
			String sql="select * from productos where codigo_producto=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, codigo);
			res=ps.executeQuery();
			while(res.next()) {
				prod=new ProductosDTO(res.getInt(1),res.getString(2),res.getInt(3),res.getDouble(4),res.getDouble(5),res.getDouble(6));
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar"+ ex);
		}
		return prod;
	}
	
	public boolean Actualiza_Producto(ProductosDTO prod) {
		boolean resul=false;
		try {
			String sql="update productos set nombre_producto=?,precio_compra=?,ivacompra=?,precio_venta=? where codigo_producto=?";
			ps=conec.prepareStatement(sql);
			ps.setString(1, prod.getNombre_producto());
			ps.setDouble(2, prod.getPrecio_compra());
			ps.setDouble(3, prod.getIvacompra());
			ps.setDouble(4, prod.getPrecio_venta());
			ps.setInt(5, prod.getCodigo_producto());
			resul=ps.executeUpdate()>0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar Producto"+ex);
		}
		return resul;
	}
	
	public boolean Elimina_Producto(int codigo) {
		boolean resul=false;
		try {
			String sql="delete from productos where codigo_producto=?";
			ps=conec.prepareStatement(sql);
			ps.setInt(1, codigo);
			resul=ps.executeUpdate()>0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar producto"+ex);
		}
		return resul;
	}
}
