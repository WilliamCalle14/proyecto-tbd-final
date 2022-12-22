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
            
            conductor.setCi(resultados.getInt(1));
            conductor.setNroLicencia(resultados.getInt(2));
            conductor.setCategoriaLicencia(resultados.getString(3));
            conductor.setNombre(resultados.getString(4));
            conductor.setTelefono(resultados.getString(5));
            conductor.setDireccion(resultados.getString(6));
            conductor.setEstado(resultados.getString(7));
            conductor.setFechaVencimientoLicencia(resultados.getDate(8));
            conductor.setFechaNacimiento(resultados.getDate(9));
            
            conductores.add(conductor);
        }
        
        declaracion.close();
        conexion.cerrarConexion();
        
        return conductores;
    }

    @Override
    public Conductor obtener(Integer id) {
        return null;
    }
}
