package graphs;

import java.util.ArrayList;
import java.util.List;

public class HamiltonianPathAndCycle {
    public static void main(String[] args) {
        int vertices = 7;
        int sr = 0;
        ArrayList<Edge>[] edges = Util.getEdges(vertices);
        edges[2].add(new Edge(2,5,10));
        edges[5].add(new Edge(5,2,10));
        boolean[] visited = new boolean[vertices];
        visited[sr] = true;
        getHamiltanionPathAndCycle(edges, sr, sr, visited, ""+sr, vertices-1);
        System.out.println("hamiltanion path:"+hpath);
        System.out.println("hamiltanion cycle:"+hcycle);
    }

    static List<String> hpath = new ArrayList<>();
    static List<String> hcycle = new ArrayList<>();
    private static void getHamiltanionPathAndCycle(ArrayList<Edge>[] edges, int originalSr, int sr, boolean[] visited, String path, int vertices){
        if(vertices == 0) {
            int lastVertex = path.charAt(path.length()-1) - '0';
            ArrayList<Edge> edges1 = edges[lastVertex];
            for(Edge e1 : edges1) {
                if (e1.getDes() == originalSr){
                    hcycle.add(path);
                    return;
                }
            }
            hpath.add(path);
            return;
        }
        for(Edge ed : edges[sr]){
            int des = ed.getDes();
            if (visited[des]) continue;
            visited[des] = true;
            getHamiltanionPathAndCycle(edges, originalSr, des, visited, path+"-"+des, vertices-1);
            visited[des] = false;
        }
    }
}

