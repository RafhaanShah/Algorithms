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
    private WeightedGraph<String> weightedGraph;

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
        weightedGraph = new WeightedGraph<>();

        outContent.reset();
        errContent.reset();
    }

    @Test
    public void testLinearSearch() {
        int result = LinearSearch.find(list, 4);
        assertEquals(4, result);
    }

    @Test
    public void testBinarySearch() {
        int result = BinarySearch.find(sortedList, 4);
        assertEquals(3, result);
    }

    @Test
    public void testBreadthFirstSearch() {
        setupBFSGraph();

        BreadthFirstSearch.traverse(graph, 1);

        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 ", outContent.toString());

    }

    @Test
    public void testDepthFirstSearch() {
        setupDFSGraph();

        DepthFirstSearch.traverse(graph, 1);

        assertEquals("1 8 12 9 11 10 7 2 6 3 5 4 ", outContent.toString());

    }

    @Test
    public void testDepthFirstSearchRecursive() {
        setupDFSGraph();

        DepthFirstSearch.traverseRecursive(graph, 1);

        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 ", outContent.toString());

    }

    @Test
    public void testDjikstrasAlgorithm() {
        setupWeightedGraph();

        int actual = DjikstrasAlgorithm.shortestPath(weightedGraph, "A", "E");

        assertEquals(21, actual);
    }

    private void setupBFSGraph() {
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        graph.addEdge(5, 9);
        graph.addEdge(5, 10);

        graph.addEdge(4, 7);
        graph.addEdge(4, 8);

        graph.addEdge(7, 11);
        graph.addEdge(7, 12);
    }

    private void setupDFSGraph() {
        graph.addEdge(1, 2);
        graph.addEdge(1, 7);
        graph.addEdge(1, 8);

        graph.addEdge(2, 3);
        graph.addEdge(2, 6);

        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        graph.addEdge(8, 9);
        graph.addEdge(8, 12);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
    }

    private void setupWeightedGraph() {
        weightedGraph.addEdge("A", "B", 4);
        weightedGraph.addEdge("A", "H", 8);

        weightedGraph.addEdge("B", "C", 8);
        weightedGraph.addEdge("B", "H", 11);

        weightedGraph.addEdge("H", "G", 1);
        weightedGraph.addEdge("H", "I", 7);

        weightedGraph.addEdge("C", "I", 2);
        weightedGraph.addEdge("C", "D", 7);
        weightedGraph.addEdge("C", "F", 4);

        weightedGraph.addEdge("G", "I", 6);
        weightedGraph.addEdge("G", "F", 2);

        weightedGraph.addEdge("F", "D", 14);
        weightedGraph.addEdge("F", "E", 10);

        weightedGraph.addEdge("E", "D", 9);
    }

}
