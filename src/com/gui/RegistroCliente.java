package com.gui;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class RegistroCliente extends JPanel {
    private static final long serialVersionUID = 1L;
    static final String COMANDO_CANCELAR = "CANCELAR-CLIENTE";
    static final String COMANDO_GUARDAR = "GUARDAR-CLIENTE";
    static final String COMANDO_CAMBIO_CLIENTE = "CAMBIO CLIENTE";
    static final String COMANDO_ANIADIR_TELEFONO = "ANIADIR-TELEFONO-CLIENTE";
    private String[] tiposCliente = { "Preferencial", "Normal" };
    private JTextField campoIdCliente;
    private JTextField campoNombre;
    private JTextField campoDireccion;
    private JLabel etiquetaIdCliente;
    private JLabel etiquetaNombre;
    private JTextField campoTelefono;
    private JList<Object> listaTelefonos;
    private DefaultListModel<Object> modelo;
    private String clienteSeleccionado = "Preferencial";

    private ControlMouse control;
    private ControlComponentes controlComponentes;

    RegistroCliente() {
        setBounds(0, 0, 622, 379);
        setLayout(null);

        control = ControlMouse.obtenerInstancia();
        control.agregarPanelCliente(this);

        controlComponentes = ControlComponentes.obtenerInstancia();
        controlComponentes.agregarPanelCliente(this);

        hacerPanelBase();
        hacerBotones();
    }

    void hacerPanelBase() {
        JLabel etiquetaTipoCliente = new JLabel("Tipo de cliente");
        etiquetaTipoCliente.setBounds(17, 19, 108, 16);
        add(etiquetaTipoCliente);

        JComboBox<Object> comboBoxTipoCliente = new JComboBox<Object>(
                tiposCliente);
        comboBoxTipoCliente.setBounds(137, 14, 117, 26);
        comboBoxTipoCliente.setActionCommand(COMANDO_CAMBIO_CLIENTE);
        comboBoxTipoCliente.addActionListener(controlComponentes);
        add(comboBoxTipoCliente);

        etiquetaIdCliente = new JLabel("NIT");
        etiquetaIdCliente.setBounds(17, 64, 117, 16);
        add(etiquetaIdCliente);

        campoIdCliente = new JTextField();
        campoIdCliente.setBounds(137, 58, 159, 28);
        campoIdCliente.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField campo = (JTextField) input;
                try {
                    Integer.valueOf(campo.getText());
                } catch (NumberFormatException e) {
                    if (!campo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(RegistroCliente.this,
                                "Este campo solo debe contener numeros",
                                "Entrada Incorrecta",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
                return true;
            }
        });
        campoIdCliente.setVerifyInputWhenFocusTarget(true);
        add(campoIdCliente);
        campoIdCliente.setColumns(10);

        etiquetaNombre = new JLabel("Nombre Empresa");
        etiquetaNombre.setBounds(17, 109, 107, 16);
        add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(137, 103, 159, 28);
        add(campoNombre);
        campoNombre.setColumns(10);

        JLabel etiquetaDireccion = new JLabel("Dirección");
        etiquetaDireccion.setBounds(17, 154, 55, 16);
        add(etiquetaDireccion);

        campoDireccion = new JTextField();
        campoDireccion.setBounds(137, 148, 211, 28);
        add(campoDireccion);
        campoDireccion.setColumns(10);

        JLabel etiquetaTelefono = new JLabel("Telefono");
        etiquetaTelefono.setBounds(17, 199, 55, 16);
        add(etiquetaTelefono);

        campoTelefono = new JTextField();
        campoTelefono.setBounds(137, 193, 122, 28);
        campoTelefono.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField campo = (JTextField) input;
                try {
                    Integer.valueOf(campo.getText());
                } catch (NumberFormatException e) {
                    if (!campo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(RegistroCliente.this,
                                "Este campo solo debe contener numeros",
                                "Entrada Incorrecta",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
                return true;
            }
        });
        campoTelefono.setVerifyInputWhenFocusTarget(true);
        add(campoTelefono);
        campoTelefono.setColumns(10);

        listaTelefonos = new JList<>();
        listaTelefonos.setLocation(137, 0);
        // listaTelefonos.setBounds(130, 227, 117, 90);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(listaTelefonos);
        listaTelefonos.setLayoutOrientation(JList.VERTICAL);
        scrollPane.setBounds(140, 227, 117, 90);

        modelo = new DefaultListModel<>();
        listaTelefonos.setModel(modelo);

        add(scrollPane);
    }

    void agregarTelefonoAlista() {
        modelo.addElement(campoTelefono.getText());
        listaTelefonos.repaint();
        campoTelefono.setText("");
        campoTelefono.repaint();
    }

    void hacerBotones() {
        Image imagenAniadir = Toolkit.getDefaultToolkit().getImage(
                RegistroCliente.class.getResource("/resources/107078.png"));
        JPanel panelBtnAniadir = FabricaPanelBoton.obtenerBotonConIcono(260,
                193, 28, 28, 0, imagenAniadir, SystemColor.inactiveCaption,
                COMANDO_ANIADIR_TELEFONO);
        panelBtnAniadir.addMouseListener(control);
        add(panelBtnAniadir);

        Image imagenGuardar = Toolkit.getDefaultToolkit().getImage(
                RegistroCliente.class.getResource("/resources/747439.png"));
        JPanel panelBtnGuardar = FabricaPanelBoton.obtenerBotonConIcono(538,
                315, 30, 30, 0, imagenGuardar, SystemColor.inactiveCaption,
                COMANDO_GUARDAR);
        panelBtnGuardar.addMouseListener(control);
        add(panelBtnGuardar);

        Image imagenCancelar = Toolkit.getDefaultToolkit().getImage(
                RegistroCliente.class.getResource("/resources/2140667.png"));
        JPanel panelBtnCancelar = FabricaPanelBoton.obtenerBotonConIcono(496,
                315, 30, 30, 0, imagenCancelar, SystemColor.inactiveCaption,
                COMANDO_CANCELAR);
        panelBtnCancelar.addMouseListener(control);
        add(panelBtnCancelar);
    }

    void cambiarPanelClientePreferencial() {
        clienteSeleccionado = tiposCliente[0];
        etiquetaIdCliente.setText("NIT");
        etiquetaNombre.setText("Nombre Empresa");
        repaint();
    }

    void cambiarPanelClienteNormal() {
        clienteSeleccionado = tiposCliente[1];
        etiquetaIdCliente.setText("Cedula de Identidad");
        etiquetaNombre.setText("Nombre Completo");
        repaint();
    }

    String[] obtenerTiposCliente() {
        return tiposCliente;
    }

    void limpiarCampos() {
        campoIdCliente.setText("");
        campoNombre.setText("");
        campoDireccion.setText("");
        campoTelefono.setText("");
        modelo.removeAllElements();
        listaTelefonos.removeAll();
        repaint();
    }

    JTextField getCampoIdCliente() {
        return campoIdCliente;
    }

    JTextField getCampoNombre() {
        return campoNombre;
    }

    JTextField getCampoDireccion() {
        return campoDireccion;
    }

    Object[] getListaTelefonos() {
        return modelo.toArray();
    }

    String getClienteSeleccionado() {
        return clienteSeleccionado;
    }
}
