package sorters.abstraction;

/**
 * This abstract class presents basic functionality for bubble sorting.
 *
 * @author Amir Dogmosh
 */
public abstract class BubbleSorter extends AbstractSorter {
    /**
     *Method that sorts array using bubble sort algorithm {@code doSort(int[], int)}.
     * @param array array that will be sorted.
     */
    public void sort(int[] array){
        for(int i=0; i<array.length; i++){
            doSort(array, i);
        }
    }

    /**
     * Abstract method that will present a nested loop in bubble sort algorithm.
     * @param array array whose elements will be sort.
     * @param i iteration that might be used for condition in a loop.
     */
    protected abstract void doSort(int[] array, int i);

    /**
     *
     * @param firstElement array element that will be the first to assign an iterator.
     */
    protected abstract int getFromValue(int firstElement);

    /**
     * Method that will present a condition in a nested loop for subclasses.
     * @param j first operand in the condition.
     * @param value second operand in the condition.
     */
    protected abstract boolean condition(int j, int value);

    /**
     * Method swaps two elements in array.
     * @param array reference on array.
     * @param j current element in array.
     */
    protected abstract void swap(int[] array, int j);
}
