package search;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

    public static <T> void traverse(Graph<T> graph, T root) {
        Stack<T> s = new Stack<>();
        Set<T> v = new HashSet<T>();

        v.add(root);
        s.push(root);

        while (!s.isEmpty()) {
            T c = s.pop();
            v.add(c);
            System.out.print(c + " "); // visit

            for (T t : graph.getNeighbours(c)) {
                if (!v.contains(t)) {
                    s.push(t);
                }
            }
        }
    }

    public static <T> void traverseRecursive(Graph<T> graph, T root) {
        traverse(graph, root, new HashSet<T>());
    }

    private static <T> void traverse(Graph<T> g, T c, Set<T> v) {
        System.out.print(c + " ");
        v.add(c);

        for (T t : g.getNeighbours(c)) {
            if (!v.contains(t)) {
                traverse(g, t, v);
            }
        }
    }

}
