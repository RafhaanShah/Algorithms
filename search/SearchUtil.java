package search;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class SearchUtil {

}

class Graph<T> {

    private Map<T, LinkedList<T>> map = new HashMap<>();

    public void addEdge(T s, T d) {
        addEdge(s, d, true);
    }

    public void addEdge(T s, T d, boolean bi) {
        if (!map.containsKey(s))
            addVertex(s);

        if (!map.containsKey(d))
            addVertex(d);

        map.get(s).add(d);

        if (bi)
            map.get(d).add(s);
    }

    public void addVertex(T t) {
        map.put(t, new LinkedList<T>());
    }

    public LinkedList<T> getNeighbours(T t) {
        return map.get(t);
    }

    public boolean isAdjacent(T s, T d) {
        return (map.containsKey(s) && map.get(s).contains(d)) || (map.containsKey(d) && map.get(d).contains(s));
    }

    public void removeEdge(T s, T d) {
        if (map.containsKey(s))
            map.get(s).remove(d);

        if (map.containsKey(d))
            map.get(d).remove(s);
    }

    public void removeVertex(T t) {
        map.remove(t);
        Iterator<LinkedList<T>> it = map.values().iterator();
        while (it.hasNext()) {
            LinkedList<T> list = it.next();
            if (list.contains(t))
                list.remove(t);
        }
    }

    public int size() {
        return map.size();
    }

}
