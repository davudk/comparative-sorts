import java.util.Comparator;

public final class UnitTest {

    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        return isSorted(arr, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public static <T> boolean isSorted(T[] arr, Comparator<T> comp) {
        if (arr == null || comp == null) {
            throw new IllegalArgumentException();
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (comp.compare(arr[i - 1], arr[i]) > 0) {
                return false;
            }
        }

        return true;
    }
}