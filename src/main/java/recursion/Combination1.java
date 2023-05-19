package recursion;

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
