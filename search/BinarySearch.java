package search;

import java.util.List;

public class BinarySearch {

    public static <T extends Comparable<T>> int find(List<T> sortedList, T element) {
        int l = 0;
        int r = sortedList.size() - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            int c = sortedList.get(m).compareTo(element);

            if (c < 0) {
                l = m + 1;
            } else if (c > 0) {
                r = m - 1;
            } else {
                return m;
            }
        }

        return -1;
    }

}
