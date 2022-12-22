package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion miConexion;
    private Connection conexion;
    private String usuario;
    private String contrasena;
    private String nombreBDUrl;

    private Conexion() {
        this.usuario = "root";
        this.contrasena = "mysql4080";
        nombreBDUrl = "jdbc:mysql://localhost/Trans_Bolivia";
    }
    
    public static Conexion obtenerInstancia() {
        if (miConexion == null)
            miConexion = new Conexion();
        return miConexion;
    }

    public void iniciarConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(nombreBDUrl, usuario,
                contrasena);
    }
    
    public Connection obtenerConexion() {
        return conexion;
    }

    public void cerrarConexion() throws SQLException {
        if (conexion != null && !conexion.isClosed())
            conexion.close();
    }
}
