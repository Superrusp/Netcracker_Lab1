package analyzer;

import org.junit.Before;
import org.junit.Test;
import sorters.abstraction.AbstractSorter;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;

public class AnalyzerTest {

    private Analyzer analyzer;
    private Reflector reflector;

    @Before
    public void setUp() throws Exception {
        analyzer = new Analyzer();
        reflector = new Reflector();
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testAnalyzeSortersException() {
        analyzer.analyzeSorters(-10);
    }

    @Test(timeout = 5000)
    public void testAnalyzeSortersTime() {
        // 5 (times) * 32 (fillers*sorters) = 160 results;
        analyzer.analyzeSorters(5);
    }

    @Test(expected = NumberFormatException.class)
    public void testAnalyzeSortersException2(){
        analyzer.analyzeSorters(Integer.parseInt("twenty"));
    }

    @Test
    public void testGetObjectsViaReflection(){
        Set<AbstractSorter> sorters = new HashSet<>();
        reflector.getObjects(sorters);
        for(AbstractSorter sorter : sorters){
            assertNotNull(sorter);
        }
    }

    @Test(timeout = 100)
    public void testGetObjectsViaReflectionTime(){
        Set<AbstractSorter> sorters = new HashSet<>();
        reflector.getObjects(sorters);
    }
}