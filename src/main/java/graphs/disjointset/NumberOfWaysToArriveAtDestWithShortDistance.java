package graphs.disjointset;

import javafx.util.Pair;

import java.util.*;

public class NumberOfWaysToArriveAtDestWithShortDistance {
    public static void main(String[] args) {
        List<List<Pair<Integer, Integer>>> graph = unDirectedWtGraph();
        int sr = 0;
        int de = 8;

        int totalWays = totalWaysToReachDestinationWithShortestPath(graph, sr, de);
        System.out.println(totalWays);
    }

    private static int totalWaysToReachDestinationWithShortestPath(List<List<Pair<Integer, Integer>>> graph, int sr, int de){
        int n = graph.size();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[sr] = 0;
        int[] ways = new int[n];
        Arrays.fill(ways, 0);
        ways[sr] = 1;

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        queue.add(new Pair<>(0, sr));

        while(!queue.isEmpty()){
            Pair<Integer, Integer> distNodePair = queue.poll();
            int dist = distNodePair.getKey();
            int node = distNodePair.getValue();
            for(Pair<Integer, Integer> pair : graph.get(node)){
                int newNode = pair.getKey();
                int newDist = dist + pair.getValue();
                if(distance[newNode] == Integer.MAX_VALUE || distance[newNode] > newDist) {
                    distance[newNode] = newDist;
                    ways[newNode] = ways[node];
                    queue.add(new Pair<>(newDist, newNode));
                }
                else if(distance[newNode] == newDist){
                    ways[newNode] += ways[node];
                }
            }
        }
        return ways[de];
    }

    public static List<List<Pair<Integer, Integer>>> unDirectedWtGraph() {
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for(int i=0; i<9; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Pair<>(1, 1));
        graph.get(0).add(new Pair<>(2, 2));
        graph.get(0).add(new Pair<>(3, 1));
        graph.get(0).add(new Pair<>(4, 2));
        graph.get(1).add(new Pair<>(0, 1));
        graph.get(1).add(new Pair<>(5, 2));
        graph.get(2).add(new Pair<>(0, 2));
        graph.get(2).add(new Pair<>(5, 1));
        graph.get(3).add(new Pair<>(0, 1));
        graph.get(3).add(new Pair<>(5, 2));
        graph.get(3).add(new Pair<>(7, 3));
        graph.get(3).add(new Pair<>(6, 2));
        graph.get(4).add(new Pair<>(0, 2));
        graph.get(4).add(new Pair<>(6, 1));
        graph.get(6).add(new Pair<>(8, 1));
        graph.get(6).add(new Pair<>(3, 2));
        graph.get(6).add(new Pair<>(4, 1));
        graph.get(5).add(new Pair<>(8, 1));
        graph.get(5).add(new Pair<>(1, 2));
        graph.get(5).add(new Pair<>(2, 1));
        graph.get(5).add(new Pair<>(3, 2));
        graph.get(7).add(new Pair<>(8, 1));
        graph.get(7).add(new Pair<>(3, 3));
        graph.get(8).add(new Pair<>(5, 1));
        graph.get(8).add(new Pair<>(7, 1));
        graph.get(8).add(new Pair<>(6, 1));

        return graph;
    }
}
