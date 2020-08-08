package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {
        doSort(list, 0, list.size() - 1);
    }

    public static <T extends Comparable<T>> void sortIterative(List<T> list) {
        for (int i = 1; i <= list.size() - 1; i = 2 * i) {
            for (int j = 0; j < list.size() - 1; j = j + (2 * i)) {
                int m = Math.min(i + j - 1, list.size() - 1);
                int r = Math.min(j + (2 * i) - 1, list.size() - 1);
                merge(list, j, m, r);
            }
        }
    }

    private static <T extends Comparable<T>> void doSort(List<T> list, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            doSort(list, l, m);
            doSort(list, m + 1, r);
            merge(list, l, m, r);
        }
    }

    private static <T extends Comparable<T>> void merge(List<T> list, int l, int m, int r) {
        List<T> sublistA = new ArrayList<T>();
        List<T> sublistB = new ArrayList<T>();

        for (int i = 0; i < m - l + 1; i++) {
            sublistA.add(list.remove(l));
        }

        for (int i = 0; i < r - m; i++) {
            sublistB.add(list.remove(l));
        }

        int i = l;

        while (!sublistA.isEmpty() && !sublistB.isEmpty()) {
            int c = sublistA.get(0).compareTo(sublistB.get(0));
            if (c < 0) {
                list.add(i, sublistA.remove(0));
            } else {
                list.add(i, sublistB.remove(0));
            }
            i++;
        }

        while (!sublistA.isEmpty()) {
            list.add(i, sublistA.remove(0));
            i++;
        }

        while (!sublistB.isEmpty()) {
            list.add(i, sublistB.remove(0));
            i++;
        }
    }

}
