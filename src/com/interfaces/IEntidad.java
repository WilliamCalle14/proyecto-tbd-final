package com.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IEntidad<T, K> {
    public void eliminar(K id);

    public void insertar(T entidad) throws ClassNotFoundException, SQLException;

    public void modificar(T entidad, K id);

    public List<T> listar() throws ClassNotFoundException, SQLException;

    public T obtener(K id) throws ClassNotFoundException, SQLException;
}
