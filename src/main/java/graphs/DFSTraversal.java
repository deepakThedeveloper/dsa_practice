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

    private static void dfsTraversal(List<List<Integer>> graph, int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v+" ");
        for(Integer nbrs : graph.get(v)){
            if(!visited[nbrs])
            dfsTraversal(graph, nbrs, visited);
        }
    }
}
