package sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSort {

    private static List<Integer> sortedList;

    private List<Integer> list;
    private List<Integer> emptyList;
    private List<Integer> oneItemList;

    @BeforeAll
    public static void createSortedList() {
        sortedList = new ArrayList<>((Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @BeforeEach
    public void setup() {
        list = new ArrayList<>((Arrays.asList(2, 5, 3, 7, 4, 9, 10, 1, 8, 6)));
        emptyList = new ArrayList<>();
        oneItemList = new ArrayList<>(Arrays.asList(1));
    }

    @Test
    public void testBubbleSort() {
        BubbleSort.sort(emptyList);
        assertTrue(emptyList.isEmpty());

        BubbleSort.sort(oneItemList);
        assertEquals(1, oneItemList.get(0).intValue());

        BubbleSort.sort(list);
        assertEquals(sortedList, list);
    }

    @Test
    public void testSelectionSort() {
        SelectionSort.sort(emptyList);
        assertTrue(emptyList.isEmpty());

        SelectionSort.sort(oneItemList);
        assertEquals(1, oneItemList.get(0).intValue());

        SelectionSort.sort(list);
        assertEquals(sortedList, list);
    }

    @Test
    public void testInsertionSort() {
        InsertionSort.sort(emptyList);
        assertTrue(emptyList.isEmpty());

        InsertionSort.sort(oneItemList);
        assertEquals(1, oneItemList.get(0).intValue());

        InsertionSort.sort(list);
        assertEquals(sortedList, list);
    }

    @Test
    public void testShellSort() {
        ShellSort.sort(emptyList);
        assertTrue(emptyList.isEmpty());

        ShellSort.sort(oneItemList);
        assertEquals(1, oneItemList.get(0).intValue());

        ShellSort.sort(list);
        assertEquals(sortedList, list);
    }

    @Test
    public void testMergeSort() {
        MergeSort.sort(emptyList);
        assertTrue(emptyList.isEmpty());

        MergeSort.sort(oneItemList);
        assertEquals(1, oneItemList.get(0).intValue());

        MergeSort.sort(list);
        assertEquals(sortedList, list);
    }

    @Test
    public void testIterativeMergeSort() {
        MergeSort.sortIterative(emptyList);
        assertTrue(emptyList.isEmpty());

        MergeSort.sortIterative(oneItemList);
        assertEquals(1, oneItemList.get(0).intValue());

        MergeSort.sortIterative(list);
        assertEquals(sortedList, list);
    }

    @Test
    public void testBucketSort() {
        BucketSort.sort(emptyList);
        assertTrue(emptyList.isEmpty());

        BucketSort.sort(oneItemList);
        assertEquals(1, oneItemList.get(0).intValue());

        BucketSort.sort(list);
        assertEquals(sortedList, list);
    }

    @Test
    public void testBucketSortSquareRoot() {
        BucketSort.sortSqrt(emptyList);
        assertTrue(emptyList.isEmpty());

        BucketSort.sortSqrt(oneItemList);
        assertEquals(1, oneItemList.get(0).intValue());

        BucketSort.sortSqrt(list);
        assertEquals(sortedList, list);
    }

    @Test
    public void testQuickSort() {
        QuickSort.sort(emptyList);
        assertTrue(emptyList.isEmpty());

        QuickSort.sort(oneItemList);
        assertEquals(1, oneItemList.get(0).intValue());

        QuickSort.sort(list);
        assertEquals(sortedList, list);
    }

    @Test
    public void testCountingSort() {
        CountingSort.sort(emptyList);
        assertTrue(emptyList.isEmpty());

        CountingSort.sort(oneItemList);
        assertEquals(1, oneItemList.get(0).intValue());

        CountingSort.sort(list);
        assertEquals(sortedList, list);
    }

    @Test
    public void testHeapSort() {
        HeapSort.sort(emptyList);
        assertTrue(emptyList.isEmpty());

        HeapSort.sort(oneItemList);
        assertEquals(1, oneItemList.get(0).intValue());

        HeapSort.sort(list);
        assertEquals(sortedList, list);
    }

}
