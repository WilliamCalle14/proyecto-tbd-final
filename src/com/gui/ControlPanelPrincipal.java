package com.gui;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ControlPanelPrincipal extends MouseAdapter {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		switch (e.getComponent().getName()) {
			case PanelPrincipal.ID_PANEL_CLIENTE:
				SistemaTransporteIU.getInstance().cambiarPanelClientes();
				break;
			case PanelPrincipal.ID_PANEL_CONTRATO:
				System.out.println("Contratos...");
				break;
		}
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
