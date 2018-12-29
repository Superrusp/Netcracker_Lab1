package sorters;

import sorters.abstraction.MergedSorter;

public class MergedBaseSorter extends MergedSorter {

    @Override
    public int[] sortDividedArrays(int[] array1, int[] array2) {
        BaseSorter sorter = new BaseSorter();
        sorter.sort(array1);
        sorter.sort(array2);
        return mergeArrays(array1, array2);
    }
}
