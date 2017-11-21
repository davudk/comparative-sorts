import java.util.Comparator;

public class InsertionSort extends Sorter {

    @Override
    public String getName() {
        return "InsertionSort";
    }

    @Override
    protected <T> void innerSort(T[] arr, Comparator<T> comp) {
        //for every item in the array:
        //  compare it to its preceeding item and swap if necessary
        //    continue this until a swap is not necessary
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (comp.compare(arr[j - 1], arr[j]) > 0) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}