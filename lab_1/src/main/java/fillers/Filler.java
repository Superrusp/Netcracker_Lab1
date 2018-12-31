package fillers;

import java.util.Arrays;

/**
 * Class that has methods to fill the array.
 *
 * @author Amir Dogmosh
 */
public class Filler {
    /**
     * This Method generates a sorted array in ascending order.
     *
     * @param ARRAY_LENGTH the array size.
     */
    @Generator(name = "SortedArrayAscending")
    public static int[] generateSortedArrayAscending(int ARRAY_LENGTH) {
        int[] array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH-1; i++) {
            array[0] = generateRandomNumber();
            array[i+1] = array[i] + generateRandomNumber();
        }
        return array;
    }

    /**
     * This method generates a sorted array with X on the last element.
     *
     * @param ARRAY_LENGTH the array size
     */
    @Generator(name = "SortedArrayWithX")
    public static int[] generateSortedArrayWithX(int ARRAY_LENGTH) {
        int[] array;
        int[] generatedArray = generateSortedArrayAscending(ARRAY_LENGTH);
        array = Arrays.copyOf(generatedArray, ARRAY_LENGTH );
        array[ARRAY_LENGTH - 1] = generateRandomNumber();
        return array;
    }

    /**
     * This method generates a sorted array in descending order.
     *
     * @param ARRAY_LENGTH the array size
     */
    @Generator(name = "SortedArrayDescending")
    public static int[] generateSortedArrayDescending(int ARRAY_LENGTH) {
      int[] array = generateSortedArrayAscending(ARRAY_LENGTH);
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] > array[j]) {
                    int var = array[i];
                    array[i] = array[j];
                    array[j] = var;
                }
            }
        }
        return array;
    }

    /**
     * This method generates a randomly filled array.
     *
     * @param ARRAY_LENGTH the array size
     */
    @Generator(name = "RandomArray")
    public static int[] generateRandomArray(int ARRAY_LENGTH) {
        int[] array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = generateRandomNumber();
        }
        return array;
    }

    /**
     * This method generates a random number.
     *
     */
    private static int generateRandomNumber() {
        return (int) (Math.random() * 100);
    }
}
