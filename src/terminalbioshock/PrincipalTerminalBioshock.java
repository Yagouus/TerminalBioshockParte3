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
        
        Personaje personaje = new Personaje();        
        
        personaje.getAccionesPersonaje().LeerMapa(personaje);
        personaje.getAccionesPersonaje().LeerPersonajes("CSV/npcs.csv");
        ArrayList<Objeto> Objetos = personaje.getAccionesPersonaje().LeerObjetos("CSV/objetos.csv");
        
        personaje.setPosicion(new Point(0,0));
  
       

        ImageIcon icon = new ImageIcon("Images/Atlas.jpg");
        ImageIcon logo = new ImageIcon("Images/Logo.png");

        // Imprime logo de Bioschock
        //JOptionPane.showMessageDialog(null, map.getNombre());
        //JOptionPane.showMessageDialog(null, map.getDescripcion());
        JOptionPane.showMessageDialog(null, "", "Welcome to Rapture", JOptionPane.INFORMATION_MESSAGE, logo);

        String aux=null;
        do{
            aux = showInputDialog("Introduzca el nombre del personaje: ");
        }while(aux.equals(""));
        
        //Personaje personaje = new Personaje(map, aux, 100, 7, 10, 7);

        //JOptionPane.showMessageDialog(null, "\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getDescripcion());
        
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
        else {/*
            JOptionPane.showMessageDialog(null, "\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getDescripcion());
            map.imprimeMapa(personaje);
            JOptionPane.showMessageDialog(null, "\nFELICIDADES HAS COMPLETADO EL JUEGO");
            System.out.println("\nTUS ESTADISTICAS: " + personaje);
            JOptionPane.showMessageDialog(null, "\nHAS DADO: " + personaje.getRecorrido().size() + " PASOS" + "\nEL RECORRIDO QUE HAS SEGUIDO ES: " + personaje.getRecorrido());
        */}

    }

}
