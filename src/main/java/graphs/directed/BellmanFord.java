package graphs.directed;

// used for finding shortest path in graphs which have negative wt. It is also used to detect negative cycle in graph
// Algorithm works as:

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For N nodes do N-1 iteration.
 * At every iteration reduce distance of all the edges from source. It is same as Dijkstra with the difference that
 * in Dijkstra we needed only 1 iteration, here we need N-1 iteration.
 *
 * int[] distance = new int[nodes.size()];
 * formula for reduction: dist[v] > dist[u] + wt; then dist[v] = dist[u]+wt;
 * This needs to be done for all the edges in every iteration till N-1.
 *
 * Why N-1? because if there is a graph with case like 0->1, 1->2, 2->3, 3->4... in every iteration one node value is resolved,
 * How to detect negative cycle? It is expected that all the node values should be reduced in N-1 iteration. if on Nth iteration
 * as well there is further reduction means graph has negative cycle
 */
public class BellmanFord {
    public static void main(String[] args) {
        List<BellmanFordData> graph = directedBellmanFordGraph();
        int sr = 0;
        int vertex = 6;
        int[] shortDistances = shortestPathFromSourceToAllVertex(graph, sr, vertex);
        Arrays.stream(shortDistances).forEach(v-> System.out.print(v+" "));
        System.out.println();
    }

    private static int[] shortestPathFromSourceToAllVertex(List<BellmanFordData> graph, int sr, int vertex){
        int[] dist = new int[vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[sr] = 0;

        boolean canReduce = false;
        for(int i=0; i<vertex+1; i++){
            canReduce = false;
            for(BellmanFordData data : graph){
               if(dist[data.sr] == Integer.MAX_VALUE) continue;
               int di = dist[data.sr] + data.wt;
               if(dist[data.nhbr] > di){
                   canReduce = true;
                   dist[data.nhbr] = di;
               }
            }
        }
        if(canReduce) throw new RuntimeException("negative cycle detected as further reduction is possible after N-1 iteration");
        return dist;
    }

    private static List<BellmanFordData> directedBellmanFordGraph() {
        List<BellmanFordData> list = new ArrayList<>();

        list.add(new BellmanFordData(0, 1, 5));
        list.add(new BellmanFordData(1, 2, -2));
        list.add(new BellmanFordData(2, 4, 3));
        list.add(new BellmanFordData(3, 4, -2));
        list.add(new BellmanFordData(3, 2, 6));
        list.add(new BellmanFordData(5, 3, 1));
        list.add(new BellmanFordData(1, 5, -3));

        return list;
    }

}

@AllArgsConstructor
class BellmanFordData{
    int sr;
    int nhbr;
    int wt;
}
