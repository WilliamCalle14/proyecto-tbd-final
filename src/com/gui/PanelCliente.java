package com.gui;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class PanelCliente extends JPanel {
	private static final long serialVersionUID = 1L;
	static final String COMANDO_CANCELAR = "CANCELAR-CLIENTE";
	static final String COMANDO_GUARDAR = "GUARDAR-CLIENTE";
	static final String COMANDO_CAMBIO_CLIENTE = "CAMBIO CLIENTE";
	static final String COMANDO_ANIADIR = "ANIADIR-CLIENTE";
	private String[] tiposCliente = {"Preferencial", "Normal"};
	private JTextField campoIdCliente;
	private JTextField campoNombre;
	private JTextField campoDireccion;
	private JTextField campoApellidos;
	private JLabel etiquetaIdCliente;
	private JLabel etiquetaNombre;
	private JLabel etiquetaApellido;
	private JTextField campoTelefono;
	private JList<Object> listaTelefonos;
	private DefaultListModel<Object> modelo;
	private String clienteSeleccionado = "Preferencial";
	
	private ControlPanelBoton control;
	private ControlComponentes controlComponentes;
	
	PanelCliente() {
		setBounds(0, 0, 622, 379);
		setLayout(null);
		
		control = ControlPanelBoton.obtenerInstancia();
		control.agregarPanelCliente(this);
		
		controlComponentes = ControlComponentes.obtenerInstancia();
		controlComponentes.agregarPanelCliente(this);
		
		hacerPanelBase();
		hacerBotones();
	}
	
	void hacerPanelBase() {
		JLabel etiquetaTipoCliente = new JLabel("Tipo de cliente");
		etiquetaTipoCliente.setBounds(17, 19, 80, 16);
		add(etiquetaTipoCliente);
		
		JComboBox<Object> comboBoxTipoCliente = new JComboBox<Object>(tiposCliente);
		comboBoxTipoCliente.setBounds(127, 14, 117, 26);
		comboBoxTipoCliente.setActionCommand(COMANDO_CAMBIO_CLIENTE);
		comboBoxTipoCliente.addActionListener(controlComponentes);
		add(comboBoxTipoCliente);
		
		etiquetaIdCliente = new JLabel("NIT");
		etiquetaIdCliente.setBounds(17, 64, 55, 16);
		add(etiquetaIdCliente);
		
		campoIdCliente = new JTextField();
		campoIdCliente.setBounds(127, 58, 159, 28);
		add(campoIdCliente);
		campoIdCliente.setColumns(10);
		
		etiquetaNombre = new JLabel("Nombre Empresa");
		etiquetaNombre.setBounds(17, 109, 99, 16);
		add(etiquetaNombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(127, 103, 159, 28);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etiquetaDireccion = new JLabel("Dirección");
		etiquetaDireccion.setBounds(17, 154, 55, 16);
		add(etiquetaDireccion);
		
		campoDireccion = new JTextField();
		campoDireccion.setBounds(127, 148, 211, 28);
		add(campoDireccion);
		campoDireccion.setColumns(10);
		
		etiquetaApellido = new JLabel("Apellidos");
		etiquetaApellido.setBounds(364, 109, 55, 16);
		etiquetaApellido.setVisible(false);
		add(etiquetaApellido);
		
		campoApellidos = new JTextField();
		campoApellidos.setBounds(443, 103, 159, 28);
		campoApellidos.setVisible(false);
		add(campoApellidos);
		campoApellidos.setColumns(10);
		
		JLabel etiquetaTelefono = new JLabel("Telefono");
		etiquetaTelefono.setBounds(17, 199, 55, 16);
		add(etiquetaTelefono);
		
		campoTelefono = new JTextField();
		campoTelefono.setBounds(127, 193, 122, 28);
		add(campoTelefono);
		campoTelefono.setColumns(10);
		
		listaTelefonos = new JList<>();
		// listaTelefonos.setBounds(130, 227, 117, 90);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(listaTelefonos);
		listaTelefonos.setLayoutOrientation(JList.VERTICAL);
		scrollPane.setBounds(130, 227, 117, 90);
		
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
		Image imagenAniadir = Toolkit.getDefaultToolkit().getImage(PanelCliente.class.getResource("/resources/107078.png"));
		JPanel panelBtnAniadir = FabricaPanelBoton.obtenerBotonConIcono(250, 193, 28, 28, 0, imagenAniadir, SystemColor.inactiveCaption, COMANDO_ANIADIR);
		panelBtnAniadir.addMouseListener(control);
		add(panelBtnAniadir);
		
		Image imagenGuardar = Toolkit.getDefaultToolkit().getImage(PanelCliente.class.getResource("/resources/747439.png"));
		JPanel panelBtnGuardar = FabricaPanelBoton.obtenerBotonConIcono(560, 343, 30, 30, 0, imagenGuardar, SystemColor.inactiveCaption, COMANDO_GUARDAR);
		panelBtnGuardar.addMouseListener(control);
		add(panelBtnGuardar);
		
		Image imagenCancelar = Toolkit.getDefaultToolkit().getImage(PanelCliente.class.getResource("/resources/545676.png"));
		JPanel panelBtnCancelar = FabricaPanelBoton.obtenerBotonConIcono(515, 343, 30, 30, 0, imagenCancelar, SystemColor.inactiveCaption, COMANDO_CANCELAR);
		panelBtnCancelar.addMouseListener(control);
		add(panelBtnCancelar);
	}
	
	void cambiarPanelClientePreferencial() {
		clienteSeleccionado = tiposCliente[0];
		etiquetaIdCliente.setText("NIT");
		etiquetaNombre.setText("Nombre Empresa");
		etiquetaApellido.setVisible(false);
		campoApellidos.setVisible(false);
		repaint();
	}
	
	void cambiarPanelClienteNormal() {
		clienteSeleccionado = tiposCliente[1];
		etiquetaIdCliente.setText("CI");
		etiquetaNombre.setText("Nombre");
		etiquetaApellido.setVisible(true);
		campoApellidos.setVisible(true);
		repaint();
	}
	
	String[] obtenerTiposCliente() {
		return tiposCliente;
	}
	
	void limpiarCampos() {
		campoIdCliente.setText("");
		campoNombre.setText("");
		campoApellidos.setText("");
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

	JTextField getCampoApellidos() {
		return campoApellidos;
	}

	Object[] getListaTelefonos() {
		return modelo.toArray();
	}
	
	String getClienteSeleccionado() {
		return clienteSeleccionado;
	}
}
