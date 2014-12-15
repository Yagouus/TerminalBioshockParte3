package Comandos;

import Personajes.Jugador;
import javax.swing.ImageIcon;

public class ComandoMirar implements Comando {

    private Jugador jugador;

    public ComandoMirar(Jugador jugador) {

        this.jugador = jugador;

    }

    @Override
    public void ejecutar() {

        ImageIcon icon = new ImageIcon("Images/finn.gif");

        jugador.Mirar();

    }
}
