package recursion.subset;

import java.util.*;

// print sum of all subsets in ascending order
public class SubsetSum1 {
    public static void main(String[] args) {
        int[] a = {3,1,2};
        Arrays.sort(a);
        List<Integer> subsetSum = new ArrayList<>();
        subsetSum(a, a.length-1, 0, subsetSum);
        System.out.println(subsetSum);
    }

    private static void subsetSum(int[] ip, int idx, int sum, List<Integer> subsetSum){
        if(idx == -1){
            subsetSum.add(sum);
            return;
        }
        subsetSum(ip, idx-1, sum, subsetSum);
        subsetSum(ip, idx-1, sum + ip[idx], subsetSum);
    }
}
