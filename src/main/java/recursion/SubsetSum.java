package recursion;

import java.util.*;

public class SubsetSum {
    public static void main(String[] args) {
        //List<Integer> a = Arrays.asList(1,2,3);
        int[] a = {1,2,3,4};

        List<Integer> subsetSum = new ArrayList<>();
        subsetSum(a, new ArrayList<>(), 0, 0, subsetSum);
        System.out.println(val);
        System.out.println(subsetSum);

        int target = 4;
        int subsetCount = countSubsetSum(a, target, 0);
        System.out.println(subsetCount);
    }

    static List<List<Integer>> val = new ArrayList<>();

    private static void subsetSum(int[] ip, List<Integer> op, int i, int sum, List<Integer> subsetSum){
        if(ip.length == i){
            val.add(new ArrayList<>(op));
            subsetSum.add(sum);
            return;
        }
        op.add(ip[i]);
        subsetSum(ip, op, i+1, sum + ip[i], subsetSum);
        op.remove(op.size()-1);
        subsetSum(ip, op, i+1, sum, subsetSum);
    }

    private static int countSubsetSum(int[] a, int target, int i){
        if (target == 0) return 1;
        if (target < 0) return 0;
        if(i==a.length) return 0;

        return countSubsetSum(a, target-a[i], i+1)+
        countSubsetSum(a, target, i+1);
    }
}
