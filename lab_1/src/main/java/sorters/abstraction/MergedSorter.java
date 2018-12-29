package sorters.abstraction;

import sorters.abstraction.AbstractSorter;

import java.util.Arrays;

public abstract class MergedSorter extends AbstractSorter {


    @Override
    public final void sort(int[] array){
       divideArray(array);
    }

    public final int[] divideArray(int[] array){
        if(array.length < 2) {
            return array;}
        int middle = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, middle);
        int[] array2 = Arrays.copyOfRange(array, middle, array.length);
        return sortDividedArrays(array1, array2);
    }

    public abstract int[] sortDividedArrays(int[] array1, int[] array2);

    public final int[] mergeArrays(int[] array1, int[] array2){
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
}
