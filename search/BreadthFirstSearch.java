package search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

    public static <T> void traverse(Graph<T> graph, T root) {
        Queue<T> q = new LinkedList<>();
        Set<T> v = new HashSet<T>();

        v.add(root);
        q.add(root);

        while (!q.isEmpty()) {
            T c = q.remove();
            System.out.print(c + " ");

            for (T t : graph.getNeighbours(c)) {
                if (!v.contains(t)) {
                    v.add(t);
                    q.add(t);
                }
            }
        }
    }

}
