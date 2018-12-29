package sorters.abstraction;

public abstract class BubbleSorter extends AbstractSorter {

    public void sort(int[] array){
        for(int i=0; i<array.length; i++){
            doSort(array, i);
        }
    }
    protected abstract void doSort(int[] array, int i);
    protected abstract int getFromValue(int firstElement);
    protected abstract boolean condition(int j, int value);
    protected abstract void swap(int[] array, int j);
}
