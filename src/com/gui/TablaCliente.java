package com.gui;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.implementacion.IClienteImpl;

class TablaCliente extends JTable {
    private static final long serialVersionUID = 1L;

    TablaCliente() {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        
        getTableHeader().setReorderingAllowed(false);
        // cargarClientes();
        
//        addFocusListener(new FocusListener() {
//            @Override
//            public void focusLost(FocusEvent e) {
//                setIgnoreRepaint(true);
//            }
//            
//            @Override
//            public void focusGained(FocusEvent e) {
//                setIgnoreRepaint(false);
//            }
//        });
    }
    
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        // if (!isFocusable())
//        cargarClientes();
//    }
    
    void cargarClientes() {
        try {
            IClienteImpl clienteDB = new IClienteImpl();
            DefaultTableModel modelo = (DefaultTableModel) getModel();
            
            modelo.setRowCount(0);

            clienteDB.listar().forEach(
                    (cliente) -> modelo.addRow(new Object[] {
                            cliente.getCi(), cliente.getNombre(),
                            cliente.getDireccion(), cliente.getTipo() }));
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
