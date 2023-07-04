package dynamicProgramming.subset.combination.group3;

import matrix.Util;

//there is rod between which separates the area in two sections. at each section there are three plots available.
// at every plot you can keep either building or leave that plot empty.
// need to find total combinations in which both the sections can be filled with constraint that no two buildings can be adjacent
//to each other.
public class ArrangeBuildings {
    public static void main(String[] args) {
        int plots=3;
        int oneSectionArrangements = countBuildingSpaceArrangementTabulationDirect(plots);
        int totalArrangements = oneSectionArrangements * oneSectionArrangements;
        System.out.println("tabulation:"+totalArrangements);
    }

    // same solution as count binary string of n len with no consecutive zero.
    private static int countBuildingSpaceArrangementTabulationDirect(int plots){
        int[][] dp = new int[2][plots+1];
        dp[0][1] = dp[1][1] = 1;

        for(int c=2; c<=plots; c++){
            dp[0][c] = dp[1][c-1];
            dp[1][c] = dp[0][c-1] + dp[1][c-1];
        }
        Util.printMatrix(dp);
        return dp[0][plots] + dp[1][plots];
    }
}
