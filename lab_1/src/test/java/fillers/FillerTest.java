package fillers;

import org.junit.Test;

public class FillerTest {

    @Test(timeout = 500)
    public void testGenerateSortedArrayAscending(){
        Filler.generateSortedArrayAscending(100000);
    }

    @Test(expected = NumberFormatException.class)
    public void testSortedArrayAscendingException() {
        Filler.generateSortedArrayAscending(Integer.parseInt("two"));
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testSortedArrayAscendingException2(){
        Filler.generateSortedArrayAscending(-10);
    }

    @Test(timeout = 500)
    public void testGenerateSortedArrayWithX(){
        Filler.generateSortedArrayWithX(100000);
    }

    @Test(expected = NumberFormatException.class)
    public void testSortedArrayWithXException() {
        Filler.generateSortedArrayWithX(Integer.parseInt("ten"));
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testSortedArrayWithXException2(){
        Filler.generateSortedArrayWithX(-7);
    }

    @Test(timeout = 500)
    public void testGenerateSortedArrayDescending(){
        Filler.generateSortedArrayWithX(100000);
    }

    @Test(expected = NumberFormatException.class)
    public void testSortedArrayDescendingException() {
        Filler.generateSortedArrayDescending(Integer.parseInt("fifty"));
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testSortedArrayDescendingException2(){
        Filler.generateSortedArrayDescending(-50);
    }

    @Test(timeout = 500)
    public void testGenerateRandomArray(){
        Filler.generateSortedArrayWithX(100000);
    }

    @Test(expected = NumberFormatException.class)
    public void testGenerateRandomArrayException() {
        Filler.generateRandomArray(Integer.parseInt("twenty"));
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testGenerateRandomArrayException2(){
        Filler.generateRandomArray(-99);
    }
}