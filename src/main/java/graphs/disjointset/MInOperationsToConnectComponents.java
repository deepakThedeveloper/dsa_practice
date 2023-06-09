package graphs.disjointset;

import graphs.disjointset.DisjointSet;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class MInOperationsToConnectComponents {
    public static void main(String[] args) {
        int vertices = 4;
        List<Pair<Integer, Integer>> sourceDestGraph = disconnectedComponents();
        int minOperations = minOperationsToConnectAllComponents(sourceDestGraph, vertices);
        System.out.println(minOperations);
    }

    // find extra edges(ee). then find no of connected components(nc). if ee >= nc-1 then return nc-1 else -1
    // to find extra edges add the edges using unionByRank. while adding if ULP is same of edges then that edge is extra edge
    // for directed graph this approach works but in case of undirected graph, 1-2, 1-3, 2-1, 2-3, 3-1, 3-2
    // (ony one edge is extra edge i.e.2-3 but disjoint set will give 4 as extra edge. This issue needs to be resolved.)
    // for now working on this code with directed graph
    private static int minOperationsToConnectAllComponents(List<Pair<Integer, Integer>> sourceDesGraph, int vertices){
        DisjointSet set = new DisjointSet(vertices);

        int extraEdge = 0;
        for(Pair<Integer, Integer> pair : sourceDesGraph){
            int sr = pair.getKey();
            int de = pair.getValue();
            if(set.findUParent(sr) != set.findUParent(de)){
                set.unionByRank(sr, de);
            }
            else extraEdge++;
        }

        int count = 0;
        for(int i=0; i<vertices; i++){
            if(set.findUParent(i) == i) {
                count++;
            }
        }
        return extraEdge >= count-1 ? count-1 : -1;
    }

    private static List<Pair<Integer, Integer>> disconnectedComponents() {
        List<Pair<Integer, Integer>> graph = new ArrayList<>();
        graph.add(new Pair<>(0,1));
        graph.add(new Pair<>(0,2));
        graph.add(new Pair<>(1,2));
        graph.add(new Pair<>(3,3));

        return graph;
    }
}
