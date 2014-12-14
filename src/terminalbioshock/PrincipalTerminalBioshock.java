package terminalbioshock;

import Items.Objeto;
import Personajes.Personaje;
import Mapa.Mapa;
import Personajes.Mago;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

public class PrincipalTerminalBioshock {

    public static void main(String[] args) {

        //Ceamos instancia de juego        
        Juego juego = new Juego();

        //Inconos para la gui
        ImageIcon icon = new ImageIcon("Images/finn.gif");
        ImageIcon logo = new ImageIcon("Images/inicio.jpg");

        //Pantalla de bienvenida
        JOptionPane.showMessageDialog(null, "", "Hora de aventuras", JOptionPane.INFORMATION_MESSAGE, logo);

        //Creamos personaje y asignamos atributos
        ArrayList<Objeto> objetos = new ArrayList<>();

        Object aux1 = JOptionPane.showInputDialog(null, "Quieres cargar una partida? (Y/N)", "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);

        if (aux1.toString().contains("Y")) {

            juego.cargar("CSV");
            juego.UsarComando(juego.Comandos("CSV"));

        } else {

            Object aux2 = JOptionPane.showInputDialog(null, "Quieres cargar un Mapa (Y/N)?", "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);

            if (aux2.toString().contains("Y")) {
                juego.cargar("CSV");

            } else {

                Object aux3 = JOptionPane.showInputDialog(null, "Elige tu clase: \n Guerrero (G) \n Mago (M)", "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);

                switch (aux3.toString()) {

                    case "G":
                    case "Guerrero":

                        break;

                    case "M":
                    case "Mago":

                        break;

                }
            }
            juego.Jugador.setMapa(juego.MapaJuego);

            // Bucle de Juego
            do {

                juego.MapaJuego.imprimeMapa(juego.Jugador);
                System.out.println(juego.Jugador);

                juego.SeleccionarOpcion(juego.Jugador);

                if (juego.Jugador.getEnergia() <= 0) {
                    if (juego.Jugador.getMochila().contener(juego.Jugador, "pocima-energia")) {
                        Object decision = JOptionPane.showInputDialog(null, "Tienes una: pocima-energia" + "\nQuieres usarla (Y/N)?", "Usar!", JOptionPane.WARNING_MESSAGE);
                        if (decision.toString().contains("Y")) {
                            //juego.Jugador.getAccionesPersonaje().usarObjeto(juego.Jugador, "pocima-energia");
                        } else {

                            break;
                        }
                    } else {
                        break;
                    }

                }

            } while (!juego.Jugador.getMapa().getMapa().get((juego.Jugador.getPosicion())).isEsFin() && juego.Jugador.getVida() > 0);

            // Mostramos el resultado final de la partida dependiendo de por que razon acaba el juego
            if (juego.Jugador.getEnergia() <= 0) {
                JOptionPane.showMessageDialog(null, "\nTE HAS QUEDADO SIN ENERGIA\n EL JUEGO HA TERMINADO");
            } else if (juego.Jugador.getVida() <= 0) {
                JOptionPane.showMessageDialog(null, "\nTE HAS QUEDADO SIN VIDA\n EL JUEGO HA TERMINADO");
            } else {
                JOptionPane.showMessageDialog(null, "\n" + juego.Jugador.getMapa().getMapa().get(juego.Jugador.getPosicion()).getDescripcion());
                juego.Jugador.getMapa().imprimeMapa(juego.Jugador);
                JOptionPane.showMessageDialog(null, "\nFELICIDADES HAS COMPLETADO EL JUEGO");
                System.out.println("\nTUS ESTADISTICAS: " + juego.Jugador);
                JOptionPane.showMessageDialog(null, "\nHAS DADO: " + juego.Jugador.getRecorrido().size() + " PASOS" + "\nEL RECORRIDO QUE HAS SEGUIDO ES: " + juego.Jugador.getRecorrido());
            }

        }
    }
}
