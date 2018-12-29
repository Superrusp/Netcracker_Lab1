package sorters;

import sorters.abstraction.BubbleSorter;

public class BubbleSorterBegin extends BubbleSorter {
//    @Override
//    public void sort(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length - 1; j++) {
//                if (array[j] > array[j + 1]) {
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//            }
//        }
//    }


    public void sort(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = getFromValue(0); condition(j, array.length-1); getNextIteration(j)){
                swap(array, j);
            }
        }
    }

    @Override
    public int getFromValue(int firstElement) {
        return firstElement;
    }

    @Override
    public boolean condition(int j, int value) {
        return j < value;
    }

    @Override
    public void getNextIteration(int j) {
        ++j;
    }

    @Override
    public void swap(int[] array, int j) {
        if (array[j] > array[j + 1]) {
            int temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
        }
    }
}
