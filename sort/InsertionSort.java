package sort;

import java.util.List;

public class InsertionSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                int c = list.get(i).compareTo(list.get(j));
                if (c < 0) {
                    T temp = list.remove(i);
                    list.add(j, temp);
                    continue;
                }
            }
        }
    }

}
