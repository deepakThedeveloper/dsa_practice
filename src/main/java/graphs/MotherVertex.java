package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MotherVertex {
    public static void main(String[] args) {
        List<Edge>[] edges = getDirectedGraph(8);

        boolean[] visited = new boolean[edges.length];
        Stack<Integer> vals = new Stack<>();
        for(int i=0; i<edges.length; i++){
            if(visited[i]) continue;
            getMotherVertex(edges, i, visited, vals);
        }

        System.out.println(vals);
    }

    //todo: to need to look into traversing part
    private static void getMotherVertex(List<Edge>[] edges, int i, boolean[] visited, Stack<Integer> vals){
        if(i==edges.length)return;
        visited[i] = true;
        for (Edge edge : edges[i]){
            if(visited[edge.getSr()]) continue;
            visited[edge.getSr()] = true;
            getMotherVertex(edges, edge.getDes(), visited, vals);
        }
        vals.add(i);
    }

    public static List<Edge>[] getDirectedGraph(int vertex) {
        ArrayList<Edge>[] edges = new ArrayList[vertex];
        for(int i=0; i<vertex; i++){
            edges[i] = new ArrayList<>();
        }
        edges[0].add(new Edge(7,3,10));
        edges[0].add(new Edge(7,2,10));
        edges[0].add(new Edge(7,1,10));
        edges[0].add(new Edge(7,8,10));
        edges[0].add(new Edge(7,5,10));
        edges[0].add(new Edge(7,6,10));
        edges[5].add(new Edge(5,6,3));
        edges[1].add(new Edge(1,2,3));
        edges[2].add(new Edge(2,3,3));
        edges[3].add(new Edge(3,4,3));

        return edges;
    }

}
