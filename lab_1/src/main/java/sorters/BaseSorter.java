package sorters;

import sorters.abstraction.AbstractSorter;

import java.util.Arrays;

public class BaseSorter extends AbstractSorter {

    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
    }
}
