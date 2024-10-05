/*Propósito: Simular una guerra entre 2 ejércitos */
public class Ejercicio5PC2v2 {
    public static void main(String[] args) {
        String[] ejercito1 = inicializarEjercito((int) (Math.random() * 5 + 1)); // Inicializa con el parámetro de cantidad de soldados
        String[] ejercito2 = inicializarEjercito((int) (Math.random() * 5 + 1));
        mostrarEjercito(ejercito1, 1);
        mostrarEjercito(ejercito2, 2);
        mostrarGanador(ejercito1, ejercito2);
    }
    public static String[] inicializarEjercito(int cantidad) { // Inicializa los soldados con su nombre 
        String[] ejercito = new String[cantidad];
        for (int i = 0; i < ejercito.length; i++)
            ejercito[i] = "Soldado" + i;
        return ejercito;
    }
    public static void mostrarEjercito(String[] ejercito, int tipo) { // Muestra los soldados de un ejército
        System.out.println("\nEjercito " + tipo + ": ");
        for (int i = 0; i < ejercito.length; i++)
            System.out.println(ejercito[i]);
    }
    public static void mostrarGanador(String[] ejercito1, String[] ejercito2) { // Muestra los resultados del juego
        if (ejercito1.length > ejercito2.length)
            System.out.println("\n¡¡¡Gana el ejercito 1 con " + ejercito1.length + " soldados!!!");
        else if (ejercito1.length < ejercito2.length)
            System.out.println("\n¡¡¡Gana el ejercito 2 con " + ejercito2.length + " soldados!!!");
        else
            System.out.println("\n¡¡¡Empatan los ejercitos con " + ejercito1.length + " soldados!!!");
    }
}
