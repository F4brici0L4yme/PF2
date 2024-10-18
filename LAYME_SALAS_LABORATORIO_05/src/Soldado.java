package Laboratorio5.src;

public class Soldado {
    private String nombre;
    private int vida;
    private int fila;
    private int columna;
    public void setColumna(int columna) {
        this.columna = columna;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setVida(int vida) {
        this.vida = vida;
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
