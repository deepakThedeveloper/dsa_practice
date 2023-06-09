package graphs;

import lombok.AllArgsConstructor;
import matrix.Util;

import java.util.LinkedList;
import java.util.Queue;

//0 - empty, 1 - fresh orange, 2 - rotten orange :: need to find time required to rotten all oranges
public class RottenOranges {
    public static void main(String[] args) {
        int[][] mat = {{0,1,2},{0,1,2},{2,1,1}};
        int sr  = 0, sc = 0;
        int time = rottenOrangesBFS(mat, sr, sc);
        System.out.println("time taken bfs:"+time);
    }

    private static int rottenOrangesBFS(int[][] m1, int sr, int sc) {
        int[][] mat = Util.createCopy(m1);
        Util.printMatrix(mat);
        System.out.println("===================================");
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0 || mat[i][j] == 1 || visited[i][j]) continue;
                visited[i][j] = true;
                queue.add(new Pair(i, j, 0));
            }
        }
        int time = findTime(queue, mat, visited);
        Util.printMatrix(mat);
        return time;
    }

    private static int findTime(Queue<Pair> queue, int[][] mat, boolean[][] visited){
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};
        int time = 0;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            for(int k=0; k<4; k++){ // one technique to traverse up, down, left, right. Another technique is in flood fill
                int newR = pair.i+row[k];
                int newC = pair.j+col[k];

                if(newR<0 || newR>=mat.length || newC<0 || newC>=mat[0].length || visited[newR][newC] || mat[newR][newC] == 2 || mat[newR][newC] == 0) continue;
                mat[newR][newC] = 2;
                visited[newR][newC] = true;
                int newTime = pair.time+1;
                time  = Math.max(time, newTime);
                queue.add(new Pair(newR, newC, newTime));
            }
        }
        return time;
    }

    @AllArgsConstructor
    static class Pair{
        int i;
        int j;
        int time;
    }
}
