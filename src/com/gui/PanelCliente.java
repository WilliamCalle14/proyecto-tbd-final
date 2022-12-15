package com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class PanelCliente extends JPanel {
	private static PanelCliente panelCliente;
	static final String COMANDO_CANCELAR = "CANCELAR";
	static final String COMANDO_GUARDAR = "GUARDAR";
	static final String COMANDO_CAMBIO_CLIENTE = "CAMBIO CLIENTE";
	private static final long serialVersionUID = 1L;
	private ControlPanelCliente control;
	private String[] tiposCliente = {"Preferencial", "Normal"};
	private JTextField campoIdCliente;
	private JTextField campoNombre;
	private JTextField campoDireccion;
	private JTextField campoApellidos;
	private JLabel etiquetaIdCliente;
	private JLabel etiquetaNombre;
	private JLabel etiquetaApellido;
	
	private PanelCliente() {
		setBounds(0, 0, 622, 379);
		setLayout(null);
		
		control = new ControlPanelCliente();
		
		JLabel etiquetaTipoCliente = new JLabel("Tipo de cliente");
		etiquetaTipoCliente.setBounds(17, 29, 80, 16);
		add(etiquetaTipoCliente);
		
		JComboBox comboBoxTipoCliente = new JComboBox(tiposCliente);
		comboBoxTipoCliente.setBounds(127, 24, 117, 26);
		comboBoxTipoCliente.setActionCommand(COMANDO_CAMBIO_CLIENTE);
		comboBoxTipoCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch ((String) comboBoxTipoCliente.getSelectedItem()) {
					case "Preferencial":
						cambiarPanelClientePreferencial();
						break;
					case "Normal":
						cambiarPanelClienteNormal();
						break;
				}
			}
		});
		add(comboBoxTipoCliente);
		
		hacerPanelBase();
		hacerBotones();
	}
	
	static PanelCliente getInstance() {
		if (panelCliente == null)
			panelCliente = new PanelCliente();
		return panelCliente;
	}
	
	void hacerPanelBase() {
		etiquetaIdCliente = new JLabel("NIT");
		etiquetaIdCliente.setBounds(17, 78, 55, 16);
		add(etiquetaIdCliente);
		
		etiquetaNombre = new JLabel("Nombre Empresa");
		etiquetaNombre.setBounds(17, 136, 99, 16);
		add(etiquetaNombre);
		
		JLabel etiquetaDireccion = new JLabel("Dirección");
		etiquetaDireccion.setBounds(17, 194, 55, 16);
		add(etiquetaDireccion);
		
		campoIdCliente = new JTextField();
		campoIdCliente.setBounds(127, 72, 159, 28);
		add(campoIdCliente);
		campoIdCliente.setColumns(10);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(128, 130, 159, 28);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		campoDireccion = new JTextField();
		campoDireccion.setBounds(128, 188, 211, 28);
		add(campoDireccion);
		campoDireccion.setColumns(10);
		
		etiquetaApellido = new JLabel("Apellidos");
		etiquetaApellido.setBounds(345, 136, 55, 16);
		etiquetaApellido.setVisible(false);
		add(etiquetaApellido);
		
		campoApellidos = new JTextField();
		campoApellidos.setBounds(433, 130, 159, 28);
		campoApellidos.setVisible(false);
		add(campoApellidos);
		campoApellidos.setColumns(10);
	}
	
	void hacerBotones() {
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(502, 345, 90, 28);
		btnGuardar.setActionCommand(COMANDO_GUARDAR);
		btnGuardar.addActionListener(control);
		add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(385, 345, 90, 28);
		btnCancelar.setActionCommand(COMANDO_CANCELAR);
		btnCancelar.addActionListener(control);
		add(btnCancelar);
	}
	
	void cambiarPanelClientePreferencial() {
		etiquetaIdCliente.setText("NIT");
		etiquetaNombre.setText("Nombre Empresa");
		etiquetaApellido.setVisible(false);
		campoApellidos.setVisible(false);
		repaint();
	}
	
	void cambiarPanelClienteNormal() {
		etiquetaIdCliente.setText("CI");
		etiquetaNombre.setText("Nombre");
		etiquetaApellido.setVisible(true);
		campoApellidos.setVisible(true);
		repaint();
	}
}
