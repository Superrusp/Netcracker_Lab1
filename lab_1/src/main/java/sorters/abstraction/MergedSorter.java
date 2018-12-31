package sorters.abstraction;
import java.util.Arrays;

/**
 *  Abstract lass that extends {@link sorters.abstraction.AbstractSorter} class.
 *
 * @author Amir Dogmosh
 */
public abstract class MergedSorter extends AbstractSorter {

    /**
     * Overridden sort method that use merged sort
     *
     * @param array array that will be sorted.
     */
    @Override
    public final void sort(int[] array){
       divideArray(array);
    }

    /**
     * This method divides array on two.
     * Method calls {@code sortDividedArrays} to sort divided arrays.
     *
     * @param array the array that will be divided.
     */
    public final int[] divideArray(int[] array){
        if(array.length < 2) {
            return array;}
        int middle = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, middle);
        int[] array2 = Arrays.copyOfRange(array, middle, array.length);
        return sortDividedArrays(array1, array2);
    }

    /**
     * This method must be overridden and sorts two parts of array separately.
     *
     * @param array1 first part of divided array.
     * @param array2 second part of divided array.
     */
    public abstract int[] sortDividedArrays(int[] array1, int[] array2);

    /**
     * Method merges two sorted parts of one divided array.
     *
     * @param array1 first sorted part of divided array.
     * @param array2 second sorted part of divided array.
     */
    public final int[] mergeArrays(int[] array1, int[] array2){
        int newArrayLength = array1.length + array2.length;
        int[] array = new int[newArrayLength];
        int k = 0;
        int j = 0;
        for (int i = 0; i < newArrayLength; i++) {
            if (k == array1.length) {
                array[i] = array2[j++];
            } else if (j == array2.length) {
                array[i] = array1[k++];
            } else {
                if (array1[k] < array2[j]) {
                    array[i] = array1[k++];
                } else {
                    array[i] = array2[j++];
                }
            }
        }
        return array;
    }
}
