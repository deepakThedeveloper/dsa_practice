package graphs.directed;

import graphs.Util;

import java.util.*;

public class DetectCycleInDirectedGraphBFS {
    public static void main(String[] args) {
        int vertex = 8;
        List<List<Integer>> graph1 = Util.adjacencyDirectedListCyclic(vertex);
        List<Integer> result = topologicalSortBFS(graph1, vertex);
        boolean isCyclic = result.size() != vertex;
        System.out.println("cycle present:"+isCyclic);

        List<List<Integer>> graph2 = Util.adjacencyDirectedListAcyclic(vertex);
        List<Integer> result1 = topologicalSortBFS(graph2, vertex);
        boolean isCyclic1 = result1.size() != vertex;
        System.out.println("cycle present:"+isCyclic1);
    }

    private static List<Integer> topologicalSortBFS(List<List<Integer>> graph, int vertex){
        System.out.println(graph);
        int[] inDegree =  getIndegree(graph);
        Arrays.stream(inDegree).forEach(v->System.out.print(v+" "));
        System.out.println();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i]==0)queue.add(i);
        }

        return bfsTopologicalTraversal(graph, inDegree, queue);
    }

    private static List<Integer> bfsTopologicalTraversal(List<List<Integer>> graph, int[] indegree, Queue<Integer> qu){
        List<Integer> result = new ArrayList<>();
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

    private static int[] getIndegree(List<List<Integer>> graph){
        int[] indegree = new int[graph.size()];

        for(int i=0;  i<graph.size(); i++){
            for(Integer v : graph.get(i)){
                indegree[v]++;
            }
        }
        return indegree;
    }
}
