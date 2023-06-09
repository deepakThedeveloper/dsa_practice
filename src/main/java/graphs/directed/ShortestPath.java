package graphs.directed;

import graphs.Util;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortestPath {
    public static void main(String[] args) {
        List<List<Pair<Integer, Integer>>> wtGraph = Util.directedAcyclicWtGraph();
        int sr = 6;
        List<Integer> distance = findShortestPath(wtGraph, sr);
        System.out.println(distance);
    }

    private static List<Integer> findShortestPath(List<List<Pair<Integer, Integer>>> graph, int sr){
        Stack<Integer> topoSortedData = topoRevisionDFS(graph, graph.size());
        System.out.println(topoSortedData);
        List<Integer> distance = new ArrayList<>();
        for(int i=0; i<topoSortedData.size(); i++){
            distance.add(Integer.MAX_VALUE);
        }
        distance.set(sr, 0);
        while(!topoSortedData.isEmpty()){
            int v = topoSortedData.pop();
            for(Pair<Integer, Integer> pair : graph.get(v)){
                int i = pair.getKey();
                int sum = pair.getValue() + distance.get(v);
                distance.set(i,Math.min(distance.get(i), sum));
            }
        }
        return distance;
    }

    public static Stack<Integer> topoRevisionDFS(List<List<Pair<Integer, Integer>>> graph, int vertices){
        System.out.println(graph);
        boolean[] visited = new boolean[vertices];
        Stack<Integer> result = new Stack<>();
        for(int i=0; i<vertices; i++){
            if(!visited[i]){
                visited[i] = true;
                traverseDFS(graph, i, visited, result);
            }
        }
        return result;
    }

    private static void traverseDFS(List<List<Pair<Integer, Integer>>> graph, int sr, boolean[] visited, Stack<Integer> result){
        for(Pair<Integer, Integer> v : graph.get(sr)){
            if(!visited[v.getKey()]){
                visited[v.getKey()] = true;
                traverseDFS(graph, v.getKey(), visited, result);
            }
        }
        result.push(sr);
    }
}
