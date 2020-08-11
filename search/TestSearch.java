package search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSearch {

    private static List<Integer> list;
    private static List<Integer> sortedList;

    @BeforeEach
    public void setup() {
        list = new ArrayList<>((Arrays.asList(2, 5, 3, 7, 4, 9, 10, 1, 8, 6)));
        sortedList = new ArrayList<>((Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @Test
    public void testLinearSearch() {
        int result = LinearSearch.find(list, Integer.valueOf(4));
        assertEquals(4, result);
    }

    @Test
    public void testBinarySearch() {
        int result = BinarySearch.find(sortedList, Integer.valueOf(4));
        assertEquals(3, result);
    }

}
