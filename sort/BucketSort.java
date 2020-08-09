package sort;

import static sort.SortUtil.max;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    public static void sort(List<Integer> list) {
        int n = list.size();
        sort(list, n);
    }

    public static void sortSqrt(List<Integer> list) {
        int n = (int) Math.sqrt(list.size());
        sort(list, n);
    }

    private static void sort(List<Integer> list, int n) {
        int s = list.size();

        List<List<Integer>> buckets = new ArrayList<>(n);
        Integer m = max(list);

        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < s; i++) {
            Integer j = list.remove(0);
            buckets.get((int) ((double) j / m * (n - 1))).add(j);
        }

        for (List<Integer> l : buckets) {
            InsertionSort.sort(l);
        }

        for (List<Integer> l : buckets) {
            list.addAll(l);
        }
    }

}
