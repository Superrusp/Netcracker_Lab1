package sorters;

import sorters.abstraction.MergedSorter;

public class MergedBubbleSorterBegin extends MergedSorter {

    @Override
    public int[] sortDividedArrays(int[] array1, int[] array2) {
        BubbleSorterBegin sorterBegin = new BubbleSorterBegin();
        sorterBegin.sort(array1);
        sorterBegin.sort(array2);
        return mergeArrays(array1, array2);
    }
}
