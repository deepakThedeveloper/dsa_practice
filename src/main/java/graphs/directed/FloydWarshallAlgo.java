package graphs.directed;

import matrix.Util;

//unlike dijkstra used when graph has negative wt and cycle
//unlike bellman ford, it is multi source algo where shortest path from every source to every other source is found
//used to detect negative cycles as well. if dist[i][i] < 0 then there is negative cycle
public class FloydWarshallAlgo {
    public static void main(String[] args) {
        int[][] graph = directedWtGraphMatrix();
        System.out.println("before path:");
        Util.printMatrix(graph);

        shortestPath(graph);
        System.out.println("after path:");
        Util.printMatrix(graph);
    }

    private static void shortestPath(int[][] graph) {
        int n = graph.length;
        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            graph[i][j] = 0; // path from same node to same node will always be zero until there is -ve cycle
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[k][i]);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (graph[j][k] == (int)1e9) {
                    graph[j][k] = -1;
                }
            }
        }
    }

    private static int[][] directedWtGraphMatrix() {
        int n = 4;
        int[][] graph = Util.getMatrix(n, n, (int)1e9);

        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            graph[i][j] = 0; // path from same node to same node will always be zero until there is -ve cycle
        }
        graph[0][1] = 2;
        graph[1][0] = 1;
        graph[3][0] = 3;
        graph[3][1] = 5;
        graph[3][2] = 4;
        graph[1][2] = 3;

        return graph;
    }
}
