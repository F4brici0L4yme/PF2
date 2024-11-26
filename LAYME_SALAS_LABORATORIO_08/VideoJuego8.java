/*Propósito: Simular el tablero de ejércitos usando HashMap*/
import java.util.*;

public class VideoJuego8 {
    public static int vidaTotalAzul = 0;
    public static int vidaTotalRojo = 0;
    public static Soldado mayorVidaAzul = new Soldado(null, 0, null, null);
    public static Soldado mayorVidaRojo = new Soldado(null, 0, null, null);
    public static Soldado[] soldadosUniDimensionalAzul = new Soldado[10];
    public static Soldado[] soldadosUniDimensionalRojo = new Soldado[10];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean seguir = true;

        HashMap<String, Soldado> tablero = new HashMap<>();
        while (seguir) {
            System.out.println("¿Desea ejecutar el programa? (s/n)");
            String rpta = scan.next();
            if (rpta.equals("s")) {
                iniciarPrograma(tablero);
                tablero.clear(); /*Nuevo comando, clear() para reiniciar los HashMaps que utilizo */
                vidaTotalAzul = 0;
                vidaTotalRojo = 0;
                mayorVidaAzul = new Soldado(null, 0, null, null); /*Nueva estructura de constructor*/
                mayorVidaRojo = new Soldado(null, 0, null, null); /*Por el uso de HashMap */
                soldadosUniDimensionalAzul = new Soldado[10];
                soldadosUniDimensionalRojo = new Soldado[10];
            } else if (rpta.equals("n"))
                seguir = false;
            else
                System.out.println("Esa no es una opción válida");
        }
    }

    public static void iniciarPrograma(HashMap<String, Soldado> tablero) {
        int cantidad = (int) (Math.random()*10+1);
        int cantidadEnemiga = (int) (Math.random()*10+1);

        inicializarEjercito(tablero, cantidad, "\u001B[44mSoldado", "azul");
        inicializarEjercito(tablero, cantidadEnemiga, "\u001B[41mSoldado", "rojo");

        mostrarTabla(tablero);
        hallarSoldadoMayorVida(tablero);

        System.out.println("El soldado con mayor vida del ejército azul es: " + mayorVidaAzul);
        System.out.println("El soldado con mayor vida del ejército rojo es: " + mayorVidaRojo);
        System.out.println("El promedio del ejército azul es: " + vidaTotalAzul/cantidad);
        System.out.println("El promedio del ejército rojo es: " + vidaTotalRojo/cantidadEnemiga);

        System.out.println("DATOS DEL EJÉRCITO AZUL POR ORDEN DE INGRESO:");
        imprimirInformacion(cantidad, soldadosUniDimensionalAzul);
        System.out.println("DATOS DEL EJÉRCITO ROJO POR ORDEN DE INGRESO:");
        imprimirInformacion(cantidadEnemiga, soldadosUniDimensionalRojo);

        rankingDePoder(cantidad, soldadosUniDimensionalAzul);
        ordenarSeleccion(cantidadEnemiga, soldadosUniDimensionalRojo);

        System.out.println("DATOS DEL EJÉRCITO AZUL ORDENADO POR NIVEL DE VIDA:");
        imprimirInformacion(cantidad, soldadosUniDimensionalAzul);
        System.out.println("DATOS DEL EJÉRCITO ROJO ORDENADO POR NIVEL DE VIDA:");
        imprimirInformacion(cantidadEnemiga, soldadosUniDimensionalRojo);

        mostrarGanador();
    }

    public static void inicializarEjercito(HashMap<String, Soldado> tablero, int cantidad, String color, String equipo) {
        int contadorIndiceSoldadoAzul = 0;
        int contadorIndiceSoldadoRojo = 0;

        while (cantidad > 0) {
            String key = (int) (Math.random()*10) + "X" + (int) (Math.random()*10); /*Ahora uso keys para la posición y nombre */

            if (!tablero.containsKey(key)) {
                Soldado soldado = new Soldado(color + key + "\u001B[0m", (int) (Math.random()*5+1), key, equipo);
                tablero.put(key, soldado); /*Cambio al método put() para insertar los Soldados */
                cantidad--;

                if (equipo.equals("azul")) {
                    vidaTotalAzul += soldado.getVida();
                    soldadosUniDimensionalAzul[contadorIndiceSoldadoAzul] = soldado;
                    contadorIndiceSoldadoAzul++;
                } else {
                    vidaTotalRojo += soldado.getVida();
                    soldadosUniDimensionalRojo[contadorIndiceSoldadoRojo] = soldado;
                    contadorIndiceSoldadoRojo++;
                }
            }
        }
    }

    public static void mostrarTabla(HashMap<String, Soldado> tablero) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String key = i + "X" + j;
                if (tablero.containsKey(key)) /*Verifica la existencia de la key en HashMap */
                    System.out.print("|" + tablero.get(key).getNombre()); /*Retorna el nombre del Soldado */
                else
                    System.out.print("|__________");
            }
            System.out.println("|");
        }
    }

    public static void hallarSoldadoMayorVida(HashMap<String, Soldado> tablero) {
        for (Soldado soldado : tablero.values()) { /*Itera solo en los Soldados del HashMap */
            if (soldado.getEquipo().equals("azul") && soldado.getVida() > mayorVidaAzul.getVida())
                mayorVidaAzul = soldado;
            if (soldado.getEquipo().equals("rojo") && soldado.getVida() > mayorVidaRojo.getVida())
                mayorVidaRojo = soldado;
        }
    }

    public static void rankingDePoder(int cantidad, Soldado[] soldadosUniDimensional) {
        boolean intercambio = true;
        while (intercambio) {
            intercambio = false;
            for (int i = 0; i < cantidad - 1; i++)
                if (soldadosUniDimensional[i].getVida() < soldadosUniDimensional[i + 1].getVida()) {
                    intercambio = true;
                    Soldado temp = new Soldado(null, 0, null, null);
                    temp = soldadosUniDimensional[i + 1];
                    soldadosUniDimensional[i + 1] = soldadosUniDimensional[i];
                    soldadosUniDimensional[i] = temp;
                }
        }
    }

    public static void ordenarSeleccion(int cantidad, Soldado[] soldadosUniDimensional) {
        for (int i = 0; i < cantidad-1; i++) {
            int menor = i;
            for (int j = i + 1; j < cantidad; j++)
                if (soldadosUniDimensional[j].getVida() > soldadosUniDimensional[menor].getVida())
                    menor = j;
            Soldado temp = soldadosUniDimensional[menor];
            soldadosUniDimensional[menor] = soldadosUniDimensional[i];
            soldadosUniDimensional[i] = temp;
        }
    }

    public static void imprimirInformacion(int cantidad, Soldado[] soldadosUniDimensional) {
        for (int i = 0; i < cantidad; i++) {
            System.out.println("SOLDADO " + i + ":");
            System.out.println(soldadosUniDimensional[i].toString());
        }
    }

    public static void mostrarGanador() {
        if (vidaTotalAzul > vidaTotalRojo) /*Gana quien tiene mayor vida en todo el ejército */
            System.out.println("¡El ejercito azul gana por mayor nivel de vida! " + "\nAzul " + vidaTotalAzul + ":" + vidaTotalRojo + " Rojo");
        else if (vidaTotalAzul < vidaTotalRojo)
            System.out.println("¡El ejercito rojo gana por mayor nivel de vida! " + "\nAzul " + vidaTotalAzul + ":" + vidaTotalRojo + " Rojo");
        else
            System.out.println("¡Ha ocurrido un empate! " + "\nAzul " + vidaTotalAzul + ":" + vidaTotalRojo + " Rojo");
    }
}