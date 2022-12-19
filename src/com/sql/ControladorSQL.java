package com.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.objetos.Cliente;

public class ControladorSQL {
	private Connection conexion;
	
	public ControladorSQL() {
		try {
			conexion = new Conexion("root", "mysql4080", "localhost", "3306", "Trans_Bolivia").obtenerConexion();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertarCliente(Cliente cliente) throws SQLException {
		int idx, numeroTelefonos;
		String sql, telefonos[]; 
		PreparedStatement declaracion;
		
		sql = "insert into cliente (ci_cliente, nombre_cliente, direccion_cliente, tipo_cliente) values (?, ?, ?, ?)"; 
		declaracion = conexion.prepareStatement(sql);
		
		declaracion.setInt(1, cliente.getCiCliente());
		declaracion.setString(2, cliente.getNombreCliente());
		declaracion.setString(3, cliente.getDireccionCliente());
		declaracion.setString(4, cliente.getTipoCliente());
		declaracion.executeUpdate();

		telefonos = cliente.getTelefonos();
		numeroTelefonos = telefonos != null ? telefonos.length : 0;
		
		if (numeroTelefonos > 0) {
			sql = "insert into telefono_cliente (ci_cliente, telefono_cliente) values (";
			
			for (idx = 0; idx < numeroTelefonos - 1; idx++)
				sql += cliente.getCiCliente() + ", " + telefonos[idx] + "), (";
			sql += cliente.getCiCliente() + ", " + telefonos[idx] + ")";
			
			declaracion = conexion.prepareStatement(sql);
			declaracion.execute();
		}
	}
	
	public ResultSet ejecutarConsulta(String consulta) throws SQLException {
		Statement declaracion = conexion.createStatement();
		return declaracion.executeQuery(consulta);
	}
}
