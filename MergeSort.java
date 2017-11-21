import java.util.Comparator;

public class MergeSort extends Sorter {
    static final int SPLIT_THRESHOLD = 4;
    static InsertionSort insertionSort = new InsertionSort();

    @Override
    public String getName() {
        return "MergeSort";
    }

    @Override
    protected <T> void innerSort(T[] arr, Comparator<T> comp) {
        //split the array into two parts, until each is relatively small
        //  perform insertion sort on the small subsections
        //  merge the parts together again, inserting the items into correct position
        T[] dest = split(arr, comp, 0, arr.length);
        System.arraycopy(dest, 0, arr, 0, dest.length);
    }

    <T> T[] split(T[] arr, Comparator<T> comp, int left, int right) {
        int size = right - left;
        if (size <= SPLIT_THRESHOLD) {
            T[] temp = (T[])new Object[size];
            System.arraycopy(arr, left, temp, 0, size);
            insertionSort.sort(temp, comp);
            return temp;
        } else {
            int m = left + size / 2;
            T[] leftarr = split(arr, comp, left, m);
            T[] rightarr = split(arr, comp, m, right);
            return merge(leftarr, rightarr, comp);
        }
    }

    <T> T[] merge(T[] leftarr, T[] rightarr, Comparator<T> comp) {
        int size = leftarr.length + rightarr.length;
        T[] arr = (T[])new Object[size];

        for (int left = 0, right = 0, i = 0; i < size; i++) {

            if (left < leftarr.length && (right >= rightarr.length ||
                comp.compare(leftarr[left], rightarr[right]) <= 0)) {
                arr[i] = leftarr[left++];
            } else {
                arr[i] = rightarr[right++];
            }
        }
        
        return arr;
    }
}