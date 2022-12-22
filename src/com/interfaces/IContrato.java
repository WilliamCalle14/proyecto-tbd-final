package com.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.objetos.Contrato;

public interface IContrato {
    public void insertar(Contrato contrato) throws ClassNotFoundException, SQLException;
    
    public List<Contrato> listar() throws SQLException, ClassNotFoundException;
}
