package Mapa;

import Items.Objeto;
import MainCharacter.Personaje;
import java.awt.Point;
import java.util.HashMap;

public final class Mapa {

    private String Descripcion;
    private HashMap<Point, Celda> mapa;
    private final Point tamaño;

    // Constructor
    public Mapa(int x, int y) {

        this.tamaño = new Point(x, y);
        this.mapa = new HashMap<>();
        for (int i = 0; i < tamaño.x; i++) {
            for (int j = 0; j < tamaño.y; j++) {
                Celda celda = new Celda();
                this.insertaCelda(i, j, celda);
            }
        }

        //descripcion
        
    }

    // Getters
    public String getDescripcion() {
        return Descripcion;
    }

    public HashMap<Point, Celda> getMapa() {
        return mapa;
    }

    // Setters
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setMapa(HashMap<Point, Celda> mapa) {
        this.mapa = mapa;
    }

    // Metodos propios
    public void insertaCelda(int x, int y, Celda celda) {

        Point punto = new Point(x, y);
        mapa.put(punto, celda);

    }

    public void imprimeMapa(Personaje personaje) {
        

        for (int i = 0; i < tamaño.x; i++) {
            System.out.print("\n");
            for (int j = 0; j < tamaño.y; j++) {
                if(personaje.getPosicion().equals(new Point(i,j))){
                    System.out.print("☻ ");
                }else{
                System.out.print(this.getMapa().get(new Point(i, j)) + " ");
                }
            }
        }

    }

