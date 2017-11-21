import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Program {
    static ArrayList<Sorter> sorters = new ArrayList<Sorter>();
    static Random rnd = new Random(1024); // fixed seed for debugging

    public static void main(String[] args) {
        sorters.add(new InsertionSort());
        sorters.add(new SelectionSort());
        sorters.add(new OddEvenTranspositionSort());
        sorters.add(new MergeSort());

        doTest(10000);
    }

    static void doTest(int n) {
        Float[][] arr = rndFloats(n, sorters.size());
        
        System.out.println("Name\t\tTime\t\tComparisons\t[" + n + " elements]");
        System.out.println();

        for (int i = 0; i < sorters.size(); i++) {
            long startNano = System.nanoTime();
            
            FloatComparator comp = new FloatComparator();
            Sorter s = sorters.get(i);
            s.sort(arr[i], comp);

            long elapsedNano = System.nanoTime() - startNano;
            double elapsed = elapsedNano / 1000000000.0;
            
            System.out.print(s.getName());
            System.out.print("\t" + elapsed + "\t" + comp.getComparisons());

            if (!UnitTest.isSorted(arr[i])) {
                System.out.println("\tSORT FAILED");
            } else System.out.println();
        }
    }

    static Float[][] rndFloats(int n, int copies) {
        Float[][] arr = new Float[copies][];

        if (copies > 0) {
            Float[] first = new Float[n];
            for (int i = 0; i < n; i++) {
                first[i] = rnd.nextFloat();
            }

            arr[0] = first;
            for (int i = 1; i < copies; i++) {
                arr[i] = new Float[n];
                System.arraycopy(first, 0, arr[i], 0, n);
            }
        }

        return arr;
    }
    
    static class FloatComparator implements Comparator<Float> {
        int comparisons;
        
        public int getComparisons() {
            return comparisons;
        }

        @Override
        public int compare(Float o1, Float o2) {
            comparisons += 1;
            return o1.compareTo(o2);
        }
    };
}