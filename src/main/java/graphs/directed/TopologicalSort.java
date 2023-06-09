package graphs.directed;

import graphs.Edge;
import graphs.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// topological sorted works only on DAG(Directed Acyclic Graph). When traversing from u to v, u should always appear before v
public class TopologicalSort {
    public static void main(String[] args){
        int vertices = 7;
        List<Edge>[] graph = Util.getDirectedGraph(vertices);
        topo2(graph, vertices);

        int vertex = 8;
        List<List<Integer>> graph1 = Util.adjacencyDirectedListAcyclic(vertex);
        List<Integer> result = topoRevisionDFS(graph1, vertex);
        System.out.println("dfs revision:"+result);
    }

    public static List<Integer> topoRevisionDFS(List<List<Integer>> graph, int vertices){
        System.out.println(graph);
        boolean[] visited = new boolean[vertices];
        Stack<Integer> result = new Stack<>();
        List<Integer> result1 = new ArrayList<>();
        for(int i=0; i<vertices; i++){
            if(!visited[i]){
                visited[i] = true;
                traverseDFS(graph, i, visited, result);
            }
        }
        while(!result.isEmpty()){
            result1.add(result.pop());
        }
        return result1;
    }

    private static void traverseDFS(List<List<Integer>> graph, int sr, boolean[] visited, Stack<Integer> result){
        for(Integer v : graph.get(sr)){
            if(!visited[v]){
                visited[v] = true;
                traverseDFS(graph, v, visited, result);
            }
        }
        result.push(sr);
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
}
