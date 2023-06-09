package dynamicProgramming.catalan;

public class CombinationOfBalancedParanthesis {
    public static void main(String[] args) {
        int pairOfBrackets = 3;
        int[] dp = CatalanNumber.catalanNumber(pairOfBrackets);
        System.out.println(dp[pairOfBrackets]);
    }
}
