package com.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SistemaTransporteIU extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panelContenedor;
	private PanelPrincipal panelPrincipal;
	private PanelCliente panelCliente;
	
	private ControlPanelBoton control;

	public SistemaTransporteIU() {
		super("Sistema Transporte - Trans Bolivia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 430);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		
		control = ControlPanelBoton.obtenerInstancia();
		control.agregarSistema(this);
		panelPrincipal = new PanelPrincipal();
		panelCliente = new PanelCliente();
		
		hacerPanelContenedor();
	}
	
	void hacerPanelContenedor() {
		panelContenedor = new JPanel();
		panelContenedor.setBounds(6, 6, 622, 379);
		panelContenedor.setLayout(null);
		panelContenedor.add(panelPrincipal);
		getContentPane().add(panelContenedor);
	}
	
	void cambiarPanelPrincipal() {
		panelContenedor.removeAll();
		panelContenedor.add(panelPrincipal);
		panelContenedor.revalidate();
		panelContenedor.repaint();
	}
	
	void cambiarPanelClientes() {
		panelContenedor.removeAll();
		panelContenedor.add(panelCliente);
		panelContenedor.revalidate();
		panelContenedor.repaint();
	}
}
