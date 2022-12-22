package com.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

class DialogoSeleccionCliente extends JDialog {
    private static final long serialVersionUID = 1L;
    private TablaCliente tablaClientes;

    public DialogoSeleccionCliente(JPanel panel) {
        super((JFrame) SwingUtilities.getWindowAncestor(panel),
                "Seleccionar cliente", true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(500, 250);
        setResizable(false);
        setLocationRelativeTo(panel);
        getContentPane().setLayout(null);
        
        tablaClientes = new TablaCliente();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 6, 472, 166);
        scrollPane.setViewportView(tablaClientes);
        
        getContentPane().add(scrollPane);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> cerrar());
        btnCancelar.setBounds(388, 177, 90, 28);
        getContentPane().add(btnCancelar);
        setVisible(true);
    }
    
    private void cerrar() {
        setVisible(false);
    }
}
