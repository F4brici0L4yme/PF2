import java.util.*;
public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        for (int i = array.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}