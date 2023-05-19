package graphs;

import java.util.ArrayList;
import java.util.List;

public class AllPath {
    public static void main(String[] args) {
        int vertices = 7;
        int sr = 0;
        int des = 6;
        ArrayList<Edge>[] edges = Util.getEdges(vertices);
        boolean[] visited = new boolean[vertices];
        visited[sr] = true;
        List<List<Integer>> finalPaths = getAllPath(edges, sr, des, visited, ""+sr);
        System.out.println(finalPaths);
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

