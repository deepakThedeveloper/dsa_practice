package dynamicProgramming.subset.combination.group6;

public class PartitionInKSubsets {
    public static void main(String[] args) {
        int n = 4, k = 3;
        int subsetCombination = partitionInKSubset(n, k);
        System.out.println(subsetCombination);
    }

    private static int partitionInKSubset(int players, int teams){
        int[][] dp =  new int[players+1][teams+1];
        dp[1][1] = 1;

        //fun(n,j) = k*(n-1 players in k teams) + n-1 players in k-1 teams.
        // n-1 players forming k teams, then nth player will sit in any of the team. so k * fun(n-1,k) +.....
        // n-1 players forming k-1 teams, then nth player has to create new team i.e. should sit in team which is empty.
        // therefore: fun(n, k) = k * fun(n-1, k) + fun(n-1, k-1);
        for(int i=2; i<=players; i++){
            for(int j=1; j<=teams; j++){
                dp[i][j] = (j*dp[i-1][j])+dp[i-1][j-1];
            }
        }
        return dp[players][teams];
    }
}
