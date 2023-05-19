package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueSubset {
    public static void main(String[] args) {
        int[] a = {1,2,2};
//        Set<List<Integer>> finalList = new HashSet<>();
//        subsetUsingSet(a, 0, new ArrayList<>(), finalList);
//        System.out.println(finalList);

        List<List<Integer>> finalList1 = new ArrayList<>();
        subsetUsingIteration(a, 0, new ArrayList<>(), finalList1);
        System.out.println(finalList1);

    }

    private static void subsetUsingSet(int[] a, int i, List<Integer> val, Set<List<Integer>> finalList){
        if(i==a.length){
            finalList.add(new ArrayList<>(val));
            return;
        }

        val.add(a[i]);
        subsetUsingSet(a, i+1, val, finalList);
        val.remove(val.size()-1);
        subsetUsingSet(a, i+1, val, finalList);
    }

    private static void subsetUsingIteration(int[] a, int start, List<Integer> val, List<List<Integer>> finalList){
        if(start==a.length){
            finalList.add(new ArrayList<>(val));
            return;
        }

        for(int i=start; i<a.length; i++){
            if(i>start && a[i]==a[i-1]) continue;
            val.add(a[i]);
            subsetUsingIteration(a, i + 1, val, finalList);
            val.remove(val.size() - 1);
        }
        finalList.add(new ArrayList<>(val));
    }
}
