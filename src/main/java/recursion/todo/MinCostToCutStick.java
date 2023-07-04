package recursion.todo;

import java.util.Arrays;

public class MinCostToCutStick {
    public static void main(String[] args){
        int[] cuts = {1,4,3,5};
        Arrays.sort(cuts);

        int stickLength = 7;
        int minCost = minCost(cuts, 1, 3);
        System.out.println(minCost);
    }

    //todo
    private static int minCost(int[] cuts, int i, int j){
        if(i > j) return 0;

        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int left = minCost(cuts, i, k-1);
            int right = minCost(cuts, k+1, j);

            int totalCost =  cuts[j+1] - cuts[i-1] + left + right;

            min = Math.min(min, totalCost);
        }
        return min;
    }
}
