package recursion.subset;

import java.util.*;

// print sum of all subsets in ascending order
public class SubsetSum2 {
    public static void main(String[] args) {
        int[] a = {1,2,2};
        Arrays.sort(a);
        List<List<Integer>> subset = new ArrayList<>();
        subsetBetterApproach(a, 0, new ArrayList<>(), subset, -1);
        System.out.println(subset);

        List<List<Integer>> subset1 = new ArrayList<>();
        findPairs(0, a, new ArrayList<>(), subset1);
        System.out.println(subset1);

        List<List<Integer>> subset2 = new ArrayList<>();
        findPairsBestApproach(0, a, new ArrayList<>(), subset2);
        System.out.println(subset2);
    }

    // leetcode tested
    private static void findPairsBestApproach(int start, int[] val, ArrayList<Integer> subset, List<List<Integer>> finalList){
        finalList.add(new ArrayList<>(subset));
        for(int i=start; i<val.length; i++) {
            if(i != start && val[i] == val[i-1]){
                continue;
            }
            subset.add(val[i]);
            findPairs(i+1, val, subset, finalList);
            subset.remove(subset.size() - 1);
        }
    }

    // leetcode tested: https://leetcode.com/problems/subsets-ii/submissions/970257359/
    private static void subsetBetterApproach(int[] ip, int i, List<Integer> op, List<List<Integer>> subsets, int notTaken){
        if(i == ip.length){
            subsets.add(new ArrayList<>(op));
            return;
        }
        if(notTaken==-1 || ip[i] != ip[notTaken]) {
            op.add(ip[i]);
            subsetBetterApproach(ip, i + 1, op, subsets, notTaken);
            op.remove(op.size() - 1);
        }
        subsetBetterApproach(ip, i+1, op, subsets, i);
    }

    // leetcode tested
    private static void findPairs(int start, int[] val, ArrayList<Integer> subset, List<List<Integer>> finalList){
        if(start==val.length){
            finalList.add(new ArrayList<>(subset));
            return;
        }
        for(int i=start; i<=val.length; i++) {
            if(i>start && i<val.length && val[i] == val[i-1]){
                continue;
            }
            if(i==val.length){
                findPairs(i, val, subset, finalList);
            }
            else{
                subset.add(val[i]);
                findPairs(i+1, val, subset, finalList);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
