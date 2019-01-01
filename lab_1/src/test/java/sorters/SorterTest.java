package sorters;

import fillers.Filler;
import org.junit.Test;
import sorters.abstraction.AbstractSorter;

import static org.junit.Assert.*;

public class SorterTest {

    private AbstractSorter sorter;
    private int[] array;

    @Test(expected = NullPointerException.class)
    public void testBaseSort() {
        sorter = new BaseSorter();
        sorter.sort(array);
    }

    @Test(expected = NullPointerException.class)
    public void testQuickSort() {
        sorter = new QuickSorter();
        sorter.sort(array);
    }

    @Test(expected = NullPointerException.class)
    public void testBubbleSortBegin() {
        sorter = new BubbleSorterBegin();
        sorter.sort(array);
    }

    @Test(expected = NullPointerException.class)
    public void testBubbleSortEnd() {
        sorter = new BubbleSorterEnd();
        sorter.sort(array);
    }

    @Test(expected = NullPointerException.class)
    public void testMergedBaseSort() {
        sorter = new MergedBaseSorter();
        sorter.sort(array);
    }

    @Test(expected = NullPointerException.class)
    public void testMergedQuickSort() {
        sorter = new MergedQuickSorter();
        sorter.sort(array);
    }

    @Test(expected = NullPointerException.class)
    public void testMergedBubbleSortBegin() {
        sorter = new MergedBubbleSorterBegin();
        sorter.sort(array);
    }

    @Test(expected = NullPointerException.class)
    public void testMergedBubbleSortEnd() {
        sorter = new MergedBubbleSorterEnd();
        sorter.sort(array);
    }

    @Test(timeout = 1000)
    public void testBaseSortTime(){
        array = Filler.generateRandomArray(10000);
        sorter = new BaseSorter();
        sorter.sort(array);
    }

    @Test(timeout = 1000)
    public void testQuickSortTime(){
        array = Filler.generateRandomArray(10000);
        sorter = new QuickSorter();
        sorter.sort(array);
    }

    @Test(timeout = 1000)
    public void testBubbleSortBeginTime(){
        array = Filler.generateRandomArray(10000);
        sorter = new BubbleSorterBegin();
        sorter.sort(array);
    }

    @Test(timeout = 1000)
    public void testBubbleSortEndTime(){
        array = Filler.generateRandomArray(10000);
        sorter = new BubbleSorterEnd();
        sorter.sort(array);
    }

    @Test(timeout = 1000)
    public void testMergedBaseSortTime(){
        array = Filler.generateRandomArray(10000);
        sorter = new MergedBaseSorter();
        sorter.sort(array);
    }

    @Test(timeout = 1000)
    public void testMergedQuickSortTime(){
        array = Filler.generateRandomArray(10000);
        sorter = new MergedQuickSorter();
        sorter.sort(array);
    }

    @Test(timeout = 1000)
    public void testMergedBubbleSortBeginTime(){
        array = Filler.generateRandomArray(10000);
        sorter = new MergedBubbleSorterBegin();
        sorter.sort(array);
    }

    @Test(timeout = 1000)
    public void testMergedBubbleSortEndTime(){
        array = Filler.generateRandomArray(10000);
        sorter = new MergedBubbleSorterEnd();
        sorter.sort(array);
    }

    @Test
    public void testBaseSortComparing(){
        int[] arrayExpected = { -65, -34, -17, -2, 0, 1, 3, 3, 7, 18, 39, 57, 99, 150 };
        int[] arrayActual = { 99, 3, 18, 7, 57, 39, 3, -2, -17, 150, -65, 1, -34, 0 };
        sorter = new BaseSorter();
        sorter.sort(arrayActual);
        assertArrayEquals(arrayExpected, arrayActual);
    }

    @Test
    public void testQuickSortComparing(){
        int[] arrayExpected = { -65, -34, -17, -2, 0, 1, 3, 3, 7, 18, 39, 57, 99, 150 };
        int[] arrayActual = { 99, 3, 18, 7, 57, 39, 3, -2, -17, 150, -65, 1, -34, 0 };
        sorter = new QuickSorter();
        sorter.sort(arrayActual);
        assertArrayEquals(arrayExpected, arrayActual);
    }

    @Test
    public void testBubbleSortBeginComparing(){
        int[] arrayExpected = { -65, -34, -17, -2, 0, 1, 3, 3, 7, 18, 39, 57, 99, 150 };
        int[] arrayActual = { 99, 3, 18, 7, 57, 39, 3, -2, -17, 150, -65, 1, -34, 0 };
        sorter = new BubbleSorterBegin();
        sorter.sort(arrayActual);
        assertArrayEquals(arrayExpected, arrayActual);
    }

    @Test
    public void testBubbleSortEndSortComparing(){
        int[] arrayExpected = { -65, -34, -17, -2, 0, 1, 3, 3, 7, 18, 39, 57, 99, 150 };
        int[] arrayActual = { 99, 3, 18, 7, 57, 39, 3, -2, -17, 150, -65, 1, -34, 0 };
        sorter = new BubbleSorterEnd();
        sorter.sort(arrayActual);
        assertArrayEquals(arrayExpected, arrayActual);
    }

    @Test
    public void testMergedBaseSortComparing(){
        int[] arrayExpected = { -65, -34, -17, -2, 0, 1, 3, 3, 7, 18, 39, 57, 99, 150 };
        int[] unsortedArray = { 99, 3, 18, 7, 57, 39, 3, -2, -17, 150, -65, 1, -34, 0 };
        sorter = new MergedBaseSorter();
        int[] arrayActual = ((MergedBaseSorter) sorter).divideArray(unsortedArray);
        assertArrayEquals(arrayExpected, arrayActual);
    }

    @Test
    public void testMergedQuickSortComparing(){
        int[] arrayExpected = { -65, -34, -17, -2, 0, 1, 3, 3, 7, 18, 39, 57, 99, 150 };
        int[] unsortedArray = { 99, 3, 18, 7, 57, 39, 3, -2, -17, 150, -65, 1, -34, 0 };
        sorter = new MergedQuickSorter();
        int[] arrayActual = ((MergedQuickSorter) sorter).divideArray(unsortedArray);
        assertArrayEquals(arrayExpected, arrayActual);
    }

    @Test
    public void testMergedBubbleSortBeginComparing(){
        int[] arrayExpected = { -65, -34, -17, -2, 0, 1, 3, 3, 7, 18, 39, 57, 99, 150 };
        int[] unsortedArray = { 99, 3, 18, 7, 57, 39, 3, -2, -17, 150, -65, 1, -34, 0 };
        sorter = new MergedBubbleSorterBegin();
        int[] arrayActual = ((MergedBubbleSorterBegin) sorter).divideArray(unsortedArray);
        assertArrayEquals(arrayExpected, arrayActual);
    }

    @Test
    public void testMergedBubbleSortEndComparing(){
        int[] arrayExpected = { -65, -34, -17, -2, 0, 1, 3, 3, 7, 18, 39, 57, 99, 150 };
        int[] unsortedArray = { 99, 3, 18, 7, 57, 39, 3, -2, -17, 150, -65, 1, -34, 0 };
        sorter = new MergedBubbleSorterEnd();
        int[] arrayActual = ((MergedBubbleSorterEnd) sorter).divideArray(unsortedArray);
        assertArrayEquals(arrayExpected, arrayActual);
    }
}