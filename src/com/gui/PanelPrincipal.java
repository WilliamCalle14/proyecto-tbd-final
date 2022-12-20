package com.gui;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JPanel;

class PanelPrincipal extends JPanel {
	private static final long serialVersionUID = 1L;
	static final String ID_PANEL_CLIENTE = "CLIENTE";
	static final String ID_PANEL_CONTRATO = "CONTRATO";
	
	private ControlMouse control;
	
	PanelPrincipal() {
		setBounds(0, 0, 622, 379);
		setLayout(null);
		
		control = ControlMouse.obtenerInstancia();
	
		Image imagenCliente = Toolkit.getDefaultToolkit().getImage(PanelPrincipal.class.getResource("/resources/3126649.png"));
		JPanel panelBtnCliente = FabricaPanelBoton.obtenerBotonConIconoTexto(51, 118, 128, 143, 6, imagenCliente, "Clientes", SystemColor.inactiveCaption, ID_PANEL_CLIENTE);
		panelBtnCliente.addMouseListener(control);
		add(panelBtnCliente);
	
		Image imagenContrato = Toolkit.getDefaultToolkit().getImage(PanelPrincipal.class.getResource("/resources/1429239.png"));
		JPanel panelBtnContrato = FabricaPanelBoton.obtenerBotonConIconoTexto(247, 118, 128, 143, 6, imagenContrato, "Contratos", SystemColor.inactiveCaption, ID_PANEL_CONTRATO);
		panelBtnContrato.addMouseListener(control);
		add(panelBtnContrato);
	}
}
