package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//rm*wa* -- remove, mark*, work, add* ... remove element from queue, mark it visited, perform operation on it, add its neighbour in queue
public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        int vertices = 7;

        System.out.println(" test for cyclic graph");
        System.out.println("===========================================");

        List<List<Integer>> cyclicGraph = Util.adjacencyList(vertices);
        detectCycleUsingDFS(cyclicGraph, vertices);
        detectCycleUsingBFS(cyclicGraph, vertices);

        System.out.println("===========================================");

        System.out.println(" test for non cyclic graph");
        System.out.println("===========================================");

        List<List<Integer>> cycleLessGraph = Util.cycleLessGraph(vertices);
        detectCycleUsingDFS(cycleLessGraph, vertices);
        detectCycleUsingBFS(cycleLessGraph, vertices);

        System.out.println("===========================================");

    }

    private static void detectCycleUsingBFS(List<List<Integer>> cyclicGraph, int vertices) {
        boolean[] visited = new boolean[vertices];
        boolean cyclePresent = false;
        for(int i=0; i<vertices; i++){
            if(!visited[i]) {
                cyclePresent = isGraphCyclic(cyclicGraph, i, visited);
                if(cyclePresent) break;
            }
        }
        if(cyclePresent){
            System.out.println(" cycle is detected in bfs");
        }
        else {
            System.out.println("cycle is not present in bfs");
        }
    }

    private static boolean isGraphCyclic(List<List<Integer>> edges, int sr, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sr);

        while(!queue.isEmpty()){
            int src = queue.poll();
            if(visited[src]) return true;  // it means the node that we are trying to traverse is already traversed earlier
            // means there is a cycle
            visited[src] = true;

            for(Integer nbr : edges.get(src)){
                if(visited[nbr]) continue;
                queue.add(nbr);
            }
        }
        return false;
    }

    private static void detectCycleUsingDFS(List<List<Integer>> cyclicGraph, int vertices){
        boolean[] visited = new boolean[vertices];
        boolean cyclePresent = false;
        for(int i=0; i<vertices; i++){
            if(!visited[i]) {
                cyclePresent = isCyclePresentDFS(cyclicGraph, i, -1, visited);
                if(cyclePresent) break;
            }
        }
        if(cyclePresent){
            System.out.println(" cycle is detected in dfs");
        }
        else {
            System.out.println("cycle is not present in dfs");
        }
    }

    private static boolean isCyclePresentDFS(List<List<Integer>> nbrs, int sr, int parent, boolean[] visited){
        for(Integer nbr : nbrs.get(sr)){
            if(nbr == parent) continue;
            if(visited[nbr]) return true;
            visited[nbr] = true;

            boolean present = isCyclePresentDFS(nbrs, nbr, sr, visited);
            if(present)return true;
        }
        return false;
    }
}

