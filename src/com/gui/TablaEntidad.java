package com.gui;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.interfaces.IEntidad;

abstract class TablaEntidad<T, K> extends JTable {
    private static final long serialVersionUID = 1L;
    
    TablaEntidad() {
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    abstract void cargarTabla();
    
    T obtenerEntidadSeleccionada(IEntidad<T, K> entidadImpl) {
        T entidad;
        if (getSelectedRow() < 0)
            entidad = null;
        else {
            int n = getSelectedRow();
            @SuppressWarnings("unchecked")
            K id = (K) getModel().getValueAt(n, 0);
            try {
                entidad = entidadImpl.obtener(id);
            } catch (ClassNotFoundException | SQLException e) {
                entidad = null;
                System.out.println(e);
            }
        }
        return entidad;
    }
}
