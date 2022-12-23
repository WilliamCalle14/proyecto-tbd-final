package com.gui;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.implementacion.IClienteImpl;
import com.objetos.Cliente;

class TablaCliente extends TablaEntidad<Cliente, Integer> {
    private static final long serialVersionUID = 1L;
    private static TablaCliente tabla;

    private TablaCliente() {
        setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "CODIGO", "NOMBRE", "DIRECCION", "TIPO" }) {
            private static final long serialVersionUID = 1L;
            @SuppressWarnings("rawtypes")
            Class[] tipos = new Class[] { String.class, String.class,
                    String.class, String.class };

            @SuppressWarnings({ "unchecked", "rawtypes" })
            public Class getColumnClass(int idx) {
                return tipos[idx];
            }

            @Override
            public boolean isCellEditable(int n, int m) {
                return false;
            }
        });
    }
    
    static TablaCliente obtenerInstancia() {
        if (tabla == null)
            tabla = new TablaCliente();
        // tabla.cargarTabla();
        return tabla;
    }

    @Override
    void cargarTabla() {
        try {
            IClienteImpl clienteDB = new IClienteImpl();
            DefaultTableModel modelo = (DefaultTableModel) getModel();

            modelo.setRowCount(0);

            clienteDB.listar()
                    .forEach((cliente) -> modelo.addRow(new Object[] {
                            cliente.getCi(), cliente.getNombre(),
                            cliente.getDireccion(), cliente.getTipo() }));
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
