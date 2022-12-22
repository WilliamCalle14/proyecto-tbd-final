package com.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.interfaces.IContrato;
import com.objetos.Contrato;
import com.sql.Conexion;

public class IContratoImpl implements IContrato {
    private final String CONSULTA = "select * from contrato";
    private final String INSERCION = "insert into contrato (id_ruta, "
            + "ci_conductor, placa, ci_cliente, ci_empleado, nit_sucursal, "
            + "fecha_reg_contrato, fecha_salida, fecha_llegada, monto_total)"
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private Conexion conexion;
    
    public IContratoImpl() {
        conexion = Conexion.obtenerInstancia();
    }
    
    @Override
    public void insertar(Contrato contrato) throws ClassNotFoundException, SQLException {
        conexion.iniciarConexion();
        
        PreparedStatement declaracion = conexion.obtenerConexion()
                .prepareStatement(INSERCION);
        
        declaracion.setInt(1, contrato.getIdRuta());
        declaracion.setInt(2, contrato.getCiConductor());
        declaracion.setString(3, contrato.getPlaca());
        declaracion.setInt(4, contrato.getCiCliente());
        declaracion.setInt(5, contrato.getCiEmpleado());
        declaracion.setInt(6, contrato.getNitSucursal());
        declaracion.setDate(7, contrato.getFechaRegContrato());
        declaracion.setDate(8, contrato.getFechaSalida());
        declaracion.setDate(9, contrato.getFechaLlegada());
        declaracion.setFloat(10, contrato.getMontoTotal());
        
        declaracion.close();
        
        conexion.cerrarConexion();
    }

    @Override
    public List<Contrato> listar() throws SQLException, ClassNotFoundException {
        conexion.iniciarConexion();
        
        List<Contrato> contratos = new ArrayList<>();
        
        PreparedStatement declaracion = conexion.obtenerConexion().prepareStatement(CONSULTA);
        
        ResultSet resultados = declaracion.executeQuery();
        
        while (resultados.next()) {
            Contrato contrato = new Contrato();
            
            contrato.setIdRuta(resultados.getInt(1));
            contrato.setCiConductor(resultados.getInt(2));
            contrato.setPlaca(resultados.getString(3));
            contrato.setCiCliente(resultados.getInt(4));
            contrato.setCiEmpleado(resultados.getInt(5));
            contrato.setNitSucursal(resultados.getInt(6));
            contrato.setFechaRegContrato(resultados.getDate(7));
            contrato.setFechaSalida(resultados.getDate(8));
            contrato.setFechaLlegada(resultados.getDate(9));
            contrato.setMontoTotal(resultados.getFloat(10));
            
            contratos.add(contrato);
        }
        
        declaracion.close();
        conexion.cerrarConexion();
        
        return contratos;
    }
}
