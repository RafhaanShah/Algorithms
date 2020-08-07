package sort;

import java.util.List;

public class BubbleSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int c = list.get(i).compareTo(list.get(j));
                if (c > 0) {
                    swap(i, j, list);
                }
            }
        }
    }

    private static <T> void swap(int a, int b, List<T> list) {
        T temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

}
