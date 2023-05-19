package graphs;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//rm*wa* -- remove, mark*, work, add* ... remove element from queue, mark it visited, perform operation on it, add its neighbour in queue
public class BFSTraversal {
    public static void main(String[] args) {
        int vertices = 7;
        int sr = 2;
        ArrayList<Edge>[] edges = Util.getEdges(vertices);
        bfsTraversal(edges, sr, vertices);
    }

    private static void bfsTraversal(ArrayList<Edge>[] edges, int sr, int vertex){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sr+""));

        boolean[] visited = new boolean[vertex];
        while(!queue.isEmpty()){
            //rm*wa*
            //remove
            Pair pair = queue.remove();
            int src = pair.src;
            if(visited[src]) continue;

            //mark *
            visited[src] = true;

            //work
            System.out.println(src+"@"+pair.pathSoFar);

            //add connected vertices
            for(Edge edge : edges[src]){
                if(visited[edge.getDes()]) continue;
                queue.add(new Pair(edge.getDes(), pair.pathSoFar+"-"+edge.getDes()));
            }
        }
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

