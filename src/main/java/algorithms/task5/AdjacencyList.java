package algorithms.task5;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    private final int vertex;
    private final List<Integer> destinations;

    private AdjacencyList(int vertex) {
        this.vertex = vertex;
        this.destinations = new ArrayList<>();
    }

    public int getVertex() {
        return vertex;
    }

    public List<Integer> getDestinations() {
        return destinations;
    }

    public void addPair(int value) {
        this.destinations.add(value);
    }

    @Override
    public String toString() {
        return vertex + " " + destinations;
    }

    public static AdjacencyList of(int vertex) {
        return new AdjacencyList(vertex);
    }
}
