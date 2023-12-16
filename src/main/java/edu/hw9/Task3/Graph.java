package edu.hw9.Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Graph {
    private int vertices;
    private List<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new List[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    public void dfs(int startVertex, int numberOfThreads) {
        boolean[] visited = new boolean[vertices];
        List<Integer> path = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        depthFirstSearchUtil(startVertex, visited, executorService, path);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
                executorService.shutdown();
            }

        } catch (InterruptedException e) {

        }
        System.out.println("DFS Path: " + path);
    }


    private void depthFirstSearchUtil(int currentVertex, boolean[] visited, ExecutorService executorService, List<Integer> path) {
        if (!visited[currentVertex]) {
            visited[currentVertex] = true;
            path.add(currentVertex);

            if (!executorService.isShutdown()) {
                for (int neighbor : this.adjacencyList[currentVertex]) {
                    executorService.execute(() -> depthFirstSearchUtil(neighbor, visited, executorService, path));
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        int startVertex = 0;
        graph.dfs(startVertex, 1);
    }
}
