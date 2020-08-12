package search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSearch {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private List<Integer> list;
    private List<Integer> sortedList;
    private Graph<Integer> graph;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @BeforeEach
    public void setup() {
        list = new ArrayList<>((Arrays.asList(2, 5, 3, 7, 4, 9, 10, 1, 8, 6)));
        sortedList = new ArrayList<>((Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        graph = new Graph<>();

        outContent.reset();
        errContent.reset();
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

    @Test
    public void testBreadthFirstSearch() {
        setupBFSGraph();

        BreadthFirstSearch.traverse(graph, Integer.valueOf(1));

        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 ", outContent.toString());

    }

    @Test
    public void testDepthFirstSearch() {
        setupDFSGraph();

        DepthFirstSearch.traverse(graph, Integer.valueOf(1));

        assertEquals("1 8 12 9 11 10 7 2 6 3 5 4 ", outContent.toString());

    }

    @Test
    public void testDepthFirstSearchRecursive() {
        setupDFSGraph();

        DepthFirstSearch.traverseRecursive(graph, Integer.valueOf(1));

        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 ", outContent.toString());

    }

    private void setupBFSGraph() {
        graph.addEdge(Integer.valueOf(1), Integer.valueOf(2));
        graph.addEdge(Integer.valueOf(1), Integer.valueOf(3));
        graph.addEdge(Integer.valueOf(1), Integer.valueOf(4));

        graph.addEdge(Integer.valueOf(2), Integer.valueOf(5));
        graph.addEdge(Integer.valueOf(2), Integer.valueOf(6));

        graph.addEdge(Integer.valueOf(5), Integer.valueOf(9));
        graph.addEdge(Integer.valueOf(5), Integer.valueOf(10));

        graph.addEdge(Integer.valueOf(4), Integer.valueOf(7));
        graph.addEdge(Integer.valueOf(4), Integer.valueOf(8));

        graph.addEdge(Integer.valueOf(7), Integer.valueOf(11));
        graph.addEdge(Integer.valueOf(7), Integer.valueOf(12));
    }

    private void setupDFSGraph() {
        graph.addEdge(Integer.valueOf(1), Integer.valueOf(2));
        graph.addEdge(Integer.valueOf(1), Integer.valueOf(7));
        graph.addEdge(Integer.valueOf(1), Integer.valueOf(8));

        graph.addEdge(Integer.valueOf(2), Integer.valueOf(3));
        graph.addEdge(Integer.valueOf(2), Integer.valueOf(6));

        graph.addEdge(Integer.valueOf(3), Integer.valueOf(4));
        graph.addEdge(Integer.valueOf(3), Integer.valueOf(5));

        graph.addEdge(Integer.valueOf(8), Integer.valueOf(9));
        graph.addEdge(Integer.valueOf(8), Integer.valueOf(12));

        graph.addEdge(Integer.valueOf(9), Integer.valueOf(10));
        graph.addEdge(Integer.valueOf(9), Integer.valueOf(11));
    }

}
