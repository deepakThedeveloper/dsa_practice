package graphs;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
    public static void main(String[] args) {
        int vertices = 7;

        ArrayList<Edge>[] edges = Util.getDiconnectedEdges(vertices);

        List<List<Integer>> finalPaths = connectedComponents(edges);
        System.out.println(finalPaths);
    }

    private static List<List<Integer>> connectedComponents(ArrayList<Edge>[] edges){
        List<List<Integer>> finalPaths = new ArrayList<>();

        boolean[] visited = new boolean[edges.length];
        for(int i=0; i<edges.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            List<Integer> comp = new ArrayList<>();
            comp.add(i);
            getConnectedComponents(edges, i, visited, comp);
            finalPaths.add(comp);
        }
        return finalPaths;
    }

    private static void getConnectedComponents(ArrayList<Edge>[] edges, int sr, boolean[] visited,
                                                              List<Integer> path){

        ArrayList<Edge> edges1 = edges[sr];
        for (Edge ed : edges1) {
            int des = ed.getDes();
            if (visited[des]) continue;
            visited[des] = true;
            path.add(des);
            getConnectedComponents(edges, des, visited, path);
        }
    }
}

