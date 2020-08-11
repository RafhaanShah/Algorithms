package search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSearch {

    private static List<Integer> list;

    @BeforeEach
    public void setup() {
        list = new ArrayList<>((Arrays.asList(2, 5, 3, 7, 4, 9, 10, 1, 8, 6)));
    }

    @Test
    public void testLinearSearch() {
        int result = LinearSearch.find(list, Integer.valueOf(4));
        assertEquals(4, result);
    }

}
