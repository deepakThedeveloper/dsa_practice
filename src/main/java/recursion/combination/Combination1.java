package recursion.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination1 {
    public static void main(String[] args) {
        int[] a = {2,3,6,7};
        Arrays.sort(a);
        int k = 7;

        List<List<Integer>> combinations = new ArrayList<>();
        getCombinations(a, k, 0, combinations, new ArrayList<>());
        System.out.println(combinations);

        List<List<Integer>> combinations1 = new ArrayList<>();
        combinationsRevision(a, k, combinations1, new ArrayList<>(), 0);
        System.out.println(combinations1);
    }

    //leetcode verified: https://leetcode.com/problems/combination-sum/submissions/970145404/
    private static void combinationsRevision(int[] c, int target, List<List<Integer>> vals, List<Integer> op, int idx){
        if(target == 0){
            vals.add(new ArrayList<>(op));
            return;
        }
        if(idx == c.length) return;

        if(c[idx] <= target){
            op.add(c[idx]);
            combinationsRevision(c, target - c[idx], vals, op, idx);
            op.remove(op.size()-1);
        }
        combinationsRevision(c, target, vals, op, idx+1);
    }

    private static void getCombinations(int[] a, int k, int i, List<List<Integer>> op, List<Integer> pair){
        if(k==0){
            op.add(new ArrayList<>(pair));
            return;
        }
        if(i==a.length || k<0) return;

        pair.add(a[i]);
        getCombinations(a, k - a[i], i, op, pair);
        pair.remove(pair.size()-1);

        getCombinations(a, k , i+1, op, pair);
    }
}
