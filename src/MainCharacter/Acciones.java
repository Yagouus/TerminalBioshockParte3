package MainCharacter;

import Mapa.Mapa;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

public class Acciones {

    public void SeleccionarOpcion(Personaje personaje) {

        Object aux1;
        String aux = null;
        ImageIcon icon = new ImageIcon("Images/Atlas.jpg");

        do {

            aux1 = JOptionPane.showInputDialog(null, "Mover, Mirar, Salir", "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);

        } while (aux1 == null);

        if (aux1.equals("Salir") || aux1.equals("salir")) {
            System.exit(0);
        }

        aux = aux1.toString();

        switch (aux) {

            case "Mover":
            case "mover":

                personaje.getAccionesPersonaje().Mover(personaje, personaje.getMapa());

                break;

            case "Mirar":
            case "mirar":

                personaje.getAccionesPersonaje().Mirar(personaje);

                break;

        }

    }

    public void Mover(Personaje personaje, Mapa mapa) {

        String Mensaje = "";

        Point posicionPersonaje = new Point();
        int x, y;

        x = personaje.getPosicion().x;
        y = personaje.getPosicion().y;

        String aux = null;

        Mensaje += ("\nMovimientos disponibles:");

        // Norte
        posicionPersonaje.x = x - 1;
        posicionPersonaje.y = y;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                Mensaje += (" Norte(N)");
            }
        }

        // Sur
        posicionPersonaje.x = x + 1;
        posicionPersonaje.y = y;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                Mensaje += (" Sur(S)");
            }
        }

        // Este
        posicionPersonaje.x = x;
        posicionPersonaje.y = y + 1;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                Mensaje += (" Este(E)");
            }
        }

        // Oeste
        posicionPersonaje.x = x;
        posicionPersonaje.y = y - 1;

        if (mapa.getMapa().get(posicionPersonaje) != null) {
            if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                Mensaje += (" Oeste(O)");
            }
        }

        boolean repetir;

        do {
            do {
                aux = showInputDialog(null, Mensaje, "Elige una direccion chico, ¿quieres?", JOptionPane.QUESTION_MESSAGE);
            } while (aux == null);
            repetir = false;

            switch (aux) {

                case "n":
                case "N":

                    posicionPersonaje.x = x - 1;
                    posicionPersonaje.y = y;

                    if (mapa.getMapa().get(posicionPersonaje) != null) {
                        if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                            personaje.setMovimientos(personaje.getPosicion());
                            personaje.setPosicion(posicionPersonaje);
                            personaje.setRecorrido("Norte");
                            personaje.setEnergia(personaje.getEnergia() - 3);
                            if (personaje.getMochila().getPeso() >= 5) {
                                int life = personaje.getMochila().getPeso() / 5;
                                personaje.setEnergia(personaje.getEnergia() - life);
                            }

                        } else {
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
                            personaje.setMovimientos(personaje.getPosicion());
                            personaje.setPosicion(posicionPersonaje);
                            personaje.setRecorrido("Sur");
                            personaje.setEnergia(personaje.getEnergia() - 3);
                            if (personaje.getMochila().getPeso() >= 5) {
                                int life = personaje.getMochila().getPeso() / 5;
                                personaje.setEnergia(personaje.getEnergia() - life);
                            }

                        } else {
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
                            personaje.setMovimientos(personaje.getPosicion());
                            personaje.setPosicion(posicionPersonaje);
                            personaje.setRecorrido("Este");
                            personaje.setEnergia(personaje.getEnergia() - 3);
                            if (personaje.getMochila().getPeso() >= 5) {
                                int life = personaje.getMochila().getPeso() / 5;
                                personaje.setEnergia(personaje.getEnergia() - life);
                            }

                        } else {
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
                            personaje.setMovimientos(personaje.getPosicion());
                            personaje.setPosicion(posicionPersonaje);
                            personaje.setRecorrido("Oeste");
                            personaje.setEnergia(personaje.getEnergia() - 3);
                            if (personaje.getMochila().getPeso() >= 5) {
                                int life = personaje.getMochila().getPeso() / 5;
                                personaje.setEnergia(personaje.getEnergia() - life);
                            }

                        } else {
                            repetir = true;
                            JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

            }

        } while (repetir);

    }

    public void Mirar(Personaje personaje) {

        if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getDescripcion() != null && !personaje.getMovimientos().contains(personaje.getPosicion())) {
            JOptionPane.showMessageDialog(null, "\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getDescripcion());
        }

        if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().size() != 0) {
            JOptionPane.showMessageDialog(null, "Encuentras:\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems());
        } else {
            JOptionPane.showMessageDialog(null, "No has encontrado nada...");

        }
    }

    public void RestarVida(Personaje personaje) {
    }

    public void RestarEnergia(Personaje personaje, int resta) {

        personaje.setEnergia(personaje.getEnergia() - resta);

    }

    public void LeerMapa() {

        Scanner scanner = null;
        String a = "";
        try {
            scanner = new Scanner(new File("CSV/mapa.csv"));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        while (scanner.hasNext()) {
            
            String linea = scanner.nextLine();
            String[] aux;
            String[] coordenadas;
            String descripcion;
            String tipo;
            
            aux = linea.split(";");    
            
            coordenadas = aux[0].split(",");
            
            tipo = aux[1];
            
            descripcion = aux[2];
            
            
            
           
            
            
            
            for(int i = 0; i < aux.length; i++){
                a += "\n" + aux[i];
            }
            

        }
        System.out.println(a);
        scanner.close();
    }

}
