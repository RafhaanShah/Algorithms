package sort;

import static sort.SortUtil.swap;

import java.util.List;

public class QuickSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {
        doSort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void doSort(List<T> list, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(list, lo, hi);
            doSort(list, lo, pi - 1);
            doSort(list, pi + 1, hi);
        }
    }

    private static <T extends Comparable<T>> int partition(List<T> list, int lo, int hi) {
        T pivot = list.get(hi);
        int i = lo;

        for (int j = lo; j < hi; j++) {
            int c = list.get(j).compareTo(pivot);
            if (c < 0) {
                swap(i, j, list);
                i++;
            }
        }

        swap(i, hi, list);
        return i;
    }

}
