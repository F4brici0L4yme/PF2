/*Propósito: Simular un tablero 10x10*/
import java.util.*;

public class VideoJuego3 {
    public static int vidaTotalAzul = 0;
    public static int vidaTotalRojo = 0;
    public static Soldado[] soldadosUniDimensionalAzul = new Soldado[10]; // PARA NO DESPERDICIR TANTA MEMORIA ME APOYO DE UNA MATRIZ
    public static Soldado[] soldadosUniDimensionalRojo = new Soldado[10];
    public static void main(String[] args) {
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<ArrayList<Soldado>>();
        int cantidad = (int)(Math.random() * 10 + 1);
        int cantidadEnemiga = (int)(Math.random() * 10 + 1);
        for(int i = 0; i<10; i++){
            tablero.add(new ArrayList<Soldado>());
            for(int j = 0; j<10;j++){
                tablero.get(i).add(new Soldado(null, 0, 0, 0, null)); // INICIALIZA CON VALORES NULL Y 0
            }
        }
        inicializarEjercito(tablero, cantidad);
        inicializarEjercitoEnemigo(tablero, cantidadEnemiga);
        mostrarTabla(tablero);
        System.out.println("El soldado con mayor vida del ejército azul es: ");
        System.out.println("El soldado con mayor vida del ejército rojo es: ");
    }
    public static void inicializarEjercito(ArrayList<ArrayList<Soldado>> tablero, int cantidad) { // INICIALIZA SOLDADOS CON SU INFORMACIÓN
        int contadorNombreSoldado = 0;
        while (cantidad > 0) {
            int fila = (int) (Math.random() * 10);
            int columna = (int) (Math.random() * 10);
            if (tablero.get(fila).get(columna).getVida() == 0) { // SE VERIFICA QUE NO HAYA OTRO SOLDADO EN ESA POSICIÓN, SI LO HAY, BUSCA OTRA
                tablero.get(fila).set(columna, new Soldado("\u001B[44mSoldado"+fila+"X"+columna + "\u001B[0m", (int) (Math.random() * 5 + 1), fila, columna, "azul"));  //USÉ COLORES PARA LA DISTINCIÓN ENTRE SOLDADOS
                soldadosUniDimensionalAzul[contadorNombreSoldado] = tablero.get(fila).get(columna);
                contadorNombreSoldado++;
                cantidad--;
                vidaTotalAzul += tablero.get(fila).get(columna).getVida();
            }
        }
    }
    public static void inicializarEjercitoEnemigo(ArrayList<ArrayList<Soldado>> tablero, int cantidad) { // INICIALIZA SOLDADOS CON SU INFORMACIÓN
        int contadorNombreSoldado = 0;
        while (cantidad > 0) {
            int fila = (int) (Math.random() * 10);
            int columna = (int) (Math.random() * 10);
            if (tablero.get(fila).get(columna).getVida() == 0) { // SE VERIFICA QUE NO HAYA OTRO SOLDADO EN ESA POSICIÓN, SI LO HAY, BUSCA OTRA
                tablero.get(fila).set(columna, new Soldado("\u001B[41mSoldado"+fila+"X"+columna + "\u001B[0m", (int) (Math.random() * 5 + 1), fila, columna, "rojo")); //USÉ COLORES PARA LA DISTINCIÓN ENTRE SOLDADOS
                soldadosUniDimensionalRojo[contadorNombreSoldado] = tablero.get(fila).get(columna);
                contadorNombreSoldado++;
                cantidad--;
                vidaTotalRojo += tablero.get(fila).get(columna).getVida();
            }
        }
    }
    public static void mostrarTabla(ArrayList<ArrayList<Soldado>> tablero) {  // GENERA A BASE DE | Y _ UN TABLA PARA LOS SOLDADOS
        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                if (tablero.get(i).get(j).getVida() == 0) { // GENERA ESPACIOS VACÍOS SI NO HAY UN OBJETO EN ESA DIRECCIÓN
                    System.out.print("|__________");
                } else {
                    System.out.print("|" + tablero.get(i).get(j).getNombre());  // CARGA EL NOMBRE DEL SOLDADO SI EXISTE
                }
            }
            System.out.println("|"); // ACOMODA EL TABLERO 10X10
        }
    }
    // public static Soldado mostrarSoldadoMayorVida(ArrayList<ArrayList<Soldado>> tablero) { // MUESTRA AL SOLDADO CON MAYOR VIDA
    //     Soldado mayorVidaAzul = tablero.get(0).get(0);                             // TRABAJA EN LA MATRIZ BIDIMENSIONAL
    //     Soldado mayorVidaRojo = tablero.get(0).get(0);
    //     for (int i = 0; i < tablero.size(); i++) {
    //         for (int j = 0; j < tablero.get(i).size(); j++) {
    //             if (tablero.get(i).get(j).getVida() != 0) {
    //                 if (mayorVida.getVida() < tablero.get(i).get(j).getVida()) {
    //                     mayorVida = tablero.get(i).get(j);
    //                 }
    //             }
    //         }
    //     }
    //     return mayorVida;
    // }

    public static double promedioVida(ArrayList<ArrayList<Soldado>> tablero, int cantidad) { //MUESTRA EL PROMEDIO DE VIDA TRBAJA EN LA
        double promedioVida = 0;                                            // MATRIZ BIDIMENSIONAL
        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                if (tablero.get(i).get(j).getVida() != 0)
                    promedioVida += tablero.get(i).get(j).getVida();
            }
        }
        promedioVida /= cantidad;
        return promedioVida;
    }
}
