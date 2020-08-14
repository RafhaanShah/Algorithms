package search;

import java.util.List;

public class LinearSearch {

    public static <T> int find(List<T> list, T element) {
        for (int i = 0; i < list.size(); i++) {
            if (element.equals(list.get(i))) {
                return i;
            }
        }

        return -1;
    }

}
