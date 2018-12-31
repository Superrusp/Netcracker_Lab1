package sorters;

import sorters.abstraction.MergedSorter;

/**
 * Class that extends {@link sorters.abstraction.MergedSorter} class.
 *
 * @author Amir Dogmosh
 */
@Sorter(sorterName = "MergedBaseSorter")
public final class MergedBaseSorter extends MergedSorter {
    /**
     * This method overrides {@link sorters.abstraction.MergedSorter#sortDividedArrays(int[], int[])} method.
     * <p>It uses <b>BaseSorter</b> object and built-in method for sorting two parts of the array and then merges them.
     *
     * @param array1 first part of divided array.
     * @param array2 second part of divided array.
     * @return the method {@link sorters.abstraction.MergedSorter#mergeArrays(int[], int[])}.
     */
    @Override
    public int[] sortDividedArrays(int[] array1, int[] array2) {
        BaseSorter sorter = new BaseSorter();
        sorter.sort(array1);
        sorter.sort(array2);
        return mergeArrays(array1, array2);
    }
}
