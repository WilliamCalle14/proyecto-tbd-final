package com.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.Insets;
import java.awt.event.ActionEvent;

@SuppressWarnings("rawtypes")
class DialogoSeleccion extends JDialog {
    private static final long serialVersionUID = 1L;
    
    static final String ACCION_SELECCIONAR = "SELECCIONAR_DIALOGO";
    static final String ACCION_CANCELAR = "CANCELAR_DIALOGO";
    private JScrollPane scrollPane;
    private TablaEntidad tablaActual;
    private boolean seleccionado;

    DialogoSeleccion(JPanel panel) {
        super((JFrame) SwingUtilities.getWindowAncestor(panel), true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(500, 250);
        setResizable(false);
        setLocationRelativeTo(panel);
        getContentPane().setLayout(null);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 6, 472, 166);
        
        getContentPane().add(scrollPane);
        
        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setMargin(new Insets(2, 0, 2, 0));
        btnSeleccionar.setBounds(101, 177, 90, 28);
        btnSeleccionar.setActionCommand(ACCION_SELECCIONAR);
        btnSeleccionar.addActionListener(e -> objetoSeleccionado(e));
        getContentPane().add(btnSeleccionar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(292, 177, 90, 28);
        btnCancelar.setActionCommand(ACCION_CANCELAR);
        btnCancelar.addActionListener(e -> objetoSeleccionado(e));
        getContentPane().add(btnCancelar);
    }
    
    void setTabla(TablaEntidad tabla, String texto, boolean visible) {
        setTitle(texto);
        tablaActual = tabla;
        tablaActual.clearSelection();
        seleccionado = false;
        tablaActual.cargarTabla();
        scrollPane.setViewportView(tablaActual);
        scrollPane.revalidate();
        scrollPane.repaint();
        setVisible(visible);
    }
    
    boolean objetoSeleccionado() {
        return seleccionado;
    }
    
    void objetoSeleccionado(ActionEvent e) {
        String nombreAccion = e.getActionCommand();
        
        if (nombreAccion.equals(ACCION_CANCELAR)) {
            setVisible(false);
            return;
        }
        
        seleccionado = nombreAccion.equals(ACCION_SELECCIONAR)
                && tablaActual.getSelectedRow() >= 0;
                
        if (seleccionado)
            setVisible(false);
    }
}
