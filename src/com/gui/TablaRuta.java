package com.gui;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.implementacion.IRutaImpl;

public class TablaRuta extends JTable {
    private static final long serialVersionUID = 1L;

    public TablaRuta() {
        super(new DefaultTableModel(
                new Object[][] {},
                new String[] { "CODIGO", "DESTINO", "TIEMPO DE VIAJE",
                        "DISTANCIA", "TIPO" }) {
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
    
    void cargarRutas() {
        try {
            IRutaImpl rutaDB = new IRutaImpl();
            DefaultTableModel modelo = (DefaultTableModel) getModel();
            
            modelo.setRowCount(0);
            
            rutaDB.listar().forEach(
                    (ruta) -> modelo.addRow(new Object[] {
                            ruta.getId(), ruta.getDestino(), 
                            ruta.getTiempoViaje(), ruta.getDistancia(),
                            ruta.getTipo()
                    }));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
