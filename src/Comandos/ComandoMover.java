package Comandos;

import Excepciones.ExcepcionMovimiento;
import Personajes.Jugador;
import javax.swing.ImageIcon;

public class ComandoMover implements Comando {

    private Jugador jugador;
    private String direccion;

    public ComandoMover(Jugador jugador, String Direccion) {

        this.jugador = jugador;
        this.direccion = Direccion;

    }

    @Override
    public void ejecutar() throws ExcepcionMovimiento {

        ImageIcon icon = new ImageIcon("Images/finn.gif");

        try {
            jugador.Mover(direccion);
        } catch (ExcepcionMovimiento m) {

            throw new ExcepcionMovimiento();

        }
    }

}
