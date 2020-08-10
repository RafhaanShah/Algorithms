package sort;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountingSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {
        Map<T, Integer> counts = new TreeMap<>();
        int n = list.size();

        for (int i = 0; i < n; i++) {
            T t = list.remove(0);
            counts.putIfAbsent(t, 0);
            counts.put(t, counts.get(t) + 1);
        }

        for (Map.Entry<T, Integer> e : counts.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) {
                list.add(e.getKey());
            }
        }
    }

}
