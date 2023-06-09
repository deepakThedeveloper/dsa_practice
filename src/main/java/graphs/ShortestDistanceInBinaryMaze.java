package graphs;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMaze {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,1,1},
                {1,1,0,1},
                {1,1,1,1},
                {1,1,0,0},
                {1,0,0,0}
        };
        int sr = 0, sc = 1, dr = 2, dc = 2;
        Data data = findShortestPath(mat, sr, sc, dr, dc);
        System.out.println(data);
    }

    private static Data findShortestPath(int[][] mat, int sr, int sc, int dr, int dc){
        int n = mat.length;
        int m = mat[0].length;

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        boolean[][] visited = new boolean[n][m];
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(sr, sc, 1, sr+"-"+sc+"->"));
        while(!queue.isEmpty()){
            Data data = queue.poll();
            for(int i=0; i<4; i++){
                int nr = data.sr+row[i];
                int nc = data.sc+col[i];

                if(nr>=0 && nc>=0 && nr<mat.length && nc<mat[0].length && !visited[nr][nc] && mat[nr][nc] == 1){
                    visited[nr][nc] = true;
                    Data d = new Data(nr, nc, data.wt+1, data.psf+nr+"-"+nc+"->");
                    queue.add(d);
                    if(nr == dr && nc == dc){
                        return d;
                    }
                }
            }
        }
        return null;
    }

    @AllArgsConstructor
    @ToString
    static class Data{
        int sr;
        int sc;
        int wt;
        String psf;
    }
}
