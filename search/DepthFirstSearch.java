package search;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

    public static <T> void traverse(Graph<T> graph, T root) {
        Stack<T> s = new Stack<>();
        Set<T> v = new HashSet<T>();

        s.push(root);

        while (!s.isEmpty()) {
            T c = s.pop();

            if (!v.contains(c)) {
                v.add(c);
                System.out.print(c + " ");

                for (T t : graph.getNeighbours(c)) {
                    s.push(t);
                }
            }
        }
    }

}