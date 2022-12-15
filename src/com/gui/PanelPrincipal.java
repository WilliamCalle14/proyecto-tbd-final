package com.gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class PanelPrincipal extends JPanel {
	static final String ID_PANEL_CLIENTE = "CLIENTE";
	static final String ID_PANEL_CONTRATO = "CONTRATO";
	private static final long serialVersionUID = 1L;
	private ControlPanelPrincipal control;
	
	PanelPrincipal() {
		setBounds(0, 0, 622, 379);
		setLayout(null);
		
		control = new ControlPanelPrincipal();
		
		hacerPanelBtnCliente();
		hacerPanelBtnContrato();
	}
	
	void hacerPanelBtnCliente() {
		JPanel panelBtnCliente = new JPanel();
		panelBtnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBtnCliente.setBackground(SystemColor.inactiveCaption);
		panelBtnCliente.setBounds(51, 118, 128, 143);
		add(panelBtnCliente);
		panelBtnCliente.setLayout(null);
		
		panelBtnCliente.setName(ID_PANEL_CLIENTE);
		panelBtnCliente.addMouseListener(control);
		
		ImageIcon iconoCliente = new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelPrincipal.class.getResource("/resources/3126649.png")).getScaledInstance(116, 116, Image.SCALE_SMOOTH));
		
		JLabel etiquetaIconoCliente = new JLabel(iconoCliente);
		etiquetaIconoCliente.setBounds(6, 6, 116, 116);
		panelBtnCliente.add(etiquetaIconoCliente);
		
		JLabel etiquetaCliente = new JLabel("Clientes");
		etiquetaCliente.setFont(etiquetaCliente.getFont().deriveFont(etiquetaCliente.getFont().getStyle() | Font.BOLD));
		etiquetaCliente.setBounds(41, 121, 46, 16);
		panelBtnCliente.add(etiquetaCliente);
	}
	
	void hacerPanelBtnContrato() {
		JPanel panelBtnContrato = new JPanel();
		panelBtnContrato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBtnContrato.setBackground(SystemColor.inactiveCaption);
		panelBtnContrato.setBounds(247, 118, 128, 143);
		add(panelBtnContrato);
		panelBtnContrato.setLayout(null);
		
		panelBtnContrato.setName(ID_PANEL_CONTRATO);
		panelBtnContrato.addMouseListener(control);
		
		ImageIcon iconoContrato = new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelPrincipal.class.getResource("/resources/1429239.png")).getScaledInstance(116, 116, Image.SCALE_SMOOTH));
		
		JLabel etiquetaIconoContrato = new JLabel(iconoContrato);
		etiquetaIconoContrato.setBounds(6, 6, 116, 116);
		panelBtnContrato.add(etiquetaIconoContrato);
		
		JLabel etiquetaContrato = new JLabel("Contratos");
		etiquetaContrato.setFont(etiquetaContrato.getFont().deriveFont(etiquetaContrato.getFont().getStyle() | Font.BOLD));
		etiquetaContrato.setBounds(36, 121, 56, 16);
		panelBtnContrato.add(etiquetaContrato);
	}
}
