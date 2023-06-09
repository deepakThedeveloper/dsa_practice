package graphs;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<List<Integer>> cycleLessGraph(int vertex){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(3);
        graph.get(3).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(3).add(4);
        graph.get(4).add(3);

        graph.get(4).add(5);
        graph.get(5).add(4);

        graph.get(5).add(6);
        graph.get(6).add(5);

        return graph;
    }

    public static List<List<Integer>> adjacencyList(int vertex){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(3);
        graph.get(3).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(4);
        graph.get(4).add(3);

        graph.get(4).add(5);
        graph.get(5).add(4);

        graph.get(4).add(6);
        graph.get(6).add(4);

        graph.get(5).add(6);
        graph.get(6).add(5);

        return graph;
    }

    public static List<List<Integer>> adjacencyDirectedListCyclic(int vertex) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(4);
        graph.get(0).add(1);

        graph.get(1).add(2);

        graph.get(2).add(3);

        graph.get(3).add(1);

        graph.get(4).add(5);
        graph.get(4).add(6);

        graph.get(5).add(7);

        graph.get(6).add(7);

        return graph;
    }

    public static List<List<Integer>> newAdjacencyList(){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<6; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(5).add(0);
        graph.get(5).add(2);

        graph.get(4).add(0);
        graph.get(4).add(1);

        graph.get(2).add(3);
        graph.get(3).add(1);

        return graph;
    }

    public static List<List<Integer>> adjacencyDirectedListAcyclic(int vertex) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<8; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(4);

        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(3);

        graph.get(4).add(5);
        graph.get(4).add(6);

        graph.get(5).add(7);

        graph.get(6).add(7);

        return graph;
    }

    public static List<List<Integer>> evenNodeCyclicUndirectedGraph(int vertex){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(3);
        graph.get(3).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(4);
        graph.get(4).add(3);

        graph.get(4).add(5);
        graph.get(5).add(4);

        graph.get(4).add(6);
        graph.get(6).add(4);

        graph.get(5).add(7);
        graph.get(7).add(5);

        graph.get(6).add(7);
        graph.get(7).add(6);

        return graph;
    }

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

    public static List<List<Pair<Integer, Integer>>> directedAcyclicWtGraph() {
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for(int i=0; i<7; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Pair<>(1, 2));
        graph.get(1).add(new Pair<>(3, 1));
        graph.get(2).add(new Pair<>(3, 3));
        graph.get(6).add(new Pair<>(4, 2));
        graph.get(6).add(new Pair<>(5, 3));
        graph.get(4).add(new Pair<>(0, 3));
        graph.get(4).add(new Pair<>(2, 1));
        graph.get(5).add(new Pair<>(4, 1));

        return graph;
    }

    public static List<List<Pair<Integer, Integer>>> unDirectedWtGraph() {
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for(int i=0; i<7; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Pair<>(1, 2));
        graph.get(1).add(new Pair<>(0, 2));
        graph.get(1).add(new Pair<>(3, 1));
        graph.get(3).add(new Pair<>(1, 1));
        graph.get(2).add(new Pair<>(3, 3));
        graph.get(3).add(new Pair<>(2, 3));
        graph.get(6).add(new Pair<>(4, 2));
        graph.get(4).add(new Pair<>(6, 2));
        graph.get(6).add(new Pair<>(5, 3));
        graph.get(5).add(new Pair<>(6, 3));
        graph.get(4).add(new Pair<>(0, 3));
        graph.get(0).add(new Pair<>(4, 3));
        graph.get(4).add(new Pair<>(2, 1));
        graph.get(2).add(new Pair<>(4, 1));
        graph.get(5).add(new Pair<>(4, 1));
        graph.get(4).add(new Pair<>(5, 1));

        return graph;
    }

    public static int[][] undirectedGraph(int vertices) {
        int[][] graph = matrix.Util.getMatrix(vertices, vertices, 0);
        graph[0][1] = 1;
        graph[1][0] = 1;
        graph[1][2] = 1;
        graph[2][1] = 1;
        graph[3][4] = 1;
        graph[4][3] = 1;
        graph[5][6] = 1;
        graph[6][5] = 1;

        return graph;
    }
}
