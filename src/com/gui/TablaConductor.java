package com.gui;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.implementacion.IConductorImpl;
import com.objetos.Conductor;

class TablaConductor extends TablaEntidad<Conductor, Integer> {
    private static final long serialVersionUID = 1L;
    
    private static TablaConductor tabla;

    private TablaConductor() {
        setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CI",
                "NRO LICENCIA", "CATEGORIA", "NOMBRE", "ESTADO" }) {
            private static final long serialVersionUID = 1L;

            @SuppressWarnings("rawtypes")
            Class[] tipos = { String.class, String.class, String.class,
                    String.class, String.class };

            @SuppressWarnings({ "unchecked", "rawtypes" })
            @Override
            public Class getColumnClass(int idx) {
                return tipos[idx];
            }

            @Override
            public boolean isCellEditable(int n, int m) {
                return false;
            }
        });
    }
    
    static TablaConductor obtenerInstancia() {
        if (tabla == null)
            tabla = new TablaConductor();
        return tabla;
    }

    @Override
    void cargarTabla() {
        try {
            IConductorImpl conductorDB = new IConductorImpl();
            DefaultTableModel modelo = (DefaultTableModel) getModel();

            modelo.setRowCount(0);

            conductorDB.listar()
                    .forEach((conductor) -> modelo.addRow(new Object[] {
                            conductor.getCi(), conductor.getNroLicencia(),
                            conductor.getEstado(), conductor.getNombre(),
                            conductor.getEstado() }));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
