package com.gui;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class ContratoIU extends JPanel {
    private static final long serialVersionUID = 1L;

    static final String COMANDO_HOME = "HOME_CONTRATOIU";
    static final String COMANDO_ANIADIR = "ANIADIR_CONTRATOIU";
    
    private TablaContrato tablaContratos;

    private ControlMouse control;

    ContratoIU() {
        setBounds(0, 0, 622, 379);
        setLayout(null);

        control = ControlMouse.obtenerInstancia();

        JLabel etiquetaContratos = new JLabel("CONTRATOS");
        etiquetaContratos.setBounds(276, 32, 74, 16);
        add(etiquetaContratos);

        tablaContratos = new TablaContrato();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(16, 60, 594, 230);
        scrollPane.setViewportView(tablaContratos);

        add(scrollPane);

        Image iconoAniadir = Toolkit.getDefaultToolkit().getImage(
                ClienteIU.class.getResource("/resources/7235505.png"));
        JPanel panelBtnAniadir = FabricaPanelBoton.obtenerBotonConIcono(538,
                315, 30, 30, 0, iconoAniadir, SystemColor.inactiveCaption,
                COMANDO_ANIADIR);
        panelBtnAniadir.addMouseListener(control);
        add(panelBtnAniadir);

        Image iconoHome = Toolkit.getDefaultToolkit().getImage(
                ClienteIU.class.getResource("/resources/4103187.png"));
        JPanel panelBtnHome = FabricaPanelBoton.obtenerBotonConIcono(49, 315,
                30, 30, 0, iconoHome, SystemColor.inactiveCaption,
                COMANDO_HOME);
        panelBtnHome.addMouseListener(control);
        add(panelBtnHome);
    }
}
