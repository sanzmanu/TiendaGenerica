package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class VentasDAO {

	Conexion cnn = new Conexion();
	Connection conec = cnn.conecta();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean Inserta_venta(VentasDTO venta) {

		boolean resul = false;
		try {
			String sql = "insert into ventas (cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) values(?,?,?,?,?)";
			ps = conec.prepareStatement(sql);
			ps.setInt(1, venta.getCedula_cliente());
			ps.setInt(2, venta.getCedula_usuario());
			ps.setDouble(3, venta.getIvaventa());
			ps.setDouble(4, venta.getTotal_venta());
			ps.setDouble(5, venta.getValor_venta());
			resul = ps.executeUpdate() > 0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar venta" + ex);
		}
		return resul;
	}
	
	public ArrayList<VentasDTO> cargarVentas(){
		VentasDTO ven = null;
		ArrayList<VentasDTO> lista = new ArrayList<>();
		try {
			String sql="select * from ventas";
			ps=conec.prepareStatement(sql);
			res=ps.executeQuery();
			while(res.next()) {
				ven=new VentasDTO(res.getInt(1),res.getInt(2),res.getDouble(3),res.getDouble(4),res.getDouble(5));
						lista.add(ven);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar Ventas" + ex);
		}
		return lista;	
	}
}
