package fillers;

import sorters.Sorter;
import java.util.Arrays;

public class Filler {

    // Generates a sorted array
    public static int[] generateSortedArrayAscending(int ARRAY_LENGTH) {
        int[] array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = generateRandomNumber();
        }
        Arrays.sort(array);
        return array;
    }

    // Generates a sorted array with X on the last element
    public static int[] generateSortedArrayWithX(int ARRAY_LENGTH, int X) {
        int[] array;
        int[] generatedArray = generateSortedArrayAscending(ARRAY_LENGTH);
        array = Arrays.copyOf(generatedArray, ARRAY_LENGTH );
        array[ARRAY_LENGTH - 1] = X;
        return array;
    }

    // Generates a sorted array descending
    public static int[] generateSortedArrayDescending(int ARRAY_LENGTH) {
        int[] array = generateSortedArrayAscending(ARRAY_LENGTH);
        Sorter.sortReverseOrder(array);
        return array;
    }

    // Generates a random array
    public static int[] generateRandomArray(int ARRAY_LENGTH) {
        int[] array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = generateRandomNumber();
        }
        return array;
    }

    private static int generateRandomNumber() {
        return (int) (Math.random() * 1000);
    }
}
