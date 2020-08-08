package sort;

import static sort.SortUtil.swap;

import java.util.List;

public class SelectionSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            swap(i, smallestIndex(i, list), list);
        }
    }

    private static <T extends Comparable<T>> int smallestIndex(int start, List<T> list) {
        int index = start;

        for (int i = start + 1; i < list.size(); i++) {
            int c = list.get(i).compareTo(list.get(index));
            if (c < 0) {
                index = i;
            }
        }

        return index;
    }

}