    public void mapaTransitable(Mapa map) {

        map.getMapa().get(new Point(8, 0)).setTransitable(true);
        map.getMapa().get(new Point(8, 1)).setTransitable(true);
        map.getMapa().get(new Point(8, 1)).getItems().add(new Objeto("LLave inglesa", "Arma", 2, 0));
        map.getMapa().get(new Point(8, 1)).getItems().add(new Objeto("Plasmido", "Ayuda", 2, 0));
        map.getMapa().get(new Point(8, 3)).getItems().add(new Objeto("Pistola", "Arma", 2, 0));
        map.getMapa().get(new Point(8, 3)).getItems().add(new Objeto("Municion", "Arma", 2, 0));
        
        map.getMapa().get(new Point(6, 1)).setTransitable(true);
        map.getMapa().get(new Point(5, 1)).setTransitable(true);
        map.getMapa().get(new Point(5, 2)).setTransitable(true);
        map.getMapa().get(new Point(5, 5)).setTransitable(true);
        map.getMapa().get(new Point(4, 5)).setTransitable(true);
        map.getMapa().get(new Point(4, 6)).setTransitable(true);
        map.getMapa().get(new Point(4, 5)).setTransitable(true);
        map.getMapa().get(new Point(4, 3)).setTransitable(true);
        map.getMapa().get(new Point(3, 3)).setTransitable(true);
        map.getMapa().get(new Point(2, 3)).setTransitable(true);
        map.getMapa().get(new Point(2, 4)).setTransitable(true);
        map.getMapa().get(new Point(2, 5)).setTransitable(true);
        map.getMapa().get(new Point(2, 6)).setTransitable(true);
        map.getMapa().get(new Point(2, 7)).setTransitable(true);
        map.getMapa().get(new Point(2, 8)).setTransitable(true);
        map.getMapa().get(new Point(3, 8)).setTransitable(true);
        map.getMapa().get(new Point(4, 8)).setTransitable(true);
        map.getMapa().get(new Point(5, 8)).setTransitable(true);
        map.getMapa().get(new Point(6, 8)).setTransitable(true);
        map.getMapa().get(new Point(7, 8)).setTransitable(true);
        map.getMapa().get(new Point(8, 8)).setTransitable(true);
        map.getMapa().get(new Point(8, 7)).setTransitable(true);
        map.getMapa().get(new Point(8, 6)).setTransitable(true);
        map.getMapa().get(new Point(7, 6)).setTransitable(true);
        map.getMapa().get(new Point(6, 6)).setTransitable(true);
        map.getMapa().get(new Point(6, 5)).setTransitable(true);
        map.getMapa().get(new Point(6, 4)).setTransitable(true);
        map.getMapa().get(new Point(6, 3)).setTransitable(true);
        map.getMapa().get(new Point(7, 3)).setTransitable(true);
        map.getMapa().get(new Point(8, 3)).setTransitable(true);
        map.getMapa().get(new Point(8, 2)).setTransitable(true);
        map.getMapa().get(new Point(1, 5)).setTransitable(true);
        map.getMapa().get(new Point(0, 5)).setTransitable(true);
        map.getMapa().get(new Point(1, 1)).setTransitable(true);
        map.getMapa().get(new Point(2, 1)).setTransitable(true);
        map.getMapa().get(new Point(2, 2)).setTransitable(true);
        map.getMapa().get(new Point(1, 8)).setTransitable(true);
        map.getMapa().get(new Point(1, 9)).setTransitable(true);
        map.getMapa().get(new Point(8, 9)).setTransitable(true);
        map.getMapa().get(new Point(4, 2)).setTransitable(true);

        //Descripciones
        
        map.getMapa().get(new Point(8, 0)).setDescripcion("Entras en las catacumbas de Rapture a traves de una gran puerta, tras tu primer paso en ella estas se iluminan.\n"
                + "Al adentrarte en la cueva, en la pared derecha ves una estatua de un hombre en la que dice: \n\t\t'NO GODS OR KINGS.\n\t\t    ONLY MAN'\n"
                + "Al fondo del oscuro pasillo se ve una batisfera, entras en ella, y esta desciende numerosos metros bajo el mar.\nDurante el descenso escuchas a dos hombres "
                + "hablar a traves de la radio de la batisfera.\nMiras a traves de sus cristales observando una increible ciudad submarina.");
        map.getMapa().get(new Point(8, 1)).setDescripcion("La batisfera se detiene, y una Splicer intenta abrirla tozudamente, "
                + "cuando este se detienese escucha por radio:\n" +
                "+ Coge la radio de onda corta, ¿quieres?\n" +
                "\n" +
                "La coges, el individuo se presenta como ATLAS y promete sacarte de alli. La batisfera se abre, y el añade:\n" +
                "\n" +
                "+ Respira hondo y sal de la batisfera, no te dejare colgado. ");        
        map.getMapa().get(new Point(8, 2)).setDescripcion("Avanzas por el pasillo y en una pared se puede leer << No deberías haber venido>>. Se vuelve a escuchar la voz del extraño guía:\n" +
                "+Busca una palanca o algo, ¿quieres?\n" +
                "\n" +
                "En la sala encuentras una jeringa de ADAM y te la inyectas, ojo, ¡Has modificado tu ADN y has caído desmayado!\n" +
                "\n" +
                "Los Splicers intentan aprovecharlo pero un robot enorme los espanta, este camina con su Little sister en busca de ADAM. ");
        map.getMapa().get(new Point(8, 3)).setDescripcion("Avanzas a través de un conducto submarino de cristal desde el cual se ve parte de la ciudad, \neste se rompe y empieza a entrar agua, lo cual te hace avanzar con mas dificultad (perder energía en esta celda).\n" +
                "\n" +
                "Llegas a una gran sala en la cual, y escuchas a alguien pedir perdón a un tal RYAN, en ella hay 6 estandartes que contienen las palabras:\n" +
                "\n" +
                "<<CREATIVIDAD, INDEPENDENCIA, COMERCIO, SUPREMACÍA, LIBERTAD y SUPREMACÍA>> ");
        map.getMapa().get(new Point(8, 6)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(8, 7)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(8, 8)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(7, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(7, 3)).setDescripcion("Asciendes en ascensor mientras ATLAS te pide que encuentres a su familia en Neptune’s Bounty, finalizando con:\n" +
                "+[…] eres mi ultima esperanza.\n" +
                "\n" +
                "Se abre el ascensor y entras hacia el restaurante, junto a una balcón interior. \nEste esta totalmente destrozado, mientras lo observas ATLAS te va informando de la triste historia de Rapture.\n" +
                "\n" +
                "Alli en el baño ves una mujer fantasma lamentándose de todas sus recombinaciones. ");
        
        
        map.getMapa().get(new Point(6, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(6, 6)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(6, 5)).setDescripcion("Llegas a una especie de elevador, en el cual se cierra la puerta y comienza un video de ANDREW RYAN "
                + "\nacusándote de provenir de alguna potencia a saquear su ciudad, al acabar el elevador se detiene. "
                + "\nVuelve a sonar la misteriosa voz de ATLAS:\n" +
                "+Ya conoces a ANDREW RYAN, el puñetero rey de Rapture. Ahora dirigete al acceso de emergencia, ¿quieres?\n" +
                "\n" +
                "Sales y reconoces el lugar como la zona medica. ");
        map.getMapa().get(new Point(6, 4)).setDescripcion("Bajas un piso por escaleras, por las cuales cae agua filtrada por alguna zona del techo. \n"
                + "Al llegar al final de estas reconoces un Big Daddy que aparenta apagado o muerto bajo una pequeña cascada provocada por la filtración.\n" +
                "\n" +
                "Encuentras una puerta hacia Neptune´s Bounty pero cerrada, deberas continuar por otro camino. Comienza a sonar la alarma y ATLAS te advierte:\n" +
                "\n" +
                "+¡Es RYAN! ¡El maldito ANDREW RYAN! Nos ha descubierto, ha bloqueado el acceso a Neptune, dirigete al centro medico rápido. ¡Vamos!  ");
        map.getMapa().get(new Point(6, 3)).setDescripcion("Avanzas a través de un agujero que te lleva al teatro, concretamente al techo del escenario, "
                + "\nbajas las escaleras y observas en  el a una Little sister obteniendo ADAM de un Splicer. "
                + "\nOtro intenta atacarla y de nuevo aparece otro de esos robots gigantes, el cual elimina al individuo al instante."
                + "\n ATLAS te pone en situación: \n" +
                "+Ese es un Big Daddy. Ella recoge ADAM, el la mantiene a salvo.\n" +
                "\n" +
                "Se van y avanzas tiempo después tras sus pasos. ");        
        map.getMapa().get(new Point(6, 1)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(5, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(5, 1)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(4, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(4, 3)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(3, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(3, 3)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(2, 8)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(2, 7)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(2, 6)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(2, 5)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(2, 4)).setDescripcion(Descripcion);
        map.getMapa().get(new Point(2, 3)).setDescripcion(Descripcion);
    
        map.getMapa().get(new Point(1, 5)).setDescripcion(Descripcion);
        
        map.getMapa().get(new Point(0, 5)).setDescripcion(Descripcion);
        
        
        

    }

    public Point getInicio() {
        for (int i = 0; i < this.tamaño.x; i++) {
            for (int j = 0; j < this.tamaño.y; j++) {
                if (this.mapa.get(new Point(i, j)).isEsInicio()) {
                    return new Point(i, j);
                } 
            }
        }
        return null;
    }
      
    
    
}
