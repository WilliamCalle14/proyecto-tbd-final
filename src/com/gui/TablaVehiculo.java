package com.gui;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.implementacion.IVehiculoImpl;

class TablaVehiculo extends JTable {
    private static final long serialVersionUID = 1L;
    
    TablaVehiculo() {
        super(new DefaultTableModel(
                new Object[][] {},
                new String[] { "PLACA", "MODELO", "ESTADO", "MARCA", "TIPO" }) {
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
    }
    
    void cargarVehiculos() {
        try {
            IVehiculoImpl vehiculoDB = new IVehiculoImpl();
            DefaultTableModel modelo = (DefaultTableModel) getModel();
            
            modelo.setRowCount(0);
            
            vehiculoDB.listar().forEach(
                    (vehiculo) -> modelo.addRow(new Object[] {
                            vehiculo.getPlaca(), vehiculo.getModelo(),
                            vehiculo.getEstado(), vehiculo.getMarca(),
                            vehiculo.getTipo()
                    }));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
