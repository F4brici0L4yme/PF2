/*Propósito: Inicializar soldados */
import java.util.*;
public class Ejercicio4PC1v2 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        Soldado[] soldados = new Soldado[5];
        for(int i = 0; i<soldados.length; i++){
            Soldado persona = new Soldado(); // Creción de objetos dentro del array
            System.out.println("Ingrese el nombre del soldado " + (i+1));
            persona.setNombre(scan.next());
            System.out.println("Ingrese el nivel de vida ");
            persona.setVida(scan.nextInt());
            soldados[i] = persona; // Completar la inicialización
        }
        imprimirSoldados(soldados);
    }
    public static void imprimirSoldados(Soldado[] soldados){ // Imprime los datos de los soldados
        for(int i = 0; i<soldados.length; i++){
            System.out.println("Soldado "+ (i+1) + ":");
            System.out.println(soldados[i].toString());
        }
    }
}
