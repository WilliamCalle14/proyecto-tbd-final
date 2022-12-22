package com.gui;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class ClienteIU extends JPanel {
    private static final long serialVersionUID = 1L;

    private ControlMouse control;
    static final String COMANDO_ANIADIR = "ANIADIR_CLIENTEDB";
    static final String COMANDO_HOME = "HOME_CLIENTEDB";
    
    private TablaCliente tablaClientes;

    ClienteIU() {
        setBounds(0, 0, 622, 379);
        setLayout(null);

        control = ControlMouse.obtenerInstancia();

        JLabel etiquetaClientes = new JLabel("CLIENTES");
        etiquetaClientes.setBounds(279, 32, 65, 16);
        add(etiquetaClientes);
        
        tablaClientes = new TablaCliente();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(16, 60, 594, 230);
        scrollPane.setViewportView(tablaClientes);

        add(scrollPane);

        Image iconoAniadir = Toolkit.getDefaultToolkit()
                .getImage(ClienteIU.class.getResource("/resources/72648.png"));
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
        
//        addFocusListener(new FocusListener() {
//            
//            @Override
//            public void focusLost(FocusEvent arg0) {
//                tablaClientes.setFocusable(true);
//            }
//            
//            @Override
//            public void focusGained(FocusEvent arg0) {
//                tablaClientes.setFocusable(false);
//            }
//        });
    }
    
    void cargarClientes() {
        tablaClientes.cargarClientes();
    }
}
