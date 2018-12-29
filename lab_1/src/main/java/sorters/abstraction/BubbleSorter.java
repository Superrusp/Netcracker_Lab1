package sorters.abstraction;

public abstract class BubbleSorter extends AbstractSorter {

    public abstract void  sort(int[] array);
    public abstract int getFromValue(int firstElement);
    public abstract boolean condition(int j, int value);
    public abstract void getNextIteration(int j);
    public  abstract void swap(int[] array, int j);
}
