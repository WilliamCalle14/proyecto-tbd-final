package com.gui;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.interfaces.ICliente;
import com.objetos.Cliente;
import com.sql.Conexion;

public class ClienteDB extends Conexion implements ICliente {

	@Override
	public void insertar(Cliente cliente) throws ClassNotFoundException, SQLException {
		iniciarConexion();
		
		PreparedStatement declaracion = conexion.prepareStatement(
				"insert into cliente (ci_cliente, nombre_cliente, "
				+ "direccion_cliente, tipo_cliente) values (?, ?, ?, ?)");
		
		declaracion.setInt(1, cliente.getCiCliente());
		declaracion.setString(2, cliente.getNombreCliente());
		declaracion.setString(3, cliente.getDireccionCliente());
		declaracion.setString(4, cliente.getTipoCliente());
		
		declaracion.executeUpdate();
		
		for (String telefono : cliente.getTelefonos()) {
			declaracion = conexion.prepareStatement("insert into telefono_cliente"
					+ " (ci_cliente, telefono_cliente) values (?, ?)");
			declaracion.setInt(1, cliente.getCiCliente());
			declaracion.setString(2, telefono);
			declaracion.executeUpdate();
		}
		
		cerrarConexion();
	}

	@Override
	public void eliminar(int idCliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(int idCliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente obtenerCliente(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}
}
