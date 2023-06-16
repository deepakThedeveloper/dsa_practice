package recursion.permutation;

import java.util.*;

public class GetPermutationsForDuplicate {
    public static void main(String[] args) {
        GetPermutationsForDuplicate gp = new GetPermutationsForDuplicate();
        int[] a = {1,1,2};
        int[] a1 = {1,1,2,2};
        //gp.permuteApproach1(a1);
        gp.permuteApproach2(a);
    }

    private void permuteApproach2(int[] nums) {
        boolean[] checked = new boolean[nums.length];
        List<List<Integer>> list = getPermutation2(nums, checked, new ArrayList<>());
        System.out.println(list);
    }

    public Set<List<Integer>> permuteApproach1(int[] nums) {
        boolean[] checked = new boolean[nums.length];
        List<List<Integer>> list =  getPermutation(nums, checked, new ArrayList<>());
        Set<List<Integer>> set = new HashSet<>(list);
        System.out.println(set);

        return set;
    }

    private List<List<Integer>> getPermutation(int[] nums, boolean[] checked, List<Integer> list){
        if(list.size() == nums.length){
            List<List<Integer>> list1 = new ArrayList<>();
            list1.add(list);

            return list1;
        }

        List<List<Integer>> finalList = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            List<Integer> l2  = new ArrayList<>(list);
            if(checked[i] == false){
                checked[i] = true;
                l2.add(nums[i]);
                finalList.addAll(getPermutation(nums, checked, l2));
                checked[i] = false;
            }
        }

        return finalList;
    }

    // remember that
    /*
    1. passing a reference of a class to method and setting its values in next iteration, when that method call is poped from
    stack and cursor is on previous method call, the value set in its next iteration will remain and it will not revert back
    to its original state when a next recursive call is made. e.g:
    public void method(list<integer> list, int n){ // call 0 - empty list
        if(n==1){
            list.add(12);
        }
        else{
            method(list, n+1);  // call 1 - empty list
            sout(list)          // op: 12
        }
    }
     logically if we think when we have passed empty list in call 1, when we are returning back to previous call it should be empty
     only but this won't be case reason being same reference is passed on stack and object is created on heap.
     so in any recursion call, if value is set, then the in any previous recursive call we will get that value as same reference
     is referring to same object in heap
     */
    private List<List<Integer>> getPermutation2(int[] nums, boolean[] checked, List<Integer> list){
        if(list.size() == nums.length){
            List<List<Integer>> list1 = new ArrayList<>();
            list1.add(list);
            return list1;
        }
        List<List<Integer>> finalList = new ArrayList<>();
        Set<Integer> solved1 = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(solved1.contains(nums[i])){
                continue;
            }
            List<Integer> l2  = new ArrayList<>(list);
            if(!checked[i]){
                checked[i] = true;
                l2.add(nums[i]);
                finalList.addAll(getPermutation2(nums, checked, l2));
                checked[i] = false;
                solved1.add(nums[i]);
            }
        }
        return finalList;
    }
}
