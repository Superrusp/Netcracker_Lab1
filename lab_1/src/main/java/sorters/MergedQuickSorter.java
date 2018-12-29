package sorters;


import sorters.abstraction.MergedSorter;

public class MergedQuickSorter extends MergedSorter {

    @Override
    public int[] sortDividedArrays(int[] array1, int[] array2) {
        QuickSorter quickSorter = new QuickSorter();
        quickSorter.sort(array1);
        quickSorter.sort(array2);
        return mergeArrays(array1, array2);
    }
}
