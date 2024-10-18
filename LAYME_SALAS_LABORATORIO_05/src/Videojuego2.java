package Laboratorio5.src;
import java.util.*;
public class Videojuego2 {
    public static int vidaTotal = 0;
    public static Soldado[] soldadosUniDimensional = new Soldado[10]; // PARA NO DESPERDICIR TANTA MEMORIA ME APOYO DE UNA MATRIZ
                                                                    // UNIDIMENSIONAL PARA LOS ORDENAMIENTOS
    public static void main(String[] args) {
        int cantidad = (int) (Math.random() * 10 + 1);
        Soldado[][] tablero = new Soldado[10][10];
        mostrarTabla(tablero);                          // MUESTRA LA TABLA VACÍA
        System.out.println(); 
        inicializarEjercito(cantidad, tablero);         // GENERA A LOS SOLDADOS
        mostrarTabla(tablero);                          // MUESTRA LA TABLA CON NOMBRES DE SOLDADOS EN SUS POSICIONES
        System.out.println("¡¡El soldado con mayor cantidad de vida es el " + mostrarSoldadoMayorVida(tablero).getNombre() + " con " + mostrarSoldadoMayorVida(tablero).getVida() + " puntos de vida!!");
        System.out.println("El promedio del nivel de vida de los soldados es: " + promedioVida(tablero, cantidad));
        System.out.println("El nivel de vida de todo el ejercito es: " + vidaTotal);
        System.out.println("Soldado en el orden que fueron creados");
        imprimirInformacion(cantidad);              //IMPRIME CON EL toString LA INFORMACIÓN DE LOS SOLDADOS DESORDENADOS
        ordenarPorPuntosSeleccion(cantidad);               //ORDENA LA MATRIZ GLOBAL (BURBUJA)
        rankingDePoder(cantidad);                           // TAMBIÉN ORDENA LA MATRIZ GLOBAL (SELECCIÓN)
        System.out.println("Soldado por ranking de poder: ");
        imprimirInformacion(cantidad);              // IMPRIME CON EL toString LA INFROMACIÓN ORDENADA DESCENDENTEMENTE
    }

    public static void inicializarEjercito(int cantidad, Soldado[][] tablero) { // INICIALIZA SOLDADOS CON SU INFORMACIÓN
        int contadorNombreSoldado = 0;
        while (cantidad > 0) {
            int fila = (int) (Math.random() * 10);  
            int columna = (int) (Math.random() * 10);
            if (tablero[fila][columna] == null) { // SE VERIFICA QUE NO HAYA OTRO SOLDADO EN ESA POSICIÓN, SI LO HAY, BUSCA OTRA
                tablero[fila][columna] = new Soldado(); // CREA UNA NUEVA DIRECCIÓN DEL OBJETO SOLDADO
                tablero[fila][columna].setFila(fila);
                tablero[fila][columna].setColumna(columna);
                tablero[fila][columna].setNombre("Soldado" + contadorNombreSoldado);
                tablero[fila][columna].setVida((int) (Math.random() * 5 + 1));
                soldadosUniDimensional[contadorNombreSoldado] = tablero[fila][columna];
                contadorNombreSoldado++;
                cantidad--;
                vidaTotal += tablero[fila][columna].getVida();
            }
        }
    }
    public static void mostrarTabla(Soldado[][] tablero) {  // GENERA A BASE DE | Y _ UN TABLA PARA LOS SOLDADOS
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("|________");  // GENERA ESPACIOS VACÍOS SI NO HAY UN OBJETO EN ESA DIRECCIÓN
                } else {
                    System.out.print("|" + tablero[i][j].getNombre());  // CARGA EL NOMBRE DEL SOLDADO SI EXISTE
                }
            }
            System.out.println("|"); //ACOMODA EL TABLERO 10X10
        }
    }

    public static Soldado mostrarSoldadoMayorVida(Soldado[][] tablero) { // MUESTRA AL SOLDADO CON MAYOR VIDA
        Soldado mayorVida = null;                                           // TRABAJA EN LA MATRIZ BIDIMENSIONAL
        for (int i = 0; i < tablero.length; i++) {  
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    if (mayorVida == null || mayorVida.getVida() < tablero[i][j].getVida()) {
                        mayorVida = tablero[i][j];
                    }
                }
            }
        }
        return mayorVida;
    }

    public static double promedioVida(Soldado[][] tablero, int cantidad) { //MUESTRA EL PROMEDIO DE VIDA TRBAJA EN LA
        double promedioVida = 0;                                            // MATRIZ BIDIMENSIONAL
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null)
                    promedioVida += tablero[i][j].getVida();
            }
        }
        promedioVida /= cantidad;
        return promedioVida;
    }
    public static Soldado[] rankingDePoder(int cantidad) { //PRIMER ALGORITMO DE ORDENAMIENTO (BURBUJA)
        boolean intercambio = true;
        while (intercambio) {
            intercambio = false;  // LO MANTIENE FALSO HASTA QUE SE HAYA UN INTERCAMBIO, SINO SE SALE DEL BUCLE
            for (int i = 0; i < cantidad - 1; i++)
                if (soldadosUniDimensional[i].getVida() < soldadosUniDimensional[i + 1].getVida()) {
                    intercambio = true;
                    Soldado temp = new Soldado(); //VARIABLE TEMPORAL PARA EL INTERCAMBIO
                    temp = soldadosUniDimensional[i + 1];
                    soldadosUniDimensional[i + 1] = soldadosUniDimensional[i];
                    soldadosUniDimensional[i] = temp;
                }
        }
        return soldadosUniDimensional;
    }

    public static void ordenarPorPuntosSeleccion(int cantidad) { // 2DO ALGORITMO DE ORDENAMIENTO
        for (int i = 0; i < cantidad - 1; i++) { //SE USA LA CANTIDAD PARA EVITAR QUE EL BUCLE SEÑALE A OBJETOS NULL
            int menor = i;
            for (int j = i + 1; j < cantidad; j++) {
                if (soldadosUniDimensional[j].getVida() > soldadosUniDimensional[menor].getVida()) {
                    menor = j; // Almacena la posición del menor
                }
            }
            // Intercambio de elementos
            Soldado temp = soldadosUniDimensional[menor];
            soldadosUniDimensional[menor] = soldadosUniDimensional[i];
            soldadosUniDimensional[i] = temp;
        }
    }
    public static void imprimirInformacion(int cantidad){
        for(int i = 0; i<cantidad; i++){
            System.out.println("SOLDADO " + i + ":");
            System.out.println(soldadosUniDimensional[i].toString()); //ME APOYO DE UNA MATRIZ UNIDIMENSIONAL PARA NO
        }                                                               // DESPERDICIAR MEMORIA
    }
}
