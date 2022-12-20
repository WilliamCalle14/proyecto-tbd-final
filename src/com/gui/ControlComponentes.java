package com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

class ControlComponentes implements ActionListener {
	private static ControlComponentes control;
	private RegistroCliente panelCliente;
	
	private ControlComponentes() {}
	
	void agregarPanelCliente(RegistroCliente panelCliente) {
		this.panelCliente = panelCliente;
	}
	
	static ControlComponentes obtenerInstancia() {
		if (control == null)
			control = new ControlComponentes();
		return control;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(RegistroCliente.COMANDO_CAMBIO_CLIENTE)) {
			@SuppressWarnings("unchecked")
			JComboBox<Object> comboBox = (JComboBox<Object>) e.getSource();
			if (((String) comboBox.getSelectedItem()).equals(panelCliente.obtenerTiposCliente()[0]))
				panelCliente.cambiarPanelClientePreferencial();
			else 
				panelCliente.cambiarPanelClienteNormal();
		}
	}
}
