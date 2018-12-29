package sorters;

import fillers.Filler;
import sorters.abstraction.BubbleSorter;

public class BubbleSorterEnd extends BubbleSorter {
//    @Override
//    public void sort(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = array.length - 1; j > i; j--) {
//                if (array[j] < array[j - 1]) {
//                    int temp = array[j];
//                    array[j] = array[j - 1];
//                    array[j - 1] = temp;
//                }
//            }
//        }
//    }

    @Override
    public void sort(int[] array){
        for(int i=0; i<array.length; i++){
            for (int j = getFromValue(array.length); condition(j,i); getNextIteration(j)){
                swap(array, j);
            }
        }
    }

    @Override
    public int getFromValue(int firstElement){
        return firstElement-1;
    }

    @Override
    public boolean condition(int j, int value) {
       return j > value;
    }

    @Override
    public void getNextIteration(int j) {
        --j;
    }

    @Override
    public void swap(int[] array, int j) {
        if (array[j] < array[j - 1]) {
            int temp = array[j];
            array[j] = array[j - 1];
            array[j - 1] = temp;
        }
    }
}
