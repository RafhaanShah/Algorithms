package sort;

import static sort.SortUtil.swap;

import java.util.List;

public class HeapSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {
        int n = list.size();
        for (int i = n / 2 - 1; i > -1; i--) {
            heapify(list, n, i);
        }

        for (int i = n - 1; i > -1; i--) {
            swap(0, i, list);
            heapify(list, i, 0);
        }
    }

    private static <T extends Comparable<T>> void heapify(List<T> list, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && list.get(left).compareTo(list.get(max)) > 0) {
            max = left;
        }

        if (right < n && list.get(right).compareTo(list.get(max)) > 0) {
            max = right;
        }

        if (max != i) {
            swap(i, max, list);
            heapify(list, n, max);
        }
    }

}
