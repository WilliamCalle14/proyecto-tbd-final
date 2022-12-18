package com.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class FabricaPanelBoton {
	private FabricaPanelBoton() {}
	
	private static JPanel obtenerPanelBase(int x, int y, int wP, int hP, Color color, String nombre) {
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.PAGE_AXIS));
		panelBoton.setPreferredSize(new Dimension(wP, hP));
		panelBoton.setBounds(x, y, wP, hP);
		panelBoton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBoton.setBackground(color);
		panelBoton.setName(nombre);
		return panelBoton;
	}
	
	static JPanel obtenerBotonConIcono(int x, int y, int wP, int hP, int aG, Image imagenIcono, Color color, String nombre) {
		int dimI;
		dimI = wP - aG;
		JPanel panelBoton = obtenerPanelBase(x, y, wP, hP, color, nombre);
		ImageIcon icono = new ImageIcon(imagenIcono.getScaledInstance(dimI, dimI, Image.SCALE_SMOOTH));
		JLabel etiquetaIcono = new JLabel(icono);
		etiquetaIcono.setPreferredSize(new Dimension(dimI, dimI));
		etiquetaIcono.setAlignmentX(Component.CENTER_ALIGNMENT);
		etiquetaIcono.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelBoton.add(etiquetaIcono);
		return panelBoton;
	}
	
	static JPanel obtenerBotonConIconoTexto(int x, int y, int wP, int hP, int aG, Image imagenIcono, String texto, Color color, String nombre) {
		JPanel panelBoton = obtenerBotonConIcono(x, y, wP, hP, aG, imagenIcono, color, nombre);
		JLabel etiquetaTexto = new JLabel(texto);
		etiquetaTexto.setFont(etiquetaTexto.getFont().deriveFont(etiquetaTexto.getFont().getStyle() | Font.BOLD));
		etiquetaTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
		etiquetaTexto.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelBoton.add(etiquetaTexto);
		return panelBoton;
	}
}
