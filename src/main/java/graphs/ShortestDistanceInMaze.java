package graphs;

import lombok.AllArgsConstructor;
import lombok.ToString;
import matrix.Util;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// the wt in every ecll represents ht of mountain.
// when comming from source to destination the height needs to be subtracted. Like wise traverse in all 4 directions
// from every cell till destination and caclulate efforts needed to reac the destination.
// amongst all path which ever path has min efforts that is the answer
public class ShortestDistanceInMaze {
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };
        int sr = 0, sc = 0, dr = 2, dc = 2;
        int minEffort= findMinEffortPath(mat, sr, sc, dr, dc);
        System.out.println(minEffort);
    }

    private static int findMinEffortPath(int[][] mat, int sr, int sc, int dr, int dc){
        int n = mat.length;
        int m = mat[0].length;

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        int[][] visited = Util.getMatrix(n, m, Integer.MAX_VALUE);
        PriorityQueue<Data> queue = new PriorityQueue<>(Comparator.comparingInt(d -> d.effort));
        queue.add(new Data(sr, sc, 0, sr+"-"+sc+"->"));
        while(!queue.isEmpty()){
            Data data = queue.poll();
            int cr = data.sr, cc = data.sc, pastEffort = data.effort;
            for(int i=0; i<4; i++){
                int nr = cr+row[i];
                int nc = cc+col[i];

                if(nr>=0 && nc>=0 && nr<mat.length && nc<mat[0].length){
                    int curEffort = Math.abs(mat[nr][nc] - mat[cr][cc]);
                    int newEffort = Math.max(curEffort, pastEffort);
                    if(visited[nr][nc] > newEffort){
                        visited[nr][nc] = newEffort;
                        Data d = new Data(nr, nc, newEffort, data.psf+nr+"-"+nc+"->");
                        queue.add(d);
                    }
                }
            }
        }
        return visited[dr][dc];
    }

    @AllArgsConstructor
    @ToString
    static class Data{
        int sr;
        int sc;
        int effort;
        String psf;
    }
}
