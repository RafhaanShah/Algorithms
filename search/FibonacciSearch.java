package search;

import java.util.List;

public class FibonacciSearch {

    public static <T extends Comparable<T>> int find(List<T> sortedList, T element) {
        int off = -1;
        int fibm2 = 0;
        int fibm1 = 1;
        int fib = fibm1 + fibm2;
        int size = sortedList.size();

        while (fib < size) {
            fibm2 = fibm1;
            fibm1 = fib;
            fib = fibm1 + fibm2;
        }

        while (fib > 1) {
            int i = Math.min(off + fibm2, size - 1);

            if (sortedList.get(i).compareTo(element) < 0) {
                fib = fibm1;
                fibm1 = fibm2;
                fibm2 = fib - fibm1;
                off = i;
            }

            else if (sortedList.get(i).compareTo(element) > 0) {
                fib = fibm2;
                fibm1 = fibm1 - fibm2;
                fibm2 = fib - fibm1;
            }

            else {
                return i;
            }
        }

        if (fibm1 == 1 && sortedList.get(off + 1).equals(element))
            return off + 1;

        return -1;
    }

}
