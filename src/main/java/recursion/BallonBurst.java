package recursion;

import java.util.Arrays;
import java.util.List;

//todo: answer is incorrect.
public class BallonBurst {
    public static void main(String[] args) {
        int[] ballons = {3,1,5,8};
        int[] modifiedBalloons = {1,3,1,5,8,1}; // adding 1 at first and last to original balloon array for computation
        int maxCoins = maxCoins(modifiedBalloons, 0,  ballons.length-1);
        System.out.println("maxcoins:"+maxCoins);

    }
    private static int maxCoins(int[] a, int i, int j){
        if(i>j) return 0;

        int max = Integer.MIN_VALUE;
        for(int idx=i; idx<=j; idx++){
           int coins = a[i]+a[idx]+a[j+1] + maxCoins(a, i, idx-1) + maxCoins(a, idx+1, j);
            max = Math.max(max, coins);
        }
        return max;
    }
}
