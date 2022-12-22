package com;

import javax.swing.SwingUtilities;

import com.gui.SistemaTransporteIU;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SistemaTransporteIU().setVisible(true);
                ;
            }
        });
    }
}
