package com.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.interfaces.ICliente;
import com.objetos.Cliente;
import com.sql.Conexion;

public class IClienteImpl implements ICliente {
    private final String CONSULTA = "select * from cliente";
    private final String INSERCION = "insert into cliente (ci_cliente,"
            + " nombre_cliente, direccion_cliente, tipo_cliente) values (?, ?, ?, ?)";
//    private final String MODIFICACION = "update cliente set nombre_cliente = ?,"
//            + " direccion_cliente = ?, tipo_cliente = ? where ci_cliente = ?";
//    private final String OBTENER_UNO = "select * from cliente "
//            + "where ci_cliente = ?";
//    private final String ELIMINACION = "delete from cliente "
//            + "where ci_cliente = ?";
    private Conexion conexion;
    
    public IClienteImpl() {
        conexion = Conexion.obtenerInstancia();
    }

    @Override
    public void insertar(Cliente cliente)
            throws ClassNotFoundException, SQLException {
        conexion.iniciarConexion();

        PreparedStatement declaracion = conexion.obtenerConexion()
                .prepareStatement(INSERCION);

        declaracion.setInt(1, cliente.getCi());
        declaracion.setString(2, cliente.getNombre());
        declaracion.setString(3, cliente.getDireccion());
        declaracion.setString(4, cliente.getTipo());

        declaracion.executeUpdate();
        declaracion.close();
        conexion.cerrarConexion();
    }

    @Override
    public List<Cliente> listar() throws ClassNotFoundException, SQLException {
        conexion.iniciarConexion();
        
        List<Cliente> clientes = new ArrayList<>();;

        PreparedStatement declaracion = conexion.obtenerConexion()
                .prepareStatement(CONSULTA);

        ResultSet resultados = declaracion.executeQuery();

        while (resultados.next()) {
            Cliente cliente = new Cliente();
            
            cliente.setCi(resultados.getInt(1));
            cliente.setNombre(resultados.getString(2));
            cliente.setDireccion(resultados.getString(3));
            cliente.setTipo(resultados.getString(4));

            clientes.add(cliente);
        }
        
        declaracion.close();
        conexion.cerrarConexion();

        return clientes;
    }

    @Override
    public void eliminar(Integer id) {
    }

    @Override
    public void modificar(Cliente entidad, Integer id) {
    }
    
    @Override
    public Cliente obtener(Integer idCliente) {
        return null;
    }
}
