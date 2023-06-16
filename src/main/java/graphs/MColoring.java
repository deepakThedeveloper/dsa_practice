package graphs;

// same as bipartite graph with 2 color. here instead of 2 there is m color and solved using recursion
public class MColoring {
    public static void main(String[] args){
        boolean[][] graph = {
                {false, true, true, false},
                {false, false, true, false},
                {false, false, false, true},
                {true, false, false, false},
        };
        int vertices = 4;
        int color = 3;
        int[] colors = new int[vertices];
        boolean canColor =  colorNode(0, color, colors, graph, vertices);
        System.out.println("can color:"+canColor);
    }

    // GFG verified: https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
    private static boolean colorNode(int node, int m, int[] colors, boolean[][] graph, int vertices){
        if(node == vertices){
            for(int i=0; i<vertices; i++){
                if(colors[i] == 0) return false;
            }
            return true;
        }
        for(int i = 1; i <= m; i++){
            if(canColorNode(node, i, graph, colors)){
                colors[node] = i;
                boolean valid = colorNode(node+1, m, colors, graph, vertices);
                if(valid) return true;
                colors[node] = 0;
            }
        }
        return false;
    }

    private static boolean canColorNode(int node, int color, boolean[][] graph, int[] colors){
        for(int i = 0; i < graph[node].length; i++){
            if(!graph[node][i]) continue;
            if(colors[i] == color) return false;
        }
        return true;
    }

}
