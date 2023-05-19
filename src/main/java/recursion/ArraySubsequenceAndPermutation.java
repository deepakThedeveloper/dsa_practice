package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraySubsequenceAndPermutation {
    public static void main(String[] args) {
        ArraySubsequenceAndPermutation arraySubsequenceAndPermutation = new ArraySubsequenceAndPermutation();
        int[] a = {1,2,3};
//        List<List<Integer>> list = arraySubsequence.subsetsWithDup(a);
//        System.out.println(list);

//        List<List<Integer>> list2 = new ArrayList<>();
//        subsequence(a, list2, new ArrayList<>(), 0);
//        System.out.println(list2);
//
//        List<List<Integer>> list3 = new ArrayList<>();
//        subsequence1(a, list3, new ArrayList<>(), 0);
//        System.out.println(list3);

        List<List<Integer>> list2 = new ArrayList<>();
        permutation(a, list2, new ArrayList<>(), 0);
        System.out.println(list2);
    }

    private static void permutation(int[] nums, List<List<Integer>> list, List<Integer> data, int ht){
        if(data.size()==3){
            list.add(new ArrayList<>(data));
            return;
        }
        for(int i=ht; i<nums.length; i++){
            data.add(nums[i]);
            swap(nums, i, ht);
            permutation(nums, list, data, ht+1);
            swap(nums, ht, i);
            data.remove(data.size()-1);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void subsequence(int[] nums, List<List<Integer>> list, List<Integer> vals, int idx){
        list.add(new ArrayList<>(vals));

        for(int i=idx; i<nums.length; i++){
            vals.add(nums[i]);
            subsequence(nums, list, vals, i+1);
            vals.remove(vals.size()-1);
        }
    }
    private static void subsequence1(int[] nums, List<List<Integer>> list, List<Integer> vals, int idx){
        if(idx == nums.length){
            list.add(new ArrayList<>(vals));
            return;
        }
        vals.add(nums[idx]);
        subsequence1(nums, list, vals, idx+1);
        vals.remove(vals.size()-1);
        subsequence1(nums, list, vals, idx+1);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return getSubsequence(nums, new ArrayList<>(), 0);
    }

    private List<List<Integer>> getSubsequence(int[] nums, List<Integer> list, int n){
        if(n==nums.length){
            List<List<Integer>> list1 = new ArrayList<>();
            list1.add(list);

            return list1;
        }

        List<List<Integer>> finalList = new ArrayList<>();
        Set<Integer> solved = new HashSet<>();
        for(int i=n; i<nums.length; i++){
            if(solved.contains(nums[i])) continue;
            List<Integer> l1 = new ArrayList<>(list);
            l1.add(nums[i]);
            finalList.addAll(getSubsequence(nums, l1, i+1));
            solved.add(nums[i]);

            if(list.size()>=1){
                finalList.add(list);
                return finalList;
            }

        }
        if(list.size()==0 && n==0){
            finalList.add(new ArrayList<>());
        }
        return finalList;
    }
}
