package sorters;

import sorters.abstraction.BubbleSorter;

public class BubbleSorterBegin extends BubbleSorter {
    @Override
    protected void doSort(int array[], int i){
        for (int j = getFromValue(0); condition(j, array.length); j++){
            swap(array, j);
        }
    }

    @Override
    protected int getFromValue(int firstElement) {
        return firstElement;
    }

    @Override
    protected boolean condition(int j, int value) {
        return j < (value-1);
    }

    @Override
    protected void swap(int[] array, int j) {
        if (array[j] > array[j + 1]) {
            int temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
        }
    }
}
