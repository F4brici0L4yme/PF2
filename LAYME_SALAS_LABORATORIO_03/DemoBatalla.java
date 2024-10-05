// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class DemoBatalla {
   public static Scanner sc;

   public DemoBatalla() {
   }

   public static void main(String[] var0) {
      Nave[] var1 = new Nave[2];

      for(int var7 = 0; var7 < var1.length; ++var7) {
         System.out.println("NAVE " + (var7 + 1) + ":");
         System.out.print("Nombre: ");
         String var2 = sc.next();
         System.out.println("Fila ");
         int var4 = sc.nextInt();
         System.out.print("Columna: ");
         String var3 = sc.next();
         System.out.print("Estado: ");
         boolean var6 = sc.nextBoolean();
         System.out.print("Puntos: ");
         int var5 = sc.nextInt();
         var1[var7] = new Nave();
         var1[var7].setNombre(var2);
         var1[var7].setFila(var4);
         var1[var7].setColumna(var3);
         var1[var7].setEstado(var6);
         var1[var7].setPuntos(var5);
      }

      System.out.println("\nNaves creadas:");
      mostrarNaves(var1);
      mostrarPorNombre(var1);
      mostrarPorPuntos(var1);
      System.out.println("\nNave con mayor n\u00c3\u00bamero de puntos: \n" + mostrarMayorPuntos(var1));
      Nave[] var9 = new Nave[2];
      System.out.println(var9);
      System.out.println("Naves desordenadas: ");

      for(int var8 = 0; var8 < var9.length; ++var8) {
         System.out.println(var9[var8].toString());
      }

   }

   public static void mostrarNaves(Nave[] var0) {
      for(int var1 = 0; var1 < var0.length; ++var1) {
         System.out.println("Nave: " + (var1 + 1));
         var0[0].toString();
      }

   }

   public static void mostrarPorNombre(Nave[] var0) {
      System.out.println("Ingrese el nombre de las naves que desea mostrar:");
      String var1 = sc.next();

      for(int var2 = 0; var2 < var0.length; ++var2) {
         if (var0[var2].getNombre().equals(var1)) {
            System.out.println("Nave " + (var2 + 1));
            System.out.println(var0[var2].toString());
         }
      }

   }

   public static void mostrarPorPuntos(Nave[] var0) {
      System.out.println("Ingrese una cantidad de puntos, se mostrar\u00c3\u00a1 las naves que tengan menor o igual puntaje: ");
      int var1 = sc.nextInt();

      for(int var2 = 0; var2 < var0.length; ++var2) {
         if (var0[var2].getPuntos() == var1 || var0[var2].getPuntos() < var1) {
            System.out.println("Nave " + (var2 + 1));
            System.out.println(var0[var2].toString());
         }
      }

   }

   public static Nave mostrarMayorPuntos(Nave[] var0) {
      Nave var1 = var0[0];

      for(int var2 = 1; var2 < var0.length; ++var2) {
         if (var0[var2].getPuntos() > var1.getPuntos()) {
            var1 = var0[var2];
         }
      }

      return var1;
   }

   public static Nave[] navesDesordenadas(Nave[] var0, Nave[] var1) {
      System.arraycopy(var0, 0, var1, 0, var0.length);

      for(int var2 = var1.length - 1; var2 > 0; --var2) {
         int var3 = (int)(Math.random() * (double)(var2 + 1));
         Nave var4 = var1[var2];
         var1[var2] = var1[var3];
         var1[var3] = var4;
      }

      return var1;
   }

   static {
      sc = new Scanner(System.in);
   }
}
