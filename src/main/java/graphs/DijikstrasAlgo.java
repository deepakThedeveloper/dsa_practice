package graphs;

import lombok.AllArgsConstructor;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//shortest distance from source to destination based on wt of edges
public class DijikstrasAlgo {
    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = Util.getEdges(vertices);
        int sr = 0;
        int de = 6;

        List<Integer> shortestPath = shortestPathViaBFS(graph, sr, de, new boolean[vertices]);
        System.out.println("shortest path:"+shortestPath+" wt:"+wtCount);

        boolean[] visited =  new boolean[vertices];
        visited[sr] = true;
        int wtCount1 = shortestPathViaDFS(graph, sr, de, visited, 0);
        System.out.println("shortest path via dfs"+finalPath+" wt:"+wtCount1);
    }

    static int wtCount = 0;
    //rm*wa*
    private static List<Integer> shortestPathViaBFS(ArrayList<Edge>[] edges, int sr, int de, boolean[] visited){
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(Comparator.comparingInt(p->p.weight));
        queue.add(new Pair(sr, 0, sr+""));
        List<Integer> path = new ArrayList<>();

        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            int src = pair.sr;
            if(visited[src]) continue;
            visited[src] = true;
            path.add(src);
            wtCount += pair.weight;

            for(Edge ed : edges[src]){
                if(visited[ed.getDes()]) continue;
                queue.add(new Pair(ed.getDes(), ed.getWt(), pair.path+"-"+ed.getDes()));
            }
        }
        return path;
    }

    static List<Integer> finalPath = new ArrayList<>();

    //todo: answer is gettign wrong
    private static int shortestPathViaDFS(ArrayList<Edge>[] graph, int sr, int des, boolean[] visited, int currWt){
        if(sr == des) return 0;

        int finalWt = Integer.MAX_VALUE;

        for(Edge edge : graph[sr]){
            if(visited[edge.getDes()]) continue;

            visited[edge.getDes()] = true;
           // finalPath.add(edge.getDes());
            int wt = shortestPathViaDFS(graph, edge.getDes(), des, visited, edge.getWt());
            //finalPath.remove(finalPath.size()-1);
            //finalPath.add(sr);
            finalWt = Math.min((wt+edge.getWt()), finalWt);
            visited[edge.getDes()] = false;
        }
        return finalWt;
    }

    @AllArgsConstructor
    static class Pair{
        int sr;
        int weight;
        String path;
    }
}
