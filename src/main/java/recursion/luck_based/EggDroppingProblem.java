package recursion.luck_based;

import matrix.Util;

public class EggDroppingProblem {
    public static void main(String[] args){
        int eggs = 3, floors = 7;
        int minAttempts = minAttemptsToFindCriticalFloorDirect(eggs, floors);
        System.out.println(minAttempts);
    }

    private static int minAttemptsToFindCriticalFloorDirect(int eggs, int floors){
        int[][] dp = new int[eggs+1][floors+1];

        // for single egg and n floors we have to go to every floor from 1st till nth floor. no option
        for(int c = 1; c<=floors; c++){
            dp[1][c] = c;
        }

        //for 1 floor and n eggs, we can find critical floor only in 1 attempt because floor itself is 1
        for(int r=1; r<=eggs; r++){
            dp[r][1] = 1;
        }

        for(int i=2; i<=eggs; i++){
            for(int j=2; j<=floors; j++){
                int min = Integer.MAX_VALUE;

                //for every cell, find max of all its previous rows in form of catalan. i-1 row and ith row represents
                // egg will break or not break. take max of break and not break and do it for all the cols from j-1 till 0;
                // then from max of all min+1 is our answer
                for(int k=0, m=j-1; k<j && m>=0; k++, m--){
                    min = Math.min(min, Math.max(dp[i-1][k], dp[i][m]));
                }
                dp[i][j] = min+1;
            }
        }
        Util.printMatrix(dp);
        return dp[eggs][floors];
    }
}
