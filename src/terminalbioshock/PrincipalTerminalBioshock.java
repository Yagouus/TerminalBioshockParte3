
package terminalbioshock;

import MainCharacter.Personaje;
import Mapa.Mapa;
import java.awt.Point;
import static javax.swing.JOptionPane.showInputDialog;

public class PrincipalTerminalBioshock {

    public static void main(String[] args) {
        
        Mapa map = new Mapa(12,12); 
        map.mapaTransitable(map);
        map.getMapa().get(new Point(8,0)).setEsInicio();
        map.getMapa().get(new Point(0,5)).setEsFin();
        
        System.out.println("**********************************************");
        System.out.println("           BIENVENIDO A RAPTURE");
        System.out.println("**********************************************");
        
        String aux;       
        aux = showInputDialog("Introduzca el nombre del personaje: ");        
        Personaje personaje = new Personaje(map, aux , 100, 100);  
        
       do{ 
           
        map.imprimeMapa(personaje);
            
        aux = showInputDialog("Seleccione accion (Mover, Mirar): ");                      
        personaje.getAccionesPersonaje().SeleccionarOpcion(aux, personaje);
                     
        
        
       }while(!map.getMapa().get((personaje.getPosicion())).isEsFin());
       
       map.imprimeMapa(personaje);
       System.out.println("\nHAS COMPLETADO EL JUEGO");       
       System.out.println("\nEL RECORRIDO QUE HAS SEGUIDO ES:");
       System.out.println(personaje.getRecorrido());
        
    }
      
}