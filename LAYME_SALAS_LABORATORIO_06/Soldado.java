public class Soldado {
    private String nombre;
    private int vida;
    private int fila;
    private int columna;
    private String equipo;
    public Soldado(String nombre, int vida, int fila, int columna, String equipo){
        this.nombre = nombre;
        this.vida = vida;
        this.fila = fila;
        this.columna = columna;
        this.equipo = equipo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getVida() {
        return vida;
    }
    @Override
    public String toString() {
        return "Información:\nNombre: " + nombre + "\nVida: " + vida + "\nFila: " + fila + "\nColumna: " + columna;
    }
}
