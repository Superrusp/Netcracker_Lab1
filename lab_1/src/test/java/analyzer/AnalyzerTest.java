package analyzer;

import org.junit.Before;
import org.junit.Test;
import sorters.abstraction.AbstractSorter;
import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class AnalyzerTest {

    private Analyzer analyzer;
    private Reflector reflector;
    private Set<Method> methods;
    private Set<AbstractSorter> sorters;

    @Before
    public void setUp() throws Exception {
        analyzer = new Analyzer();
        reflector = new Reflector();
        methods = new HashSet<>();
        sorters = new LinkedHashSet<>();
    }

    @Test(timeout = 1000)
    public void testAnalyzeSortersTime1() {
        for(Method method : reflector.getFillers(methods)) {
            for(AbstractSorter sorter : sorters )
            analyzer.getSortTime(method, sorter,2000);
        }
    }

    @Test(timeout = 1000)
    public void testAnalyzeSortersTime2() {
        // 20 (times) * 32 (fillers*sorters) = 640 results;
        int arr[] = analyzer.generateArraySizes(50);
        for(int i=0; i<arr.length; i++){
            for(Method method : reflector.getFillers(methods)) {
                for(AbstractSorter sorter : sorters )
                    analyzer.getSortTime(method, sorter,arr[i]);
            }
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGenerateArraySizes() {
        int arr[] = analyzer.generateArraySizes(0);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testGenerateArraySizes2() {
        int arr[] = analyzer.generateArraySizes(-1);
    }

    @Test
    public void testGetObjectsViaReflection(){
        sorters = new HashSet<>();
        reflector.getObjects(sorters);
        for(AbstractSorter sorter : sorters){
            assertNotNull(sorter);
        }
    }

    @Test(timeout = 500)
    public void testGetObjectsViaReflectionTime(){
        sorters = new HashSet<>();
        reflector.getObjects(sorters);
    }

    @Test(expected = NullPointerException.class)
    public void testGetSorterName(){
        AbstractSorter sorter = null;
        reflector.getSorterName(sorter);
    }


    @Test(expected = NullPointerException.class)
    public void testGetFillerName(){
        Method method = null;
        reflector.getFillerName(method);
    }
}