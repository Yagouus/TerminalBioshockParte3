package terminalbioshock;

import MainCharacter.Personaje;
import Mapa.Mapa;
import java.awt.Point;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

public class PrincipalTerminalBioshock {

    public static void main(String[] args) {
        
      
        Mapa map = new Mapa(11, 11);
        map.setNombre("Terminal Bioshock (parte 1)");
        map.setDescripcion("Rapture, Ciudad Submarina");
        map.mapaTransitable(map);
        map.getMapa().get(new Point(8, 0)).setEsInicio();
        map.getMapa().get(new Point(0, 5)).setEsFin();

        ImageIcon icon = new ImageIcon("Images/Atlas.jpg");
        ImageIcon logo = new ImageIcon("Images/Logo.png");

        // Imprime logo de Bioschock
        JOptionPane.showMessageDialog(null, map.getNombre());
        JOptionPane.showMessageDialog(null, map.getDescripcion());
        JOptionPane.showMessageDialog(null, "", "Welcome to Rapture", JOptionPane.INFORMATION_MESSAGE, logo);

        String aux=null;
        do{
            aux = showInputDialog("Introduzca el nombre del personaje: ");
        }while(aux.equals(""));
        
        Personaje personaje = new Personaje(map, aux, 5, 100);

        JOptionPane.showMessageDialog(null, "\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getDescripcion());
        
        // Bucle de Juego
        do {

            map.imprimeMapa(personaje);
            System.out.println(personaje);
         
            personaje.getAccionesPersonaje().SeleccionarOpcion(personaje);

        } while (!map.getMapa().get((personaje.getPosicion())).isEsFin() && personaje.getEnergia() > 0);

        // Mostramos el resultado final de la partida dependiendo de por que razon acaba el juego
        if (personaje.getEnergia() <= 0) {
            JOptionPane.showMessageDialog(null, "\nTE HAS QUEDADO SIN ENERGIA\n EL JUEGO HA TERMINADO");
        } else {
            JOptionPane.showMessageDialog(null, "\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getDescripcion());
            map.imprimeMapa(personaje);
            JOptionPane.showMessageDialog(null, "\nFELICIDADES HAS COMPLETADO EL JUEGO");
            System.out.println("\nTUS ESTADISTICAS: " + personaje);
            JOptionPane.showMessageDialog(null, "\nHAS DADO: " + personaje.getRecorrido().size() + " PASOS" + "\nEL RECORRIDO QUE HAS SEGUIDO ES: " + personaje.getRecorrido());
        }

    }

}
