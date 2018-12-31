package sorters;

import sorters.abstraction.AbstractSorter;
import java.util.Arrays;

/**
 * Class that extends {@link sorters.abstraction.AbstractSorter} class.
 * This class uses built-in method {@link java.util.Arrays#sort(int[])}.
 *
 * @author Amir Dogmosh
 */
@Sorter(sorterName = "BaseSorter")
public final class BaseSorter extends AbstractSorter {
    /**
     * This method overrides  {@link sorters.abstraction.AbstractSorter#sort(int[])} method.
     * And it calls {@code Arrays.sort} to do sort.
     *
     * @param array array that will be sorted.
     */
    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
    }
}
