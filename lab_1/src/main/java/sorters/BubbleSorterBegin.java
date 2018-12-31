package sorters;

import sorters.abstraction.BubbleSorter;

/**
 * Class that extends {@link sorters.abstraction.BubbleSorter} class.
 *
 * @author Amir Dogmosh
 */
@Sorter(sorterName = "BubbleSorterBegin")
public class BubbleSorterBegin extends BubbleSorter {

    /**
     * Overridden method of {@link #sort(int[])} method.
     * This method sorts array using bubble sort algorithm from the beginning.
     *
     * @param array the array whose elements will be sort.
     * @param i the iteration that might be used for condition in a loop.
     */
    @Override
    protected final void doSort(int array[], int i){
        for (int j = getFromValue(0); condition(j, array.length); j++){
            swap(array, j);
        }
    }

    @Override
    protected final int getFromValue(int firstElement) {
        return firstElement;
    }

    @Override
    protected final boolean condition(int j, int value) {
        return j < (value-1);
    }

    /**
     * Method swaps two elements in array.
     * @param array reference on array.
     * @param j current element in array.
     */
    @Override
    protected final void swap(int[] array, int j) {
        if (array[j] > array[j + 1]) {
            int temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
        }
    }
}
