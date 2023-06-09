package graphs;

import javafx.util.Pair;

import java.util.*;

/**
 * There is K distance. Need to find out how many cities can be travelled through every other city with distance at most K.
 * Of these find out list of cities from which least no of cities can be travelled.
 * Of these list return largest city number.
 *
 * This can be solved using Dijkstra by applying Dijkstra for every node. tc: V*ElogV and can also apply
 * Floyd Warshall with tc: V^3;
 */
public class CityWithSmallestNumberOfNeighbourAtKDist {
    public static void main(String[] args) {
        int vertex = 4;
        List<List<Pair<Integer, Integer>>> graph = undirectedWtGraph(vertex);
        int threeshold = 4;
        int min = findCity(graph, threeshold, vertex);
        System.out.println(min);
    }

    private static int findCity(List<List<Pair<Integer, Integer>>> graph, int k, int vertex){
        int minSize = Integer.MAX_VALUE;
        int maxIndex = -1;
        for(int i=0; i<vertex; i++){
            int reachableCities = applyDijikstraForFindingReachableCitiesFromSource(graph, i, k, vertex);
            System.out.println("sr:"+i+" reachable:"+reachableCities);
            if(minSize >= reachableCities){
                minSize = reachableCities;
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private static int applyDijikstraForFindingReachableCitiesFromSource(List<List<Pair<Integer, Integer>>> graph,
                                                                         int sr, int k, int vertex) {
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        queue.add(new Pair<>(0, sr));

        int[] dist1 = new int[vertex];
        Arrays.fill(dist1, (int)1e9);
        dist1[sr] = 0;
        int reachable = 0;
        while(!queue.isEmpty()){
            Pair<Integer, Integer> distNodePair = queue.poll();
            int dist = distNodePair.getKey();
            int node = distNodePair.getValue();

            for(Pair<Integer, Integer> nbr : graph.get(node)){
                int curNode = nbr.getKey();
                int curWt = nbr.getValue();
                int newDist = dist + curWt;
                if(newDist > k || dist1[curNode] < newDist) continue;
                reachable = dist1[curNode] == (int)1e9 ? ++reachable : reachable;
                dist1[curNode] = newDist;
                queue.add(new Pair<>(newDist, curNode));
            }
        }
        return reachable;
    }

    private static List<List<Pair<Integer, Integer>>> undirectedWtGraph(int vertex) {
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for(int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair<>(1, 3));
        graph.get(1).add(new Pair<>(0, 3));
        graph.get(1).add(new Pair<>(2, 1));
        graph.get(2).add(new Pair<>(1, 1));
        graph.get(1).add(new Pair<>(3, 4));
        graph.get(3).add(new Pair<>(1, 4));
        graph.get(2).add(new Pair<>(3, 1));
        graph.get(3).add(new Pair<>(2, 1));

        return graph;
    }
}
