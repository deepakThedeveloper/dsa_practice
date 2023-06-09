package recursion;

public class MaxGoldMineMediumDifficult {
    public static void main(String[] args) {
        int[][] gold = {
                {10, 0, 20, 0,  0,   0},
                {20, 0, 0,  0,  0,   0},
                { 0, 0, 0,  0,  10,  0},
                { 5, 6, 0,  20, 30, 40},
                { 8, 9, 0,  50, 60, 70},
        };

        int rlen = gold.length;
        int clen = gold[0].length;
        boolean[][] visited = new boolean[rlen][clen];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<rlen; i++) {
            for(int j=0; j<clen; j++){
                if(gold[i][j] !=0 && !visited[i][j]){
                    int sum = maxGoldRecursionRevision(gold, i, j, visited);
                    max = Math.max(sum, max);
                }
            }
        }
        System.out.println("max profit:"+max);
    }

    private static int maxGoldRecursionRevision(int[][] a, int sr, int sc, boolean[][] visited){
        if(sr >=a.length || sc>=a[0].length || sr<0 || sc<0 || visited[sr][sc] || a[sr][sc]==0) return 0;

        visited[sr][sc] = true;
        int sum = 0;
        int v1 = maxGoldRecursionRevision(a, sr - 1, sc, visited); // top
        int v2 = maxGoldRecursionRevision(a, sr, sc + 1, visited); // right
        int v3 = maxGoldRecursionRevision(a, sr, sc - 1, visited); // left
        int v4 = maxGoldRecursionRevision(a, sr + 1, sc, visited); // down

        return v1+v2+v3+v4 + a[sr][sc];
        //return sum;
    }
}
