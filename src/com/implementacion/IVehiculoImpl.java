package com.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.interfaces.IVehiculo;
import com.objetos.Vehiculo;
import com.sql.Conexion;

public class IVehiculoImpl implements IVehiculo {
    private final String CONSULTA = "select * from vehiculo";
    private final String OBTENER_UNO = "select * from vehiculo "
            + "where placa = ?";

    private Conexion conexion;

    public IVehiculoImpl() {
        conexion = Conexion.obtenerInstancia();
    }

    @Override
    public void eliminar(String id) {
    }

    @Override
    public void insertar(Vehiculo entidad)
            throws ClassNotFoundException, SQLException {
    }

    @Override
    public void modificar(Vehiculo entidad, String id) {
    }

    @Override
    public List<Vehiculo> listar() throws ClassNotFoundException, SQLException {
        conexion.iniciarConexion();

        List<Vehiculo> vehiculos = new ArrayList<>();

        PreparedStatement declaracion = conexion.obtenerConexion()
                .prepareStatement(CONSULTA);

        ResultSet resultados = declaracion.executeQuery();

        while (resultados.next()) {
            Vehiculo vehiculo = new Vehiculo();

            setVehiculo(resultados, vehiculo);

            vehiculos.add(vehiculo);
        }

        declaracion.close();
        conexion.cerrarConexion();

        return vehiculos;
    }

    private void setVehiculo(ResultSet resultado, Vehiculo vehiculo)
            throws SQLException {
        vehiculo.setPlaca(resultado.getString(1));
        vehiculo.setModelo(resultado.getString(2));
        vehiculo.setEstado(resultado.getString(3));
        vehiculo.setMarca(resultado.getString(4));
        vehiculo.setTipo(resultado.getString(5));
    }

    @Override
    public Vehiculo obtener(String id)
            throws ClassNotFoundException, SQLException {
        conexion.iniciarConexion();

        PreparedStatement declaracion = conexion.obtenerConexion()
                .prepareStatement(OBTENER_UNO);
        declaracion.setString(1, id);
        
        ResultSet resultado = declaracion.executeQuery();

        Vehiculo vehiculo; 
        
        if (resultado.next()) {
            vehiculo = new Vehiculo();
            setVehiculo(resultado, vehiculo);
        } else
            vehiculo = null;

        declaracion.close();
        conexion.cerrarConexion();

        return vehiculo;
    }

}
