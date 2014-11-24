package MainCharacter;

import Items.Objeto;
import Mapa.Celda;
import Mapa.Mapa;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Point;
import static java.lang.Math.floor;
import java.util.ArrayList;
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
        int resta = 3;

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

                            int a = (int) floor(personaje.getMochila().getPeso() % 5);
                            personaje.setEnergia(personaje.getEnergia() - (resta + a));

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
                            int a = (int) floor(personaje.getMochila().getPeso() % 5);
                            personaje.setEnergia(personaje.getEnergia() - (resta + a));

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
                            int a = (int) floor(personaje.getMochila().getPeso() % 5);
                            personaje.setEnergia(personaje.getEnergia() - (resta + a));

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
                            int a = (int) floor(personaje.getMochila().getPeso() % 5);
                            personaje.setEnergia(personaje.getEnergia() - (resta + a));

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

    public void LeerMapa(Personaje personaje) {

        Scanner scanner = null;
        String a = "";
        Mapa mapa = new Mapa();

        String[] aux;
        String[] coordenadas = null;
        String descripcion;
        String tipo;

        try {
            scanner = new Scanner(new File("CSV/mapa.csv"));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (scanner.hasNext()) {

            String linea = scanner.nextLine();

            aux = linea.split(";");

            coordenadas = aux[0].split(",");

            tipo = aux[1];

            descripcion = aux[2];

            mapa.insertaCelda(Integer.parseInt(coordenadas[0]), Integer.parseInt(coordenadas[1]), new Celda(tipo, descripcion));
        }

        scanner.close();

        personaje.setMapa(mapa);
        personaje.getMapa().setTamaño(Integer.parseInt(coordenadas[0]) + 1, Integer.parseInt(coordenadas[1]) + 1);
        personaje.getMapa().crearMuros();

    }

    public void LeerPersonajes(String directorio) {

        Scanner scanner = null;
        String a = "";
        Mapa mapa = new Mapa();

        String[] aux;
        String[] coordenadas = null;
        String nombre;
        String tipo;
        String vida;
        String energia;
        String fuerza;
        String defensa;
        String frase;

        try {
            scanner = new Scanner(new File(directorio));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (scanner.hasNext()) {

            String linea = scanner.nextLine();

            aux = linea.split(";");

            coordenadas = aux[0].split(",");

            tipo = aux[1];

            nombre = aux[2];

            vida = aux[3];

            energia = aux[4];

            fuerza = aux[5];

            defensa = aux[6];

            frase = aux[7];

            Point punto = new Point(Integer.parseInt(coordenadas[0]), Integer.parseInt(coordenadas[1]));

            new Personaje(punto, nombre, tipo, Integer.parseInt(vida), Integer.parseInt(energia), Integer.parseInt(fuerza), Integer.parseInt(defensa), frase);

        }

        scanner.close();

    }

    public ArrayList<Objeto> LeerObjetos(String directorio) {

        ArrayList<Objeto> Objetos = new ArrayList<>();

        Scanner scanner = null;
        String a = "";
        Mapa mapa = new Mapa();

        String[] aux;
        String[] coordenadas = null;
        String nombre;
        String tipo;
        String propietario;
        String descripcion;
        String modificador;
        String efecto;
        String peso;

        try {
            scanner = new Scanner(new File(directorio));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (scanner.hasNext()) {

            String linea = scanner.nextLine();

            aux = linea.split(";");

            coordenadas = aux[0].split(",");

            propietario = aux[1];

            tipo = aux[2];

            nombre = aux[3];

            descripcion = aux[4];

            modificador = aux[5];

            efecto = aux[6];

            peso = aux[7];

            Point punto = new Point(Integer.parseInt(coordenadas[0]), Integer.parseInt(coordenadas[1]));

            Objetos.add(new Objeto(punto, propietario, tipo, nombre, descripcion, modificador, Integer.parseInt(efecto), Float.parseFloat(peso)));

        }

        scanner.close();

        return Objetos;

    }

}
