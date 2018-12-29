package analyzer;

import fillers.Filler;
import fillers.Generator;
import org.reflections.scanners.MethodAnnotationsScanner;
import sorters.*;
import org.reflections.Reflections;
import sorters.abstraction.AbstractSorter;
import java.lang.reflect.Method;
import java.util.Set;

public class Analyzer {
    private static long startTime;
    private static long endTime;
    private static final int ARRAY_LENGTH = 50;
    private static final int X = (int) (Math.random() * ARRAY_LENGTH);

    //Fillers
    private static int[] sortedArrayAscending = Filler.generateSortedArrayAscending(ARRAY_LENGTH);
    private static int[] sortedArrayWithX = Filler.generateSortedArrayWithX(ARRAY_LENGTH, X);
    private static int[] sortedArrayDescending = Filler.generateSortedArrayDescending(ARRAY_LENGTH);
    private static int[] randomArray = Filler.generateRandomArray(ARRAY_LENGTH);


    // Measures time to sort already sorted array
    public static long bubbleSortFromTheBeginningToSortedArray(){
        int[] array = sortedArrayAscending.clone();
        return measureTimeOfBubbleSortFromTheBeginning(array);
    }

    public static long bubbleSortFromTheEndToSortedArray(){
        int[] array = sortedArrayAscending.clone();
        return measureTimeOfBubbleSortFromTheEnd(array);
    }

    public static long quickSortToSortedArray(){
        int[] array = sortedArrayAscending.clone();
        return measureTimeOfQuickSort(array);
    }

    public static long arraySortToSortedArray(){
        int[] array = sortedArrayAscending.clone();
        return measureTimeOfArraySort(array);
    }

    public static long mergedBubbleSortFromTheBeginningToSortedArray(){
        int[] array = sortedArrayAscending.clone();
        return measureTimeOfMergedBubbleSortFromTheBeginning(array);
    }

    public static long mergedBubbleSortFromTheEndToSortedArray(){
        int[] array = sortedArrayAscending.clone();
        return measureTimeOfMergedBubbleSortFromTheEnd(array);
    }

    public static long mergedQuickSortToSortedArray(){
        int[] array = sortedArrayAscending.clone();
        return measureTimeOfMergedQuickSort(array);
    }

    public static long mergedArraySortToSortedArray(){
        int[] array = sortedArrayAscending.clone();
        return measureTimeOfMergedArraySort(array);
    }


    // Measures time to sort already sorted array with X
    public static long bubbleSortFromTheBeginningToSortedArrayWithX(){
        int[] array = sortedArrayWithX.clone();
        return measureTimeOfBubbleSortFromTheBeginning(array);
    }

    public static long bubbleSortFromTheEndToSortedArrayWithX(){
        int[] array = sortedArrayWithX.clone();
        return measureTimeOfBubbleSortFromTheEnd(array);
    }

    public static long quickSortToSortedArrayWithX(){
        int[] array = sortedArrayWithX.clone();
        return measureTimeOfQuickSort(array);
    }

    public static long arraySortToSortedArrayWithX(){
        int[] array = sortedArrayWithX.clone();
        return measureTimeOfArraySort(array);
    }

    public static long mergedBubbleSortFromTheBeginningToSortedArrayWithX(){
        int[] array = sortedArrayWithX.clone();
        return measureTimeOfMergedBubbleSortFromTheBeginning(array);
    }

    public static long mergedBubbleSortFromTheEndToSortedArrayWithX(){
        int[] array = sortedArrayWithX.clone();
        return measureTimeOfMergedBubbleSortFromTheEnd(array);
    }

    public static long mergedQuickSortToSortedArrayWithX(){
        int[] array = sortedArrayWithX.clone();
        return measureTimeOfMergedQuickSort(array);
    }

    public static long mergedArraySortToSortedArrayWithX(){
        int[] array = sortedArrayWithX.clone();
        return measureTimeOfMergedArraySort(array);
    }


    // Measures time to sort already sorted descending array
    public static long bubbleSortFromTheBeginningToSortedArrayDescending(){
        int[] array = sortedArrayDescending.clone();
        return measureTimeOfBubbleSortFromTheBeginning(array);
    }

    public static long bubbleSortFromTheEndToSortedArrayDescending(){
        int[] array = sortedArrayDescending.clone();
        return measureTimeOfBubbleSortFromTheEnd(array);
    }

    public static long quickSortToSortedArrayDescending(){
        int[] array = sortedArrayDescending.clone();
        return measureTimeOfQuickSort(array);
    }

    public static long arraySortToSortedArrayDescending (){
        int[] array = sortedArrayDescending.clone();
        return measureTimeOfArraySort(array);
    }

    public static long mergedBubbleSortFromTheBeginningToSortedArrayDescending(){
        int[] array = sortedArrayDescending.clone();
        return measureTimeOfMergedBubbleSortFromTheBeginning(array);
    }

