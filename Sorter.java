import java.util.Comparator;

public abstract class Sorter {
    
    public abstract String getName();
    protected abstract <T> void innerSort(T[] arr, Comparator<T> comp);

    public <T extends Comparable> void sort(T[] arr) {
        sort(arr, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public <T> void sort(T[] arr, Comparator<T> comp) {
        if (arr == null || comp == null) {
            throw new IllegalArgumentException();
        }

        innerSort(arr, comp);
    }

    protected <T> void swap(T[] arr, int i0, int i1) {
        T temp = arr[i0];
        arr[i0] = arr[i1];
        arr[i1] = temp;
    }
}