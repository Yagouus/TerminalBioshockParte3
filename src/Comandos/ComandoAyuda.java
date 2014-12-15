package Comandos;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ComandoAyuda implements Comando {

    public ComandoAyuda() {

    }

    @Override
    public void ejecutar() {

        ImageIcon icon = new ImageIcon("Images/finn.gif");

        JOptionPane.showMessageDialog(null, "Mover: moverte por el mapa \nMirar: Ver objetos y personajes de la celda  \nCoger: Coger objetos  \nUsar: usar objetos \nTirar: tirar objeto  \nOjear: ver contenido mochila \nAyuda: inception \nSalir: salir del juego", "Welcome to Rapture", JOptionPane.INFORMATION_MESSAGE);

    }

}
