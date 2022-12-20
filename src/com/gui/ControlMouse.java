package com.gui;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.objetos.Cliente;

class ControlMouse extends MouseAdapter {
	private static ControlMouse control;
	
	private SistemaTransporteIU sistema;
	private RegistroCliente panelCliente;
	
	private ControlMouse() {
	}
	
	static ControlMouse obtenerInstancia() {
		if (control == null)
			control = new ControlMouse();
		return control;
	}
	
	void agregarSistema(SistemaTransporteIU sistema) {
		this.sistema = sistema;
	}
	
	void agregarPanelCliente(RegistroCliente panelCliente) {
		this.panelCliente = panelCliente;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		String nombre = e.getComponent().getName();
		if (nombre.equals(PanelPrincipal.ID_PANEL_CLIENTE)
				|| nombre.equals(RegistroCliente.COMANDO_CANCELAR))
			sistema.cambiarPanelClienteIU();
		else if (nombre.equals(ClienteIU.COMANDO_HOME)
				|| nombre.equals(ContratoIU.COMANDO_HOME))
			sistema.cambiarPanelPrincipal();
		else if (nombre.equals(PanelPrincipal.ID_PANEL_CONTRATO))
			sistema.cambiarPanelContratoIU();
		else if (nombre.equals(ClienteIU.COMANDO_ANIADIR))
			sistema.cambiarPanelRegistroCliente();
		else if (nombre.equals(RegistroCliente.COMANDO_ANIADIR_TELEFONO))
			panelCliente.agregarTelefonoAlista();
		else if (nombre.equals(RegistroCliente.COMANDO_GUARDAR))
			agregarCliente();
		e.getComponent().setBackground(SystemColor.inactiveCaption);
	}
	
	private void agregarCliente() {
		Cliente cliente;
		String tmp;
		
		cliente = new Cliente();
		
		tmp = validarCampo(panelCliente.getCampoIdCliente());
		cliente.setCiCliente(Integer.valueOf(tmp));
		
		tmp = validarCampo(panelCliente.getCampoNombre());
		if (tmp == null) return;
		cliente.setNombreCliente(tmp);
		
		cliente.setTipoCliente("PREFERENCIAL");
		
		if (panelCliente.getClienteSeleccionado().
				equals(panelCliente.obtenerTiposCliente()[1]))
			cliente.setTipoCliente("NORMAL");
		
		tmp = validarCampo(panelCliente.getCampoDireccion());
		if (tmp == null) return;
		cliente.setDireccionCliente(tmp);
		
		Object[] objs = panelCliente.getListaTelefonos();
		String[] telefonos = new String[objs.length];
		
		for (int i = 0; i < objs.length; i++)
			telefonos[i] = (String) objs[i];
		cliente.setTelefonos(telefonos);
		
		ClienteDB clienteDB = new ClienteDB();
		try {
			clienteDB.insertar(cliente);
		} catch (ClassNotFoundException | SQLException e1) {
			JOptionPane.showMessageDialog(panelCliente, e1.getMessage(),
					"Error al guardar", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			return;
		}
		panelCliente.limpiarCampos();
		JOptionPane.showMessageDialog(panelCliente, "Cliente guardado");
	}
	
	private String validarCampo(JTextField campo) {
		String texto = campo.getText();
		if (texto.isEmpty()) {
			JOptionPane.showMessageDialog(panelCliente, "Algunos campos estan vacios",
					"Campos Vacios", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return texto;
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
