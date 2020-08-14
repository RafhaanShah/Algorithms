package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DjikstrasAlgorithm {

    private static int infinity = Integer.MAX_VALUE;

    public static <T> int shortestPath(WeightedGraph<T> graph, T source, T destination) {
        Set<T> queue = new HashSet<>();
        Map<T, Integer> distance = new HashMap<>();
        Map<T, Boolean> visited = new HashMap<>();

        for (T t : graph.getVertices()) {
            distance.put(t, infinity);
            visited.put(t, false);
            queue.add(t);
        }

        distance.put(source, 0);

        while (!queue.isEmpty()) {
            T min = minDistance(distance, visited);
            queue.remove(min);
            visited.put(min, true);

            for (T t : graph.getNeighbours(min).keySet()) {
                if (!visited.get(t) && distance.get(min) != infinity) {
                    int i = distance.get(min) + graph.getWeight(t, min);
                    if (i < distance.get(t)) {
                        distance.put(t, i);
                    }
                }
            }
        }

        return distance.get(destination);
    }

    private static <T> T minDistance(Map<T, Integer> dist, Map<T, Boolean> vis) {
        int min = infinity;
        T t = null;

        for (Entry<T, Integer> e : dist.entrySet()) {
            if (!vis.get(e.getKey()) && e.getValue() < min) {
                min = e.getValue();
                t = e.getKey();
            }
        }

        return t;
    }

}
