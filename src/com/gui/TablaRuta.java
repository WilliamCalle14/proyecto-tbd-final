package com.gui;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.implementacion.IRutaImpl;
import com.objetos.Ruta;

class TablaRuta extends TablaEntidad<Ruta, Integer> {
    private static final long serialVersionUID = 1L;
    
    private static TablaRuta tabla;

    private TablaRuta() {
        setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CODIGO",
                "DESTINO", "TIEMPO DE VIAJE", "DISTANCIA", "TIPO" }) {
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
    
    static TablaRuta obtenerInstancia() {
        if (tabla == null)
            tabla = new TablaRuta();
        return tabla;
    }
    
    @Override
    void cargarTabla() {
        try {
            IRutaImpl rutaDB = new IRutaImpl();
            DefaultTableModel modelo = (DefaultTableModel) getModel();

            modelo.setRowCount(0);

            rutaDB.listar().forEach((ruta) -> modelo.addRow(new Object[] {
                    ruta.getId(), ruta.getDestino(), ruta.getTiempoViaje(),
                    ruta.getDistancia(), ruta.getTipo() }));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
