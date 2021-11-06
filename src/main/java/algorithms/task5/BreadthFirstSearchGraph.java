package algorithms.task5;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearchGraph {
    private final Map<Integer, List<Integer>> vertexToAdjacencyList;

    BreadthFirstSearchGraph(List<AdjacencyList> adjacencyLists) {
        this.vertexToAdjacencyList = new HashMap<>();

        adjacencyLists.forEach(adjacencyList -> {
            int vertex = adjacencyList.getVertex();
            vertexToAdjacencyList.put(vertex, adjacencyList.getDestinations());
        });
    }

    public Queue<Integer> findPath(int from, int to) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> res = new LinkedList<>();

        if (from == to) {
            return res;
        }
        queue.add(from);

        int size = vertexToAdjacencyList.size();
        int[] previous = new int[size];
        for (int i = 0; i < size; i++) {
            previous[i] = -1;
        }

        while (queue.size() != 0) {
            int current = queue.poll();

            for (int vertex : vertexToAdjacencyList.get(current)) {
                if (previous[vertex] == -1) {
                    previous[vertex] = current;
                    if (vertex == to) {
                        while (vertex != from) {
                            res.addFirst(vertex);
                            vertex = previous[vertex];
                        }
                        return res;
                    }
                    queue.add(vertex);
                }
            }
        }

        return res;
    }

    public static void processBreadthFirstSearch(List<AdjacencyList> adjacencyLists, int from, int to) {
        BreadthFirstSearchGraph graph = new BreadthFirstSearchGraph(adjacencyLists);
        System.out.println("Path from: " + from + " to: " + to + " " + graph.findPath(from, to));
    }
}