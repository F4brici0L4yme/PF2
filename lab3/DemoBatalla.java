import java.util.*;

public class DemoBatalla {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[2];
        String nomb, col;
        int fil, punt;
        boolean est;

        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("NAVE " + (i + 1) + ":");
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.println("Fila ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();

            misNaves[i] = new Nave(); // Se crea un objeto Nave y se asigna su referencia a misNaves

            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }

        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves);
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos: \n" + mostrarMayorPuntos(misNaves));
        Nave[] misNavesDesordenadas = new Nave[2];
        System.out.println(misNavesDesordenadas);
        System.out.println("Naves desordenadas: ");
        for(int i = 0; i<misNavesDesordenadas.length; i++)
            System.out.println(misNavesDesordenadas[i].toString());
    }

    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for(int i = 0; i<flota.length; i++){
            System.out.println("Nave: " + (i+1));
            flota[0].toString();
        }
    }

    // Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota) {
        System.out.println("Ingrese el nombre de las naves que desea mostrar:");
        String nombreNave = sc.next();
        for(int i = 0; i<flota.length; i++){
            if(flota[i].getNombre().equals(nombreNave)){
                System.out.println("Nave " + (i+1));
                System.out.println(flota[i].toString());
            }
        }
    }

    // Método para mostrar todas las naves con un número de puntos inferior o igual
    // al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota) {
        System.out.println("Ingrese una cantidad de puntos, se mostrará las naves que tengan menor o igual puntaje: ");
        int puntosNave = sc.nextInt();
        for(int i = 0; i<flota.length; i++){
            if(flota[i].getPuntos() == puntosNave){
                System.out.println("Nave " + (i+1));
                System.out.println(flota[i].toString());
            }
        }
    }
    // Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        Nave naveMayorPuntaje = flota[0];
        for(int i = 1; i<flota.length; i++){
            if(flota[i].getPuntos() > naveMayorPuntaje.getPuntos())
                naveMayorPuntaje = flota[i];
        }
        return naveMayorPuntaje;
    }
    public static Nave[] navesDesordenadas(Nave[] flota, Nave[] misNavesDesordenadas){
        System.arraycopy(flota, 0, misNavesDesordenadas, 0, flota.length);
        for (int indexOriginal = misNavesDesordenadas.length - 1; indexOriginal > 0; indexOriginal--) {
            int indexIntercambio = (int)(Math.random() * (indexOriginal + 1));
            Nave temp = misNavesDesordenadas[indexOriginal];
            misNavesDesordenadas[indexOriginal] = misNavesDesordenadas[indexIntercambio];
            misNavesDesordenadas[indexIntercambio] = temp;
        }
        return misNavesDesordenadas;
    }
}