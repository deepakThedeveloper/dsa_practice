package graphs;

import lombok.AllArgsConstructor;

import java.util.*;

//if all the vertices of a graph is placed in two sets such that edges between these vertices lie across the set and
// should not be present in same set
public class BipartiteGraph {
    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] edges = Util.getEdges(vertices);

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

    // NOTE: if graph has no cycle or if graph has even length cycle then it is bipartite else if graph has odd length cycle
    // than it is not bipartite
    private static boolean bipartiteGaph(ArrayList<Edge>[] edges, int sr, int[] visited){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sr+"", 0));

        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            int src = pair.src;
            if(visited[src]!=-1){ // cycle detected
                if(visited[src] != pair.level) return false;
            }
            else {
                visited[src] = pair.level;
            }

            for(Edge edge : edges[src]){
                if(visited[edge.getDes()]!=-1) continue;
                queue.add(new Pair(edge.getDes(), pair.pathSoFar+"-"+edge.getDes(), pair.level+1));
            }
        }
        return true;
    }

    @AllArgsConstructor
    static class Pair{
        int src;
        String pathSoFar;
        int level;
    }
}

