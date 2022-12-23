package com.gui;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.implementacion.IClienteImpl;
import com.implementacion.IContratoImpl;
import com.implementacion.IEmpleadoImpl;
import com.implementacion.ITelefonoClienteImpl;
import com.objetos.Cliente;
import com.objetos.Conductor;
import com.objetos.Contrato;
import com.objetos.Empleado;
import com.objetos.Ruta;
import com.objetos.TelefonoCliente;
import com.objetos.Vehiculo;

class ControlMouse extends MouseAdapter {
    private static ControlMouse control;

    private SistemaTransporteIU sistema;
    private RegistroCliente registroCliente;
    private RegistroContrato registroContrato;

    private ControlMouse() {}

    static ControlMouse obtenerInstancia() {
        if (control == null)
            control = new ControlMouse();
        return control;
    }

    void agregarSistema(SistemaTransporteIU sistema) {
        this.sistema = sistema;
    }

    void agregarPanelCliente(RegistroCliente panelCliente) {
        this.registroCliente = panelCliente;
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
        else if (nombre.equals(ClienteIU.COMANDO_MODIFICAR))
            System.out.println(TablaCliente.obtenerInstancia()
                    .obtenerEntidadSeleccionada(new IClienteImpl()));
        else if (nombre.equals(ContratoIU.COMANDO_ANIADIR))
            sistema.cambiarPanelRegistroContrato();
        else if (nombre.equals(RegistroCliente.COMANDO_ANIADIR_TELEFONO))
            registroCliente.agregarTelefonoAlista();
        else if (nombre.equals(RegistroCliente.COMANDO_GUARDAR))
            agregarCliente();
        else if (nombre.equals(RegistroContrato.COMANDO_GUARDAR))
            guardarContrato();
        else if (nombre.equals(RegistroContrato.COMANDO_BUSCAR_CLIENTE))
            registroContrato.mostrarDialogoCliente();
        else if (nombre.equals(RegistroContrato.COMANDO_BUSCAR_CONDUCTOR))
            registroContrato.mostrarDialogoConductor();
        else if (nombre.equals(RegistroContrato.COMANDO_BUSCAR_DESTINO))
            registroContrato.mostrarDialogoRuta();
        else if (nombre.equals(RegistroContrato.COMANDO_BUSCAR_VEHICULO))
            registroContrato.mostrarDialogoVehiculo();
        e.getComponent().setBackground(SystemColor.inactiveCaption);
    }
    
    private void mostrarMensajeCamposVacios(JPanel origen) {
        JOptionPane.showMessageDialog(origen,
                "Algunos campos estan vacios", "Campos vacios",
                JOptionPane.ERROR_MESSAGE);
    }

    private void guardarContrato() {
        Cliente cliente = registroContrato.getCliente();
        
        if (cliente == null) {
            mostrarMensajeCamposVacios(registroContrato);
            return;
        }
        
        Conductor conductor = registroContrato.getConductor();
        
        if (conductor == null) {
            mostrarMensajeCamposVacios(registroContrato);
            return;
        }
        
        Vehiculo vehiculo = registroContrato.getVehiculo();
        
        if (vehiculo == null) {
            mostrarMensajeCamposVacios(registroContrato);
            return;
        }
        
        Date fechaSalida = registroContrato.getFechaSalida().getDate();
        
        if (fechaSalida == null) {
            mostrarMensajeCamposVacios(registroContrato);
            return;
        }
        
        Ruta ruta = registroContrato.getRuta();
        
        if (ruta == null) {
            mostrarMensajeCamposVacios(registroContrato);
            return;
        }
        
        String tmp = validarCampo(registroContrato.getCampoMontoTotal(),
                registroContrato);
        
        if (tmp == null)
            return;
        
        float montoTotal = Float.parseFloat(tmp);
        
        try {
            IEmpleadoImpl empleadoDB = new IEmpleadoImpl();
            Empleado empleado = empleadoDB.obtener(2097480);
        
            Contrato contrato = new Contrato();
            
            contrato.setIdRuta(ruta.getId());
            contrato.setCiConductor(conductor.getCi());
            contrato.setPlaca(vehiculo.getPlaca());
            contrato.setCiCliente(cliente.getCi());
            contrato.setCiEmpleado(empleado.getCi());
            contrato.setNitSucursal(empleado.getNitSucursal());
            contrato.setFechaRegContrato(
                    new java.sql.Date(new Date().getTime()));
            contrato.setFechaSalida(new java.sql.Date(fechaSalida.getTime()));
            contrato.setMontoTotal(montoTotal);
            
            IContratoImpl contratoDB = new IContratoImpl();
            
            contratoDB.insertar(contrato);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(registroContrato, e.toString(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        registroContrato.limpiarCampos();
        JOptionPane.showMessageDialog(registroContrato, "Contrato registrado");
    }

    private void agregarCliente() {
        Cliente cliente;
        String tmp;

        cliente = new Cliente();

        tmp = validarCampo(registroCliente.getCampoIdCliente(),
                registroCliente);
        cliente.setCi(Integer.valueOf(tmp));

        tmp = validarCampo(registroCliente.getCampoNombre(), registroCliente);
        if (tmp == null)
            return;
        cliente.setNombre(tmp);

        cliente.setTipo("Preferencial");

        if (registroCliente.getClienteSeleccionado()
                .equals(registroCliente.obtenerTiposCliente()[1]))
            cliente.setTipo("Normal");

        tmp = validarCampo(registroCliente.getCampoDireccion(),
                registroCliente);
        if (tmp == null)
            return;
        cliente.setDireccion(tmp);

        Object[] objs = registroCliente.getListaTelefonos();
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
            JOptionPane.showMessageDialog(registroCliente, e1.getMessage(),
                    "Error al guardar", JOptionPane.ERROR_MESSAGE);
            return;
        }

        registroCliente.limpiarCampos();
        JOptionPane.showMessageDialog(registroCliente, "Cliente guardado");
    }

    private String validarCampo(JTextField campo, JPanel panel) {
        String texto = campo.getText();
        if (texto.isEmpty()) {
            mostrarMensajeCamposVacios(panel);
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
