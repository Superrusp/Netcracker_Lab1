package sorters;

import sorters.abstraction.AbstractSorter;

public class QuickSorter extends AbstractSorter {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

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
