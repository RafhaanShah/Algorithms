package sort;

import java.util.List;

public class SortUtil {

    public static <T> void swap(int a, int b, List<T> list) {
        T temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
    
}
