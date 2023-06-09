package graphs.directed;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

public class SafeNodeBFS {
    public static void main(String[] args) {
        int vertex = 12;
        List<List<Integer>> cyclicGraph = adjacencyDirectedList(vertex);
        System.out.println("cyclic graph:"+cyclicGraph);
        TreeSet<Integer> safeNode = findSafeNodes(cyclicGraph, vertex);
        System.out.println("safe nodes:"+safeNode);

    }

    private static TreeSet<Integer> findSafeNodes(List<List<Integer>> graph, int vertex){
        List<List<Integer>> reversedGraph = new ArrayList<>();
        for(int i=0; i<graph.size(); i++){
            reversedGraph.add(new ArrayList<>());
        }
        int[] inDegree = new int[vertex];
        for(int i=0; i<graph.size(); i++){
            for(Integer it : graph.get(i)){
                reversedGraph.get(it).add(i);
                inDegree[i]++;
            }
        }
        System.out.println(reversedGraph);
        Arrays.stream(inDegree).forEach(v-> System.out.print(v+" "));
        System.out.println();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i]==0)queue.add(i);
        }

        return bfsTopologicalTraversal(reversedGraph, inDegree, queue);
    }

    private static TreeSet<Integer> bfsTopologicalTraversal(List<List<Integer>> graph, int[] indegree, Queue<Integer> qu){
        TreeSet<Integer> result = new TreeSet<>();
        while(!qu.isEmpty()){
            Integer v = qu.poll();
            result.add(v);

            for(Integer it : graph.get(v)){
                indegree[it]--;
                if(indegree[it] == 0){
                    qu.add(it);
                }
            }
        }
        return result;
    }

    private static int[] getIndegree(Map<Integer, List<Integer>> graph, int vertices){
        int[] indegree = new int[vertices];

        for(List<Integer> itm : graph.values()){
            for(Integer v : itm){
                indegree[v]++;
            }
        }
        return indegree;
    }

    public static List<List<Integer>> adjacencyDirectedList(int vertex) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);

        graph.get(1).add(2);

        graph.get(2).add(3);

        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(5).add(6);
        graph.get(4).add(6);

        graph.get(6).add(7);

        graph.get(8).add(1);
        graph.get(8).add(9);
        graph.get(9).add(10);
        graph.get(10).add(8);


        graph.get(11).add(9);

        return graph;
    }
}
