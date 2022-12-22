package com.gui;

import java.awt.Graphics;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.implementacion.IContratoImpl;
import javax.swing.ListSelectionModel;

class TablaContrato extends JTable {
    private static final long serialVersionUID = 1L;

    TablaContrato() {
        super(new DefaultTableModel(new Object[][] {},
                new String[] { "DESTINO", "CLIENTE", "CONDUCTOR", "VEHICULO",
                        "EMPLEADO", "FECHA SALIDA", "FECHA LLEGADA",
                        "MONTO TOTAL" }) {
            private static final long serialVersionUID = 1L;

            @SuppressWarnings("rawtypes")
            Class[] tipos = { String.class, String.class, String.class,
                    String.class, String.class, String.class, String.class,
                    String.class };

            @SuppressWarnings({ "unchecked", "rawtypes" })
            public Class getColumnClass(int idx) {
                return tipos[idx];
            }
            
            @Override
            public boolean isCellEditable(int n, int m) {
                return false;
            }
        });
        
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setCellSelectionEnabled(false);
        setRowSelectionAllowed(false);
        getTableHeader().setReorderingAllowed(false);
        // cargarContratos();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        cargarContratos();
    }
    
    void cargarContratos() {
        try {
            IContratoImpl contratoDB = new IContratoImpl();
            DefaultTableModel modelo = (DefaultTableModel) getModel();
            
            modelo.setRowCount(0);
        
            contratoDB.listar().forEach(
                    (contrato) -> modelo.addRow(new Object[] {
                            contrato.getIdRuta(), contrato.getCiConductor(),
                            contrato.getPlaca(), contrato.getCiEmpleado(),
                            contrato.getFechaSalida(), 
                            contrato.getFechaLlegada(),
                            contrato.getMontoTotal()
                    }));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
