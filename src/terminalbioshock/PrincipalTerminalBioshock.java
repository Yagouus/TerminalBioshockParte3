
package terminalbioshock;

import MainCharacter.Personaje;
import Mapa.Mapa;
import java.awt.Point;

public class PrincipalTerminalBioshock {

    public static void main(String[] args) {
        
        Mapa map = new Mapa(12,12); 
        
        map.getMapa().get(new Point(8,0)).setEsInicio();
        
        Personaje personaje = new Personaje(map, "Juan", 100, 100);      
               
        map.mapaTransitable(map);       
        
        map.imprimeMapa(personaje);
        
        
    }
      
}