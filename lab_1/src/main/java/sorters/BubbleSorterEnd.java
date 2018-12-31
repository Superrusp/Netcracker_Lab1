package sorters;
import sorters.abstraction.BubbleSorter;

/**
 *Class that extends {@link sorters.abstraction.BubbleSorter} class.
 *
 * @author Amir Dogmosh
 */
@Sorter(sorterName = "BubbleSorterBegin")
public class BubbleSorterEnd extends BubbleSorter {

    /**
     * Overridden method of {@link #sort(int[])} method.
     * This method sorts array using bubble sort algorithm from the end.
     * @param array the array whose elements will be sort.
     * @param i the iteration that will be used for condition in a loop.
     */
    @Override
    protected final void doSort(int[] array, int i) {
        for (int j = getFromValue(array.length); condition(j, i); j-- ){
            swap(array, j);
        }
    }

    @Override
    protected final int getFromValue(int firstElement){
        return firstElement -1;
    }

    @Override
    protected final boolean condition(int j, int value) {
       return j > value;
    }

    @Override
    protected final void swap(int[] array, int j) {
        if (array[j] < array[j - 1]) {
            int temp = array[j];
            array[j] = array[j - 1];
            array[j - 1] = temp;
        }
    }
}
