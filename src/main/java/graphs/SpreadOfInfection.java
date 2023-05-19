package graphs;

import lombok.AllArgsConstructor;

import java.util.*;

public class SpreadOfInfection {
    public static void main(String[] args) {
        int vertices = 7;
        int sr = 6;
        ArrayList<Edge>[] edges = Util.getEdges(vertices);
        Set<Integer> infectedPeople = infectionSpread(edges, sr, vertices, 3);
        System.out.println(infectedPeople);
    }

    private static Set<Integer> infectionSpread(ArrayList<Edge>[] edges, int sr, int vertex, int timer){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sr+""));
        timer--;

        boolean[] visited = new boolean[vertex];
        Set<Integer> infectedPeople = new HashSet<>();
        infectedPeople.add(sr);
        while(!queue.isEmpty()){
            if(timer==0) break;
            Pair pair = queue.remove();
            int src = pair.src;
            if(visited[src]) continue;

            visited[src] = true;
            for(Edge edge : edges[src]){
                if(visited[edge.getDes()]) continue;
                infectedPeople.add(edge.getDes());
                queue.add(new Pair(edge.getDes(), pair.pathSoFar+"-"+edge.getDes()));
            }
            timer--;
        }
        return infectedPeople;
    }

    @AllArgsConstructor
    static class Pair{
        int src;
        String pathSoFar;
    }
}

