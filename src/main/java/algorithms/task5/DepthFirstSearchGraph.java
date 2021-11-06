package algorithms.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstSearchGraph {
    private final List<Integer> path = new ArrayList<>();

    private final Map<Integer, List<Integer>> vertexToAdjacencyList;
    private final boolean[] visitedVertex;

    public DepthFirstSearchGraph(List<AdjacencyList> adjacencyLists) {
        this.vertexToAdjacencyList = new HashMap<>();
        this.visitedVertex = new boolean[adjacencyLists.size()];

        adjacencyLists.forEach(adjacencyList -> {
            int vertex = adjacencyList.getVertex();
            vertexToAdjacencyList.put(vertex, adjacencyList.getDestinations());
        });
    }

    void process(int vertex) {
        visitedVertex[vertex] = true;
        path.add(vertex);

        for (int adj : vertexToAdjacencyList.get(vertex)) {
            if (!visitedVertex[adj]) {
                process(adj);
            }
        }
    }

    public List<Integer> getPath() {
        return path;
    }

    public static void processDepthFirstSearch(List<AdjacencyList> adjacencyLists, int startVertex) {
        DepthFirstSearchGraph graph = new DepthFirstSearchGraph(adjacencyLists);
        graph.process(startVertex);
        System.out.println("From: " + startVertex + " " + graph.getPath());
    }
}