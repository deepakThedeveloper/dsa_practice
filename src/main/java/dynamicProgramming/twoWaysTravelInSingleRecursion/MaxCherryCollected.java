package dynamicProgramming.twoWaysTravelInSingleRecursion;

public class MaxCherryCollected {
    public static void main(String[] args){
        int[][] cherries = {
                {1,1,1,0,-1},
                {0,0,1,0,0},
                {0,0,1,0,1},
                {1,0,1,0,0},
                {-1,0,1,1,1},
        };
        int n = cherries.length, m = cherries[0].length;

        int max = maxCherriesTopToBottomMax(cherries, 0, 0, 0, new int[n][m][n*m]);
        System.out.println("approach 1:"+max);

        int max1 = maxCherriesApproach2Memo(0, 0, 0,0, cherries, new int[n][m][n][m]);
        System.out.println("approach 2:"+max1);
    }

    //rather than one person traversing till last and collecting the cherries and again comming back and collecting cherries while comming,
    // lets make 2 persons travel from start till end in their own direction but taking one step at same time.
    // this is similar to problem  taught by striver of 2 friends collecting choclates at same time.
    //r1, c1 = row and col of person 1 anc r2,c2 is row and col of person 2
    private static int maxCherriesApproach2Memo(int r1, int c1, int r2, int c2, int[][] cherries, int[][][][] dp){
        if(r1>=cherries.length || r2>=cherries.length || c1>=cherries[0].length || c2>=cherries[0].length
                || cherries[r1][c1] == -1|| cherries[r2][c2] == -1) return 0;

        if(r1 == cherries.length-1 && c1 == cherries[0].length-1){
            return cherries[r1][c1];
        }
        if(dp[r1][c1][r2][c2] != 0) return dp[r1][c1][r2][c2];
        int cherry = 0;
        if(r1 == r2 && c1 == c2){
            // both person on same spot so pick cherry only once
            cherry += cherries[r1][c1];
        }
        else{
            // both person on different spot so pick cherry only once
            cherry += cherries[r1][c1] + cherries[r2][c2];
        }

        int hhCollection = maxCherriesApproach2Memo(r1, c1+1, r2, c2+1, cherries, dp); //h,h
        int hvCollection = maxCherriesApproach2Memo(r1, c1+1, r2+1, c2, cherries, dp); //h,h
        int vhCollection = maxCherriesApproach2Memo(r1+1, c1, r2, c2+1, cherries, dp); //h,h
        int vvCollection = maxCherriesApproach2Memo(r1+1, c1, r2+1, c2, cherries, dp); //h,h

        cherry += Math.max(Math.max(hhCollection, hvCollection), Math.max(vhCollection, vvCollection));

        return dp[r1][c1][r2][c2] = cherry;
    }

    // after exploring one path from top to bottom, it needs to come back from bottom to top so it gives call to bottomToTop() method
    // and the bottomToTop method explores all the possible paths for every single call from this method.
    // in itself this method without bottomToTop call is 2^n*m, and when giving call to bottomToTop its timecomplexity becomes
    // (2^n*m) * (2^n*m)
    private static int maxCherriesTopToBottomMax(int[][] cherries, int sr, int sc, int sum, int[][][] dp){
        if(sr>=cherries.length || sc>=cherries[0].length || cherries[sr][sc] == -1) return 0 ;
        if(sr == cherries.length-1 && sc == cherries[0].length-1){
            return maxCherriesBottomToTopMax(cherries, sr, sc, sum, new int[cherries.length][cherries[0].length][cherries.length * cherries[0].length]);
        }

        if(dp[sr][sc][sum] != 0) {
            return dp[sr][sc][sum];
        }
        int cherry = cherries[sr][sc];
        cherries[sr][sc] = 0;

        int max = Integer.MIN_VALUE;
        int v1 = maxCherriesTopToBottomMax(cherries, sr, sc+1, sum + cherry, dp);
        int v2 = maxCherriesTopToBottomMax(cherries, sr+1, sc, sum + cherry, dp);
        cherries[sr][sc] = cherry;

        return dp[sr][sc][sum] = Math.max(max, Math.max(v1, v2));
    }

    // whenever it gets call from topToBottomMax() method, it doesn't care about the path in which the topToBottom() has traversed
    // its job is it needs to explore all paths from bottom to top in such a way that the sum should be maximum.
    // so for one path of topToBottom() it explores all paths from bottomToTop.
    // its individual time complexity is 2^n*m for every single call from topToBottom() method.
    private static int maxCherriesBottomToTopMax(int[][] cherries, int sr, int sc, int sum, int[][][] dp){
        if(sr<0 || sc<0 || cherries[sr][sc] == -1) return 0;

        if(sr == 0 && sc == 0){
            return sum + cherries[sr][sc];
        }

        if(dp[sr][sc][sum] != 0) return dp[sr][sc][sum];
        int max = Integer.MIN_VALUE;
        int cherry = cherries[sr][sc];
        cherries[sr][sc] = 0;
        int v1 = maxCherriesBottomToTopMax(cherries, sr, sc-1, sum + cherry, dp);
        int v2 = maxCherriesBottomToTopMax(cherries, sr-1, sc, sum + cherry, dp);
        cherries[sr][sc] = cherry;

        return dp[sr][sc][sum] = Math.max(max, Math.max(v1, v2));
    }
}
