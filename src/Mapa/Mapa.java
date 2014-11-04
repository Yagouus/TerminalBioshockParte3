package Mapa;

import Items.Objeto;
import MainCharacter.Personaje;
import java.awt.Point;
import java.util.HashMap;

public final class Mapa {

    private String Nombre; 
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
                if (personaje.getPosicion().equals(new Point(i, j))) {
                    System.out.print("☻ ");
                } else {
                    System.out.print(this.getMapa().get(new Point(i, j)) + " ");
                }
            }
        }

    }

    public void mapaTransitable(Mapa map) {

        map.getMapa().get(new Point(8, 0)).setTransitable(true);
        map.getMapa().get(new Point(8, 1)).setTransitable(true);
        map.getMapa().get(new Point(8, 1)).getItems().add(new Objeto("Radio de Onda Corta", "Herramienta", 2, 0));
        map.getMapa().get(new Point(8, 2)).setTransitable(true);
        map.getMapa().get(new Point(8, 2)).getItems().add(new Objeto("Adam", "Plasmido", 2, 0));
        map.getMapa().get(new Point(8, 2)).getItems().add(new Objeto("Palanca", "Arma", 2, 0));
        map.getMapa().get(new Point(6, 1)).setTransitable(true);
        map.getMapa().get(new Point(5, 1)).setTransitable(true);
        map.getMapa().get(new Point(5, 2)).setTransitable(true);
        map.getMapa().get(new Point(5, 5)).setTransitable(true);
        map.getMapa().get(new Point(4, 5)).setTransitable(true);
        map.getMapa().get(new Point(4, 6)).setTransitable(true);
        map.getMapa().get(new Point(4, 6)).getItems().add(new Objeto("Pistola", "Arma", 2, 0));
        map.getMapa().get(new Point(4, 6)).getItems().add(new Objeto("20 Monedas", "Dinero", 2, 0));

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
                + "cuando este se detienese escucha por radio:\n"
                + "+ Coge la radio de onda corta, ¿quieres?\n"
                + "\n"
                + "La coges, el individuo se presenta como ATLAS y promete sacarte de alli. La batisfera se abre, y el añade:\n"
                + "\n"
                + "+ Respira hondo y sal de la batisfera, no te dejare colgado. ");
        map.getMapa().get(new Point(8, 2)).setDescripcion("Avanzas por el pasillo y en una pared se puede leer << No deberías haber venido>>. Se vuelve a escuchar la voz del extraño guía:\n"
                + "+Busca una palanca o algo, ¿quieres?\n"
                + "\n"
                + "En la sala encuentras una jeringa de ADAM y te la inyectas, ojo, ¡Has modificado tu ADN y has caído desmayado!\n"
                + "\n"
                + "Los Splicers intentan aprovecharlo pero un robot enorme los espanta, este camina con su Little sister en busca de ADAM. ");
        map.getMapa().get(new Point(8, 3)).setDescripcion("Avanzas a través de un conducto submarino de cristal desde el cual se ve parte de la ciudad, \neste se rompe y empieza a entrar agua, lo cual te hace avanzar con mas dificultad.\n"
                + "\n"
                + "Llegas a una gran sala en la cual, y escuchas a alguien pedir perdón a un tal RYAN, en ella hay 6 estandartes que contienen las palabras:\n"
                + "\n"
                + "<<CREATIVIDAD, INDEPENDENCIA, COMERCIO, SUPREMACÍA, LIBERTAD y SUPREMACÍA>> ");
        map.getMapa().get(new Point(8, 6)).setDescripcion("Llegas a una zona que parece ser la recepción del lugar, sobre ella ves una grabadora y decides pulsar el botón de play, se oye la voy de ANDREW RYAN:\n"
                + "+En la superficie, el parasito espera que el medico lo trate gratis, que el granjero lo alimente por caridad. Que poco se diferencia del pervertido, que merodea las calles,\n en busca de una victima a la que pueda violar para su grotesca diversión.");
        map.getMapa().get(new Point(8, 7)).setDescripcion("Entras de nuevo en un conducto submarino desde el cual puedes ver las profundidades y en el que te diriges hacia un edificio en el que pone\ncon letras luminosas sobre la puerta que lo encierra: <<Cirugia>>.\n"
                + "En el conducto encuentras un televisor encendido en el que el doctor STEINMAN habla sobre las modificaciones genéticas y su forma ética de verlo.");
        map.getMapa().get(new Point(8, 8)).setDescripcion("Entras y llegas a un hall en el que encuentras dos bifurcaciones, una finalmente es la que te llevara al pabellón de cirugía,\nen la otra no consigues identificar nada que te indique hacia donde te llevara.\n"
                + "En el hall todo esta destruido y el cartel que indica la entrada a cirugía en llamas.");

        map.getMapa().get(new Point(7, 8)).setDescripcion("Al tomar la bifurcación hacia cirugía subes unas escaleras hacia lo que parece una sala de espera, la cual está totalmente\ndestruida como si una batalla campal hubiese tenido lugar allí.\n"
                + "Repleta de cadáveres de Splicers la recorres evitando pisar sus restos.");
        map.getMapa().get(new Point(7, 6)).setDescripcion("Avanzas por numerosos pasillos, llenos de rastros de sangre por el suelo, lamentos escritos con esta en las paredes,\nademás de cadáveres de Splicers que fallecieron en su incansable lucha por un poco mas de ADAM.");
        map.getMapa().get(new Point(7, 3)).setDescripcion("Asciendes en ascensor mientras ATLAS te pide que encuentres a su familia en Neptune’s Bounty, finalizando con:\n"
                + "+[…] eres mi ultima esperanza.\n"
                + "\n"
                + "Se abre el ascensor y entras hacia el restaurante, junto a una balcón interior. \nEste esta totalmente destrozado, mientras lo observas ATLAS te va informando de la triste historia de Rapture.\n"
                + "\n"
                + "Alli en el baño ves una mujer fantasma lamentándose de todas sus recombinaciones. ");

        map.getMapa().get(new Point(6, 8)).setDescripcion("Sigues por un pasillo al fondo del cual ves una antorcha sobre la que hay un cartel que pone:\n"
                + "<<LLAMA ETERNA>>, al cruzarlo y virar a la derecha una puerta explota muy cerca de ti.");
        map.getMapa().get(new Point(6, 6)).setDescripcion("Al continuar por el largo pasillo ves una puerta cerrada al final de el, y también una llave enganchada en una mano mutilada en el suelo, la recoges y la utilizas para abrir la puerta totalmente asqueado. \n"
                + "Una vez abres la puerta ves un cartel y una flecha que indica, <<Crematorio,  Cirugia y Funeraria>>.");
        map.getMapa().get(new Point(6, 5)).setDescripcion("Llegas a una especie de elevador, en el cual se cierra la puerta y comienza un video de ANDREW RYAN "
                + "\nacusándote de provenir de alguna potencia a saquear su ciudad, al acabar el elevador se detiene. "
                + "\nVuelve a sonar la misteriosa voz de ATLAS:\n"
                + "+Ya conoces a ANDREW RYAN, el puñetero rey de Rapture. Ahora dirigete al acceso de emergencia, ¿quieres?\n"
                + "\n"
                + "Sales y reconoces el lugar como la zona medica. ");
        map.getMapa().get(new Point(6, 4)).setDescripcion("Bajas un piso por escaleras, por las cuales cae agua filtrada por alguna zona del techo. \n"
                + "Al llegar al final de estas reconoces un Big Daddy que aparenta apagado o muerto bajo una pequeña cascada provocada por la filtración.\n"
                + "\n"
                + "Encuentras una puerta hacia Neptune´s Bounty pero cerrada, deberas continuar por otro camino. Comienza a sonar la alarma y ATLAS te advierte:\n"
                + "\n"
                + "+¡Es RYAN! ¡El maldito ANDREW RYAN! Nos ha descubierto, ha bloqueado el acceso a Neptune, dirigete al centro medico rápido. ¡Vamos!  ");
        map.getMapa().get(new Point(6, 3)).setDescripcion("Avanzas a través de un agujero que te lleva al teatro, concretamente al techo del escenario, "
                + "\nbajas las escaleras y observas en  el a una Little sister obteniendo ADAM de un Splicer. "
                + "\nOtro intenta atacarla y de nuevo aparece otro de esos robots gigantes, el cual elimina al individuo al instante."
                + "\n ATLAS te pone en situación: \n"
                + "+Ese es un Big Daddy. Ella recoge ADAM, el la mantiene a salvo.\n"
                + "\n"
                + "Se van y avanzas tiempo después tras sus pasos. ");
        map.getMapa().get(new Point(6, 1)).setDescripcion("Finalmente en el lugar consigues llegar a una caja fuerte, la cual parece haber sido forzada, pero que todavía no ha sido abierta.\n"
                + "Por la cantidad de sangre del lugar algo horrible debió ocurrir allí. Encuentras un cadáver con algo que semeja un arpon clavado en el cráneo,\n y una grabadora junto a el perteneciente al doctor SUCHONG, la reproduces:"
                + "+Ensayo clínico Lote 44 Dr. Suchong/Cliente Fontaine Futuristics. El sujeto es un varon blanco, un tal Roland Wallace. ¿Me oye señor Wallace?\n"
                + "-Si sr.\n"
                + "+Muy bien. Bueno voy a empezar con el Lote 44… Le hemos puesto el nombre en clave ‘Enfurecer’ por su tendencia a… Enfermera, sujételo… ¡Enfermera! ¡Enfermera!\n");

        map.getMapa().get(new Point(5, 8)).setDescripcion("Accedes gracias a la explosión a un despacho en el que encuentras dos fotos en cada esquina de este, una de un hombre y otra de su mujer, debajo de las cuales pone <<En memoria de>>.\n"
                + "Además detrás de la mesa se encuentra una puerta trasera entreabierta.");
        map.getMapa().get(new Point(5, 5)).setDescripcion("Desciendes un piso por unas escaleras. Se escucha mucho ruido de fondo pero por culpa de la oscuridad apenas consigues ver nada. De nuevo, la tenebrosa voz de ATLAS:\n"
                + "+Chico, esa no es la dirección correcta, deberías dar la vuelta.");
        map.getMapa().get(new Point(5, 1)).setDescripcion("Continua por unos pasillos que por la suciedad de estos parecen casi propios de un hospital de la Guerra Mundial, llenos de goteras,\ny en las zonas más bajas pequeños charcos de agua ya muy sucia por el tiempo que lleva allí estancada.");

        map.getMapa().get(new Point(4, 8)).setDescripcion("Encuentras otra nota de voz a los pies del escritorio y la reproduces antes de continuar:\n"
                + "+(STEINMAN) Cuando Picasso se aburrió de pintar gente, empezó a representarlos como cubos y otras formas abstractas.\nEl mundo lo calificó de genio. He pasado toda mi carrera de cirujano creando…"
                + "De repente el audio se corta.");
        map.getMapa().get(new Point(4, 5)).setDescripcion("Recorres el oscuro pasillo y llegas a lo que parece ser un despacho de un doctor, al fin bien iluminado. En una grabadora sobre su escritorio puedes identificar su nombre: doctor STEINMAN.\n"
                + "Sobre el escritorio también identificas una maquina de escribir, y ves que los cajones de este han sido saqueados.");
        map.getMapa().get(new Point(4, 6)).setDescripcion("Al llegar al final de un pasillo situado cerca del siniestro despacho, te encuentras con la visión de un fantasma que grita:\n"
                + "+Me prometiste belleza STEINMAN, me prometiste belleza… Y ahora mírame… ¡MIRAME!\n"
                + "Esta se desvanece e intuyes un baúl situado a la derecha de la puerta que golpeaba el fantasma.");
        map.getMapa().get(new Point(4, 3)).setDescripcion("Por un pasillo lateral, el cual está totalmente inundado por agua tratas de continuar,\n"
                + "pero esto te conlleva un esfuerzo importante llegas a otra camilla para autopsias, pero esta mucho mas macabra,\nen una habitación totalmente oscura y con un único foco enfocando al cadáver situado en esta.");

        map.getMapa().get(new Point(3, 8)).setDescripcion("Al salir por la puerta suena la voz de ATLAS por la radio:\n"
                + "+Cámaras de seguridad. Puedo oir esos cacharros infernales por todas partes a tu alrededor. Los ojos y oídos de Ryan.");
        map.getMapa().get(new Point(3, 3)).setDescripcion("Continuando por otra de las habitaciones contiguas das lugar a una sala de autopsias, la cual está peligrosamente sucia,\ncon restos humanos y un cadáver sobre una de las tres camillas que utilizan para ellos.");

        map.getMapa().get(new Point(2, 8)).setDescripcion("Despues del extraño despacho te encuentras en una especie de pasadizo que parecer llevar a un pasillo principal del complejo. Rapture está lleno de pequeñas escapatorias creadas por sus\nhabitantes al parecer piensas en alto. En el pasillo principal puedes decidir entre tomar dos direcciones.");
        map.getMapa().get(new Point(2, 7)).setDescripcion("Al seguir la otra alternativa del pasillo te guía hacia una escalera que sube.\nRealiza un giro de 180º en la subida llegando a lo que semejan algunos quirófanos enlazados.");
        map.getMapa().get(new Point(2, 6)).setDescripcion("A lo largo de la sala ves numerosos instrumentos quirúrgicos, y finalmente encuentras un despacho al cual no puedes acceder ya que sus puertas parecen estar totalmente selladas.");
        map.getMapa().get(new Point(2, 5)).setDescripcion("Encuentras una entrada hacia al misteriosamente cerrado despacho. En él encuentras información sobre el plásmido de incineración,\ny un frasco en el cual se supone contenido el susodicho.\n"
                + "Aparecen numerosos Splicers y con la curiosidad de probar el novedoso plasmido provocas una pequeña llama\nque alcanza el aceite de la sala y achicharra a los bandidos y te permite salir sin sufrir daños.");
        map.getMapa().get(new Point(2, 4)).setDescripcion("Tu radio vuelve a activar resonando la voz de ATLAS:\n"
                + "+Chico, no creo que ese sea el camino que debas tomar, piénsalo bien, ¿quieres?\n"
                + "Continua:\n"
                + "+Todos los caminos de Rapture llevan a Ryan. La seguridad, los Splicers, los Big Daddies, las Little sisters:\nbombea algún tipo de fragancia química en el aire, la llaman feromonas, que hace que todos bailen al son que el toque.");
        map.getMapa().get(new Point(2, 3)).setDescripcion("Gracias al nuevo plasmido que ha sido incorporado a tu ADN, logras acceder por una puerta la cual semejaba congelada.\n"
                + "De fondo resuena por la megafonía:\n"
                + "+El parasito tiene la vista puesta en Rapture, no pierdas de vista al parasito.\n");

        map.getMapa().get(new Point(1, 5)).setDescripcion("Al salir de la zona llegas a una puerta que pone en grande <<Pabellon Medico>>, semeja ser la otra entrada de este,\nuno de los pasillos contiguos parece sellado pero una explosión ocasionada por una pelea de Splicers abre una pequeña brecha por la que consigues colarte.");

        map.getMapa().get(new Point(0, 5)).setDescripcion("Llegas a lo que parece el quirófano de STEINMAN, el cual se encuentra en el mutilando a un cadáver bajo su locura.\n"
                + "Rodeado de otros cadáveres de seguramente inocentes que intentando realizarles cirugías asesino bajo su locura de alcanzar la perfeccion.\n"
                + "Intenta atacarte tras su cristal blindado, pero al disparar desde el interior hace reventar uno de sus aparatos y caer uno de sus aparatosos tableros colgados del techo con cadáveres sobre los que realizó sus locuras,\n"
                + "quedando aplastado y abriéndote así el camino por una puerta trasera de este a la salida. Y un paso mas cerca de la familia de ATLAS.");
        map.getMapa().get(new Point(8, 9)).setDescripcion("Tomas la desconocida bifurcación y llegas a una puerta congelada, ves una grabadora en el suelo y la reproduces:\n"
                + "+STEINMAN, se que el pabellón medico es tu feudo, pero te conviene cavilar sobre lo siguiente:\nel agua del mar esta fría como el hielo. Si no calientas las cañerías se congelaran. Y si se congelan, revientan. Entonces empieza a entrar agua en Rapture.\n"
                + "Soy consciente de que eres un tio muy pijo y francamente, por mi alla te pudras.\nPero cuando Rapture se empiece a llenar de vías de agua, no parara.\nY entonces no dudes que le dire a RYAN que te lo agradezca a ti.\n"
                + "La grabadora estaba firmada por un tal McDonagh.");
        map.getMapa().get(new Point(1, 8)).setDescripcion("Giras hacia la derecha y llegas al crematorio, donde un horno está encendido, su bandeja abierta y un cadáver situado sobre ella.\nA la derecha del horno un botón.");
        map.getMapa().get(new Point(1, 9)).setDescripcion("Pulsas el botón, la puerta se cierra introduciéndose la bandeja. Aumenta la temperatura del ambiente al estarse quemando algo, y al finalizar se abre la bandeja.\n"
                + "Entre las cenizas puedes localizar que han quedado algunos objetos que el sujeto incinerado debía llevar encima.");
        map.getMapa().get(new Point(1, 1)).setDescripcion("Introduces el codigo en una puerta cerrada con seguridad en la propia habitación, lo introduces y esta se abre, dentro,\nsolo encuentras un mueble zapatero, con zapatos viejos y algo objetos que quizás puedan serte de ayuda.");
        map.getMapa().get(new Point(2, 1)).setDescripcion("Continuando por las habitaciones que parecen estar enlazadas unas con otros encuentras un ataúd abierto, y de nuevo,\n"
                + "la foto que había encontrado en el despacho antes de llegar al crematorio que recuerda a un hombre difunto,\n"
                + "esta vez esta todo por el suelo como si lo hubieran revuelto en busca de algo. Junto al ataúd un codigo: 0,4,5,1");
        map.getMapa().get(new Point(2, 2)).setDescripcion("Llegas a una sala que está totalmente vacia en la que apenas se encuentra una mesa y algunas botellas de alcohol que ni siquiera sabes si tendrán algún contenido en su interior.");
        map.getMapa().get(new Point(4, 2)).setDescripcion("Justo al lado un pasillo te guía hacia una puerta helada, cuyo cartel pone: <<Dentista>> ,"
                + "gracias al plasmido entras en ella, esta muy destrozada, y los focos funcionan a duras penas, dejándote casi a oscuras.");
        map.getMapa().get(new Point(5, 2)).setDescripcion("Llegando a la recepción del lugar continua todo muy destrozado, hasta el punto de encontrar una bitacamara destrozada, pese a la gran resistencia del avanzado invento.");
        
        
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
