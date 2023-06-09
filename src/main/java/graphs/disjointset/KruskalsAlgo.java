package graphs.disjointset;

import graphs.disjointset.DisjointSet;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 * Used for finding MST. It uses disjoint set for its operation
 */
public class KruskalsAlgo {
    public static void main(String[] args) {
        int vertices = 5;
        List<Data> graph = undirectedWtGraph();
        int mst_wt = kruskalsViaDisjointSet(graph, vertices);
        System.out.println(mst_wt);
    }

    private static int kruskalsViaDisjointSet(List<Data> graph, int vertices){
        Collections.sort(graph, Comparator.comparingInt(d->d.weight));
        DisjointSet disjointSet = new DisjointSet(vertices);
        int wt = 0;
        for(Data d : graph){
            int ulp_sr = disjointSet.findUParent(d.sr);
            int ulp_de = disjointSet.findUParent(d.de);
            if(ulp_sr != ulp_de){
                disjointSet.unionByRank(d.sr, d.de);
                wt += d.weight;
            }
        }
        return wt;
    }

    @AllArgsConstructor
    static class Data {
        int weight;
        int sr;
        int de;
    }

    private static List<Data> undirectedWtGraph(){
        List<Data> graph = new ArrayList<>();

        graph.add(new Data(2, 0, 1));
        graph.add(new Data(2, 1, 0));
        graph.add(new Data(1, 0, 2));
        graph.add(new Data(1, 2, 0));
        graph.add(new Data(1, 2, 1));
        graph.add(new Data(1, 1, 2));
        graph.add(new Data(2, 2, 4));
        graph.add(new Data(2, 4, 2));
        graph.add(new Data(2, 2, 3));
        graph.add(new Data(2, 3, 2));
        graph.add(new Data(1, 3, 4));
        graph.add(new Data(1, 4, 3));

        return graph;
    }
}
