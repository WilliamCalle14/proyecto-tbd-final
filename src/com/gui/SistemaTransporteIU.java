package com.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SistemaTransporteIU extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panelContenedor;
	private PanelPrincipal panelPrincipal;
	private ClienteIU clienteIU;
	private RegistroCliente panelCliente;
	private ContratoIU contratoIU;
	
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
		panelCliente = new RegistroCliente();
		clienteIU = new ClienteIU();
		contratoIU = new ContratoIU();
		
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
		panelCliente.limpiarCampos();
		clienteIU.cargarClientes();
		cambiarPanel(clienteIU);
	}
	
	void cambiarPanelRegistroCliente() {
		cambiarPanel(panelCliente);
	}

	void cambiarPanelContratoIU() {	
		cambiarPanel(contratoIU);
	}
}
