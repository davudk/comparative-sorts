import java.util.Comparator;

public class SelectionSort extends Sorter {

    @Override
    public String getName() {
        return "SelectionSort";
    }

    @Override
    protected <T> void innerSort(T[] arr, Comparator<T> comp) {
        //for every item in the array:
        //  find the minimum between that item and the end of the away
        //    swap those two values
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comp.compare(arr[j], arr[k]) < 0) {
                    k = j;
                }
            }
            
            if (k != i) {
                swap(arr, i, k);
            }
        }
    }
}