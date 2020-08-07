package sort;

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

    private static <T> void swap(int a, int b, List<T> list) {
        T temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

}
