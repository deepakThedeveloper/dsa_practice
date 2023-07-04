package recursion.subset.combination;

import java.util.*;
import arrays.Util;

public class Combination2 {
    public static void main(String[] args) {
//        int[] a1 = {2,5,2,1,2};
        int k = 8;
//        Set<List<Integer>> combo = new HashSet<>();
//        combinations(a1, k, combo, new ArrayList<>(), 0);
//
//        List<List<Integer>> vals = new ArrayList<>(combo);
//        System.out.println(vals);

        int[] a2 = {3,1,3,5,1,1};
        Arrays.sort(a2);
        Util.print1DArray("sorted",a2);
        List<List<Integer>> combo1 = new ArrayList<>();
        combinationsBetter(a2, k, combo1, new ArrayList<>(), 0);
        System.out.println(combo1);
    }

    // leetcode verified: https://leetcode.com/problems/combination-sum-ii/submissions/970209004/
    // no TLE because additional operation of set is avoided
    private static void combinationsBetter(int[] c, int target, List<List<Integer>> vals, List<Integer> op, int idx){
        if(target == 0){
            vals.add(new ArrayList<>(op));
            return;
        }
        for(int i=idx; i<c.length; i++){
            if(i>idx && c[i] == c[i-1]) continue;
            if(c[i] <= target){
                op.add(c[i]);
                combinationsBetter(c, target - c[i], vals, op, i+1);
                op.remove(op.size()-1);
            }
        }
    }


    // this also works but causes TLE
    private static void combinations(int[] c, int target, Set<List<Integer>> vals, List<Integer> op, int idx){
        if(target == 0){
            List<Integer> newVal = new ArrayList<>(op);
            Collections.sort(newVal);
            vals.add(newVal);
            return;
        }
        if(idx == c.length) return;

        if(c[idx] <= target){
            op.add(c[idx]);
            combinations(c, target - c[idx], vals, op, idx + 1);
            op.remove(op.size()-1);
        }
        combinations(c, target, vals, op, idx + 1);
    }
}
