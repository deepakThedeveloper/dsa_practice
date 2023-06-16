package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeInGraph {
    public static void main(String[] args) {
        int vertices = 12;
        List<List<Integer>> adjacencyList = getGraph(vertices);
        int sr = 0;
        List<List<Integer>> bridges = bridges(adjacencyList, vertices, sr);
        System.out.println(bridges);
    }

    private static List<List<Integer>> bridges(List<List<Integer>> graph, int vertices, int sr){
        int[] tim = new int[vertices];
        int[] low = new int[vertices];
        boolean[] visited = new boolean[vertices];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(visited, graph, tim, low, -1, sr, bridges);
        return bridges;
    }

    static int timer = 1;
    private static void dfs(boolean[] visited, List<List<Integer>> adj, int[] tim, int[] low, int parent, int node, List<List<Integer>> bridge){
        visited[node] = true;
        tim[node] = low[node] = timer;
        timer ++;
        for(Integer nbr : adj.get(node)){
            if(nbr == parent) continue;
            if(!visited[nbr]){
                dfs(visited, adj, tim, low, node, nbr, bridge);
                low[node] = Math.min(low[node], low[nbr]);
                if(low[nbr] > tim[node]){
                    bridge.add(Arrays.asList(nbr, node));
                }
            }
            else{
                low[node] = Math.min(low[node], low[nbr]);
            }
        }
    }

    private static List<List<Integer>> getGraph(int vertices){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(0).add(3);
        graph.get(3).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(5).add(4);
        graph.get(5).add(6);
        graph.get(6).add(5);
        graph.get(5).add(7);
        graph.get(7).add(5);
        graph.get(6).add(8);
        graph.get(8).add(6);
        graph.get(7).add(8);
        graph.get(8).add(7);
        graph.get(8).add(9);
        graph.get(9).add(8);
        graph.get(9).add(10);
        graph.get(10).add(9);
        graph.get(9).add(11);
        graph.get(11).add(9);
        graph.get(10).add(11);
        graph.get(11).add(10);

        return graph;
    }
}
