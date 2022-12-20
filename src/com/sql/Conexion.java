package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	protected Connection conexion;
	private String usuario;
	private String contrasena;
	private String nombreBDUrl;
	
	public Conexion() {
		this.usuario = "root";
		this.contrasena = "mysql4080";
		nombreBDUrl = "jdbc:mysql://localhost/Trans_Bolivia";
	}
	
	public void iniciarConexion() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexion = DriverManager.getConnection(nombreBDUrl, usuario, contrasena);
	}
	
	public void cerrarConexion() throws SQLException {
		if (conexion != null && !conexion.isClosed())
			conexion.close();
	}
}
