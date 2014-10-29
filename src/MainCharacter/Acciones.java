package MainCharacter;

import Mapa.Mapa;
import java.awt.Point;
import static javax.swing.JOptionPane.showInputDialog;

public class Acciones {

    
    public void SeleccionarOpcion(String opcion, Personaje personaje){
        
        switch(opcion){
            
            case "Mover":
                
                personaje.getAccionesPersonaje().Mover(personaje, personaje.getMapa());
                
                break;
                
            case "Mirar":
                
                break;
            
            
        }
        
    }
    
    public void Mover(Personaje personaje, Mapa mapa) {

        Point posicionPersonaje = new Point();
        int x, y;

        x = personaje.getPosicion().x;
        y = personaje.getPosicion().y;

        String aux;

        System.out.println("\nMovimientos disponibles:");

        // Norte
        posicionPersonaje.x = x - 1;
        posicionPersonaje.y = y;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                System.out.println("Norte");
            }
        }

        // Sur
        posicionPersonaje.x = x + 1;
        posicionPersonaje.y = y;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                System.out.println("Sur");
            }
        }

        // Este
        posicionPersonaje.x = x;
        posicionPersonaje.y = y + 1;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                System.out.println("Este");
            }
        }

        // Oeste
        posicionPersonaje.x = x;
        posicionPersonaje.y = y - 1;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                System.out.println("Oeste");
            }
        }

        aux = showInputDialog("A donde quiere moverse? ");

        switch (aux) {

            case "n":
            case "N":

                posicionPersonaje.x = x - 1;
                posicionPersonaje.y = y;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        personaje.setPosicion(posicionPersonaje);
                        personaje.getRecorrido().add("Norte");
                        personaje.setEnergia(-3);

                    }
                }
                break;
            
            case "s":    
            case "S":

                posicionPersonaje.x = x + 1;
                posicionPersonaje.y = y;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        personaje.setPosicion(posicionPersonaje);
                        personaje.getRecorrido().add("Sur");
                        personaje.setEnergia(-3);

                    }
                }
                break;
                
            case "e":   
            case "E":

                posicionPersonaje.x = x;
                posicionPersonaje.y = y + 1;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        personaje.setPosicion(posicionPersonaje);
                        personaje.getRecorrido().add("Este");
                        personaje.setEnergia(-3);

                    }
                }
                break;

            case "o":
            case "O":

                posicionPersonaje.x = x;
                posicionPersonaje.y = y - 1;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        personaje.setPosicion(posicionPersonaje);
                        personaje.getRecorrido().add("Oeste");
                        personaje.setEnergia(-3);

                    }
                }
                break;

        }

    }

    public void Mirar() {

    }

}
