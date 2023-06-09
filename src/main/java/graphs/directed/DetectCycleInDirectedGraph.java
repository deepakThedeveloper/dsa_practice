package graphs.directed;

import graphs.Util;

import java.util.List;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        int vertex = 8;
        List<List<Integer>> cyclicGraph = Util.adjacencyDirectedListCyclic(vertex);
        System.out.println("cyclic graph:"+cyclicGraph);
        boolean present = detectCycleDFS(cyclicGraph, vertex);
        System.out.println("cyclic graph cycle present dfs:"+present);

        List<List<Integer>> aCyclicGraph = Util.adjacencyDirectedListAcyclic(vertex);
        boolean present1 = detectCycleDFS(aCyclicGraph, vertex);
        System.out.println("acyclic graph cycle present dfs:"+present1);
    }

    //cycle is detected when both visited and path visited are one. just visited = 1 and pathVisited as 0 mean the node is already visited without cycle so don't visit it again.
    // in order to avoid two arrays make visited as 1 and visited and pathVisited both as 2 and not visited as 0
    private static boolean detectCycleDFS(List<List<Integer>> graph, int vertex){
        boolean[] pathVisited = new boolean[vertex];
        boolean[] visited = new boolean[vertex];

        for(int i=0; i<vertex; i++){
            if(visited[i]) continue;
            if(isCyclePresentDFS(graph, i, visited, pathVisited)) {
                System.out.println("cycle path:");
                for(int i1=0; i1<pathVisited.length; i1++){
                    if(pathVisited[i1])
                    System.out.print(i1+" ");
                }
                System.out.println();
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclePresentDFS(List<List<Integer>> graph, int sr, boolean[] visited, boolean[] pVisited){
        visited[sr] = true;
        pVisited[sr] = true;
        //traverse for adjacent nodes
        for(Integer nbr : graph.get(sr)){
            // when the node is not visited
            if(!visited[nbr]){
                if(isCyclePresentDFS(graph, nbr, visited, pVisited)) return true;
            }
            // if node is visied on same path
            else if(pVisited[nbr]) return true;
        }
        pVisited[sr] = false;
        return false;
    }
}
