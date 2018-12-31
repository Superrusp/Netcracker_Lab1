package analyzer;

import fillers.Filler;
import fillers.Generator;
import sorters.Sorter;
import sorters.abstraction.AbstractSorter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

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
     * The value is used to started counting the sort time.
     */
    private long startTime;

    /**
     * The value is used to stop counting the sort time.
     */
    private long endTime;

    /**
     * The object of class <b>Reflector</b> is used to get fillers and sorters using reflection.
     */
    private Reflector reflector;
    /**
     * The collection of methods which will be presented fillers of the array.
     */
    private Set<Method> methods;

    public Analyzer(){
        reflector = new Reflector();
        methods = new HashSet<>();
    }


    /**
     * This method analyzes fillers and inherited classes of class
     * <b>AbstractSorter</b>
     * <p>It gives information about sorting time of each sorter.
     *
     * @param count the amount of arrays that have different size.
     * @see Analyzer#generateArrayOfSizes(int).
     */
    public void analyzeSorters(int count){
     for(int size : generateArrayOfSizes(count)) {
         for (Method method : reflector.getFillers(methods)) {
             try {
                 Set<AbstractSorter> sorters = new HashSet<>();

                 Generator generator = method.getAnnotation(Generator.class);
                 System.out.println(generator.name());

                 mass = (int[]) method.invoke(Filler.class, size);

                 for (AbstractSorter sorter : reflector.getObjects(sorters)) {
                     measureTime(sorter);

                     Sorter annotation = sorter.getClass().getAnnotation(Sorter.class);
                     System.out.println(annotation.sorterName()+" has sort time: " + endTime + " ns");
                     for (int arr : mass) {
                         System.out.print(arr + " ");
                     }
                     System.out.println();
                 }
             } catch (IllegalAccessException e) {
                 e.printStackTrace();
             } catch (InvocationTargetException e) {
                 e.printStackTrace();
             }
         }
     }
    }

    /**
     * This method measures the sorting time of each object that extended
     * class {@link sorters.abstraction.AbstractSorter}.
     *
     * @param sorter the object of class <b>AbstractSorter</b>
     *               invokes {@link AbstractSorter#sort(int[])} method.
     * @see Analyzer#analyzeSorters(int).
     */
    private void measureTime(AbstractSorter sorter){
        startTime = System.nanoTime();
        sorter.sort(mass.clone());
        endTime = System.nanoTime() - startTime;
    }

    /**
     * This method generates the different sizes of the array.
     *
     * @param count the array size
     * @return the array that keeps sizes.
     */
    private int[] generateArrayOfSizes(int count){
       int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }
}