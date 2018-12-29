package sorters;
import sorters.abstraction.BubbleSorter;

public class BubbleSorterEnd extends BubbleSorter {
    @Override
    protected void doSort(int[] array, int i) {
        for (int j = getFromValue(array.length); condition(j, i); j-- ){
            swap(array, j);
        }
    }

    @Override
    public int getFromValue(int firstElement){
        return firstElement -1;
    }

    @Override
    public boolean condition(int j, int value) {
       return j > value;
    }

    @Override
    public void swap(int[] array, int j) {
        if (array[j] < array[j - 1]) {
            int temp = array[j];
            array[j] = array[j - 1];
            array[j - 1] = temp;
        }
    }
}
