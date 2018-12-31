package sorters;

import sorters.abstraction.MergedSorter;

/**
 * Class that extends {@link sorters.abstraction.MergedSorter} class.
 *
 * @author Amir Dogmosh
 */
@Sorter(sorterName = "MergedBubbleSorterEnd")
public final class MergedBubbleSorterEnd extends MergedSorter {
    /**
     * This method overrides  {@link sorters.abstraction.AbstractSorter#sort(int[])} method.
     * <p>It uses <b>BubbleSorterEnd</b> object for sorting two parts of the array and then merges them.
     *
     * @param array1 first part of divided array.
     * @param array2 second part of divided array.
     * @return the method {@link sorters.abstraction.MergedSorter#mergeArrays(int[], int[])}.
     */
    @Override
    public int[] sortDividedArrays(int[] array1, int[] array2) {
        BubbleSorterEnd sorterEnd = new BubbleSorterEnd();
        sorterEnd.sort(array1);
        sorterEnd.sort(array2);
        return  mergeArrays(array1, array2);
    }
}
