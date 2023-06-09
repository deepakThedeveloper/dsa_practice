package graphs;

import graphs.disjointset.DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectedComponents {
    public static void main(String[] args) {
        int vertices = 7;

        ArrayList<Edge>[] edges = Util.getDiconnectedEdges(vertices);
        List<List<Integer>> finalPaths = connectedComponentsDisjointSet(edges);
        System.out.println(finalPaths);

        int[][] adjacencyMatrix = Util.undirectedGraph(vertices);
        int v = connectedComponentsDisjointSet(adjacencyMatrix, vertices);
        System.out.println("connected components using disjoint set:"+v);
    }

    public static int connectedComponentsDisjointSet(int[][] graph, int vertices){
        DisjointSet set = new DisjointSet(vertices);
        for(int i=0; i<vertices; i++){
            for(int j=0; j<vertices; j++){
                if(graph[i][j] == 1){
                    if(set.findUParent(i) != set.findUParent(j)) {
                        set.unionByRank(i, j);
                    }
                }
            }
        }
        int count = 0;
        for(int i=0; i<vertices; i++){
            if(set.findUParent(i) == i) {
                count++;
            }
        }
        return count;
    }

    private static List<List<Integer>> connectedComponentsDisjointSet(ArrayList<Edge>[] edges){
        List<List<Integer>> finalPaths = new ArrayList<>();

        boolean[] visited = new boolean[edges.length];
        for(int i=0; i<edges.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            List<Integer> comp = new ArrayList<>();
            comp.add(i);
            getConnectedComponents(edges, i, visited, comp);
            finalPaths.add(comp);
        }
        return finalPaths;
    }

    private static void getConnectedComponents(ArrayList<Edge>[] edges, int sr, boolean[] visited,
                                                              List<Integer> path){

        ArrayList<Edge> edges1 = edges[sr];
        for (Edge ed : edges1) {
            int des = ed.getDes();
            if (visited[des]) continue;
            visited[des] = true;
            path.add(des);
            getConnectedComponents(edges, des, visited, path);
        }
    }
}

