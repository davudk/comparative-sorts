import java.util.Comparator;

public class OddEvenTranspositionSort extends Sorter {

    @Override
    public String getName() {
        return "OddEvenSort";
    }

    @Override
    protected <T> void innerSort(T[] arr, Comparator<T> comp) {
        //there are n rounds (equal to the array size):
        //  each round swap (if necessary) every two adjacent items
        //    even rounds: indices 0:1, 2:3, etc...
        //    odd rounds: indices 1:2, 3:4, etc...
        for (int i = 0; i < arr.length; i++) {
            int oddEven = i % 2;
            for (int j = oddEven; j < arr.length - 1; j += 2) {
                if (comp.compare(arr[j], arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}