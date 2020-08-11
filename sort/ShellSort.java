package sort;

import java.util.ArrayList;
import java.util.List;

public class ShellSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {
        for (int i = list.size() / 2; i > 0; i = i / 2) {
            for (int j = 0; j < i; j++) {
                List<T> sublist = new ArrayList<>(list.size() / i);
                for (int k = j; k < list.size(); k = k + i) {
                    sublist.add(list.get(k));
                }

                InsertionSort.sort(sublist);
                for (int k = j; k < list.size(); k = k + i) {
                    list.set(k, sublist.remove(0));
                }
            }
        }
    }

}
