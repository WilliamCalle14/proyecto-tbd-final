package com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ControlPanelCliente implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case PanelCliente.COMANDO_GUARDAR:
				break;
			case PanelCliente.COMANDO_CANCELAR:
				SistemaTransporteIU.getInstance().cambiarPanelPrincipal();
				break;
		}
	}
}
