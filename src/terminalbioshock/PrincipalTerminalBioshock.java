package terminalbioshock;

import Items.Objeto;
import Personajes.Personaje;
import Mapa.Mapa;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

public class PrincipalTerminalBioshock {

    public static void main(String[] args) {

        //Inicio de juego
        ImageIcon icon = new ImageIcon("Images/finn.gif");
        ImageIcon logo = new ImageIcon("Images/inicio.jpg");

        JOptionPane.showMessageDialog(null, "", "Hora de aventuras", JOptionPane.INFORMATION_MESSAGE, logo);

        //Creamos personaje y asignamos atributos
        Personaje personaje = new Personaje();

        ArrayList<Objeto> objetos = new ArrayList<>();

        personaje.getAccionesPersonaje().cargar("CSV", personaje);
        personaje.setPosicion(personaje.getMapa().getInicio());

        Object aux1 = JOptionPane.showInputDialog(null, "Quieres cargar una partida? (Y/N)", "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);

        if (aux1.toString().contains("Y")) {

            personaje.getAccionesPersonaje().UsarComando(personaje.getAccionesPersonaje().Comandos("CSV"), personaje);

        } else {

            // Bucle de Juego
            do {

                personaje.getMapa().imprimeMapa(personaje);
                System.out.println(personaje);

                personaje.getAccionesPersonaje().SeleccionarOpcion(personaje);

                if (personaje.getEnergia() <= 0) {
                    if (personaje.getMochila().contener(personaje, "pocima-energia")) {
                        Object decision = JOptionPane.showInputDialog(null, "Tienes una: pocima-energia" + "\nQuieres usarla (Y/N)?", "Usar!", JOptionPane.WARNING_MESSAGE);
                        if (decision.toString().contains("Y")) {
                            personaje.getAccionesPersonaje().usarObjeto(personaje, "pocima-energia");
                        } else {

                            break;
                        }
                    } else {
                        break;
                    }

                }

            } while (!personaje.getMapa().getMapa().get((personaje.getPosicion())).isEsFin() && personaje.getVida() > 0);

            // Mostramos el resultado final de la partida dependiendo de por que razon acaba el juego
            if (personaje.getEnergia() <= 0) {
                JOptionPane.showMessageDialog(null, "\nTE HAS QUEDADO SIN ENERGIA\n EL JUEGO HA TERMINADO");
            } else if (personaje.getVida() <= 0) {
                JOptionPane.showMessageDialog(null, "\nTE HAS QUEDADO SIN VIDA\n EL JUEGO HA TERMINADO");
            } else {
                JOptionPane.showMessageDialog(null, "\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getDescripcion());
                personaje.getMapa().imprimeMapa(personaje);
                JOptionPane.showMessageDialog(null, "\nFELICIDADES HAS COMPLETADO EL JUEGO");
                System.out.println("\nTUS ESTADISTICAS: " + personaje);
                JOptionPane.showMessageDialog(null, "\nHAS DADO: " + personaje.getRecorrido().size() + " PASOS" + "\nEL RECORRIDO QUE HAS SEGUIDO ES: " + personaje.getRecorrido());
            }

        }
    }

}
