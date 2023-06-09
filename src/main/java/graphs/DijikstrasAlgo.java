package graphs;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//shortest distance from source to destination based on wt of edges
public class DijikstrasAlgo {
    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = Util.getEdges(vertices);
        int sr = 0;
        int de = 6;

        List<Integer> shortestPath = shortestPathViaBFS(graph, sr, de, new boolean[vertices]);
        System.out.println("shortest path:"+shortestPath+" wt:"+wtCount);

        List<List<Pair<Integer, Integer>>> graph1 = Util.unDirectedWtGraph();
        System.out.println(graph1);
        List<Integer> distances = shortestPathToEveryVertex(graph1, sr);
        System.out.println(distances);

        List<Data> data = printShortestPathToEveryVertex(graph1, sr);
        System.out.println(data);
    }

    static int wtCount = 0;
    //rm*wa*
    private static List<Integer> shortestPathViaBFS(ArrayList<Edge>[] edges, int sr, int de, boolean[] visited){
        PriorityQueue<Data> queue = new PriorityQueue<Data>(Comparator.comparingInt(p->p.weight));
        queue.add(new Data(sr, 0, sr+""));
        List<Integer> path = new ArrayList<>();

        while(!queue.isEmpty()){
            Data pair = queue.remove();
            int src = pair.sr;
            if(visited[src]) continue;
            visited[src] = true;
            path.add(src);
            wtCount += pair.weight;

            for(Edge ed : edges[src]){
                if(visited[ed.getDes()]) continue;
                queue.add(new Data(ed.getDes(), ed.getWt(), pair.path+"-"+ed.getDes()));
            }
        }
        return path;
    }

    private static List<Integer> shortestPathToEveryVertex(List<List<Pair<Integer, Integer>>> graph, int st){
        PriorityQueue<Pair<Integer, Integer>> wtNodeQueue = new PriorityQueue<>(Comparator.comparingInt(p1 -> p1.getKey()));
        wtNodeQueue.add(new Pair<>(0, st));

        List<Integer> distance = new ArrayList<>();
        for(int i=0; i< graph.size(); i++){
            distance.add(Integer.MAX_VALUE);
        }

        while(!wtNodeQueue.isEmpty()) {
            Pair<Integer, Integer> pair = wtNodeQueue.poll();
            int  parent = pair.getValue();
            if(distance.get(parent) == Integer.MAX_VALUE) {
                distance.set(parent, pair.getKey());
                for (Pair<Integer, Integer> adj : graph.get(parent)) {
                    int curChild = adj.getKey();
                    if (distance.get(curChild) == Integer.MAX_VALUE) {
                        int sumWt = adj.getValue() + distance.get(parent);
                        wtNodeQueue.add(new Pair<>(sumWt, curChild));
                    }

                }
            }
        }

        return distance;
    }

    private static List<Data> printShortestPathToEveryVertex(List<List<Pair<Integer, Integer>>> graph, int st){
        PriorityQueue<Data> wtNodeQueue = new PriorityQueue<>(Comparator.comparingInt(p1 -> p1.weight));
        wtNodeQueue.add(new Data(st, 0, st+"->"));

        List<Data> distance = new ArrayList<>();
        for(int i=0; i< graph.size(); i++){
            distance.add(new Data(i, Integer.MAX_VALUE,""));
        }

        while(!wtNodeQueue.isEmpty()) {
            Data data = wtNodeQueue.poll();
            int  psr = data.sr;
            int pval = data.weight;
            String path = data.path;
            if(distance.get(psr).weight == Integer.MAX_VALUE) {
                distance.set(psr, new Data(psr, pval, path));
                for (Pair<Integer, Integer> adj : graph.get(psr)) {
                    int curChild = adj.getKey();
                    if (distance.get(curChild).weight == Integer.MAX_VALUE) {
                        int sumWt = adj.getValue() + distance.get(psr).weight;
                        wtNodeQueue.add(new Data(curChild, sumWt, path+curChild+"->"));
                    }
                }
            }
        }
        return distance;
    }

    @AllArgsConstructor
    @ToString
    static class Data {
        int sr;
        int weight;
        String path;
    }
}
