package sorters.abstraction;

/**
 * This class presents abstract method {@link #sort(int[])} for classes of heirs.
 *
 * @author Amir Dogmosh
 */
public abstract class AbstractSorter {
    /**
     * Abstract method that must be overridden.
     * @param array array that will be sorted.
     */
    public abstract void sort(int[] array);
}
