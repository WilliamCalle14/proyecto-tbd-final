package com.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.interfaces.IConductor;
import com.objetos.Conductor;
import com.sql.Conexion;

public class IConductorImpl implements IConductor {
    private final String CONSULTA = "select * from conductor";
    private final String OBTENER_UNO = "select * from conductor "
            + "where ci_conductor = ?";
    
    private Conexion conexion;
    
    public IConductorImpl() {
        conexion = Conexion.obtenerInstancia();
    }

    @Override
    public void eliminar(Integer id) {
    }

    @Override
    public void insertar(Conductor entidad)
            throws ClassNotFoundException, SQLException {
    }

    @Override
    public void modificar(Conductor entidad, Integer id) {
    }

    @Override
    public List<Conductor> listar()
            throws ClassNotFoundException, SQLException {
        conexion.iniciarConexion();
        
        List<Conductor> conductores = new ArrayList<>();
        
        PreparedStatement declaracion = conexion.obtenerConexion()
                .prepareStatement(CONSULTA);
        
        ResultSet resultados = declaracion.executeQuery();
        
        while (resultados.next()) {
            Conductor conductor = new Conductor();
            
            setConductor(resultados, conductor);
            
            conductores.add(conductor);
        }
        
        declaracion.close();
        conexion.cerrarConexion();
        
        return conductores;
    }
    
    private void setConductor(ResultSet resultado, Conductor conductor) throws SQLException {
        conductor.setCi(resultado.getInt(1));
        conductor.setNroLicencia(resultado.getInt(2));
        conductor.setCategoriaLicencia(resultado.getString(3));
        conductor.setNombre(resultado.getString(4));
        conductor.setTelefono(resultado.getString(5));
        conductor.setDireccion(resultado.getString(6));
        conductor.setEstado(resultado.getString(7));
        conductor.setFechaVencimientoLicencia(resultado.getDate(8));
        conductor.setFechaNacimiento(resultado.getDate(9));
    }

    @Override
    public Conductor obtener(Integer id) 
            throws ClassNotFoundException, SQLException {
        conexion.iniciarConexion();
        
        PreparedStatement declaracion = conexion.obtenerConexion()
                .prepareStatement(OBTENER_UNO);
        declaracion.setInt(1, id);
        
        Conductor conductor = new Conductor();
        
        setConductor(declaracion.executeQuery(), conductor);
        
        declaracion.close();
        conexion.cerrarConexion();
        
        return conductor;
    }
}
