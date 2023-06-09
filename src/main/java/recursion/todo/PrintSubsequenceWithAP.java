package recursion.todo;

import java.util.List;

public class PrintSubsequenceWithAP {
    public static void main(String[] args) {
        int[] a = {1,3,2,5,3, 7, 9};
        int max = maxSubsequenceLengthWithAP(0, a.length, 0, -1,  a, "");
        System.out.println(max);
    }

    private static int maxSubsequenceLengthWithAP(int i, int n, int prev, int diff, int[] a, String op){
        if(i==n){
            System.out.println(op);
            return 0;
        }

        int take = 0;
        if(diff == -1){
            take  = maxSubsequenceLengthWithAP(i+1, n, a[i], 0, a, op+a[i]) + 1;
        }
        else if(diff == 0){
            if(a[i] > prev){
                take = maxSubsequenceLengthWithAP(i+1,n, a[i], a[i]-prev, a, op+a[i]) + 1;
            }
        }
        else if(a[i] - prev == diff){
            take = maxSubsequenceLengthWithAP(i+1, n, a[i], a[i]-prev, a, op+a[i]) + 1;
        }

        int notTake = maxSubsequenceLengthWithAP(i+1, n, prev, diff, a, op);

        return Math.max(notTake, take);
    }
}
