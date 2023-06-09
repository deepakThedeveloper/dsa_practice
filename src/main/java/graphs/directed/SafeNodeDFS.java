package graphs.directed;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SafeNodeDFS {
    public static void main(String[] args) {
        int vertex = 12;
        List<List<Integer>> cyclicGraph = adjacencyDirectedList(vertex);
        System.out.println("cyclic graph:"+cyclicGraph);
        TreeSet<Integer> safeNode = findSafeNodes(cyclicGraph, vertex);
        System.out.println("safe nodes:"+safeNode);

    }

    // nodes in cycle or node which leads to cycle i.e. outer edge of node which calls the node which is part of cycle
    // are not safe nodes. Rest all safe nodes
    private static TreeSet<Integer> findSafeNodes(List<List<Integer>> graph, int vertex){
        boolean[] pathVisited = new boolean[vertex];
        boolean[] visited = new boolean[vertex];

        TreeSet<Integer> safeNodes = new TreeSet<>();
        for(int i=0; i<vertex; i++){
            if(visited[i]) continue;
            isCyclePresentDFS(graph, i, visited, pathVisited, safeNodes);
        }
        return safeNodes;
    }

    private static boolean isCyclePresentDFS(List<List<Integer>> graph, int sr, boolean[] visited,
                                             boolean[] pVisited, TreeSet<Integer> safeNodes){
        visited[sr] = true;
        pVisited[sr] = true;
        //traverse for adjacent nodes
        for(Integer nbr : graph.get(sr)){
            // when the node is not visited
            if(safeNodes.contains(nbr)) continue;
            if(!visited[nbr]){
                if(isCyclePresentDFS(graph, nbr, visited, pVisited, safeNodes)) return true;
            }
            // if node is visied on same path
            else if(pVisited[nbr]) return true;
        }
        pVisited[sr] = false;
        safeNodes.add(sr);
        return false;
    }

    public static List<List<Integer>> adjacencyDirectedList(int vertex) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);

        graph.get(1).add(2);

        graph.get(2).add(3);

        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(5).add(6);
        graph.get(4).add(6);

        graph.get(6).add(7);

        graph.get(8).add(1);
        graph.get(8).add(9);
        graph.get(9).add(10);
        graph.get(10).add(8);


        graph.get(11).add(9);

        return graph;
    }
}
