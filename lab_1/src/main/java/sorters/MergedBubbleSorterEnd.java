package sorters;

import sorters.abstraction.MergedSorter;

public class MergedBubbleSorterEnd extends MergedSorter {

    @Override
    public int[] sortDividedArrays(int[] array1, int[] array2) {
        BubbleSorterEnd sorterEnd = new BubbleSorterEnd();
        sorterEnd.sort(array1);
        sorterEnd.sort(array2);
        return  mergeArrays(array1, array2);
    }
}
