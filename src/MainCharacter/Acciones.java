package MainCharacter;

import Mapa.Mapa;
import java.awt.Point;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

public class Acciones {

    
    public void SeleccionarOpcion(String opcion, Personaje personaje){
        
        switch(opcion){
            
            case "Mover":
            case "mover":
                
                personaje.getAccionesPersonaje().Mover(personaje, personaje.getMapa());
                
                break;
                
            case "Mirar":
            case "mirar":
                
                break;
            
            
        }
        
    }
    
    public void Mover(Personaje personaje, Mapa mapa) {
        
        String Mensaje = "";

        Point posicionPersonaje = new Point();
        int x, y;

        x = personaje.getPosicion().x;
        y = personaje.getPosicion().y;

        String aux;

        Mensaje += ("\nMovimientos disponibles:");

        // Norte
        posicionPersonaje.x = x - 1;
        posicionPersonaje.y = y;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                Mensaje +=(" Norte");
            }
        }

        // Sur
        posicionPersonaje.x = x + 1;
        posicionPersonaje.y = y;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                Mensaje +=(" Sur");
            }
        }

        // Este
        posicionPersonaje.x = x;
        posicionPersonaje.y = y + 1;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
               Mensaje +=(" Este");
            }
        }

        // Oeste
        posicionPersonaje.x = x;
        posicionPersonaje.y = y - 1;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                Mensaje +=(" Oeste");
            }
        }

        
        
        boolean repetir;

        Mensaje += "\nElige una direccion chico, ¿quieres? ";    
        
        do{
            
            aux = showInputDialog(Mensaje);
            repetir = false;
        
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

                    }else{
                        repetir = true;
                        JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
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

                    }else{
                        repetir = true;
                       JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
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

                    }else{
                        repetir = true;
                        JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
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

                    }else{
                        repetir = true;
                        JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

        }
        
        }while(repetir);

    }

    public void Mirar() {

    }

}
