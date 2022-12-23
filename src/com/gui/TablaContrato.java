package com.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.implementacion.Consultador;

class TablaContrato extends JTable {
    private static final long serialVersionUID = 1L;
    
    private static TablaContrato tabla;

    private TablaContrato() {
        setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "CLIENTE", "CONDUCTOR", "VEHICULO",
                        "EMPLEADO", "RUTA", "FECHA SALIDA", "FECHA LLEGADA",
                        "MONTO TOTAL" }) {
            private static final long serialVersionUID = 1L;

            @SuppressWarnings("rawtypes")
            Class[] tipos = { String.class, String.class, String.class,
                    String.class, String.class, String.class, String.class,
                    String.class };

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
        setCellSelectionEnabled(false);
        setRowSelectionAllowed(false);
        getTableHeader().setReorderingAllowed(false);
    }
    
    static TablaContrato obtenerInstancia() {
        if (tabla == null)
            tabla = new TablaContrato();
        return tabla;
    }

    void cargarContratos() {
        try {
//            IContratoImpl contratoDB = new IContratoImpl();
//            DefaultTableModel modelo = (DefaultTableModel) getModel();
//
//            modelo.setRowCount(0);
//
//            contratoDB.listar()
//                    .forEach((contrato) -> modelo.addRow(new Object[] {
//                            contrato.getCiCliente(), contrato.getCiConductor(),
//                            contrato.getPlaca(), contrato.getCiEmpleado(),
//                            contrato.getIdRuta(), contrato.getFechaSalida(),
//                            contrato.getFechaLlegada(), 
//                            contrato.getMontoTotal() }));
            
            Consultador consultador = new Consultador();
            List<List<Object>> datos = new ArrayList<>();
            DefaultTableModel modelo = (DefaultTableModel) getModel();
            
            modelo.setRowCount(0);
            consultador.ejecutarConsulta(
                    "select nombre_cliente, nombre_conductor, "
                    + "modelo, nombre_empleado, destino, fecha_salida, "
                    + "fecha_llegada, monto_total "
                    + "from contrato CT, cliente CL, conductor CD, vehiculo V, "
                    + "empleado E, ruta R "
                    + "where CT.ci_cliente = CL.ci_cliente "
                    + "and CT.ci_conductor = CD.ci_conductor "
                    + "and CT.placa = V.placa "
                    + "and CT.ci_empleado = E.ci_empleado "
                    + "and CT.id_ruta = R.id_ruta",
                    datos);
            
            datos.forEach((lista) -> modelo.addRow(new Vector<Object>(lista)));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
