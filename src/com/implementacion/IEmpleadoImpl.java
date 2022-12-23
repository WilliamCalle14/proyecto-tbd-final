package com.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.interfaces.IEmpleado;
import com.objetos.Empleado;
import com.sql.Conexion;

public class IEmpleadoImpl implements IEmpleado {
    private final String OBTENER_UNO = "select * from empleado"
            + " where ci_empleado = ?";

    private Conexion conexion;

    public IEmpleadoImpl() {
        conexion = Conexion.obtenerInstancia();
    }

    @Override
    public void eliminar(Integer id) {
    }

    @Override
    public void insertar(Empleado entidad)
            throws ClassNotFoundException, SQLException {
    }

    @Override
    public void modificar(Empleado entidad, Integer id) {
    }

    @Override
    public List<Empleado> listar() throws ClassNotFoundException, SQLException {
        return null;
    }
    
    private void setEmpleado(ResultSet resultado, Empleado empleado)
            throws SQLException {
        empleado.setCi(resultado.getInt(1));
        empleado.setNitSucursal(resultado.getInt(2));
        empleado.setNombre(resultado.getString(3));
        empleado.setDireccion(resultado.getString(4));
    }

    @Override
    public Empleado obtener(Integer id)
            throws ClassNotFoundException, SQLException {
        conexion.iniciarConexion();

        PreparedStatement declaracion = conexion.obtenerConexion()
                .prepareStatement(OBTENER_UNO);
        declaracion.setInt(1, id);

        ResultSet resultado = declaracion.executeQuery();

        Empleado empleado;

        if (resultado.next()) {
            empleado = new Empleado();
            setEmpleado(resultado, empleado);
        } else
            empleado = null;

        declaracion.close();
        conexion.cerrarConexion();

        return empleado;
    }
}
