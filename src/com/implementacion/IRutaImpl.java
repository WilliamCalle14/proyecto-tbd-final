package com.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.interfaces.IRuta;
import com.objetos.Ruta;
import com.sql.Conexion;

public class IRutaImpl implements IRuta {
    private final String CONSULTA = "select * from ruta";
    private final String OBTENER_UNO = "select * from ruta where id_ruta = ?";
    
    private Conexion conexion;
    
    public IRutaImpl() {
        conexion = Conexion.obtenerInstancia();
    }

    @Override
    public void eliminar(Integer id) {
    }

    @Override
    public void insertar(Ruta entidad)
            throws ClassNotFoundException, SQLException {
    }

    @Override
    public void modificar(Ruta entidad, Integer id) {
    }

    @Override
    public List<Ruta> listar() throws ClassNotFoundException, SQLException {
        conexion.iniciarConexion();
        
        List<Ruta> rutas = new ArrayList<>();
        
        PreparedStatement declaracion = conexion.obtenerConexion()
                .prepareStatement(CONSULTA);
        ResultSet resultados = declaracion.executeQuery();
        
        while (resultados.next()) {
            Ruta ruta = new Ruta();
            
            setRuta(resultados, ruta);
            
            rutas.add(ruta);
        }
        
        declaracion.close();
        conexion.cerrarConexion();
        
        return rutas;
    }
    
    private void setRuta(ResultSet resultado, Ruta ruta) throws SQLException {
        ruta.setId(resultado.getInt(1));
        ruta.setDestino(resultado.getString(2));
        ruta.setTiempoViaje(resultado.getTime(3));
        ruta.setOrigen(resultado.getString(4));
        ruta.setDistancia(resultado.getFloat(5));
        ruta.setTipo(resultado.getString(6));
    }

    @Override
    public Ruta obtener(Integer id) throws ClassNotFoundException, SQLException {
        conexion.iniciarConexion();
        
        PreparedStatement declaracion = conexion.obtenerConexion()
                .prepareStatement(OBTENER_UNO);
        
        declaracion.setInt(1, id);
        
        Ruta ruta = new Ruta();
        
        setRuta(declaracion.executeQuery(), ruta);
        
        declaracion.close();
        conexion.cerrarConexion();
        
        return ruta;
    }
}
