package graphs;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {
    public static void main(String[] args) {
        int vertices = 7;
        int sr = 2;
        List<List<Integer>> graph = Util.adjacencyList(vertices);
        dfsTraversal(graph, sr, new boolean[vertices]);
    }

    private static void dfsTraversal(List<List<Integer>> graph, int sr, boolean[] visited){
        visited[sr] = true;
        System.out.print(sr+", ");
        for(Integer nbr : graph.get(sr)){
            if(!visited[nbr])
                dfsTraversal(graph, nbr, visited);
        }
    }
}
