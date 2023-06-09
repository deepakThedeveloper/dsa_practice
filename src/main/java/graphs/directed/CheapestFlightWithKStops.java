package graphs.directed;

import graphs.Util;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.*;

// if stops are k, then only middle nodes are considered as stops. start and end are not considered
public class CheapestFlightWithKStops {
    public static void main(String[] args) {
        List<List<Pair<Integer, Integer>>> flightPaths = directedAcyclicWtGraph();
        int sr = 0;
        int de = 2;
        int stops = 2;

        int minCost = minCostToReachDest(sr, de, stops, flightPaths);
        System.out.println(minCost);
    }

    private static int minCostToReachDest(int sr, int de, int stops, List<List<Pair<Integer, Integer>>> wtNodes){
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, sr, 0));

        int[] distance = new int[wtNodes.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        while (!queue.isEmpty()){
            Data data = queue.poll();
            for(Pair<Integer, Integer> adj : wtNodes.get(data.node)){
                int stop = data.stop+1;
                int dist = adj.getValue()+ data.dist;
                int newNode = adj.getKey();
                if(stop<=stops+1 && dist < distance[newNode]){
                    queue.add(new Data(stop, newNode, dist));
                    distance[newNode] = dist;
                }
            }
        }

        return distance[de];
    }

    @AllArgsConstructor
    @ToString
    static class Data{
        int stop;
        int node;
        int dist;
    }


    private static List<List<Pair<Integer, Integer>>> directedAcyclicWtGraph() {
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for(int i=0; i<5; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Pair<>(1, 5));
        graph.get(0).add(new Pair<>(3, 2));
        graph.get(1).add(new Pair<>(2, 5));
        graph.get(1).add(new Pair<>(4, 1));
        graph.get(3).add(new Pair<>(1, 2));
        graph.get(4).add(new Pair<>(2, 1));

        return graph;
    }
}
