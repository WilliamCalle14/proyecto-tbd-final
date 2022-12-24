package com.gui;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.implementacion.IClienteImpl;
import com.implementacion.IConductorImpl;
import com.implementacion.IRutaImpl;
import com.implementacion.IVehiculoImpl;
import com.objetos.Cliente;
import com.objetos.Conductor;
import com.objetos.Ruta;
import com.objetos.Vehiculo;
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
    private JTextField campoRuta;
    private JDateChooser fechaSalida;
    private JDateChooser fechaLlegada;
    
    private JLabel etiquetaNombreCliente;
    private JLabel etiquetaNombreConductor;
    private JLabel etiquetaNombreVehiculo;
    private JLabel etiquetaNombreRuta;

    private ControlMouse control;
    private DialogoSeleccion dialogo;
    
    private Cliente cliente;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private Ruta ruta;

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

        fechaSalida = new JDateChooser();
//        fechaSalida.setDateFormatString("dd-mm-yyyy");
        fechaSalida.setBounds(94, 177, 135, 28);
        add(fechaSalida);

        fechaLlegada = new JDateChooser();
//        fechaLlegada.setDateFormatString("dd-mm-yyyy");
        fechaLlegada.setBounds(428, 177, 135, 28);
        add(fechaLlegada);

        JLabel etiquetaRuta = new JLabel("Destino");
        etiquetaRuta.setBounds(17, 263, 55, 16);
        add(etiquetaRuta);

        campoRuta = new JTextField();
        campoRuta.setEditable(false);
        campoRuta.setBounds(94, 257, 135, 28);
        add(campoRuta);
        campoRuta.setColumns(10);
        
        dialogo = new DialogoSeleccion(this);
        
        etiquetaNombreCliente = new JLabel("");
        etiquetaNombreCliente.setBorder(new LineBorder(SystemColor.scrollbar));
        etiquetaNombreCliente.setBounds(94, 52, 168, 20);
        add(etiquetaNombreCliente);
        
        etiquetaNombreConductor = new JLabel("");
        etiquetaNombreConductor.setBorder(new LineBorder(SystemColor.scrollbar));
        etiquetaNombreConductor.setBounds(94, 131, 168, 20);
        add(etiquetaNombreConductor);
        
        etiquetaNombreVehiculo = new JLabel("");
        etiquetaNombreVehiculo.setBorder(new LineBorder(SystemColor.scrollbar));
        etiquetaNombreVehiculo.setBounds(428, 131, 168, 20);
        add(etiquetaNombreVehiculo);
        
        etiquetaNombreRuta = new JLabel("");
        etiquetaNombreRuta.setBorder(new LineBorder(SystemColor.scrollbar));
        etiquetaNombreRuta.setBounds(94, 290, 168, 20);
        add(etiquetaNombreRuta);

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
                RegistroContrato.class.getResource("/resources/2874091.png"));
        JPanel panelBtnGuardar = FabricaPanelBoton.obtenerBotonConIcono(538,
                315, 30, 30, 0, imagenGuardar, SystemColor.inactiveCaption,
                COMANDO_GUARDAR);
        panelBtnGuardar.addMouseListener(control);
        add(panelBtnGuardar);

        Image imagenCancelar = Toolkit.getDefaultToolkit().getImage(
                RegistroContrato.class.getResource("/resources/2549867.png"));
        JPanel panelBtnCancelar = FabricaPanelBoton.obtenerBotonConIcono(496,
                315, 30, 30, 0, imagenCancelar, SystemColor.inactiveCaption,
                COMANDO_CANCELAR);
        panelBtnCancelar.addMouseListener(control);
        add(panelBtnCancelar);
    }

//    JTextField getCampoCliente() {
//        return campoCliente;
//    }
//
//    JTextField getCampoConductor() {
//        return campoConductor;
//    }
//
//    JTextField getCampoVehiculo() {
//        return campoVehiculo;
//    }
//
//    JTextField getCampoRuta() {
//        return campoRuta;
//    }

    JTextField getCampoMontoTotal() {
        return campoMontoTotal;
    }

    JDateChooser getFechaSalida() {
        return fechaSalida;
    }

    JDateChooser getFechaLlegada() {
        return fechaLlegada;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    private void limpiarCampoTexto(JTextField campo) {
        campo.setText("");
    }
    
    private void limpiarEtiqueta(JLabel etiqueta) {
        etiqueta.setText("");
    }
    
    private void limpiarJDateChooser(JDateChooser calendario) {
        ((JTextField) calendario.getDateEditor().getUiComponent()).setText("");
    }
    
    void limpiarCampos() {
        limpiarCampoTexto(campoCliente);
        limpiarCampoTexto(campoConductor);
        limpiarCampoTexto(campoVehiculo);
        limpiarCampoTexto(campoRuta);
        limpiarCampoTexto(campoMontoTotal);
        
        limpiarEtiqueta(etiquetaNombreCliente);
        limpiarEtiqueta(etiquetaNombreConductor);
        limpiarEtiqueta(etiquetaNombreVehiculo);
        limpiarEtiqueta(etiquetaNombreRuta);
        
        limpiarJDateChooser(fechaSalida);
        limpiarJDateChooser(fechaLlegada);
        
        cliente = null;
        conductor = null;
        vehiculo = null;
        ruta = null;
    }
    
    void registrarCliente() {
        limpiarCampos();
        fechaLlegada.setEnabled(false);
    }

    void mostrarDialogoCliente() {
        dialogo.setTabla(TablaCliente.obtenerInstancia(), "Seleccionar cliente",
                true);
        
        if (dialogo.objetoSeleccionado()) {
            cliente = TablaCliente.obtenerInstancia()
                    .obtenerEntidadSeleccionada(new IClienteImpl());
            campoCliente.setText(cliente.getCi().toString());
            campoCliente.repaint();
            etiquetaNombreCliente.setText(cliente.getNombre());
            etiquetaNombreCliente.repaint();
        }
    }
    
    void mostrarDialogoConductor() {
        dialogo.setTabla(TablaConductor.obtenerInstancia(),
                "Seleccionar conductor", true);
        
        if (dialogo.objetoSeleccionado()) {
            conductor = TablaConductor.obtenerInstancia()
                    .obtenerEntidadSeleccionada(new IConductorImpl()); 
            campoConductor.setText(conductor.getCi().toString());
            campoConductor.repaint();
            etiquetaNombreConductor.setText(conductor.getNombre());
            etiquetaNombreConductor.repaint();
        }
    }
    
    void mostrarDialogoVehiculo() {
        dialogo.setTabla(TablaVehiculo.obtenerInstancia(),
                "Seleccionar vehiculo", true);
        
        if (dialogo.objetoSeleccionado()) {
            vehiculo = TablaVehiculo.obtenerInstancia()
                    .obtenerEntidadSeleccionada(new IVehiculoImpl());
            campoVehiculo.setText(vehiculo.getPlaca());
            campoVehiculo.repaint();
            etiquetaNombreVehiculo.setText(vehiculo.getModelo());
            etiquetaNombreVehiculo.repaint();
        }
    }
    
    void mostrarDialogoRuta() {
        dialogo.setTabla(TablaRuta.obtenerInstancia(), "Seleccionar ruta",
                true);
        
        if (dialogo.objetoSeleccionado()) {
            ruta = TablaRuta.obtenerInstancia()
                    .obtenerEntidadSeleccionada(new IRutaImpl());
            campoRuta.setText(ruta.getId().toString());
            campoRuta.repaint();
            etiquetaNombreRuta.setText(ruta.getDestino());
            etiquetaNombreRuta.repaint();
        }
    }
}