    public static long mergedBubbleSortFromTheEndToSortedArrayDescending(){
        int[] array = sortedArrayDescending.clone();
        return measureTimeOfBubbleSortFromTheEnd(array);
    }

    public static long mergedQuickSortToSortedArrayDescending(){
        int[] array = sortedArrayDescending.clone();
        return measureTimeOfMergedQuickSort(array);
    }

    public static long mergedArraySortToSortedArrayDescending(){
        int[] array = sortedArrayDescending.clone();
        return measureTimeOfMergedArraySort(array);
    }


    // Measures time to sort random array
    public static long bubbleSortFromTheBeginningToRandomArray(){
        int[] array = randomArray.clone();
        return measureTimeOfBubbleSortFromTheBeginning(array);
    }

    public static long bubbleSortFromTheEndToRandomArray(){
        int[] array = randomArray.clone();
        return measureTimeOfBubbleSortFromTheEnd(array);
    }

    public static long quickSortToRandomArray(){
        int[] array = randomArray.clone();
        return measureTimeOfQuickSort(array);
    }

    public static long arraySortToRandomArray(){
        int[] array = randomArray.clone();
        return measureTimeOfArraySort(array);
    }

    public static long mergedBubbleSortFromTheBeginningToRandomArray(){
        int[] array = randomArray.clone();
        return measureTimeOfMergedBubbleSortFromTheBeginning(array);
    }

    public static long mergedBubbleSortFromTheEndToRandomArray(){
        int[] array = randomArray.clone();
        return measureTimeOfMergedBubbleSortFromTheEnd(array);
    }

    public static long mergedQuickSortToRandomArray(){
        int[] array = randomArray.clone();
        return measureTimeOfMergedQuickSort(array);
    }

    public static long mergedArraySortToRandomArray(){
        int[] array = randomArray.clone();
        return measureTimeOfMergedArraySort(array);
    }


    // Time measurement methods for different sorts
    private static long measureTimeOfBubbleSortFromTheBeginning(int[] arr){
        BubbleSorterBegin sorterBegin = new BubbleSorterBegin();
        startTime = System.nanoTime();
        sorterBegin.sort(arr);
        endTime = System.nanoTime() - startTime;
        return endTime;
    }

    private static long measureTimeOfBubbleSortFromTheEnd(int[] arr){
        BubbleSorterEnd sorterEnd = new BubbleSorterEnd();
        startTime = System.nanoTime();
        sorterEnd.sort(arr);
        endTime = System.nanoTime() - startTime;
        return endTime;
    }

    private static long measureTimeOfArraySort(int[] arr){
        BaseSorter baseSorter = new BaseSorter();
        startTime = System.nanoTime();
        baseSorter.sort(arr);
        endTime = System.nanoTime() - startTime;
        return endTime;
    }

    private static long measureTimeOfQuickSort(int[] arr){
        QuickSorter quickSorter = new QuickSorter();
        startTime = System.nanoTime();
        quickSorter.sort(arr);
        endTime = System.nanoTime() - startTime;
        return endTime;
    }

    private static long measureTimeOfMergedBubbleSortFromTheBeginning(int[] arr){
        MergedBubbleSorterBegin mergedBubbleSorterBegin = new MergedBubbleSorterBegin();
        startTime = System.nanoTime();
        mergedBubbleSorterBegin.divideArray(arr);
        endTime = System.nanoTime() - startTime;
        return endTime;
    }

    private static long measureTimeOfMergedBubbleSortFromTheEnd(int[] arr){
        MergedBubbleSorterEnd mergedBubbleSorterEnd = new MergedBubbleSorterEnd();
        startTime = System.nanoTime();
        mergedBubbleSorterEnd.divideArray(arr);
        endTime = System.nanoTime() - startTime;
        return endTime;
    }

    private static long measureTimeOfMergedQuickSort(int[] arr){
        MergedQuickSorter mergedQuickSorter = new MergedQuickSorter();
        startTime = System.nanoTime();
        mergedQuickSorter.divideArray(arr);
        endTime = System.nanoTime() - startTime;
        return endTime;
    }

    private static long measureTimeOfMergedArraySort(int[] arr){
        MergedBaseSorter mergedBaseSorter = new MergedBaseSorter();
        startTime = System.nanoTime();
        mergedBaseSorter.divideArray(arr);
        endTime = System.nanoTime() - startTime;
        return endTime;
    }

    public static Set<Method> getAnnotatedMethod(){
        Reflections reflections = new Reflections("fillers", MethodAnnotationsScanner.class);
        return reflections.getMethodsAnnotatedWith(Generator.class);
    }

    public static Set<Class<? extends AbstractSorter>> getSubTypes() {
        Reflections reflections = new Reflections("sorters");
        return reflections.getSubTypesOf(AbstractSorter.class);
    }
}
