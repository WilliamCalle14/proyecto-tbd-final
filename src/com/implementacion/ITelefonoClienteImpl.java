package com.implementacion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.interfaces.ITelefonoCliente;
import com.objetos.TelefonoCliente;
import com.sql.Conexion;

public class ITelefonoClienteImpl implements ITelefonoCliente {
    private final String INSERCION = "insert into telefono_cliente "
            + "(ci_cliente, telefono_cliente) values (?, ?)";

    private Conexion conexion;

    public ITelefonoClienteImpl() {
        conexion = Conexion.obtenerInstancia();
    }

    @Override
    public void eliminar(Integer id) {
    }

    @Override
    public void insertar(TelefonoCliente entidad)
            throws ClassNotFoundException, SQLException {
        conexion.iniciarConexion();

        for (String telefono : entidad.getTelefonos()) {
            PreparedStatement declaracion = conexion.obtenerConexion()
                    .prepareStatement(INSERCION);

            declaracion.setInt(1, entidad.getCiCliente());
            declaracion.setString(2, telefono);

            declaracion.executeUpdate();
            declaracion.close();
        }

        conexion.cerrarConexion();
    }

    @Override
    public void modificar(TelefonoCliente entidad, Integer id) {
    }

    @Override
    public List<TelefonoCliente> listar()
            throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public TelefonoCliente obtener(Integer id) {
        return null;
    }
}
