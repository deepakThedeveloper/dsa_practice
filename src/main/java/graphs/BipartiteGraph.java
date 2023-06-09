package graphs;

import javafx.util.Pair;
import lombok.AllArgsConstructor;

import java.util.*;

//if all the vertices of a graph is placed in two sets such that edges between these vertices lie across the set and
// should not be present in same set
public class BipartiteGraph {
    public static void main(String[] args) {
        int vertices = 7;

        List<List<Integer>> graph = Util.adjacencyList(vertices);
        boolean isBipartite = bipartiteGraphBFSRevision(graph);
        System.out.println("bipartite graph using BFS odd list:"+isBipartite);

        List<List<Integer>> graph1 = Util.cycleLessGraph(vertices);
        boolean isBipartite1 = bipartiteGraphBFSRevision(graph1);
        System.out.println("bipartite graph using BFS cycles graph:"+isBipartite1);

        List<List<Integer>> graph2 = Util.evenNodeCyclicUndirectedGraph(vertices+1);
        boolean isBipartite2 = bipartiteGraphBFSRevision(graph2);
        System.out.println("bipartite graph using BFS even cycle graph:"+isBipartite2);

        boolean isBipartite3 = bipartiteGraphDFSRevision(graph);
        System.out.println("bipartite graph using DFS odd list:"+isBipartite3);

        boolean isBipartite4 = bipartiteGraphDFSRevision(graph1);
        System.out.println("bipartite graph using DFS cycles graph:"+isBipartite4);

        boolean isBipartite5 = bipartiteGraphDFSRevision(graph2);
        System.out.println("bipartite graph using DFS even cycle graph:"+isBipartite5);

        ArrayList<Edge>[] edges = Util.getEdges(vertices);
        bipartiteGraphUsingAdjacencyArray(edges, vertices);
    }

    private static boolean bipartiteGraphDFSRevision(List<List<Integer>> graph){
        int[] visited = new int[graph.size()];
        Arrays.fill(visited, -1);
        for(int i=0; i<graph.size(); i++){
            if(visited[i]!=-1)continue;
            visited[i] = 0;
            boolean bipartite = isGraphBipartiteDFS(graph, i, visited);
            if(!bipartite) return false;
        }
        return true;
    }

    private static boolean isGraphBipartiteDFS(List<List<Integer>> graph, int sr, int[] visited){
        for(Integer nbr : graph.get(sr)) {
            if (visited[nbr] == -1) {
                visited[nbr] = visited[sr] == 0 ? 1 : 0;
                boolean isBipartite = isGraphBipartiteDFS(graph, nbr, visited);
                if(!isBipartite) return false;
            }
            else if(visited[sr] == visited[nbr]){
                return false;
            }
        }
        return true;
    }

    private static void bipartiteGraphUsingAdjacencyArray(ArrayList<Edge>[] edges, int vertices){
        int[] visited = new int[vertices];
        Arrays.fill(visited, -1);
        boolean isBipartite = true;
        for(int i=0; i<vertices; i++){
            if(visited[i] == -1) { // not visited
                isBipartite  = bipartiteGaph(edges, i, visited);
                if(!isBipartite) break;;
            }
        }
        System.out.println("graph isBipartite:"+isBipartite);
    }

    private static boolean bipartiteGraphBFSRevision(List<List<Integer>> graph){
        int[] visited = new int[graph.size()];
        Arrays.fill(visited, -1);
        for(int i=0; i<graph.size(); i++){
            if(visited[i]!=-1)continue;
            boolean bipartite = isGraphBipartiteBFS(graph, i, visited);
            if(!bipartite) return false;
        }
        return true;
    }

    private static boolean isGraphBipartiteBFS(List<List<Integer>> graph, int i, int[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = 0;
        while(!queue.isEmpty()){
            Integer sr = queue.poll();
            int col = visited[sr];
            for(Integer nbr : graph.get(sr)){
                if(visited[nbr] == -1){
                    visited[nbr] = col == 0 ? 1 : 0;
                    queue.add(nbr);
                }
                else if(col == visited[nbr]){
                    return false;
                }
            }
        }
        return true;
    }

    // NOTE: if graph has no cycle or if graph has even length cycle then it is bipartite else if graph has odd length cycle
    // than it is not bipartite
    private static boolean bipartiteGaph(ArrayList<Edge>[] edges, int sr, int[] visited){
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(sr, sr+"", 0));

        while(!queue.isEmpty()){
            Data data = queue.remove();
            int src = data.src;
            if(visited[src]!=-1){ // cycle detected
                if(visited[src] != data.level) return false;
            }
            else {
                visited[src] = data.level;
            }

            for(Edge edge : edges[src]){
                if(visited[edge.getDes()]!=-1) continue;
                queue.add(new Data(edge.getDes(), data.pathSoFar+"-"+edge.getDes(), data.level+1));
            }
        }
        return true;
    }

    @AllArgsConstructor
    static class Data {
        int src;
        String pathSoFar;
        int level;
    }
}

