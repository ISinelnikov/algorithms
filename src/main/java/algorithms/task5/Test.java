package algorithms.task5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    private static final int GRAPH_SIZE = 100;
    private static final int EDG_COUNTER = 200;

    public static void main(String[] args) throws IOException {
        List<String> resultAdjacencyMatrix = new ArrayList<>();

        int[][] matrix = generateGraph(GRAPH_SIZE, EDG_COUNTER);
        for (int i = 0; i < GRAPH_SIZE; i++) {
            resultAdjacencyMatrix.add(Arrays.stream(matrix[i]).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        }

        List<AdjacencyList> adjacencyLists = new ArrayList<>();
        for (int i = 0; i < GRAPH_SIZE; i++) {
            AdjacencyList adjacencyList = AdjacencyList.of(i);
            for (int j = 0; j < GRAPH_SIZE; j++) {
                if (matrix[i][j] == 1) {
                    adjacencyList.addPair(j);
                }
            }
            adjacencyLists.add(adjacencyList);
        }


        List<String> resultAdjacencyList = new ArrayList<>();
        adjacencyLists.forEach(adjacencyList -> resultAdjacencyList.add(adjacencyList.toString()));

        generateFileWithResults("adjacency-matrix.csv", resultAdjacencyMatrix);
        generateFileWithResults("adjacency-list.txt", resultAdjacencyList);

        DepthFirstSearchGraph.processDepthFirstSearch(adjacencyLists, getRandomValue());
        DepthFirstSearchGraph.processDepthFirstSearch(adjacencyLists, getRandomValue());
        DepthFirstSearchGraph.processDepthFirstSearch(adjacencyLists, getRandomValue());
        BreadthFirstSearchGraph.processBreadthFirstSearch(adjacencyLists, getRandomValue(), getRandomValue());
        BreadthFirstSearchGraph.processBreadthFirstSearch(adjacencyLists, getRandomValue(), getRandomValue());
        BreadthFirstSearchGraph.processBreadthFirstSearch(adjacencyLists, getRandomValue(), getRandomValue());
    }

    private static int[][] generateGraph(int graphSize, int edgCounter) {
        int[][] matrix = new int[graphSize][graphSize];
        do {
            int vertex1 = getRandomValue();
            int vertex2 = getRandomValue();

            if (vertex1 != vertex2 && (matrix[vertex1][vertex2] == 0 && matrix[vertex2][vertex1] == 0)) {
                matrix[vertex1][vertex2] = 1;
                matrix[vertex2][vertex1] = 1;
                edgCounter--;
            }
        } while (edgCounter != 0);

        return matrix;
    }

    public static int getRandomValue() {
        return (int) (Math.random() * 100);
    }

    private static void generateFileWithResults(String fileName, List<String> matrix) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (String row: matrix) {
            writer.write(row + "\n");
        };
        writer.close();
    }
}
