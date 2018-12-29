package output;

import analyzer.Analyzer;
import fillers.Filler;
import sorters.BubbleSorterBegin;
import sorters.BubbleSorterEnd;
import sorters.abstraction.AbstractSorter;
import sorters.abstraction.BubbleSorter;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Output {

    // Outputs sorted array

    private static void printBubbleSortFromTheBeginningToSortedArray() {
        System.out.println("BubbleSort from the beginning:  \t\t\t\t" + Analyzer.
                bubbleSortFromTheBeginningToSortedArray() + " ns");
    }

    private static void printBubbleSortFromTheEndToSortedArray() {
        System.out.println("BubbleSort from the end: \t\t\t\t\t\t" + Analyzer.
                bubbleSortFromTheEndToSortedArray() + " ns");
    }

    private static void printQuickSortToSortedArray() {
        System.out.println("QuickSort: \t\t\t\t\t\t\t\t\t\t" + Analyzer.
                quickSortToSortedArray() + " ns");
    }

    private static void printArraySortToSortedArray() {
        System.out.println("ArraySort: \t\t\t\t\t\t\t\t\t\t" + Analyzer.
                arraySortToSortedArray() + " ns");
    }

    private static void printMergedBubbleSortFromTheBeginningToSortedArray() {
        System.out.println("MergedBubbleSort from the beginning: \t\t\t" + Analyzer.
                mergedBubbleSortFromTheBeginningToSortedArray() + " ns");
    }

    private static void printMergedBubbleSortFromTheEndToSortedArray() {
        System.out.println("MergedBubbleSort from the end: \t\t\t\t\t" + Analyzer.
                mergedBubbleSortFromTheEndToSortedArray() + " ns");
    }

    private static void printMergedQuickSortToSortedArray() {
        System.out.println("MergedQuickSort: \t\t\t\t\t\t\t\t" + Analyzer.
                mergedQuickSortToSortedArray() + " ns");
    }

    private static void printMergedArraySortToSortedArray() {
        System.out.println("MergedArraySort: \t\t\t\t\t\t\t\t" + Analyzer.
                mergedArraySortToSortedArray() + " ns");
    }

    // Outputs sorted array with X

    private static void printBubbleSortFromTheBeginningToSortedArrayWithX() {
        System.out.println("BubbleSort from the beginning: \t\t\t\t\t" + Analyzer.
                bubbleSortFromTheBeginningToSortedArrayWithX() + " ns");
    }

    private static void printBubbleSortFromTheEndToSortedArrayWithX() {
        System.out.println("BubbleSort from the end: \t\t\t\t\t\t" + Analyzer.
                bubbleSortFromTheEndToSortedArrayWithX() + " ns");
    }

    private static void printQuickSortToSortedArrayWithX() {
        System.out.println("QuickSort:  \t\t\t\t\t\t\t\t\t" + Analyzer.
                quickSortToSortedArrayWithX() + " ns");
    }

    private static void printArraySortToSortedArrayWithX() {
        System.out.println("ArraySort: \t\t\t\t\t\t\t\t\t\t" + Analyzer.
                arraySortToSortedArrayWithX() + " ns");
    }

    private static void printMergedBubbleSortFromTheBeginningToSortedArrayWithX() {
        System.out.println("MergedBubbleSort from the beginning: \t\t\t" + Analyzer.
                mergedBubbleSortFromTheBeginningToSortedArrayWithX() + " ns");
    }

    private static void printMergedBubbleSortFromTheEndToSortedArrayWithX() {
        System.out.println("MergedBubbleSort from the end: \t\t\t\t\t" + Analyzer.
                mergedBubbleSortFromTheEndToSortedArrayWithX() + " ns");
    }

    private static void printMergedQuickSortToSortedArrayWithX() {
        System.out.println("MergedQuickSort: \t\t\t\t\t\t\t\t" + Analyzer.
                mergedQuickSortToSortedArrayWithX() + " ns");
    }

    private static void printMergedArraySortToSortedArrayWithX() {
        System.out.println("MergedArraySort: \t\t\t\t\t\t\t\t" + Analyzer.
                mergedArraySortToSortedArrayWithX() + " ns");
    }


    // Outputs sorted descending array

    private static void printBubbleSortFromTheBeginningToSortedArrayDescending() {
        System.out.println("BubbleSort from the beginning: \t\t\t\t\t" + Analyzer.
                bubbleSortFromTheBeginningToSortedArrayDescending() + " ns");
    }

    private static void printBubbleSortFromTheEndToSortedArrayDescending() {
        System.out.println("BubbleSort from the end: \t\t\t\t\t\t" + Analyzer.
                bubbleSortFromTheEndToSortedArrayDescending() + " ns");
    }

    private static void printQuickSortToSortedArrayDescending() {
        System.out.println("QuickSort: \t\t\t\t\t\t\t\t\t\t" + Analyzer.
                quickSortToSortedArrayDescending() + " ns");
    }

    private static void printArraySortToSortedArrayDescending() {
        System.out.println("ArraySort: \t\t\t\t\t\t\t\t\t\t" + Analyzer.
                arraySortToSortedArrayDescending() + " ns");
    }

    private static void printMergedBubbleSortFromTheBeginningToSortedArrayDescending() {
        System.out.println("MergedBubbleSort from the beginning: \t\t\t" + Analyzer.
                mergedBubbleSortFromTheBeginningToSortedArrayDescending() + " ns");
    }

    private static void printMergedBubbleSortFromTheEndToSortedArrayDescending() {
        System.out.println("MergedBubbleSort from the end: \t\t\t\t\t" + Analyzer.
                mergedBubbleSortFromTheEndToSortedArrayDescending() + " ns");
    }

    private static void printMergedQuickSortToSortedArrayDescending() {
        System.out.println("MergedQuickSort: \t\t\t\t\t\t\t\t" + Analyzer.
                mergedQuickSortToSortedArrayDescending() + " ns");
    }

    private static void printMergedArraySortToSortedArrayDescending() {
        System.out.println("MergedArraySort: \t\t\t\t\t\t\t\t" + Analyzer.
                mergedArraySortToSortedArrayDescending() + " ns");
    }


    // Outputs random array

    private static void printBubbleSortFromTheBeginningToRandomArray() {
        System.out.println("BubbleSort from the beginning: \t\t\t\t\t" + Analyzer.
                bubbleSortFromTheBeginningToRandomArray() + " ns");
    }

    private static void printBubbleSortFromTheEndToRandomArray() {
        System.out.println("BubbleSort from the end: \t\t\t\t\t\t" + Analyzer.
                bubbleSortFromTheEndToRandomArray() + " ns");
    }

    private static void printQuickSortToRandomArray() {
        System.out.println("QuickSort: \t\t\t\t\t\t\t\t\t\t" + Analyzer.
                quickSortToRandomArray() + " ns");
    }

    private static void printArraySortToRandomArray() {
        System.out.println("ArraySort: \t\t\t\t\t\t\t\t\t\t" + Analyzer.
                arraySortToRandomArray() + " ns");
    }

    private static void printMergedBubbleSortFromTheBeginningToRandomArray() {
        System.out.println("MergedBubbleSort from the beginning: \t\t\t" + Analyzer.
                mergedBubbleSortFromTheBeginningToRandomArray() + " ns");
    }

    private static void printMergedBubbleSortFromTheEndToRandomArray() {
        System.out.println("MergedBubbleSort from the end: \t\t\t\t\t" + Analyzer.
                mergedBubbleSortFromTheEndToRandomArray() + " ns");
    }

    private static void printMergedQuickSortToRandomArray() {
        System.out.println("MergedQuickSort: \t\t\t\t\t\t\t\t" + Analyzer.
                mergedQuickSortToRandomArray() + " ns");
    }

    private static void printMergedArraySortToRandomArray() {
        System.out.println("MergedArraySort: \t\t\t\t\t\t\t\t" + Analyzer.
                mergedArraySortToRandomArray() + " ns");
    }

    private static void printResults() {
        System.out.println("------------------------");
        System.out.println("SORTED ARRAY ASCENDING");
        System.out.println("------------------------");
        printBubbleSortFromTheBeginningToSortedArray();
        printBubbleSortFromTheEndToSortedArray();
        printQuickSortToSortedArray();
        printArraySortToSortedArray();
        printMergedBubbleSortFromTheBeginningToSortedArray();
        printMergedBubbleSortFromTheEndToSortedArray();
        printMergedQuickSortToSortedArray();
        printMergedArraySortToSortedArray();

        System.out.println("------------------------");
        System.out.println("SORTED ARRAY WITH X");
        System.out.println("------------------------");
        printBubbleSortFromTheBeginningToSortedArrayWithX();
        printBubbleSortFromTheEndToSortedArrayWithX();
        printQuickSortToSortedArrayWithX();
        printArraySortToSortedArrayWithX();
        printMergedBubbleSortFromTheBeginningToSortedArrayWithX();
        printMergedBubbleSortFromTheEndToSortedArrayWithX();
        printMergedQuickSortToSortedArrayWithX();
        printMergedArraySortToSortedArrayWithX();

        System.out.println("------------------------");
        System.out.println("SORTED ARRAY DESCENDING");
        System.out.println("------------------------");
        printBubbleSortFromTheBeginningToSortedArrayDescending();
        printBubbleSortFromTheEndToSortedArrayDescending();
        printQuickSortToSortedArrayDescending();
        printArraySortToSortedArrayDescending();
        printMergedBubbleSortFromTheBeginningToSortedArrayDescending();
        printMergedBubbleSortFromTheEndToSortedArrayDescending();
        printMergedQuickSortToSortedArrayDescending();
        printMergedArraySortToSortedArrayDescending();

        System.out.println("------------------------");
        System.out.println("    RANDOM  ARRAY       ");
        System.out.println("------------------------");
        printBubbleSortFromTheBeginningToRandomArray();
        printBubbleSortFromTheEndToRandomArray();
        printQuickSortToRandomArray();
        printArraySortToRandomArray();
        printMergedBubbleSortFromTheBeginningToRandomArray();
        printMergedBubbleSortFromTheEndToRandomArray();
        printMergedQuickSortToRandomArray();
        printMergedArraySortToRandomArray();
    }

    public static void main(String[] args) {
//        Set<Class<? extends AbstractSorter>> set;
//         set =  Analyzer.getSubTypes();
//         for(Class<? extends AbstractSorter> k : set){
//             System.out.println(k);
//         }
    }
}