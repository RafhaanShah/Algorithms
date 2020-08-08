package sort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSort {

    private static List<Integer> sorted;

    private List<Integer> list;

    @BeforeAll
    public static void createSortedList() {
        sorted = new ArrayList<Integer>();

        sorted.add(Integer.valueOf(1));
        sorted.add(Integer.valueOf(2));
        sorted.add(Integer.valueOf(3));
        sorted.add(Integer.valueOf(4));
        sorted.add(Integer.valueOf(5));
        sorted.add(Integer.valueOf(6));
        sorted.add(Integer.valueOf(7));
        sorted.add(Integer.valueOf(8));
        sorted.add(Integer.valueOf(9));
        sorted.add(Integer.valueOf(10));
    }

    @BeforeEach
    public void setup() {
        list = new ArrayList<Integer>();

        list.add(Integer.valueOf(2));
        list.add(Integer.valueOf(5));
        list.add(Integer.valueOf(3));
        list.add(Integer.valueOf(7));
        list.add(Integer.valueOf(4));
        list.add(Integer.valueOf(9));
        list.add(Integer.valueOf(10));
        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(8));
        list.add(Integer.valueOf(6));
    }

    @Test
    public void testBubbleSort() {
        BubbleSort.sort(list);
        assertEquals(sorted, list);
    }

    @Test
    public void testSelectionSort() {
        SelectionSort.sort(list);
        assertEquals(sorted, list);
    }

    @Test
    public void testInsertionSort() {
        SelectionSort.sort(list);
        assertEquals(sorted, list);
    }

    @Test
    public void testShellSort() {
        ShellSort.sort(list);
        assertEquals(sorted, list);
    }

    @Test
    public void testMergeSort() {
        MergeSort.sort(list);
        assertEquals(sorted, list);
    }

    @Test
    public void testIterativeMergeSort() {
        MergeSort.sortIterative(list);
        assertEquals(sorted, list);
    }

}
