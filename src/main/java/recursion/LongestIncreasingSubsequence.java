package recursion;

import matrix.Util;

import java.util.Arrays;
import java.util.stream.IntStream;

import static com.sun.tools.attach.VirtualMachine.list;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
       // int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] a = {5,4,11,1,16,8};
        int lis = lis(0, -1, a);
        System.out.println("recursion lis:"+lis);

        int lis1 = lisApproach2(a);
        System.out.println("iteration lis:"+lis1);
    }

    private static int lis(int idx, int prev, int[] a){
        if(idx==a.length) return 0;

        int notTake = lis(idx+1, prev, a);
        int take = Integer.MIN_VALUE;
        if(prev ==-1 || a[idx]>a[prev])
            take = lis(idx+1, idx, a) + 1;

        return Math.max(notTake, take);
    }

    // better approach
    private static int lisApproach2(int[] a){
        int[] count = new int[a.length];
        int[] hash = new int[a.length];
        System.out.println();
        Arrays.fill(count, 1);
        int max = 1, maxIndex = 1;
        for(int i=0; i<a.length; i++){
            hash[i] = i;
            for(int j=0; j<i; j++){
                if(a[i]>a[j] && 1+count[j] > count[i]){
                    count[i] = 1+count[j];
                    hash[i] = j;
                }
            }
            if(count[i]>max) {
                max = count[i];
                maxIndex = i;
            }
        }
        int i=maxIndex;
        while(i>0){
            System.out.print(a[i]+" ");
            i=hash[i];
        }
        System.out.print(a[i]+"\n ");
        return max;
    }

    // all above approach gives result in O(N^2). so this approach 3 will use N traversal and for every traversal do
    // binary search and so will get output in NlogN. This technique doesn't give proper subsequence, but it will give
    // length. so use this technique only when just need to print the length of LIS and not actual LIS value.
    // Will code later. Striver DP series DP 43
    private static int lisApproach3(int[] a){
        return 0;
    }

}
