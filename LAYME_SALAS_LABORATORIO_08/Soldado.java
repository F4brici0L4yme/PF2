public class Soldado {
    private String nombre;
    private int vida;
    private String filaYcolumna;
    private String equipo;
    public Soldado(String nombre, int vida, String filaYcolumna, String equipo){ // CONSTRUCTOR PARA EVITAR MUCHOS MÉTODOS
        this.nombre = nombre;
        this.vida = vida;
        this.filaYcolumna = filaYcolumna;
        this.equipo = equipo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getVida() {
        return vida;
    }
    public String getEquipo() {
        return equipo;
    }
    public String toString() {
        return "Nombre: " + nombre + " | Vida: " + vida + " | Fila y Columna: " + filaYcolumna;
    }
    public void setNombre(String next) {
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }
}