package com.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SistemaTransporteIU extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel panelContenedor;
    private PanelPrincipal panelPrincipal;
    private ClienteIU clienteIU;
    private RegistroCliente registroCliente;
    private ContratoIU contratoIU;
    private RegistroContrato registroContrato;

    private ControlMouse control;

    public SistemaTransporteIU() {
        super("Sistema de Transporte - Trans Bolivia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 430);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setResizable(false);

        control = ControlMouse.obtenerInstancia();
        control.agregarSistema(this);
        panelPrincipal = new PanelPrincipal();
        registroCliente = new RegistroCliente();
        clienteIU = new ClienteIU();
        contratoIU = new ContratoIU();
        registroContrato = new RegistroContrato();

        hacerPanelContenedor();
    }

    void hacerPanelContenedor() {
        panelContenedor = new JPanel();
        panelContenedor.setBounds(6, 6, 622, 379);
        panelContenedor.setLayout(null);
        panelContenedor.add(panelPrincipal);
        getContentPane().add(panelContenedor);
    }

    private void cambiarPanel(JPanel panel) {
        panelContenedor.removeAll();
        panelContenedor.add(panel);
        panelContenedor.revalidate();
        panelContenedor.repaint();
    }

    void cambiarPanelPrincipal() {
        cambiarPanel(panelPrincipal);
    }

    void cambiarPanelClienteIU() {
        TablaCliente tabla = TablaCliente.obtenerInstancia();
        tabla.cargarTabla();
        clienteIU.mostrarTabla(tabla);
        cambiarPanel(clienteIU);
    }

    void cambiarPanelRegistroCliente() {
        registroCliente.limpiarCampos();
        cambiarPanel(registroCliente);
    }

    void cambiarPanelContratoIU() {
        TablaContrato tabla = TablaContrato.obtenerInstancia();
        tabla.cargarContratos();
        contratoIU.mostrarTabla(tabla);
        cambiarPanel(contratoIU);
    }

    void cambiarPanelRegistroContrato() {
        registroContrato.registrarCliente();
        cambiarPanel(registroContrato);
    }
}
