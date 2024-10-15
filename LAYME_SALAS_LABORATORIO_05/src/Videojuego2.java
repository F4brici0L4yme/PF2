package Laboratorio5.src;
import java.util.*;
public class Videojuego2 {
    public static void main(String[] args){
        int cantidad = (int)(Math.random()*10+1);
        Soldado[][] tablero = new Soldado[10][10];
        inicializarEjercito(cantidad, tablero);

    }
    public static void inicializarEjercito(int cantidad, Soldado[][] tablero) { // Inicializa los soldados con su nombre 
        int contadorNombreSoldado = 0; 
        while(cantidad >= 0){
            int fila = (int)(Math.random()*5+1);
            int columna = (int)(Math.random()*5+1);
            if(tablero[fila][columna] == null){ // Verifica que no haya 2 soldados en la misma posición
                tablero[fila][columna].setFila(fila);
                tablero[fila][columna].setColumna(columna);
                tablero[fila][columna].setNombre("Soldado" + contadorNombreSoldado);
                contadorNombreSoldado++;
                tablero[fila][columna].setVida((int)(Math.random()*5+1));
                cantidad--;
            }
        }
    }
    public static Soldado mostrarSoldadoMayorVida(Soldado[][] tablero){
        Soldado mayorVida = tablero[0][0];
        for(int i = 0 ; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length; i++){
                if(tablero[i][j] != null && mayorVida.getVida() < tablero[i][j].getVida())
                    mayorVida = tablero[i][j];
            }
        }
        return mayorVida;
    }
    public static double promedioVida(Soldado[][] tablero, int cantidad){
        double promedioVida = 0;
        for(int i = 0 ; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length; i++){
                if(tablero[i][j] != null)
                    promedioVida += tablero[i][j].getVida();
            }
        }
        promedioVida/=cantidad;
        return promedioVida;
    }
    public static double promedioVida(Soldado[][] tablero){
        double ejercitoTotalVida = 0;
        for(int i = 0 ; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length; i++){
                if(tablero[i][j] != null)
                ejercitoTotalVida += tablero[i][j].getVida();
            }
        }
        return ejercitoTotalVida;
    }
    public static Soldado[] rankingDePoder(Soldado[][] tablero, int cantidad) {
        Soldado[] soldadosOrdenados = new Soldado[cantidad];
        int index = 0; 
        while(cantidad >= 0){
            for(int i = 0; i<tablero.length; i++){
                for(int j = 0; j<tablero[i].length; i++){
                    if(tablero[i][j] != null){
                        soldadosOrdenados[index] = tablero[i][j];
                    }
                }
            }
        }
        boolean intercambio = true;
        while (intercambio) {
            intercambio = false;  // LO MANTIENE FALSO HASTA QUE SE HAYA UN INTERCAMBIO, SINO SE SALE DEL BUCLE
            for (int i = 0; i < soldadosOrdenados.length - 1; i++)
                if (soldadosOrdenados[i].getVida() > soldadosOrdenados[i + 1].getVida()) {
                    intercambio = true;
                    Soldado temp = new Soldado(); //VARIABLE TEMPORAL PARA EL INTERCAMBIO
                    temp = soldadosOrdenados[i + 1];
                    soldadosOrdenados[i + 1] = soldadosOrdenados[i];
                    soldadosOrdenados[i] = temp;
                }
        }
        return soldadosOrdenados;
    }
    public static void ordenarPorPuntosSeleccion(Soldado[][] tablero, int cantidad) {
        Soldado[] soldadosOrdenados = new Soldado[cantidad];
        int index = 0; 
        while(cantidad >= 0){
            for(int i = 0; i<tablero.length; i++){
                for(int j = 0; j<tablero[i].length; i++){
                    if(tablero[i][j] != null){
                        soldadosOrdenados[index] = tablero[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < soldadosOrdenados.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < soldadosOrdenados.length; j++) {
                if (soldadosOrdenados[j].getVida() < soldadosOrdenados[menor].getVida()) {
                    menor = j; // Almacena la posición del menor
                }
            }
            // Intercambio de elementos
            Soldado temp = soldadosOrdenados[menor];
            soldadosOrdenados[menor] = soldadosOrdenados[i];
            soldadosOrdenados[i] = temp;
        }
    }
}
