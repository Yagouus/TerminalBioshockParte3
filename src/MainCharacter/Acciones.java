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

    //Seleccionar accion
    public void SeleccionarOpcion(Personaje personaje) {

        Object aux1;
        String aux = null;
        ImageIcon icon = new ImageIcon("Images/finn.gif");

        do {

            aux1 = JOptionPane.showInputDialog(null, "Mover, Mirar, Coger, Usar, Tirar, \nOjear, Ayuda, Salir", "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);

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

            case "Coger":
            case "coger":

                Object aux2;

                String objects = personaje.getAccionesPersonaje().verObjetos(personaje);
                aux2 = JOptionPane.showInputDialog(null, objects, "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                personaje.getAccionesPersonaje().cogerObjeto(personaje, aux2.toString());

                break;

            case "Tirar":
            case "tirar":

                Object aux3;

                aux3 = JOptionPane.showInputDialog(null, personaje.getMochila().getContenido().toString(), "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                personaje.getAccionesPersonaje().dejarObjeto(personaje, aux3.toString());

                break;

            case "Usar":
            case "usar":
                Object aux6;

                aux6 = JOptionPane.showInputDialog(null, personaje.getMochila().getConenidoUsable().toString(), "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                personaje.getAccionesPersonaje().usarObjeto(personaje, aux6.toString());

                break;

            case "Mirar Objeto":
            case "mirar objeto":
                Object aux4;

                String objects2 = personaje.getAccionesPersonaje().verObjetos(personaje);
                aux4 = JOptionPane.showInputDialog(null, objects2, "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                personaje.getAccionesPersonaje().mirarObjeto(personaje, aux4.toString());

                break;

            case "Hablar":
            case "hablar":
                Object aux5;
                aux5 = JOptionPane.showInputDialog(null, personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().toString(), "Con quien quieres hablar?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                personaje.getAccionesPersonaje().hablar(personaje, aux5.toString());

                break;

            case "Ojear":
            case "ojear":

                personaje.getAccionesPersonaje().ojearInventario(personaje);

                break;

            case "Ayuda":
            case "ayuda":

                JOptionPane.showMessageDialog(null, "Mover: moverte por el mapa \nMirar: Ver objetos y personajes de la celda  \nCoger: Coger objetos  \nUsar: usar objetos \nTirar: tirar objeto  \nOjear: ver contenido mochila \nAyuda: inception \nSalir: salir del juego", "Welcome to Rapture", JOptionPane.INFORMATION_MESSAGE);

                break;

            case "Atacar":
            case "atacar":

                Object aux7;
                aux7 = JOptionPane.showInputDialog(null, personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().toString(), "Con quien quieres hablar?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                personaje.getAccionesPersonaje().atacar(personaje, aux7.toString());

                break;

        }

    }

    //Acciones posibles
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

                            int a = (int) (personaje.getMochila().getPeso() % 5);
                            personaje.setEnergia(personaje.getEnergia() - (resta + a));
                            personaje.getAccionesPersonaje().ataqueAutomatico(personaje);

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
                            int a = (int) (personaje.getMochila().getPeso() % 5);
                            personaje.setEnergia(personaje.getEnergia() - (resta + a));
                            personaje.getAccionesPersonaje().ataqueAutomatico(personaje);

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
                            int a = (int) (personaje.getMochila().getPeso() % 5);
                            personaje.setEnergia(personaje.getEnergia() - (resta + a));
                            personaje.getAccionesPersonaje().ataqueAutomatico(personaje);

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
                            int a = (int) (personaje.getMochila().getPeso() % 5);
                            personaje.setEnergia(personaje.getEnergia() - (resta + a));
                            personaje.getAccionesPersonaje().ataqueAutomatico(personaje);

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

        if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getDescripcion() != null) {
            JOptionPane.showMessageDialog(null, "\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getDescripcion());
        }

        if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().size() != 0) {
            JOptionPane.showMessageDialog(null, "Encuentras:\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems());
        } else {
            JOptionPane.showMessageDialog(null, "No has encontrado nada...");

        }

        if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().size() != 0) {
            JOptionPane.showMessageDialog(null, "Te encuentras:\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().toString());
        } else {
            JOptionPane.showMessageDialog(null, "No te has encontrado con nadie...");
        }
    }

    public String verObjetos(Personaje personaje) {

        if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().size() != 0) {
            return personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().toString();
        } else {
            return "No has encontrado nada...";

        }

    }

    public void mirarObjeto(Personaje personaje, String objeto) {

        for (int i = 0; i < personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().size(); i++) {

            if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().get(i).getNombre().equals(objeto)) {

                JOptionPane.showMessageDialog(null, "Descripcion:\n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().get(i).getDescripcion());
            }

        }
    }

    public void cogerObjeto(Personaje personaje, String objeto) {

        for (int i = 0; i < personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().size(); i++) {

            if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().get(i).getNombre().equals(objeto)) {
                if (personaje.getFuerza() > 10 && personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().get(i).getTipo().equals("arma")) {
                    JOptionPane.showMessageDialog(null, "No puedes llevar mas de un arma", "NO!", JOptionPane.ERROR_MESSAGE);
                } else {

                    personaje.anadirMochila(personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().get(i));

                    if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().get(i).getModificador().equals("fuerza")) {
                        personaje.setFuerza(personaje.getFuerza() + personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().get(i).getEfecto());
                    } else if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().get(i).getModificador().equals("defensa")) {
                        personaje.setDefensa(personaje.getDefensa() + personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().get(i).getEfecto());
                    }

                    personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().remove(personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().get(i));
                }
            }

        }

    }

    public void dejarObjeto(Personaje personaje, String objeto) {

        for (int i = 0; i < personaje.getMochila().getContenido().size(); i++) {

            if (personaje.getMochila().getContenido().get(i).getNombre().equals(objeto)) {

                if (personaje.getMochila().getContenido().get(i).getModificador().equals("fuerza")) {
                    personaje.setFuerza(personaje.getFuerza() - personaje.getMochila().getContenido().get(i).getEfecto());
                } else if (personaje.getMochila().getContenido().get(i).getModificador().equals("defensa")) {
                    personaje.setDefensa(personaje.getDefensa() - personaje.getMochila().getContenido().get(i).getEfecto());
                }

                personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().add(personaje.getMochila().getContenido().get(i));
                personaje.getMochila().getContenido().remove(personaje.getMochila().getContenido().get(i));

            }

        }

    }

    public void RestarVida(Personaje personaje) {
    }

    public void RestarEnergia(Personaje personaje, int resta) {

        personaje.setEnergia(personaje.getEnergia() - resta);

    }

    public void ojearInventario(Personaje personaje) {

        if (!personaje.getMochila().getContenido().isEmpty()) {
            JOptionPane.showMessageDialog(null, personaje.getMochila().getContenido().toString() + "\nPeso: " + personaje.getMochila().getPeso(), "Mochila", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Tu mochila esta vacia", "Mochila", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void hablar(Personaje personaje, String nombre) {

        for (int i = 0; i < personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().size(); i++) {

            if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getNombre().equals(nombre)) {

                JOptionPane.showMessageDialog(null, personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getNombre() + " dice: \n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getFrase());
            }

        }

    }

    public void usarObjeto(Personaje personaje, String objeto) {

        for (int i = 0; i < personaje.getMochila().getConenidoUsable().size(); i++) {

            if (personaje.getMochila().getConenidoUsable().get(i).getModificador().equals("salud")) {

                personaje.setVida(personaje.getVida() + personaje.getMochila().getConenidoUsable().get(i).getEfecto());

            } else if (personaje.getMochila().getConenidoUsable().get(i).getModificador().equals("energia")) {

                personaje.setEnergia(personaje.getEnergia() + personaje.getMochila().getConenidoUsable().get(i).getEfecto());

            }

        }

    }

    public void atacar(Personaje personaje, String nombre) {

        for (int i = 0; i < personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().size(); i++) {
            if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getTipo().equals("enemigoactivo") || personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getTipo().equals("enemigopasivo")) {

                personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).setVida(personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getVida() - (personaje.getFuerza() * 10 - personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getDefensa()));

                personaje.setVida(personaje.getVida() - (personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getFuerza() / 2) - personaje.getDefensa());

                JOptionPane.showMessageDialog(null, "Te han atacado!", "NO!", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public void ataqueAutomatico(Personaje personaje) {

        for (int i = 0; i < personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().size(); i++) {

            if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getTipo().equals("enemigoactivo")) {

                personaje.setVida(personaje.getVida() - (personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getFuerza() / 2) - personaje.getDefensa());

                JOptionPane.showMessageDialog(null, "Te han atacado!", "NO!", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    //Carga de datos
    public void cargar(String directorio, Personaje personaje) {

        personaje.setMapa(LeerMapa(directorio));
        personaje.getMapa().setTamaño(10, 10);
        personaje.getMapa().crearMuros();
        personaje.getMapa().setInicio();
        personaje.getMapa().setFin();
        ArrayList<Objeto> objetos = LeerObjetos(directorio);
        personaje.getMapa().colocaObjetos(objetos);
        personaje.getMapa().colocaPersonajes(personaje.getAccionesPersonaje().LeerPersonajes(directorio), personaje);

    }

    public Mapa LeerMapa(String directorio) {

        Scanner scanner = null;
        String a = "";
        a = directorio;
        a += "/mapa.csv";
        Mapa mapa = new Mapa();

        String[] aux;
        String[] coordenadas = null;
        String descripcion;
        String tipo;

        try {
            scanner = new Scanner(new File(a));

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

        return mapa;

    }

    public ArrayList<Personaje> LeerPersonajes(String directorio) {

        Scanner scanner = null;
        String a = "";
        a = directorio;
        a += "/npcs.csv";

        String[] aux;
        String[] coordenadas = null;
        String nombre;
        String tipo;
        String vida;
        String energia;
        String fuerza;
        String defensa;
        String frase;

        ArrayList<Personaje> personajes = new ArrayList<>();

        try {
            scanner = new Scanner(new File(a));

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

            personajes.add(new Personaje(punto, nombre, tipo, Integer.parseInt(vida), Integer.parseInt(energia), Integer.parseInt(fuerza), Integer.parseInt(defensa), frase));

        }

        scanner.close();

        return personajes;

    }

    public ArrayList<Objeto> LeerObjetos(String directorio) {

        ArrayList<Objeto> Objetos = new ArrayList<>();

        Scanner scanner = null;
        String a = "";
        a = directorio;
        a += "/objetos.csv";
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
            scanner = new Scanner(new File(a));

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
