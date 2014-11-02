package Items;

public class Objeto {

    String nombre;
    String tipo;
    Integer peso;
    Integer efecto;

    public Objeto() {

        nombre = "Unknown";
        tipo = "Unknown";
        peso = 0;
        efecto = 0;

    }

    public Objeto(String nombre, String tipo, Integer peso, Integer efecto) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.efecto = efecto;

    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getPeso() {
        return peso;
    }

    public Integer getEfecto() {
        return efecto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public void setEfecto(Integer efecto) {
        this.efecto = efecto;
    }

    @Override
    public String toString() {
        return this.nombre; //To change body of generated methods, choose Tools | Templates.
    }

}
