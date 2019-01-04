package analyzer;

import fillers.Filler;
import sorters.abstraction.AbstractSorter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * The class <b>Analyzer</b> analyzes the sorting time of differently filled arrays.
 * <p>It generates different sizes of the array and measures sort time of each one.
 *
 * @author Amir Dogmosh
 */
public class Analyzer {
    /**
     * The value presents an array which will be equated to various fillers.
     */
    private int[] mass;

    /**
     * The value is used to calculate sort time.
     */
    private long sortTime;

    /**
     * This method analyzes fillers and inherited classes of class <b>AbstractSorter</b>
     * <p>Gives information about sorting time of each sorter.
     *
     * @param method the method is used to invoke one of the methods of class <b>Filler</b>.
     * @param sorter the object is used to find inherited class and transfer to {@link #measureTime(AbstractSorter)}.
     * @param ARRAY_LENGTH the size of the array.
     * @return sorting time
     */
    public long getSortTime(Method method, AbstractSorter sorter, final int ARRAY_LENGTH){
        try {
            mass = (int[]) method.invoke(Filler.class, ARRAY_LENGTH);
            measureTime(sorter);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return sortTime;
    }

    /**
     * This method measures the sorting time of each object that extended
     * class {@link sorters.abstraction.AbstractSorter}.
     *
     * @param sorter the object of class <b>AbstractSorter</b>
     *               invokes {@link AbstractSorter#sort(int[])} method.
     * @see Analyzer#getSortTime(Method, AbstractSorter, int).
     */
    private void measureTime(AbstractSorter sorter){
        long startTime = System.nanoTime();
        sorter.sort(mass.clone());
        sortTime = System.nanoTime() - startTime;
    }

    /**
     * This method generates the different sizes of the array.
     *
     * @param COUNT the count of array sizes
     * @return the array that keeps sizes.
     */
    public int[] generateArraySizes(final int COUNT){
        int[] arr = new int[COUNT];
        arr[0] = 100;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + 2000;
        }
        return arr;
    }
}