/*Propósito: Recrear un DemoBatalla con ordenamientos en naves de diferentes formas */
import java.util.*;
public class DemoBatalla {
    public static Scanner sc = new Scanner(System.in); //VARIABLE GLOBAL DE SCANNER
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[4];
        String nomb, col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) { //GENERACIÓN DE NAVES
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();
            misNaves[i] = new Nave();
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);                     // MUESTRA LA INFORMACIÓN DE LAS NAVES COMO SE INGRESARON
        mostrarPorNombre(misNaves);                 // MUESTRA LA INFORMACIÓN DE LA O LAS NAVES CON EL NOMBRE INGRESADO (en función)
        mostrarPorPuntos(misNaves);                 // MUESTRA LA INFORMACIÓN DE LA O LAS NAVES CON IGUAL O MENOR PUNTAJE INGRESADO (en función)
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves)); //MUESTRA LA NAVE CON MAYOR PUNTAJE
        System.out.println("Ingresa un nombre de una nave para realizar una búsqueda: ");
        String nombre = sc.next();
        int pos = busquedaLinealNombre(misNaves, nombre); // REGISTRA LA POSICIÓN DE LA NAVE QUE SE QUIERE BUSCAR
        if (pos != -1)                                    // IMPRIME SU INFORMACIÓN SI ES DIFERENTE DE -1 
            System.out.println("INFORMACIÓN: " + misNaves[pos].toString());
        else
            System.out.println("¡ERROR! No se encontró una nave con ese nombre");
        System.out.println("ORDENAMIENTO POR PUNTOS: "); 
        ordenarPorPuntosBurbuja(misNaves);              // ORDENAMIENTO POR PUNTOS CON MÉTODO BURBUJA
        mostrarNaves(misNaves);
        System.out.println("ORDENAMIENTO POR NOMBRE: "); 
        ordenarPorNombreBurbuja(misNaves); // ORDENAMIENTO POR ORDEN ALFABÉTICO CON MÉTODO BURBUJA
        mostrarNaves(misNaves);
        System.out.print("Ingrese un nombre de nave para realizar un búsqueda binaria: ");
        String nombreBinaria = sc.next();
        pos = busquedaBinariaNombre(misNaves, nombreBinaria); // ALMACENA LA POSICIÓN DE LA NAVE BUSCADA
        if (pos != -1)                                    // IMPRIME SU INFORMACIÓN SI ES DIFERENTE DE -1 
            System.out.println(misNaves[pos].toString());
        else
            System.out.println("ERROR, NOMBRE NO ENCONTRADO");
        ordenarPorPuntosSeleccion(misNaves); // ORDENA POR PUNTOS CON EL MÉTODO DE SELECCIÓN
        mostrarNaves(misNaves);             // ORDENA POR PUNTOS CON EL MÉTODO DE SELECCIÓN
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);             // ORDENA POR ORDEN ALFABÉTICO  CON EL MÉTODO DE SELECCIÓN
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);             // ORDENA POR PUNTOS CON EL MÉTODO DE INSERCIÓN
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);             // ORDENA POR ORDEN ALFABÉTICO CON EL MÉTODO DE INSERCIÓN
    }
    public static void mostrarNaves(Nave[] var0) {
        for (int var1 = 0; var1 < var0.length; ++var1) {
            System.out.println("NAVE " + (var1 + 1) + ":");
            System.out.println(var0[var1].toString()); //SE MUESTRA LA INFORMACIÓN CON EL toString DE LA CLASE NAVE
        }
    }
    public static void mostrarPorNombre(Nave[] var0) {
        System.out.println("Ingrese el nombre de las naves que desea mostrar:");
        String var1 = sc.next();
        for (int var2 = 0; var2 < var0.length; ++var2) { 
            if (var0[var2].getNombre().equals(var1)) { // CONDICIÓN PARA SOLO IMPRIMIR LAS NAVES CON IGUAL NOMBRE
                System.out.println("Nave " + (var2 + 1));
                System.out.println(var0[var2].toString());
            }
        }

    }

    public static void mostrarPorPuntos(Nave[] var0) {
        System.out.println(
                "Ingrese una cantidad de puntos, se mostrar\u00c3\u00a1 las naves que tengan menor o igual puntaje: ");
        int var1 = sc.nextInt();
        for (int var2 = 0; var2 < var0.length; ++var2)
            if (var0[var2].getPuntos() == var1 || var0[var2].getPuntos() < var1) { // CONDICIPON PARA IMPRIMIR SOLO LAS NAVES CON IGUAL O MENOR PUNTAJE
                System.out.println("NAVE " + (var2 + 1) + ":\n");
                System.out.println(var0[var2].toString());
            }
    }

    public static Nave mostrarMayorPuntos(Nave[] var0) {
        Nave var1 = var0[0];
        for (int var2 = 1; var2 < var0.length; ++var2) {
            if (var0[var2].getPuntos() > var1.getPuntos()) {
                var1 = var0[var2];                      // VA ALMACENANDO LA NAVE CON MAYOR PUNTAJE
            }
        }
        return var1;
    }

    public static int busquedaLinealNombre(Nave[] flota, String s) {
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getNombre().equals(s)) //CUANDO ENCUENTRA LA POSICIÓN DE LA NAVE CON EL NOMBRE INGRESADO RETORNA SU POSICIÓN
                return i;
        }
        return -1;
    }

    public static void ordenarPorPuntosBurbuja(Nave[] flota) {
        boolean intercambio = true;
        while (intercambio) {
            intercambio = false;  // LO MANTIENE FALSO HASTA QUE SE HAYA UN INTERCAMBIO, SINO SE SALE DEL BUCLE
            for (int i = 0; i < flota.length - 1; i++)
                if (flota[i].getPuntos() > flota[i + 1].getPuntos()) {
                    intercambio = true;
                    Nave temp = new Nave(); //VARIABLE TEMPORAL PARA EL INTERCAMBIO
                    temp = flota[i + 1];
                    flota[i + 1] = flota[i];
                    flota[i] = temp;
                }
        }
    }

    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        boolean intercambio = true;
        while (intercambio) {
            intercambio = false; 
            for (int i = 0; i < flota.length - 1; i++) {
                if (flota[i].getNombre().compareTo(flota[i + 1].getNombre()) > 0) { // compareTo INDICA SI ES MAYOR O MENOR EN UN ORDEN ALFABÉTICO
                    intercambio = true;
                    Nave temp = new Nave();
                    temp = flota[i + 1];
                    flota[i + 1] = flota[i];
                    flota[i] = temp;
                }
            }
        }
    }

    public static int busquedaBinariaNombre(Nave[] flota, String s) {
        int baja = 0, alta = flota.length - 1;
        while (baja <= alta) {
            int media = (baja + alta) / 2;
            int comparacion = flota[media].getNombre().compareTo(s);
            if (comparacion == 0) {
                return media; // Se encontró el nombre
            } else if (comparacion < 0) {
                baja = media + 1; // Buscar en la parte derecha
            } else {
                alta = media - 1; // Buscar en la parte izquierda
            }
        }
        return -1; // No se encontró el nombre
    }

    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < flota.length; j++) {
                if (flota[j].getPuntos() < flota[menor].getPuntos()) {
                    menor = j; // Almacena la posición del menor
                }
            }
            // Intercambio de elementos
            Nave temp = flota[menor];
            flota[menor] = flota[i];
            flota[i] = temp;
        }
    }

    public static void ordenarPorNombreSeleccion(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < flota.length; j++) {
                if (flota[j].getNombre().compareTo(flota[menor].getNombre()) < 0) {
                    menor = j; // Almacena la posición del menor alfabéticamente
                }
            }
            // Intercambio de elementos
            Nave temp = flota[menor];
            flota[menor] = flota[i];
            flota[i] = temp;
        }
    }

    public static void ordenarPorPuntosInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave naveActual = flota[i]; // GUARDA LA NAVE PARA QUE NO DESAPAREZCA AL DESPLAZAR
            int j = i - 1;
            while (j >= 0 && flota[j].getPuntos() > naveActual.getPuntos()) {
                flota[j + 1] = flota[j]; // DESPLAZA TODAS LAS NAVES A LA DERECHA
                j--;
            }
            flota[j + 1] = naveActual;  // ASIGNA EL VALOR DE LA NAVE INTERCAMBIADA
        }
    }

    public static void ordenarPorNombreInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave naveActual = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j].getNombre().compareTo(naveActual.getNombre()) > 0) { // COMPARA ALFABÉTICAMENTE 
                flota[j + 1] = flota[j]; // DESPLAZA TODAS LAS NAVES A LA DERECHA
                j--; // RETROCEDE EL INDEX HASTA QUE NO CUMPLA LA CONDICIÓN
            }
            flota[j + 1] = naveActual;
        }
    }
}