package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String usuario;
	private String contrasena;
	private String nombreHost;
	private String puerto;
	private String nombreBD;
	private String nombreBDUrl;
	
	public Conexion(String usuario, String contrasena, String nombreHost, String puerto, String nombreBD) {
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombreHost = nombreHost;
		this.puerto = puerto;
		this.nombreBD = nombreBD;
		nombreBDUrl = "jdbc:mysql://" + this.nombreHost + ":" + this.puerto + "/" + this.nombreBD;
	}
	
	public Connection obtenerConexion() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(nombreBDUrl, usuario, contrasena);
	}
}
