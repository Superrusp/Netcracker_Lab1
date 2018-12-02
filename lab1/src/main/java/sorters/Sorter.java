package sorters;

import java.util.Arrays;

public class Sorter {

    // This method sorts numbers using Bubble sort algorithm from the beginning
    public static void bubbleSortFromTheBeginning(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // This method sorts numbers  using Bubble sort algorithm from the end
    public static void bubbleSortFromTheEnd(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    //Sorts numbers using sort method from Arrays class
    public static void arraySort(int[] arr)
    {
        Arrays.sort(arr);
    }

    //Calls the quick sort method
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    /**
     *Sorts numbers using quick sort algorithm
     *
     * @param  arr the array to be sorted
     * @param  first the index of the first element
     * @param  last the index of the last element
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
            //compare values from both side of lists to see if they need swapping
            if (i <= j)
            {
                swap(arr, i, j);
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

    /**
     * Swaps array elements
     *
     * @param arr the array
     * @param i value on the left side
     * @param j value on the right side
     */
    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Merged sort with Bubble sort from the beginning
    public static int[] mergedBubbleSortFromTheBeginning(int[] arr) {
        if(arr.length < 2) {
            return arr;}
        int middle = arr.length / 2;
        int[] array1 = Arrays.copyOfRange(arr, 0, middle);
        int[] array2 = Arrays.copyOfRange(arr, middle, arr.length);
        bubbleSortFromTheBeginning(array1);
        bubbleSortFromTheBeginning(array2);
        return mergeArrays(array1, array2);
    }

    // Merged sort with Bubble sort from the end
    public static int[] mergedBubbleSortFromTheEnd(int[] arr) {
        if(arr.length < 2) {
            return arr;
        }
        int middle = arr.length / 2;
        int[] array1 = Arrays.copyOfRange(arr, 0, middle);
        int[] array2 = Arrays.copyOfRange(arr, middle, arr.length);
        bubbleSortFromTheEnd(array1);
        bubbleSortFromTheEnd(array2);
        return mergeArrays(array1, array2);
    }

    // Merged sort with quick sort
    public static int[] mergedQuickSort(int[] arr) {
        if(arr.length < 2) {
            return arr;}
        int middle = arr.length / 2;
        int[] array1 = Arrays.copyOfRange(arr, 0, middle);
        int[] array2 = Arrays.copyOfRange(arr, middle, arr.length);
        quickSort(array1);
        quickSort(array2);
        return mergeArrays(array1, array2);
    }

    // Merged sort with array sort
    public static int[] mergedArraySort(int[] arr) {
        if(arr.length < 2) {
            return arr;}
        int middle = arr.length / 2;
        int[] array1 = Arrays.copyOfRange(arr, 0, middle);
        int[] array2 = Arrays.copyOfRange(arr, middle, arr.length);
        arraySort(array1);
        arraySort(array2);
        return mergeArrays(array1, array2);
    }


    private static int[] mergeArrays(int[] array1, int[]array2) {
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

    // Sorts numbers in reverse order
    public static void sortReverseOrder(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] < arr[j]) {
                    //swap the elements
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

