package sort;

import java.util.List;

public class SortUtil {

    public static <T> void swap(int a, int b, List<T> list) {
        T temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }

        T max = list.get(0);

        for (T t : list) {
            int c = t.compareTo(max);
            if (c > 0) {
                max = t;
            }
        }

        return max;
    }

}
