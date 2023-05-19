package graphs;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//rm*wa* -- remove, mark*, work, add* ... remove element from queue, mark it visited, perform operation on it, add its neighbour in queue
public class CyclicGraph {
    public static void main(String[] args) {
        int vertices = 7;
        int sr = 2;
        ArrayList<Edge>[] edges = Util.getEdges(vertices);

        boolean[] visited = new boolean[vertices];
        boolean cyclePresent = false;
        for(int i=0; i<vertices; i++){
            if(!visited[i]) {
                cyclePresent = isGraphCyclic(edges, i, visited);
                if(cyclePresent){
                    break;
                }
            }
        }
        if(cyclePresent){
            System.out.println(" cycle is detected ");
        }
        else {
            System.out.println("cycle is not present");
        }
    }

    private static boolean isGraphCyclic(ArrayList<Edge>[] edges, int sr, boolean[] visited){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sr+""));

        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            int src = pair.src;
            if(visited[src]) return true;  // it means the node that we are trying to traverse is already traversed earlier
            // means there is a cycle
            visited[src] = true;

            for(Edge edge : edges[src]){
                if(visited[edge.getDes()]) continue;
                queue.add(new Pair(edge.getDes(), pair.pathSoFar+"-"+edge.getDes()));
            }
        }
        return false;
    }

    @AllArgsConstructor
    static class Pair{
        int src;
        String pathSoFar;
    }
    private static List<List<Integer>> getAllPath(ArrayList<Edge>[] edges, int sr, int de, boolean[] visited, String path){
        if(sr == de) {
            List<Integer> path1 = new ArrayList<>();
            path1.add(sr);
            List<List<Integer>> paths = new ArrayList<>();
            paths.add(path1);
            return paths;
        }
        ArrayList<Edge> edge = edges[sr];

        List<List<Integer>> finalPaths = new ArrayList<>();
        for(Edge ed : edge){
            int des = ed.getDes();
            if (visited[des]) continue;
            visited[des] = true;
            List<List<Integer>> childPath = getAllPath(edges, des, de, visited, path+"-"+des);
            for(List<Integer> p : childPath){
                p.add(sr);
            }
            finalPaths.addAll(childPath);
            visited[des] = false;
        }
        return finalPaths;
    }
}

