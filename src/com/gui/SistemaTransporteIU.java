package com.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SistemaTransporteIU extends JFrame {
	private static SistemaTransporteIU sistema;
	private static final long serialVersionUID = 1L;
	private PanelPrincipal panelPrincipal;
	private PanelCliente panelCliente;
	private JPanel panelContenedor;

	private SistemaTransporteIU() {
		super("Sistema Transporte - Trans Bolivia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 430);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		
		panelPrincipal = new PanelPrincipal();
		panelCliente = PanelCliente.getInstance();
		
		hacerPanelContenedor();
	}
	
	public static SistemaTransporteIU getInstance() {
		if (sistema == null)
			sistema = new SistemaTransporteIU();
		return sistema;
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
