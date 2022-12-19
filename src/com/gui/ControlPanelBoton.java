package com.gui;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.objetos.Cliente;
import com.sql.ControladorSQL;

class ControlPanelBoton extends MouseAdapter {
	private static ControlPanelBoton control;
	
	private SistemaTransporteIU sistema;
	private PanelPrincipal panelPrincipal;
	private PanelCliente panelCliente;
	private ControladorSQL controladorSQL;
	
	private ControlPanelBoton() {
		controladorSQL = new ControladorSQL();
	}
	
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
		else if (nombre.equals(PanelCliente.COMANDO_GUARDAR)) {
			int idCliente;
			String tmp, nombreCliente, direccionCliente, tipoCliente;
			
			try {
				tmp = validarCampo(panelCliente.getCampoIdCliente());
				if (tmp == null) return;
				idCliente = Integer.valueOf(tmp);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null,
						"El campo CI/NIT debe contener solo numeros",
						"Error de conversion", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			nombreCliente = validarCampo(panelCliente.getCampoNombre());
			if (nombreCliente == null) return;
			
			direccionCliente = validarCampo(panelCliente.getCampoDireccion());
			if (direccionCliente == null) return;
			
			tipoCliente = panelCliente.getClienteSeleccionado();
			
			if (tipoCliente.equals(panelCliente.obtenerTiposCliente()[1])) {
				tmp = validarCampo(panelCliente.getCampoApellidos());
				if (tmp == null) return;
				nombreCliente += " " + tmp;
			}
			
			Object[] listaTmp = panelCliente.getListaTelefonos();
			String[] listaTelefonos = new String[listaTmp.length];
			
			for (int i = 0; i < listaTmp.length; i++)
				listaTelefonos[i] = String.valueOf(listaTmp[i]);
			
			Cliente cliente = new Cliente(idCliente, nombreCliente,
					direccionCliente, tipoCliente, listaTelefonos);
			
			try {
				controladorSQL.insertarCliente(cliente);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1.getSQLState(),
						"Error al registrar", JOptionPane.ERROR_MESSAGE);
			}
			
			JOptionPane.showMessageDialog(null, "Cliente guardado con exito", "Guardar Cliente", JOptionPane.INFORMATION_MESSAGE);
			panelCliente.limpiarCampos();
		}
		e.getComponent().setBackground(SystemColor.inactiveCaption);
	}
	
	private String validarCampo(JTextField campo) {
		String texto = campo.getText();
		if (texto.length() == 0) {
			JOptionPane.showMessageDialog(null, "Algunos campos estan vacios",
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
