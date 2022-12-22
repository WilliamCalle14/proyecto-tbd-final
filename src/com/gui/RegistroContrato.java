package com.gui;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

class RegistroContrato extends JPanel {
    private static final long serialVersionUID = 1L;
    
    static final String COMANDO_BUSCAR_CLIENTE = "CLIENTE_CONTRATO";
    static final String COMANDO_BUSCAR_CONDUCTOR = "CONDUCTOR_CONTRATO";
    static final String COMANDO_BUSCAR_VEHICULO = "VEHICULO_CONTRATO";
    static final String COMANDO_BUSCAR_DESTINO = "DESTINO_CONTRATO";
    static final String COMANDO_GUARDAR = "GUARDAR_CONTRATO";
    static final String COMANDO_CANCELAR = "CANCELAR_CONTRATO";
    
    private JTextField campoCliente;
    private JTextField campoConductor;
    private JTextField campoVehiculo;
    private JTextField campoMontoTotal;
    private JDateChooser fechaSalida;
    private JDateChooser fechaLlegada;
    
    private ControlMouse control;
    private JTextField textField;
    
    RegistroContrato() {
        setBounds(0, 0, 622, 379);
        setLayout(null);
        
        control = ControlMouse.obtenerInstancia();
        control.agregarRegistroContrato(this);
        
        JLabel etiquetaCliente = new JLabel("Cliente");
        etiquetaCliente.setBounds(17, 25, 55, 16);
        add(etiquetaCliente);
        
        JLabel etiquetaConductor = new JLabel("Conductor");
        etiquetaConductor.setBounds(17, 104, 62, 16);
        add(etiquetaConductor);
        
        JLabel etiquetaVehiculo = new JLabel("Vehiculo");
        etiquetaVehiculo.setBounds(339, 104, 55, 16);
        add(etiquetaVehiculo);
        
        JLabel etiquetaFechaSalida = new JLabel("Fecha salida");
        etiquetaFechaSalida.setBounds(17, 183, 77, 16);
        add(etiquetaFechaSalida);
        
        JLabel etiquetaFechaLlegada = new JLabel("Fecha llegada");
        etiquetaFechaLlegada.setBounds(339, 183, 85, 16);
        add(etiquetaFechaLlegada);
        
        JLabel etiquetaMontoTotal = new JLabel("Monto");
        etiquetaMontoTotal.setBounds(339, 263, 55, 16);
        add(etiquetaMontoTotal);
        
        campoCliente = new JTextField();
        campoCliente.setBounds(94, 19, 135, 28);
        campoCliente.setEditable(false);
        add(campoCliente);
        campoCliente.setColumns(10);
        
        campoConductor = new JTextField();
        campoConductor.setBounds(94, 98, 135, 28);
        campoConductor.setEditable(false);
        add(campoConductor);
        campoConductor.setColumns(10);
        
        campoVehiculo = new JTextField();
        campoVehiculo.setBounds(428, 98, 135, 28);
        campoVehiculo.setEditable(false);
        add(campoVehiculo);
        campoVehiculo.setColumns(10);
        
        campoMontoTotal = new JTextField();
        campoMontoTotal.setBounds(428, 257, 70, 28);
        add(campoMontoTotal);
        
        JDateChooser fechaSalida = new JDateChooser();
        fechaSalida.setDateFormatString("dd-mm-yyyy");
        fechaSalida.setBounds(94, 177, 135, 28);
        add(fechaSalida);
        
        JDateChooser fechaLlegada = new JDateChooser();
        fechaLlegada.setDateFormatString("dd-mm-yyyy");
        fechaLlegada.setBounds(428, 177, 135, 28);
        add(fechaLlegada);
        
        JLabel etiquetaRuta = new JLabel("Destino");
        etiquetaRuta.setBounds(17, 263, 55, 16);
        add(etiquetaRuta);
        
        textField = new JTextField();
        textField.setBounds(94, 257, 135, 28);
        add(textField);
        textField.setColumns(10);
        
        hacerBotones();
    }
    
    void hacerBotones() {
        Image imagenBuscar = Toolkit.getDefaultToolkit().getImage(
                RegistroContrato.class.getResource("/resources/5868370.png"));
        
        JPanel panelBtnBuscarCliente = FabricaPanelBoton.obtenerBotonConIcono(
                232, 19, 28, 28, 0, imagenBuscar, SystemColor.inactiveCaption,
                COMANDO_BUSCAR_CLIENTE);
        panelBtnBuscarCliente.addMouseListener(control);
        add(panelBtnBuscarCliente);
        
        JPanel panelBtnBuscarConductor = FabricaPanelBoton.obtenerBotonConIcono(
                232, 98, 28, 28, 0, imagenBuscar, SystemColor.inactiveCaption,
                COMANDO_BUSCAR_CONDUCTOR);
        panelBtnBuscarConductor.addMouseListener(control);
        add(panelBtnBuscarConductor);
        
        JPanel panelBtnBuscarVehiculo = FabricaPanelBoton.obtenerBotonConIcono(
                566, 98, 28, 28, 0, imagenBuscar, SystemColor.inactiveCaption,
                COMANDO_BUSCAR_VEHICULO);
        panelBtnBuscarVehiculo.addMouseListener(control);
        add(panelBtnBuscarVehiculo);
        
        JPanel panelBtnBuscarDestino = FabricaPanelBoton.obtenerBotonConIcono(
                232, 256, 28, 28, 0, imagenBuscar, SystemColor.inactiveCaption,
                COMANDO_BUSCAR_DESTINO);
        panelBtnBuscarDestino.addMouseListener(control);
        add(panelBtnBuscarDestino);
        
        Image imagenGuardar = Toolkit.getDefaultToolkit().getImage(
                RegistroContrato.class.getResource("/resources/747439.png"));
        JPanel panelBtnGuardar = FabricaPanelBoton.obtenerBotonConIcono(560,
                343, 30, 30, 0, imagenGuardar, SystemColor.inactiveCaption,
                COMANDO_GUARDAR);
        panelBtnGuardar.addMouseListener(control);
        add(panelBtnGuardar);

        Image imagenCancelar = Toolkit.getDefaultToolkit().getImage(
                RegistroContrato.class.getResource("/resources/2140667.png"));
        JPanel panelBtnCancelar = FabricaPanelBoton.obtenerBotonConIcono(515,
                343, 30, 30, 0, imagenCancelar, SystemColor.inactiveCaption,
                COMANDO_CANCELAR);
        panelBtnCancelar.addMouseListener(control);
        add(panelBtnCancelar);
    }

    public JTextField getCampoCliente() {
        return campoCliente;
    }

    public JTextField getCampoConductor() {
        return campoConductor;
    }

    public JTextField getCampoVehiculo() {
        return campoVehiculo;
    }

    public JTextField getCampoMontoTotal() {
        return campoMontoTotal;
    }

    public JDateChooser getFechaSalida() {
        return fechaSalida;
    }

    public JDateChooser getFechaLlegada() {
        return fechaLlegada;
    }
}
