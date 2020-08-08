package sort;

import static sort.SortUtil.swap;

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

}
