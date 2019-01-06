package sorters.abstraction;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  Abstract class that extends {@link sorters.abstraction.AbstractSorter} class.
 *
 * @author Amir Dogmosh
 */
public abstract class MergedSorter extends AbstractSorter {
    private int[] sortedArray;
    /**
     * Overridden sort method that uses merged sort
     *
     * @param array array that will be sorted.
     */
    @Override
    public final void sort(int[] array) {
        parallelMergeSort(array);
    }

    /**
     * This method divides array on two.
     * Method calls {@code sortDividedArrays} to sort divided arrays.
     *
     * @param array the array that will be divided.
     */
    public final int[] divideArray(int[] array) {
        if (array.length < 2) { return array; }
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
        int[] array = new int[array1.length + array2.length];
        int k = 0;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
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

    /**
     * This method is used to find out the number of cores.
     * Calls {@link #parallelMergeSort(int[], int)} method to perform parallel sorting.
     *
     * @param array the array to be sorted.
     */
    private void parallelMergeSort(int[] array){
        int cores = Runtime.getRuntime().availableProcessors();
        parallelMergeSort(array, cores);
    }

    /**
     * This method is used to distribute array sorting in different threads.
     *
     * @param array the array to be sorted using merge sort algorithm.
     * @param numOfThreads the number of threads.
     * @see #parallelSort(int[]).
     */
    private void parallelMergeSort(int[] array, int numOfThreads){
        if(numOfThreads <= 2){
            divideArray(array);
        }
        else {
            int middleIndex = array.length / 2;

            int[] leftSubArray = Arrays.copyOfRange(array, 0, middleIndex);
            int[] rightSubArray = Arrays.copyOfRange(array, middleIndex, array.length);

            FutureTask<int[]> sortLeftSubArray = new FutureTask<>(parallelSort(leftSubArray));
            FutureTask<int[]> sortRightSubArray = new FutureTask<>(parallelSort(rightSubArray));

            new Thread(sortLeftSubArray).start();
            new Thread(sortRightSubArray).start();

            try {
                setSortedArray(mergeArrays(sortLeftSubArray.get(), sortRightSubArray.get()));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is used to perform parallel sorting.
     *
     * @param array the array to be sorted in another thread.
     * @return the array that will be divided, sorted and than merged.
     */
    private Callable<int[]> parallelSort(int[] array){
        return new Callable<int[]>() {
            @Override
            public int[] call() throws Exception {
                return divideArray(array);
            }
        };
    }

    public void setSortedArray(int[] array){
        this.sortedArray = array;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }
}
