package terminalbioshock;

import MainCharacter.Personaje;
import Mapa.Mapa;
import java.awt.Point;
import static javax.swing.JOptionPane.showInputDialog;

public class PrincipalTerminalBioshock {
    
    // Te dejo un enlace a una tabla de UNICODE
    // http://unicode-table.com/en/#control-character

    public static void main(String[] args) {

        Mapa map = new Mapa(12, 12);
        map.mapaTransitable(map);
        map.getMapa().get(new Point(8, 0)).setEsInicio();
        map.getMapa().get(new Point(0, 5)).setEsFin();

        System.out.println("**********************************************");
        System.out.println("           BIENVENIDO A RAPTURE");
        System.out.println("**********************************************");

        String aux;
        aux = showInputDialog("Introduzca el nombre del personaje: ");
        Personaje personaje = new Personaje(map, aux, 5, 100);

        do {

            map.imprimeMapa(personaje);
            System.out.println("\n" + map.getMapa().get(personaje.getPosicion()).getDescripcion());
            System.out.println(personaje);
            System.out.println(personaje.MostrarAcciones());

            aux = showInputDialog("Seleccione accion (Mover, Mirar): ");
            personaje.getAccionesPersonaje().SeleccionarOpcion(aux, personaje);

        } while (!map.getMapa().get((personaje.getPosicion())).isEsFin());

        map.imprimeMapa(personaje);
        System.out.println(personaje);
        System.out.println("\nHAS COMPLETADO EL JUEGO");
        System.out.println("\nEL RECORRIDO QUE HAS SEGUIDO ES:");
        System.out.println(personaje.getRecorrido());

    }

}
