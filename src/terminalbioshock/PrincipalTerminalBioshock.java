package terminalbioshock;

import MainCharacter.Personaje;
import Mapa.Mapa;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

public class PrincipalTerminalBioshock {
    
    // Te dejo un enlace a una tabla de UNICODE
    // http://unicode-table.com/en/#control-character

    public static void main(String[] args) {

        Mapa map = new Mapa(11, 11);
        map.mapaTransitable(map);
        map.getMapa().get(new Point(8, 0)).setEsInicio();
        map.getMapa().get(new Point(0, 5)).setEsFin();
        
        ImageIcon icon = new ImageIcon("Images/Atlas.jpg");
        ImageIcon logo = new ImageIcon("Images/Logo.png");

        // Imprime logo de Bioschock
        JOptionPane.showMessageDialog(null, "", "Welcome to Rapture", JOptionPane.INFORMATION_MESSAGE, logo);
      

        String aux;
        Object aux1;
        aux = showInputDialog("Introduzca el nombre del personaje: ");
        Personaje personaje = new Personaje(map, aux, 5, 100);

        do {
            
            map.imprimeMapa(personaje);
            
            if(map.getMapa().get(personaje.getPosicion()).getDescripcion() != null){
            JOptionPane.showMessageDialog(null, "\n" + map.getMapa().get(personaje.getPosicion()).getDescripcion());
            }
            System.out.println(personaje);
            System.out.println(personaje.MostrarAcciones()); 
                        
            personaje.getAccionesPersonaje().SeleccionarOpcion(personaje);

        } while (!map.getMapa().get((personaje.getPosicion())).isEsFin() && personaje.getEnergia() != 0);

        // Mostramos el resultado final de la partida dependiendo de por que razon acaba el juego
        
        if(personaje.getEnergia() == 0){
            
            
            
        }else{
        map.imprimeMapa(personaje);
        System.out.println(personaje);
        JOptionPane.showMessageDialog(null, "\nHAS COMPLETADO EL JUEGO");
        }
        System.out.println("\nEL RECORRIDO QUE HAS SEGUIDO ES:");
        System.out.println(personaje.getRecorrido());

    }

}
