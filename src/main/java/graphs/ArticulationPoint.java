package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArticulationPoint {
    public static void main(String[] args){
        int vertices = 8;
        int sr = 0;
        List<List<Integer>> graph = getGraph(8);
        HashSet<Integer> articulationPoints = findArticulationPoints(vertices, graph, sr);
        System.out.println("aritculation points:"+articulationPoints);
    }

    private static HashSet<Integer> findArticulationPoints(int vertices, List<List<Integer>> graph, int sr){
        int[] discovery = new int[vertices];
        int[] low = new int[vertices];
        boolean[] visited = new boolean[vertices];
        HashSet<Integer> result = new HashSet<>();
        dfs(graph, sr, -1, low, discovery, visited, result);

        return result;
    }

    static int timer = 1;
    private static void dfs(List<List<Integer>> graph, int sr, int parent, int[] low, int[] discovery, boolean[] visited,
                            HashSet<Integer> result){
        visited[sr] = true;
        low[sr] = discovery[sr] = timer;
        timer++;
        int count = 0;
        for(Integer nbr : graph.get(sr)){
            if(nbr == parent) continue;
            if(visited[nbr]){
                low[sr] = Math.min(low[sr], discovery[nbr]);
            }
            else{
                count++;
                dfs(graph, nbr, sr, low, discovery, visited, result);
                low[sr] = Math.min(low[sr], low[nbr]);
                if(parent == -1 && count >= 2){
                    result.add(sr);
                }
                else if(low[nbr] >= discovery[sr]){
                    result.add(sr);
                }
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
        graph.get(6).add(7);
        graph.get(7).add(6);

        return graph;
    }
}
