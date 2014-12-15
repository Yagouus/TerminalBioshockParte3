package terminalbioshock;

import CargarPartida.CargadorJuegoDeFicheros;
import CargarPartida.CargadorJuegoPorDefecto;
import Consola.ConsolaCutre;
import Consola.ConsolaExcepciones;
import Consola.ConsolaInformativa;
import Consola.ConsolaOpciones;
import Excepciones.ExcepcionAtacar;
import Excepciones.ExcepcionHablar;
import Excepciones.ExcepcionJuego;
import Excepciones.ExcepcionMirar;
import Excepciones.ExcepcionMovimiento;
import Excepciones.ExcepcionTirar;
import Excepciones.ExcepcionUsar;
import Items.Objeto;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PrincipalTerminalBioshock {

    public static void main(String[] args) throws ExcepcionJuego {

        //Ceamos instancia de juego        
        Juego juego;

        //Consolas para el juego
        ConsolaExcepciones pantalla = new ConsolaExcepciones();
        ConsolaOpciones recoger = new ConsolaOpciones();
        ConsolaInformativa informacion = new ConsolaInformativa();
        ConsolaCutre hud = new ConsolaCutre();

        //Inconos para la gui
        ImageIcon icon = new ImageIcon("Images/finn.gif");
        ImageIcon logo = new ImageIcon("Images/inicio.jpg");

        //Pantalla de bienvenida
        //JOptionPane.showMessageDialog(null, "", "Hora de aventuras", JOptionPane.INFORMATION_MESSAGE, logo);
        //Creamos personaje y asignamos atributos
        ArrayList<Objeto> objetos = new ArrayList<>();

        //OPCIONES DE JUEGO              
        String aux1 = recoger.leer("Quieres cargar una partida? (Y/N)");

        if (aux1.toString().contains("Y")) {
            String aux3 = recoger.leer("Que partida quieres cargar?");
            CargadorJuegoDeFicheros cargador = new CargadorJuegoDeFicheros(aux3);
            juego = cargador.cargarJuego();
            juego.UsarComando(juego.Comandos(aux3));

        } else {

            String aux2 = recoger.leer("Quieres cargar un Mapa (Y/N)?");
            if (aux2.toString().contains("Y")) {
                String aux4 = recoger.leer("Que mapa quieres cargar?");
                CargadorJuegoDeFicheros cargador = new CargadorJuegoDeFicheros(aux4);
                juego = cargador.cargarJuego();

            } else {

                CargadorJuegoPorDefecto cargador = new CargadorJuegoPorDefecto();
                juego = cargador.cargarJuego();

            }

            do {

                juego.MapaJuego.imprimeMapa(juego.Jugador);
                hud.imprimir(juego.Jugador.toString());

                try {
                    juego.SeleccionarOpcion(juego.Jugador);
                } catch (ExcepcionJuego ex) {
                    if (ex instanceof ExcepcionUsar) {
                        pantalla.imprimir("No puedes usar eso!");
                    } else if (ex instanceof ExcepcionMovimiento) {
                        pantalla.imprimir("No puedes ir por ahi!");
                    } else if (ex instanceof ExcepcionTirar) {
                        pantalla.imprimir("No puedes tirar eso!");
                    } else if (ex instanceof ExcepcionMirar) {
                        pantalla.imprimir("No puedes mirar eso!");
                    } else if (ex instanceof ExcepcionHablar) {
                        pantalla.imprimir("No puedes hablar, no hay nadie!");
                    } else if (ex instanceof ExcepcionAtacar) {
                        pantalla.imprimir("No puedes atacar, no hay nadie!");
                    }
                }

                if (juego.Jugador.getEnergia() <= 0) {
                    if (juego.Jugador.getMochila().contener(juego.Jugador, "pocima-energia")) {
                        String decision = recoger.leer("Tienes una: pocima-energia" + "\nQuieres usarla (Y/N)?");
                        if (decision.toString().contains("Y")) {
                            juego.SeleccionarOpcion(juego.Jugador, "Usar", "pocima-energia");
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
                informacion.imprimir("\nTE HAS QUEDADO SIN ENERGIA\n EL JUEGO HA TERMINADO");
            } else if (juego.Jugador.getVida() <= 0) {
                informacion.imprimir("\nTE HAS QUEDADO SIN VIDA\n EL JUEGO HA TERMINADO");
            } else {
                JOptionPane.showMessageDialog(null, "\n" + juego.Jugador.getMapa().getMapa().get(juego.Jugador.getPosicion()).getDescripcion());
                juego.Jugador.getMapa().imprimeMapa(juego.Jugador);
                informacion.imprimir("\nFELICIDADES HAS COMPLETADO EL JUEGO");
                informacion.imprimir("\nTUS ESTADISTICAS: " + juego.Jugador);
                informacion.imprimir("\nHAS DADO: " + juego.Jugador.getRecorrido().size() + " PASOS" + "\nEL RECORRIDO QUE HAS SEGUIDO ES: " + juego.Jugador.getRecorrido());
            }

        }
    }
}
