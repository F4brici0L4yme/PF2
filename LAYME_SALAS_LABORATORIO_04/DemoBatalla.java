import java.util.*;
public class DemoBatalla {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[4];
        String nomb, col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) {
            // System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            // System.out.println("Fila ");
            // fil = sc.nextInt();
            // System.out.print("Columna: ");
            // col = sc.next();
            // System.out.print("Estado: ");
            // est = sc.nextBoolean();
            // System.out.print("Puntos: ");
            // punt = sc.nextInt();
            misNaves[i] = new Nave();
            misNaves[i].setNombre(nomb);
            // misNaves[i].setFila(fil);
            // misNaves[i].setColumna(col);
            // misNaves[i].setEstado(est);
            // misNaves[i].setPuntos(punt);
        }
//         System.out.println("\nNaves creadas:");
//         mostrarNaves(misNaves);
//         mostrarPorNombre(misNaves);
//         mostrarPorPuntos(misNaves);
//         System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
//         System.out.println("Ingresa un nombre de una nave para realizar una búsqueda: ");
//         String nombre = sc.next();
//         int pos = busquedaLinealNombre(misNaves, nombre);
//         if(pos != -1){
//             System.out.println("INFORMACIÓN: " + misNaves[pos].toString());
//         }
//         else
//             System.out.println("¡ERROR! No se encontró una nave con ese nombre");
        // System.out.println("ORDENAMIENTO POR PUNTOS: ");
        // ordenarPorPuntosBurbuja(misNaves);
        // mostrarNaves(misNaves);
        System.out.println("ORDENAMIENTO POR NOMBRE: ");
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);
//         // mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en
//         // caso contrario
//         pos = busquedaBinariaNombre(misNaves, nombre);
//         ordenarPorPuntosSeleccion(misNaves);
//         mostrarNaves(misNaves);
//         ordenarPorNombreSeleccion(misNaves);
//         mostrarNaves(misNaves);
//         ordenarPorPuntosInsercion(misNaves);
//         mostrarNaves(misNaves);
//         ordenarPorNombreInsercion(misNaves);
//         mostrarNaves(misNaves);
    }

    public static void mostrarNaves(Nave[] var0) {
        for(int var1 = 0; var1 < var0.length; ++var1) {
           System.out.println("NAVE " + (var1 + 1) + ":");
           System.out.println(var0[var1].toString());
        }
     }
//     public static void mostrarPorNombre(Nave[] var0) {
//         System.out.println("Ingrese el nombre de las naves que desea mostrar:");
//         String var1 = sc.next();
  
//         for(int var2 = 0; var2 < var0.length; ++var2) {
//            if (var0[var2].getNombre().equals(var1)) {
//               System.out.println("Nave " + (var2 + 1));
//               System.out.println(var0[var2].toString());
//            }
//         }
  
//      }

//     public static void mostrarPorPuntos(Nave[] var0) {
//         System.out.println("Ingrese una cantidad de puntos, se mostrar\u00c3\u00a1 las naves que tengan menor o igual puntaje: ");
//         int var1 = sc.nextInt();
//         for(int var2 = 0; var2 < var0.length; ++var2) 
//            if (var0[var2].getPuntos() == var1 || var0[var2].getPuntos() < var1) {
//               System.out.println("NAVE " + (var2 + 1) + ":\n");
//               System.out.println(var0[var2].toString());
//            }
//      }

//    public static Nave mostrarMayorPuntos(Nave[] var0) {
//       Nave var1 = var0[0];
//       for(int var2 = 1; var2 < var0.length; ++var2) {
//          if (var0[var2].getPuntos() > var1.getPuntos()) {
//             var1 = var0[var2];
//          }
//       }
//       return var1;
//    }

//     // Método para buscar la primera nave con un nombre que se pidió por teclado
//     public static int busquedaLinealNombre(Nave[] flota, String s) {
//         for(int i = 0; i<flota.length; i++){
//             if(flota[i].getNombre().equals(s))
//                 return i;
//         }
//         return -1;
//     }

    // public static void ordenarPorPuntosBurbuja(Nave[] flota) {
    //     boolean intercambio = true;
    //     while(intercambio){
    //         intercambio = false;
    //         for(int i = 0; i<flota.length-1; i++)
    //             if(flota[i].getPuntos()>flota[i+1].getPuntos()){
    //                 intercambio = true;
    //                 Nave temp = new Nave();
    //                 temp = flota[i+1];
    //                 flota[i+1] = flota[i];
    //                 flota[i] = temp;
    //             }
    //     }
    // }
    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        boolean intercambio = true;
        while(intercambio){
            intercambio = false;
            for(int i = 0; i<flota.length-1; i++){
                if(flota[i].getNombre().compareTo(flota[i+1].getNombre())>0)
                    intercambio = true;
                    Nave temp = new Nave();
                    temp = flota[i+1];
                    flota[i+1] = flota[i];
                    flota[i] = temp;
            }
        }
    }

    // Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaBinariaNombre(Nave[] flota, String s) {
        return 1;
    }

    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
    }

    // Método que ordena por nombre de A a Z
    public static void ordenarPorNombreSeleccion(Nave[] flota) {
    }

    // Método que muestra las naves ordenadas por número de puntos de mayor a menor
    public static void ordenarPorPuntosInsercion(Nave[] flota) {
    }

    // Método que muestra las naves ordenadas por nombre de Z a A
    public static void ordenarPorNombreInsercion(Nave[] flota) {
    }
}