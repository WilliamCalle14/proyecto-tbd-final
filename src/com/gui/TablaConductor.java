package com.gui;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.implementacion.IConductorImpl;

class TablaConductor extends JTable {
    private static final long serialVersionUID = 1L;

    TablaConductor() {
        super(new DefaultTableModel(
                new Object[][] {},
                new String[] { "CI", "NRO LICENCIA", "CATEGORIA", "NOMBRE",
                        "ESTADO" }) {
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
        
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getTableHeader().setReorderingAllowed(false);
        
        cargarConductores();
    }
    
    void cargarConductores() {
        try {
            IConductorImpl conductorDB = new IConductorImpl();
            DefaultTableModel modelo = (DefaultTableModel) getModel();
            
            modelo.setRowCount(0);
            
            conductorDB.listar().forEach(
                    (conductor) -> modelo.addRow(new Object[] {
                            conductor.getCi(), conductor.getNroLicencia(),
                            conductor.getEstado(), conductor.getNombre(),
                            conductor.getEstado()
                    }));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
