package terminalbioshock;

import Comandos.ComandoCoger;
import Comandos.ComandoMirarObjeto;
import Comandos.ComandoMover;
import Comandos.ComandoTirar;
import Comandos.ComandoUsar;
import Excepciones.ExcepcionJuego;
import Excepciones.ExcepcionTirar;
import Excepciones.ExcepcionUsar;
import Items.Objeto;
import Items.objetoarma;
import Items.objetodefensivo;
import Items.objetomapa;
import Items.pocimaenergia;
import Items.pocimasalud;
import Items.pocimaveneno;
import Mapa.Celda;
import Mapa.Mapa;
import Personajes.Amigo;
import Personajes.EnemigoActivo;
import Personajes.EnemigoPasivo;
import Personajes.Guerrero;
import Personajes.Jugador;
import Personajes.Mago;
import Personajes.Personaje;
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

public class Juego {

    Mapa MapaJuego = new Mapa();
    Jugador Jugador;

    //Getters
    public Mapa getMapaJuego() {
        return MapaJuego;
    }

    public Personaje getJugador() {
        return Jugador;
    }

    //Seleccionar accion
    public void SeleccionarOpcion(Personaje personaje) throws ExcepcionJuego {

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

                Object direccion;
                direccion = JOptionPane.showInputDialog(null, "A donde quieres ir?", "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                ComandoMover comando = new ComandoMover(Jugador, direccion.toString());
                comando.ejecutar();
                this.ataqueAutomatico();
                break;

            case "Mirar":
            case "mirar":

                personaje.Mirar();
                this.ataqueAutomatico();
                break;

            case "Coger":
            case "coger":

                Object objeto;
                String objects = personaje.getAccionesPersonaje().verObjetos(personaje);
                objeto = JOptionPane.showInputDialog(null, objects, "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                ComandoCoger comando2 = new ComandoCoger(Jugador, objeto.toString());
                comando2.ejecutar();

                this.ataqueAutomatico();
                break;

            case "Tirar":
            case "tirar":

                Object aux3;
                aux3 = JOptionPane.showInputDialog(null, personaje.getMochila().getContenido().toString(), "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                ComandoTirar comando3 = new ComandoTirar(Jugador, aux3.toString());
                comando3.ejecutar();
                this.ataqueAutomatico();
                break;

            case "Usar":
            case "usar":

                Object aux6;
                aux6 = JOptionPane.showInputDialog(null, personaje.getMochila().getConenidoUsable().toString(), "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                ComandoUsar comando4 = new ComandoUsar(Jugador, aux6.toString());
                comando4.ejecutar();
                this.ataqueAutomatico();
                break;

            case "Mirar Objeto":
            case "mirar objeto":

                Object aux4;
                aux4 = JOptionPane.showInputDialog(null, personaje.getMochila().getConenidoUsable().toString(), "Elige una opcion chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                ComandoMirarObjeto comando5 = new ComandoMirarObjeto(Jugador, aux4.toString());
                comando5.ejecutar();
                this.ataqueAutomatico();
                break;

            case "Hablar":
            case "hablar":

                Object aux5;
                aux5 = JOptionPane.showInputDialog(null, personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().toString(), "Con quien quieres hablar?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                personaje.getAccionesPersonaje().hablar(personaje, aux5.toString());
                this.ataqueAutomatico();
                break;

            case "Inventario":
            case "inventario":

                personaje.ojearInventario();
                this.ataqueAutomatico();
                break;

            case "Ayuda":
            case "ayuda":

                JOptionPane.showMessageDialog(null, "Mover: moverte por el mapa \nMirar: Ver objetos y personajes de la celda  \nCoger: Coger objetos  \nUsar: usar objetos \nTirar: tirar objeto  \nOjear: ver contenido mochila \nAyuda: inception \nSalir: salir del juego", "Welcome to Rapture", JOptionPane.INFORMATION_MESSAGE);
                this.ataqueAutomatico();
                break;

            case "Atacar":
            case "atacar":

                int index = 0;
                Personaje enemigo = new Personaje();

                Object aux7;
                aux7 = JOptionPane.showInputDialog(null, personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().toString(), "Con quien quieres hablar?:", JOptionPane.QUESTION_MESSAGE, icon, null, null);
                do {

                    enemigo = personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(index);

                } while (personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(index).getNombre().equals(aux7));

                personaje.atacar(enemigo);
                this.ataqueAutomatico();
                break;

        }

    }

    public void SeleccionarOpcion(Personaje personaje, String opcion, String movbjeto) throws ExcepcionJuego {

        ImageIcon icon = new ImageIcon("Images/finn.gif");

        switch (opcion) {

            case "Mover":
            case "mover":

                Jugador.Mover(movbjeto);
                this.ataqueAutomatico();
                break;

            case "Mirar":
            case "mirar":

                if (!movbjeto.equals("")) {
                    ComandoMirarObjeto comando5 = new ComandoMirarObjeto(Jugador, movbjeto);
                    comando5.ejecutar();
                    this.ataqueAutomatico();

                } else {

                    personaje.Mirar();
                    this.ataqueAutomatico();
                }

                break;

            case "Coger":
            case "coger":

                personaje.Coger(movbjeto);
                this.ataqueAutomatico();
                break;

            case "Tirar":
            case "tirar":

                for (int i = 0; i < personaje.getMochila().getContenido().size(); i++) {
                    if (personaje.getMochila().getContenido().get(i).getNombre().equals(movbjeto)) {
                        try {
                            personaje.Tirar(personaje.getMochila().getContenido().get(i));
                        } catch (ExcepcionTirar j) {
                            throw new ExcepcionTirar();
                        }
                    }
                }

                this.ataqueAutomatico();
                break;

            case "Usar":
            case "usar":

                this.ataqueAutomatico();
                break;

            case "Hablar":
            case "hablar":

                personaje.getAccionesPersonaje().hablar(personaje, movbjeto);
                this.ataqueAutomatico();
                break;

            case "Inventario":
            case "inventario":

                personaje.ojearInventario();
                this.ataqueAutomatico();
                break;

            case "Ayuda":
            case "ayuda":

                JOptionPane.showMessageDialog(null, "Mover: moverte por el mapa \nMirar: Ver objetos y personajes de la celda  \nCoger: Coger objetos  \nUsar: usar objetos \nTirar: tirar objeto  \nOjear: ver contenido mochila \nAyuda: inception \nSalir: salir del juego", "Welcome to Rapture", JOptionPane.INFORMATION_MESSAGE);
                this.ataqueAutomatico();
                break;

            case "Atacar":
            case "atacar":

                //personaje.atacar(movbjeto);
                ataqueAutomatico();
                break;

        }

    }

    //Acciones posibles
    public void Mover(Personaje personaje, Mapa mapa, String direccion) {

        String Mensaje = "";
        int resta = 3;

        Point posicionPersonaje = new Point();
        int x, y;

        x = personaje.getPosicion().x;
        y = personaje.getPosicion().y;

        boolean repetir;

        switch (direccion) {

            case "norte":
            case "Norte":

                posicionPersonaje.x = x - 1;
                posicionPersonaje.y = y;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        personaje.setMovimientos(personaje.getPosicion());
                        personaje.setPosicion(posicionPersonaje);
                        personaje.setRecorrido("Norte");

                        int a = (int) (personaje.getMochila().getPeso() % 5);
                        personaje.setEnergia(personaje.getEnergia() - (resta + a));

                    } else {
                        repetir = true;
                        JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

            case "sur":
            case "Sur":

                posicionPersonaje.x = x + 1;
                posicionPersonaje.y = y;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        personaje.setMovimientos(personaje.getPosicion());
                        personaje.setPosicion(posicionPersonaje);
                        personaje.setRecorrido("Sur");
                        int a = (int) (personaje.getMochila().getPeso() % 5);
                        personaje.setEnergia(personaje.getEnergia() - (resta + a));

                    } else {
                        repetir = true;
                        JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

            case "este":
            case "Este":

                posicionPersonaje.x = x;
                posicionPersonaje.y = y + 1;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        personaje.setMovimientos(personaje.getPosicion());
                        personaje.setPosicion(posicionPersonaje);
                        personaje.setRecorrido("Este");
                        int a = (int) (personaje.getMochila().getPeso() % 5);
                        personaje.setEnergia(personaje.getEnergia() - (resta + a));

                    } else {
                        repetir = true;
                        JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

            case "oeste":
            case "Oeste":

                posicionPersonaje.x = x;
                posicionPersonaje.y = y - 1;

                if (mapa.getMapa().get(posicionPersonaje) != null) {
                    if (mapa.getMapa().get(posicionPersonaje).isTransitable()) {
                        personaje.setMovimientos(personaje.getPosicion());
                        personaje.setPosicion(posicionPersonaje);
                        personaje.setRecorrido("Oeste");
                        int a = (int) (personaje.getMochila().getPeso() % 5);
                        personaje.setEnergia(personaje.getEnergia() - (resta + a));

                    } else {
                        repetir = true;
                        JOptionPane.showMessageDialog(null, "No puedes ir por ahi chico", "NO!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

        }

    }

    public String verObjetos(Personaje personaje) {

        if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().size() != 0) {
            return personaje.getMapa().getMapa().get(personaje.getPosicion()).getItems().toString();
        } else {
            return "No has encontrado nada...";

        }

    }

    public void RestarVida(Personaje personaje) {
    }

    public void RestarEnergia(Personaje personaje, int resta) {

        personaje.setEnergia(personaje.getEnergia() - resta);

    }

    public void hablar(Personaje personaje, String nombre) {

        for (int i = 0; i < personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().size(); i++) {

            if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getNombre().equals(nombre)) {

                JOptionPane.showMessageDialog(null, personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getNombre() + " dice: \n" + personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getFrase());
            }

        }

    }

    public void ataqueAutomatico() {

        for (int i = 0; i < MapaJuego.getMapa().get(Jugador.getPosicion()).getNPCS().size(); i++) {

            if (MapaJuego.getMapa().get(Jugador.getPosicion()).getNPCS().get(i) instanceof EnemigoActivo && MapaJuego.getMapa().get(Jugador.getPosicion()).getNPCS().get(i).getVida() > 0) {

                Jugador.setVida(Jugador.getVida() - (10 + (MapaJuego.getMapa().get(Jugador.getPosicion()).getNPCS().get(i).getFuerza() / 10) - Jugador.getDefensa() / 10));

                JOptionPane.showMessageDialog(null, "Te han atacado!\n Te han quitado: " + (10 + (MapaJuego.getMapa().get(Jugador.getPosicion()).getNPCS().get(i).getFuerza() / 10) - Jugador.getDefensa() / 10) + " puntos de vida", "NO!", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    /*public void gestionCadaveres(Personaje personaje) {

     for (int i = 0; i < personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().size(); i++) {

     if (personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getVida() <= 0) {

     for (int j = 0; j < personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getMochila().getContenido().size(); j++) {

     personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getAccionesPersonaje().dejarObjeto(personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i), personaje.getMapa().getMapa().get(personaje.getPosicion()).getNPCS().get(i).getMochila().getContenido().get(j).getNombre());

     }

     }

     }

     }*/
    //Carga de datos
    public void cargar(String directorio) {

        MapaJuego = LeerMapa(directorio);
        MapaJuego.setTamaño(10, 10);
        MapaJuego.crearMuros();
        MapaJuego.setInicio();
        MapaJuego.setFin();
        colocaPersonajes(LeerPersonajes(directorio));
        ArrayList<Objeto> objetos = LeerObjetos(directorio);
        MapaJuego.colocaObjetos(objetos, Jugador);

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
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
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

            switch (tipo) {

                case "jugador":

                    personajes.add(Jugador = new Jugador(punto, nombre, Integer.parseInt(vida), Integer.parseInt(energia), Integer.parseInt(fuerza), Integer.parseInt(defensa), frase));
                    Jugador.setPosicion(MapaJuego.getInicio());
                    Jugador.setMapa(MapaJuego);
                    break;

                case "mago":

                    personajes.add(Jugador = new Mago(punto, nombre, Integer.parseInt(vida), Integer.parseInt(energia), Integer.parseInt(fuerza), Integer.parseInt(defensa), frase));
                    Jugador.setPosicion(MapaJuego.getInicio());
                    Jugador.setMapa(MapaJuego);
                    break;

                case "gerrero":

                    personajes.add(Jugador = new Guerrero(punto, nombre, Integer.parseInt(vida), Integer.parseInt(energia), Integer.parseInt(fuerza), Integer.parseInt(defensa), frase));
                    Jugador.setPosicion(MapaJuego.getInicio());
                    Jugador.setMapa(MapaJuego);
                    break;

                case "enemigoactivo":

                    personajes.add(new EnemigoActivo(punto, nombre, Integer.parseInt(vida), Integer.parseInt(energia), Integer.parseInt(fuerza), Integer.parseInt(defensa), frase));

                    break;

                case "enemigopasivo":

                    personajes.add(new EnemigoPasivo(punto, nombre, Integer.parseInt(vida), Integer.parseInt(energia), Integer.parseInt(fuerza), Integer.parseInt(defensa), frase));

                    break;

                case "amigo":

                    personajes.add(new Amigo(punto, nombre, Integer.parseInt(vida), Integer.parseInt(energia), Integer.parseInt(fuerza), Integer.parseInt(defensa), frase));

                    break;

            }

            //personajes.add(new Personaje(punto, nombre, Integer.parseInt(vida), Integer.parseInt(energia), Integer.parseInt(fuerza), Integer.parseInt(defensa), frase));
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
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (scanner.hasNext()) {

            String linea = scanner.nextLine();

            aux = linea.split(";");

            if (!aux[0].contains("#")) {

                coordenadas = aux[0].split(",");

                propietario = aux[1];

                tipo = aux[2];

                nombre = aux[3];

                descripcion = aux[4];

                modificador = aux[5];

                efecto = aux[6];

                peso = aux[7];

                Point punto = new Point(Integer.parseInt(coordenadas[0]), Integer.parseInt(coordenadas[1]));

                switch (modificador) {

                    case "energia":

                        Objetos.add(new pocimaenergia(punto, propietario, nombre, descripcion, Integer.parseInt(efecto), Float.parseFloat(peso)));

                        break;

                    case "salud":

                        if (efecto.contains("-")) {

                            Objetos.add(new pocimaveneno(punto, propietario, nombre, descripcion, Integer.parseInt(efecto), Float.parseFloat(peso)));

                        } else {

                            Objetos.add(new pocimasalud(punto, propietario, nombre, descripcion, Integer.parseInt(efecto), Float.parseFloat(peso)));

                        }

                        break;

                    case "defensa":

                        Objetos.add(new objetodefensivo(punto, propietario, nombre, descripcion, Integer.parseInt(efecto), Float.parseFloat(peso)));

                        break;

                    case "fuerza":

                        Objetos.add(new objetoarma(punto, propietario, nombre, descripcion, Integer.parseInt(efecto), Float.parseFloat(peso)));

                        break;

                    default:

                        if (tipo.equals("mapa")) {

                            Objetos.add(new objetomapa(punto, propietario, nombre, descripcion, Integer.parseInt(efecto), Float.parseFloat(peso)));

                        }

                        break;

                }

                //Objetos.add(new Objeto(punto, propietario, nombre, descripcion, Integer.parseInt(efecto), Float.parseFloat(peso)));
            }
        }

        scanner.close();

        return Objetos;

    }

    public ArrayList<String> Comandos(String directorio) {

        ArrayList<String> comandos = new ArrayList<>();

        Scanner scanner = null;
        String a = "";
        a = directorio;
        a += "/comandos.txt";
        Mapa mapa = new Mapa();

        String[] aux;
        String comando;
        String nombre;

        try {
            scanner = new Scanner(new File(a));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (scanner.hasNext()) {

            String linea = scanner.nextLine();

            aux = linea.split(" ");

            if (!aux[0].contains("#")) {

                comando = linea;

                comandos.add(comando);

            }
        }

        scanner.close();

        return comandos;

    }

    public void UsarComando(ArrayList<String> comandos) {

        int i = 0;

        do {

            String[] aux;

            aux = comandos.get(i).split(" ");

            i++;

            MapaJuego.imprimeMapa(Jugador);
            System.out.println(Jugador);

            if (aux.length > 1) {
                try {
                    SeleccionarOpcion(Jugador, aux[0], aux[1]);
                } catch (ExcepcionJuego ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    SeleccionarOpcion(Jugador, aux[0], "");
                } catch (ExcepcionJuego ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } while (!MapaJuego.getMapa().get((Jugador.getPosicion())).isEsFin() && Jugador.getVida() >= 0 || i < comandos.size());

        if (Jugador.getEnergia() <= 0) {
            JOptionPane.showMessageDialog(null, "\nTE HAS QUEDADO SIN ENERGIA\n EL JUEGO HA TERMINADO");
        } else if (Jugador.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, "\nTE HAS QUEDADO SIN VIDA\n EL JUEGO HA TERMINADO");
        } else {
            JOptionPane.showMessageDialog(null, "\n" + Jugador.getMapa().getMapa().get(Jugador.getPosicion()).getDescripcion());
            Jugador.getMapa().imprimeMapa(Jugador);
            JOptionPane.showMessageDialog(null, "\nFELICIDADES HAS COMPLETADO EL JUEGO");
            System.out.println("\nTUS ESTADISTICAS: " + Jugador);
            JOptionPane.showMessageDialog(null, "\nHAS DADO: " + Jugador.getRecorrido().size() + " PASOS" + "\nEL RECORRIDO QUE HAS SEGUIDO ES: " + Jugador.getRecorrido());
        }

    }

    public void colocaPersonajes(ArrayList<Personaje> personajes) {

        for (int i = 0; i < personajes.size(); i++) {

            if (personajes.get(i) instanceof Jugador) {
                Jugador.setNombre(personajes.get(i).getNombre());
                Jugador.setVida(personajes.get(i).getVida());
                Jugador.setFuerza(personajes.get(i).getFuerza());
                Jugador.setDefensa(personajes.get(i).getDefensa());
                Jugador.setFrase(personajes.get(i).getFrase());

            } else {
                MapaJuego.getMapa().get(personajes.get(i).getPosicion()).añadirPersonaje(personajes.get(i));
            }
        }

    }
    
    public void Partidanueva() {
        
        MapaJuego = new Mapa(8, 8);

        MapaJuego.getMapa().get(new Point(0, 0)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(0, 0)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(0, 1)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(0, 1)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(1, 0)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(1, 0)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(1, 1)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(1, 1)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(2, 1)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(2, 1)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(3, 1)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(3, 1)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(4, 1)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(4, 1)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(4, 2)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(4, 2)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(4, 3)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(4, 3)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(5, 3)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(5, 3)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(6, 3)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(6, 3)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(6, 2)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(6, 2)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(6, 1)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(6, 1)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(3, 3)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(3, 3)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(2, 3)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(2, 3)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(1, 3)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(1, 3)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(1, 4)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(1, 4)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(1, 5)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(1, 5)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(2, 4)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(2, 4)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(2, 5)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(2, 5)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(5, 4)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(5, 4)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(5, 5)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(5, 5)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(6, 5)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(6, 5)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(7, 5)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(7, 5)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(7, 6)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(7, 6)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(7, 7)).setTransitable(true);
        MapaJuego.getMapa().get(new Point(7, 7)).setTipo("camino");
        MapaJuego.getMapa().get(new Point(0, 0)).setEsInicio();
        MapaJuego.getMapa().get(new Point(7, 7)).setEsFin();

        ArrayList<Personaje> Personajes = new ArrayList<>();
        ArrayList<Objeto> Objetos = new ArrayList<>();
        
        Object aux = JOptionPane.showInputDialog(null, "Elige una clase: \n Guerrero(G) o Mago (M)", "Introduce tu clase chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, null, null, null);
        Object aux2 = JOptionPane.showInputDialog(null, "Gandalf pregunta: \n'¿Como te llamas valiente?'", "Introduce tu nombre chico, ¿quieres?:", JOptionPane.QUESTION_MESSAGE, null, null, null);

        switch(aux.toString()) {

            case "G":
            case "Guerrero":{
                
                Jugador = new Guerrero(MapaJuego.getInicio(), aux2.toString(), 100, 100, 10, 5, ".");

                Objetos.add(new objetoarma(new Point(1, 1), ".", "Espada de los hombres", "Espada creada por el pueblo de los hombres", 25, 10f));
            
            }
                break;

            case "M":
            case "Mago":{
                
                Jugador = new Mago(MapaJuego.getInicio(),aux2.toString(),100,100,5,0,".");
                
                Objetos.add(new objetoarma(new Point(1, 1), ".", "Baston de mago", "Largo baston magico que fue pasando de generacion en generacion de magos", 40, 10f));
                
            }
                break;

        }

        Personajes.add(new Amigo(new Point(3, 1), "Gimli", 100, 100, 10, 40, "¡Cuenta con mi hacha!"));
        Personajes.add(new EnemigoActivo(new Point(5, 3), "Rey Brujo", 50, 50, 60, 30, "Preparate para morir..."));

        Objetos.add(new objetoarma(new Point(3, 1), "Gimli", "Hacha de enano", "Gran hacha de guerra creada por el pueblo de los enanos", 50, 20f));

        Objetos.add(new objetodefensivo(new Point(4, 2), ".", "Armadura de tela elfica", "Camiseta magica creada por los ancestros de los elfos", 50, 10f));
        MapaJuego.colocaObjetos(Objetos, Jugador);
        colocaPersonajes(Personajes);

        
       // Jugador.setMapa(MapaJuego);
        
    }

}
