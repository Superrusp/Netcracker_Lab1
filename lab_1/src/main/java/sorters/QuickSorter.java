package sorters;

import sorters.abstraction.AbstractSorter;

/**
 * Class that extends {@link sorters.abstraction.AbstractSorter} class.
 * <p>This class presents quick sort algorithm.
 *
 * @author Amir Dogmosh
 */
@Sorter(sorterName = "QuickSorter")
public final class QuickSorter extends AbstractSorter {
    /**
     * <p>Method calls {@code quickSort} to do sort.
     *
     * @param array the array that will be sorted.
     */
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    /**
     * Method sorts an array using quick sort algorithm
     * @param arr the array that will be sorted.
     * @param first the first element of array.
     * @param last the last element of array.
     */
    private static void quickSort(int[] arr, int first, int last)
    {
        if (first >= last){
            return;
        }
        int middle = first + (last - first) / 2;
        int current = arr[middle];
        int i = first, j = last;
        while (i <= j)
        {
            while (arr[i] < current)
            {
                i++;
            }
            while (arr[j] > current)
            {
                j--;
            }
            if (i <= j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (first < j){
            quickSort(arr, first, j);
        }
        if (last > i){
            quickSort(arr, i, last);
        }
    }
}
