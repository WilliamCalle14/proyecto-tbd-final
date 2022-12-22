package com.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

class DialogoSeleccionConductor extends JDialog {
    private static final long serialVersionUID = 1L;
    private TablaConductor tablaConductor;
    
    DialogoSeleccionConductor(JPanel panel) {
        super((JFrame) SwingUtilities.getWindowAncestor(panel),
                "Seleccionar conductor", true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(500, 250);
        setResizable(false);
        setLocationRelativeTo(panel);
        getContentPane().setLayout(null);
        
        tablaConductor = new TablaConductor();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 6, 472, 166);
        scrollPane.setViewportView(tablaConductor);
        add(scrollPane);
        
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
