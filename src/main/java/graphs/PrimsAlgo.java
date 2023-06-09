package graphs;

import javafx.util.Pair;
import lombok.AllArgsConstructor;

import java.util.*;

//technical difference between dijkstra's and prims is while traversing in dijikstra previous edge wt and path is added to
// current, but in case of prims, previous wt and path is not added to current. Rest all the navigation and code is same as dijkstra
// It is used to find out minimum spanning tree
public class PrimsAlgo {
    public static void main(String[] args) {
        int vertices = 5, sr = 0;
        List<List<javafx.util.Pair<Integer, Integer>>> graph = undirectedWtGraph(vertices);
        primsViaBFS(graph, sr, new boolean[vertices]);
    }

    private static void primsViaBFS(List<List<Pair<Integer, Integer>>> edges, int sr, boolean[] visited){
        PriorityQueue<Data> queue = new PriorityQueue<>(Comparator.comparingInt(p->p.weight));
        queue.add(new Data(sr, 0, -1));
        List<List<Integer>> mst = new ArrayList<>();
        int sum = 0;

        while(!queue.isEmpty()){
            Data data = queue.remove();
            int src = data.sr;
            if(visited[src]) continue;
            sum++;
            visited[src] = true;
            if(data.parent !=-1) {
                mst.add(Arrays.asList(src, data.parent));
            }
            for(Pair<Integer, Integer> nbr : edges.get(src)){
                int curNode = nbr.getKey();
                int curWt = nbr.getValue();
                if(visited[curNode]) continue;
                queue.add(new Data(curNode, curWt, src));
            }
        }
        System.out.println("sum of mst:"+sum);
        System.out.println("mst:"+ mst);
    }

    @AllArgsConstructor
    static class Data {
        int sr;
        int weight;
        int parent;
    }

    private static List<List<Pair<Integer, Integer>>> undirectedWtGraph(int vertex){
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for(int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair<>(1, 2));
        graph.get(1).add(new Pair<>(0, 2));
        graph.get(0).add(new Pair<>(2, 1));
        graph.get(2).add(new Pair<>(0, 1));
        graph.get(2).add(new Pair<>(1, 1));
        graph.get(1).add(new Pair<>(2, 1));
        graph.get(2).add(new Pair<>(4, 2));
        graph.get(4).add(new Pair<>(2, 2));
        graph.get(2).add(new Pair<>(3, 2));
        graph.get(3).add(new Pair<>(2, 2));
        graph.get(3).add(new Pair<>(4, 1));
        graph.get(4).add(new Pair<>(3, 1));

        return graph;
    }
}
