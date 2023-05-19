package graphs;

import java.util.ArrayList;
import java.util.List;

public class SinglePath {
    public static void main(String[] args) {
        int vertices = 7;
        int sr = 0;
        int des = 6;
        ArrayList<Edge>[] edges = Util.getEdges(vertices);
        boolean[] visited = new boolean[vertices];
        visited[sr] = true;
        boolean isPathPresent = getSinglePath(edges, sr, des, visited, ""+sr);
        System.out.println(isPathPresent);
    }

    private static boolean getSinglePath(ArrayList<Edge>[] edges, int sr, int de, boolean[] visited, String path){
        if(sr == de) {
            System.out.println(path);
            return true;
        }
        ArrayList<Edge> edge = edges[sr];
        for(Edge ed : edge){
            int des = ed.getDes();
            if (visited[des]) continue;
            visited[des] = true;
            boolean b = getSinglePath(edges, des, de, visited, path+"-"+des);
            if(b)return true;
            visited[des] = false;
        }
        return false;
    }
}

