package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class TopologicalSort {
    public static void main(String[] args){
        int vertices = 7;
        int[] vertex = {0,1,2,4,5};
        List<Edge>[] graph = Util.getDirectedGraph(vertices);
        topo2(graph, vertices);
    }

    //  my approach. works but I have better datastructure and code below using stack of SummitMalick
    private static void topo1(List<Edge>[] graph, int vertices){
        boolean[] visited = new boolean[vertices];
        List<Integer> paths = new ArrayList<>();
        for(int i=0; i<vertices; i++){
            if(visited[i]) continue;
            visited[i] = true;
            List<Integer> path = topologicalSort(graph, i, visited);
            paths.addAll(path);
        }
        System.out.println(paths);
    }

    private static void topo2(List<Edge>[] graph, int vertices){
        boolean[] visited = new boolean[vertices];
        Stack<Integer> paths = new Stack<>();
        for(int i=0; i<vertices; i++){
            if(visited[i]) continue;
            visited[i] = true;
            topologicalSortBetterApproach(graph, i, visited, paths);
        }
        System.out.println(paths);
    }

    private static List<Integer> topologicalSort(List<Edge>[] graph, int sr, boolean[] visited){
        if(graph[sr] == null){
            List<Integer> path = new ArrayList<>();
            path.add(sr);
            return path;
        }

        List<Integer> finalPaths = new ArrayList<>();
        for(Edge ed : graph[sr]){
            int newSr = ed.getDes();
            if(visited[newSr]) continue;
            visited[newSr] = true;
            List<Integer> paths = topologicalSort(graph, newSr, visited);
            finalPaths.addAll(paths);
            finalPaths.add(sr);
        }
        return finalPaths;
    }

    private static void topologicalSortBetterApproach(List<Edge>[] graph, int sr, boolean[] visited,
                                                               Stack<Integer> stack){
        for(Edge ed : graph[sr]){
            int newSr = ed.getDes();
            if(visited[newSr]) continue;
            visited[newSr] = true;
            topologicalSortBetterApproach(graph, newSr, visited, stack);
        }
        stack.push(sr);
    }
}
