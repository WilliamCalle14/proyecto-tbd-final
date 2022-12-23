package com.gui;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.implementacion.IVehiculoImpl;
import com.objetos.Vehiculo;

class TablaVehiculo extends TablaEntidad<Vehiculo, String> {
    private static final long serialVersionUID = 1L;
    
    private static TablaVehiculo tabla;

    private TablaVehiculo() {
        setModel(new DefaultTableModel(new Object[][] {},
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
    }
    
    static TablaVehiculo obtenerInstancia() {
        if (tabla == null)
            tabla = new TablaVehiculo();
        return tabla;
    }
    
    @Override
    void cargarTabla() {
        try {
            IVehiculoImpl vehiculoDB = new IVehiculoImpl();
            DefaultTableModel modelo = (DefaultTableModel) getModel();

            modelo.setRowCount(0);

            vehiculoDB.listar()
                    .forEach((vehiculo) -> modelo
                            .addRow(new Object[] { vehiculo.getPlaca(),
                                    vehiculo.getModelo(), vehiculo.getEstado(),
                                    vehiculo.getMarca(), vehiculo.getTipo() }));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
