package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
a graph is given which is undirected and m colors. you need to check whether with at most color graph verticies can be colored
with condition that adjacent vertices should not have same color
 */
public class ColoringGraph {
    public static void main(String[] args) {
        int[][] undirectedgraph = {{1,2}, {2,3},{3,4},{4,1},{1,3}};
        int totalVertices = 4;
        int totalEdges = 5;
        //int mColor = 3;//atmost ans: true
        int mColor = 2;//atmost ans: false
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i< undirectedgraph.length; i++){
            int vertex = undirectedgraph[i][0];
            int nextVertex = undirectedgraph[i][1];
            if(map.containsKey(vertex)){
                List<Integer> list = map.get(vertex);
                list.add(nextVertex);
                map.put(vertex, list);
            }
            else{
                List<Integer> list= new ArrayList<>();
                list.add(nextVertex);
                map.put(vertex, list);
            }
        }
        int[] colored = new int[totalVertices+1];
        boolean isColoringPossible = canColorGraph(map, mColor, totalVertices, colored);
        System.out.println(isColoringPossible);
    }

    private static boolean canColorGraph(Map<Integer, List<Integer>> graph, int m, int v, int[] colored) {
        if(v==0) return true;
        for(int i=1; i<=m; i++){
            if(colored[v]==0 && canColor(v, i, graph, colored)){
                colored[v] = i;
                if(canColorGraph(graph, m, v-1, colored)){
                    return true;
                }
                colored[v] = 0;
            }
        }
        return false;
    }

    private static boolean canColor(int v, int i, Map<Integer, List<Integer>> graph, int[] colored){
        List<Integer> connectedVertex = graph.get(v);
        for(Integer vertex:connectedVertex){
            if(colored[vertex] == i) return false;
        }
        return true;
    }
}
