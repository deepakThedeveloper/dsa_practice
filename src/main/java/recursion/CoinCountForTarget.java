package recursion;

// infinite supply of coin denom is present. a target is given. when we sum up the coins we will reach to target.
// need to find minimum number of coin needed to reach to target.e.g: 1,2,3 - target 5. combination[2,2,1] || [2,3].
// as min coins needed for [2,3] is 2 we need to return 2.
public class CoinCountForTarget {
    public static void main(String[] args) {
        int[] denom = {1,2,3};
        int target = 7;

        int minCoinsNeeded = minCoinsForTargetK(denom, denom.length-1, target);
        System.out.println(minCoinsNeeded);
    }

    private static int minCoinsForTargetK(int[] denom, int n, int target){
        if(n==0){
            if(target % denom[0]== 0) return target/denom[0];
            else return Integer.MAX_VALUE;
        }

      //  if(target<=0) return 0;
        /**here we don't need to put condtion because condition is already put below if(denom[n]<=target)
         * if condition would not have been put below then we need condition. in both the place if we are not putting
         * condition then it will go infinite loop
         */
        int notPick = minCoinsForTargetK(denom, n-1, target);
        int pick = Integer.MAX_VALUE;
        if(denom[n]<=target){
            pick = 1+ minCoinsForTargetK(denom, n, target-denom[n]);
        }
        return Math.min(pick, notPick);
    }
}
