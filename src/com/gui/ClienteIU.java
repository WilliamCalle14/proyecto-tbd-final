package com.gui;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

class ClienteIU extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ControlMouse control;
	static final String COMANDO_ANIADIR = "ANIADIR_CLIENTEDB";
	static final String COMANDO_HOME = "HOME_CLIENTEDB";
	private JTable tablaUsuarios;
	
	public ClienteIU() {
		setBounds(0, 0, 622, 379);
		setLayout(null);
		
		control = ControlMouse.obtenerInstancia();
		
		JLabel etiquetaClientes = new JLabel("CLIENTES");
		etiquetaClientes.setBounds(279, 32, 65, 16);
		add(etiquetaClientes);
		
		tablaUsuarios = new JTable();
		tablaUsuarios.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"CODIGO", "NOMBRE", "DIRECCION", "TIPO"}) {
			private static final long serialVersionUID = 1L;
			Class[] tipos = new Class[] {
					String.class, String.class, String.class, String.class
			};
			
			public Class getColumnClass(int idx) {
				return tipos[idx];
			}
		});
		
		tablaUsuarios.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 60, 594, 230);
		scrollPane.setViewportView(tablaUsuarios);
		
		add(scrollPane);
		
		Image iconoAniadir = Toolkit.getDefaultToolkit().getImage(
				ClienteIU.class.getResource("/resources/72648.png"));
		JPanel panelBtnAniadir = FabricaPanelBoton.obtenerBotonConIcono(
				538, 315, 30, 30, 0, iconoAniadir, SystemColor.inactiveCaption,
				COMANDO_ANIADIR);
		panelBtnAniadir.addMouseListener(control);
		add(panelBtnAniadir);
		
		Image iconoHome = Toolkit.getDefaultToolkit().getImage(
				ClienteIU.class.getResource("/resources/4103187.png"));
		JPanel panelBtnHome = FabricaPanelBoton.obtenerBotonConIcono(
				49, 315, 30, 30, 0, iconoHome, SystemColor.inactiveCaption,
				COMANDO_HOME);
		panelBtnHome.addMouseListener(control);
		add(panelBtnHome);
	}
	
	void cargarClientes() {
		try {
			ClienteDB clienteDB = new ClienteDB();
			DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
			
			for (int i = 0; i < modelo.getRowCount(); i++)
				modelo.removeRow(i);
			
			clienteDB.listar().forEach((cliente) -> modelo.addRow(
					new Object[] {
							cliente.getCiCliente(),
							cliente.getNombreCliente(),
							cliente.getDireccionCliente(),
							cliente.getTipoCliente()
					}));
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
}
