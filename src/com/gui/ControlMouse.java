package com.gui;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.implementacion.IClienteImpl;
import com.implementacion.ITelefonoClienteImpl;
import com.objetos.Cliente;
import com.objetos.TelefonoCliente;

class ControlMouse extends MouseAdapter {
    private static ControlMouse control;

    private SistemaTransporteIU sistema;
    private RegistroCliente panelCliente;
    private RegistroContrato registroContrato;

    private ControlMouse() {
    }

    static ControlMouse obtenerInstancia() {
        if (control == null)
            control = new ControlMouse();
        return control;
    }

    void agregarSistema(SistemaTransporteIU sistema) {
        this.sistema = sistema;
    }

    void agregarPanelCliente(RegistroCliente panelCliente) {
        this.panelCliente = panelCliente;
    }
    
    void agregarRegistroContrato(RegistroContrato registroContrato) {
        this.registroContrato = registroContrato;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String nombre = e.getComponent().getName();
        if (nombre.equals(PanelPrincipal.ID_PANEL_CLIENTE)
                || nombre.equals(RegistroCliente.COMANDO_CANCELAR))
            sistema.cambiarPanelClienteIU();
        else if (nombre.equals(ClienteIU.COMANDO_HOME)
                || nombre.equals(ContratoIU.COMANDO_HOME))
            sistema.cambiarPanelPrincipal();
        else if (nombre.equals(PanelPrincipal.ID_PANEL_CONTRATO)
                || nombre.equals(RegistroContrato.COMANDO_CANCELAR))
            sistema.cambiarPanelContratoIU();
        else if (nombre.equals(ClienteIU.COMANDO_ANIADIR))
            sistema.cambiarPanelRegistroCliente();
        else if (nombre.equals(ContratoIU.COMANDO_ANIADIR))
            sistema.cambiarPanelRegistroContrato();
        else if (nombre.equals(RegistroCliente.COMANDO_ANIADIR_TELEFONO))
            panelCliente.agregarTelefonoAlista();
        else if (nombre.equals(RegistroCliente.COMANDO_GUARDAR))
            agregarCliente();
        else if (nombre.equals(RegistroContrato.COMANDO_GUARDAR))
            guardarContrato();
        else if (nombre.equals(RegistroContrato.COMANDO_BUSCAR_CLIENTE))
            buscarCliente();
        e.getComponent().setBackground(SystemColor.inactiveCaption);
    }

    private void buscarCliente() {
        // new DialogoSeleccionCliente(registroContrato);
        new DialogoSeleccionConductor(panelCliente);
    }

    private void guardarContrato() {
    }

    private void agregarCliente() {
        Cliente cliente;
        String tmp;

        cliente = new Cliente();

        tmp = validarCampo(panelCliente.getCampoIdCliente());
        cliente.setCi(Integer.valueOf(tmp));

        tmp = validarCampo(panelCliente.getCampoNombre());
        if (tmp == null)
            return;
        cliente.setNombre(tmp);

        cliente.setTipo("PREFERENCIAL");

        if (panelCliente.getClienteSeleccionado()
                .equals(panelCliente.obtenerTiposCliente()[1]))
            cliente.setTipo("NORMAL");

        tmp = validarCampo(panelCliente.getCampoDireccion());
        if (tmp == null)
            return;
        cliente.setDireccion(tmp);

        Object[] objs = panelCliente.getListaTelefonos();
        String[] telefonos = new String[objs.length];

        for (int i = 0; i < objs.length; i++)
            telefonos[i] = (String) objs[i];
        
        TelefonoCliente telefonoCliente = new TelefonoCliente();
        
        telefonoCliente.setCiCliente(cliente.getCi());
        telefonoCliente.setTelefonos(telefonos);

        IClienteImpl clienteDB = new IClienteImpl();
        ITelefonoClienteImpl telefonoClienteDB = new ITelefonoClienteImpl();
        
        try {
            clienteDB.insertar(cliente);
            telefonoClienteDB.insertar(telefonoCliente);
        } catch (ClassNotFoundException | SQLException e1) {
            JOptionPane.showMessageDialog(panelCliente, e1.getMessage(),
                    "Error al guardar", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        panelCliente.limpiarCampos();
        JOptionPane.showMessageDialog(panelCliente, "Cliente guardado");
    }

    private String validarCampo(JTextField campo) {
        String texto = campo.getText();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(panelCliente,
                    "Algunos campos estan vacios", "Campos Vacios",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return texto;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        e.getComponent().setBackground(SystemColor.activeCaption);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        e.getComponent().setBackground(SystemColor.inactiveCaption);
    }
}
