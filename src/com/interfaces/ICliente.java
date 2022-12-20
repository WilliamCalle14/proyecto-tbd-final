package com.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.objetos.Cliente;

public interface ICliente {
	public void insertar(Cliente cliente) throws ClassNotFoundException, SQLException;
	
	public void eliminar(int idCliente);
	
	public void modificar(int idCliente);
	
	public List<Cliente> listar();
	
	public Cliente obtenerCliente(int idCliente);
}
