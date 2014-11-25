package terminalbioshock;

import Items.Objeto;
import MainCharacter.Personaje;
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
        ImageIcon logo = new ImageIcon("Images/Logo.png");
  
        JOptionPane.showMessageDialog(null, "", "Welcome to Rapture", JOptionPane.INFORMATION_MESSAGE, logo);
        
        //Creamos personaje y asignamos atributos
        Personaje personaje = new Personaje();      
        
        ArrayList<Objeto> objetos = new ArrayList<>();
        
        personaje.getAccionesPersonaje().cargar("CSV", personaje);        
        personaje.setPosicion(personaje.getMapa().getInicio());

        
        // Bucle de Juego
        do {
  
            personaje.getMapa().imprimeMapa(personaje);
            System.out.println(personaje);
         
            personaje.getAccionesPersonaje().SeleccionarOpcion(personaje);
 
            if( personaje.getEnergia() <=0){
                //tomar poti se ten
                break;
            }
            
        } while (!personaje.getMapa().getMapa().get((personaje.getPosicion())).isEsFin() && personaje.getVida() > 0);

        // Mostramos el resultado final de la partida dependiendo de por que razon acaba el juego
        if (personaje.getEnergia() <= 0) {
            JOptionPane.showMessageDialog(null, "\nTE HAS QUEDADO SIN ENERGIA\n EL JUEGO HA TERMINADO");
        }else if(personaje.getVida() <=0){
            JOptionPane.showMessageDialog(null, "\nTE HAS QUEDADO SIN VIDA\n EL JUEGO HA TERMINADO");
        } 
        else {
            JOptionPane.showMessageDialog(null, "\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getDescripcion());
            personaje.getMapa().imprimeMapa(personaje);
            JOptionPane.showMessageDialog(null, "\nFELICIDADES HAS COMPLETADO EL JUEGO");
            System.out.println("\nTUS ESTADISTICAS: " + personaje);
            JOptionPane.showMessageDialog(null, "\nHAS DADO: " + personaje.getRecorrido().size() + " PASOS" + "\nEL RECORRIDO QUE HAS SEGUIDO ES: " + personaje.getRecorrido());
        }

    }

}
