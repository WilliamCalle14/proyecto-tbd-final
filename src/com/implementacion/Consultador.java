package com.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sql.Conexion;

public class Consultador {
    private Conexion conexion;
    
    public Consultador() {
        conexion = Conexion.obtenerInstancia();
    }
    
    public void ejecutarConsulta(String sql, List<List<Object>> datos) 
            throws SQLException, ClassNotFoundException {
        conexion.iniciarConexion();
        PreparedStatement declaracion = conexion.obtenerConexion()
                .prepareStatement(sql);
        ResultSet resultado = declaracion.executeQuery();
        ResultSetMetaData metaData = resultado.getMetaData();
        
        while (resultado.next()) {
            List<Object> subLista = new ArrayList<>();
            
            for (int i = 0; i < metaData.getColumnCount(); i++)
                subLista.add(resultado.getObject(i + 1));
            
            datos.add(subLista);
        }
        
        declaracion.close();
        conexion.cerrarConexion();
    }
}
