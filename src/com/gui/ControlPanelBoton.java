package com.gui;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ControlPanelBoton extends MouseAdapter {
	private static ControlPanelBoton control;
	
	private SistemaTransporteIU sistema;
	private PanelPrincipal panelPrincipal;
	private PanelCliente panelCliente;
	
	private ControlPanelBoton() {}
	
	static ControlPanelBoton obtenerInstancia() {
		if (control == null)
			control = new ControlPanelBoton();
		return control;
	}
	
	void agregarSistema(SistemaTransporteIU sistema) {
		this.sistema = sistema;
	}
	
	void agregarPanelPrincipal(PanelPrincipal panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}
	
	void agregarPanelCliente(PanelCliente panelCliente) {
		this.panelCliente = panelCliente;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		String nombre = e.getComponent().getName();
		if (nombre.equals(PanelPrincipal.ID_PANEL_CLIENTE))
			sistema.cambiarPanelClientes();
		else if (nombre.equals(PanelCliente.COMANDO_CANCELAR))
			sistema.cambiarPanelPrincipal();
		else if (nombre.equals(PanelCliente.COMANDO_ANIADIR))
			panelCliente.agregarTelefonoAlista();
		e.getComponent().setBackground(SystemColor.inactiveCaption);
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
