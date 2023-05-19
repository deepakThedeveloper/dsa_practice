package graphs;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static ArrayList<Edge>[] getEdges(int vertex){
        ArrayList<Edge>[] edges = new ArrayList[vertex];
        for(int i=0; i<vertex; i++){
            edges[i] = new ArrayList<>();
        }
        edges[0].add(new Edge(0,1,10));
        edges[1].add(new Edge(1,0,10));

        edges[0].add(new Edge(0,3,40));
        edges[3].add(new Edge(3,0,40));

        edges[1].add(new Edge(1,2,10));
        edges[2].add(new Edge(2,1,10));

        edges[2].add(new Edge(2,3,10));
        edges[3].add(new Edge(3,2,10));

        edges[3].add(new Edge(3,4,2));
        edges[4].add(new Edge(4,3,2));

        edges[4].add(new Edge(4,5,3));
        edges[5].add(new Edge(5,4,3));

        edges[4].add(new Edge(4,6,8));
        edges[6].add(new Edge(6,4,8));

        edges[5].add(new Edge(5,6,3));
        edges[6].add(new Edge(6,5,3));

        return edges;
    }
    public static ArrayList<Edge>[] getDiconnectedEdges(int vertex){
        ArrayList<Edge>[] edges = new ArrayList[vertex];
        for(int i=0; i<vertex; i++){
            edges[i] = new ArrayList<>();
        }
        edges[0].add(new Edge(0,1,10));
        edges[1].add(new Edge(1,0,10));

        edges[2].add(new Edge(2,3,10));
        edges[3].add(new Edge(3,2,10));

        edges[4].add(new Edge(4,5,10));
        edges[5].add(new Edge(5,4,10));

        edges[4].add(new Edge(4,6,10));
        edges[6].add(new Edge(6,4,10));

        edges[5].add(new Edge(5,6,10));
        edges[6].add(new Edge(6,5,10));

        return edges;
    }

    public static List<Edge>[] getDirectedGraph(int vertex) {
        ArrayList<Edge>[] edges = new ArrayList[vertex];
        for(int i=0; i<vertex; i++){
            edges[i] = new ArrayList<>();
        }
        edges[0].add(new Edge(0,1,10));

        edges[0].add(new Edge(0,3,40));

        edges[1].add(new Edge(1,2,10));

        edges[2].add(new Edge(2,3,10));

        edges[4].add(new Edge(4,3,2));

        edges[4].add(new Edge(4,5,3));

        edges[4].add(new Edge(4,6,8));

        edges[5].add(new Edge(5,6,3));

        return edges;
    }
}
