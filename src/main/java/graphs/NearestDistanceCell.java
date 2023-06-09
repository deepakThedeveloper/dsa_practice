package graphs;

import javafx.util.Pair;
import matrix.Util;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NearestDistanceCell {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0}, {0,1,0}, {1,0,1}};
        System.out.println("original matrix=================================");
        Util.printMatrix(mat);

        int[][] result = populateNearestDistance(mat);
        System.out.println("result matrix=================================");
        Util.printMatrix(result);
    }

    private static int[][] populateNearestDistance(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Pair<Pair<Integer, Integer>, Integer>> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && mat[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new Pair<>(new Pair<>(i, j), 0));
                }
            }
        }

        return traverse(mat, queue, visited);
    }

    private static int[][] traverse(int[][] mat, Queue<Pair<Pair<Integer, Integer>, Integer>> queue, boolean[][] visited){
        int n = mat.length;
        int m = mat[0].length;

        int[][] result = new int[n][m];
        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            Pair<Pair<Integer, Integer>, Integer> pair = queue.poll();
            int i = pair.getKey().getKey();
            int j = pair.getKey().getValue();
            int dist = pair.getValue();
            result[i][j] = dist;

            for(int k=0; k<4; k++){
                int nr = i+row[k];
                int nc = j+col[k];

                if(nr<0 || nr>=n || nc<0 || nc>=m || visited[nr][nc] || mat[nr][nc] == 1) continue;
                visited[nr][nc] = true;
                queue.add(new Pair<>(new Pair<>(nr, nc), dist+1));
            }
        }
        return result;
    }
}
