package recursion.subset.permutation;

import java.util.ArrayList;
import java.util.List;

public class IntegerArrayPermutations {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int n = a.length;
        List<List<Integer>> list1 = new ArrayList<>();
        permutationUsingVisitedArray(a, new boolean[n], new ArrayList<>(), list1);
        System.out.println("permutation with visited array:"+list1);

        List<List<Integer>> list2 = new ArrayList<>();
        permutationUsingSwap(a, 0, new ArrayList<>(), list2);
        System.out.println("permutation with swap:"+list2);
    }

    private static void permutationUsingSwap(int[] nums, int level, List<Integer> op, List<List<Integer>> list){
        if(op.size() == nums.length){
            list.add(new ArrayList<>(op));
            return;
        }

        for(int i = level; i < nums.length; i++){
            swap(i, level, nums);
            op.add(nums[level]);
            permutationUsingSwap(nums, level + 1, op, list);
            op.remove(op.size()-1);
            swap(i, level, nums);
        }
    }

    private static void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void permutationUsingVisitedArray(int[] nums, boolean[] visited, List<Integer> op, List<List<Integer>> list){
        if(op.size() == nums.length){
            list.add(new ArrayList<>(op));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            op.add(nums[i]);
            permutationUsingVisitedArray(nums, visited, op, list);
            op.remove(op.size()-1);
            visited[i] = false;
        }
    }
}
