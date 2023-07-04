package recursion.luck_based;

public class OptimalGameStrategy {
    public static void main(String[] args){
        int[] coins = {20, 30, 2, 10};
        int max = maxCoinCollection(coins, 0, coins.length-1, 62);
        System.out.println(max);
    }

    private static int maxCoinCollection(int[] arr, int i, int j, int sum){
        if (j == i + 1)
            return Math.max(arr[i], arr[j]);

        // For both of your choices, the opponent
        // gives you total sum minus maximum of
        // his value
        return Math.max(
                (sum - maxCoinCollection(arr, i + 1, j, sum - arr[i])),
                (sum - maxCoinCollection(arr, i, j - 1, sum - arr[j])));
    }
}
