public class Soldado {
    private String nombre;
    private int vida;
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
    public String toString() {
        return "Nombre: " + nombre + "\nNivel de vida: " + vida;
    }
}
