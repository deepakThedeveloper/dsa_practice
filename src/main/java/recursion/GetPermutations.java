package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetPermutations {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        permute(a);
    }
    public static void permute(int[] nums) {
        boolean[] checked = new boolean[nums.length+1];
//        List<List<Integer>> list =   getPermutation(nums, checked, new ArrayList<>());
        //List<List<Integer>> list =   permutationRevision1(nums, checked, new ArrayList<>());
        List<List<Integer>> list1 =   permutationRevisionWithN(3, checked, new ArrayList<>());
        //System.out.println(list);
        System.out.println(list1);

    }

    private static List<List<Integer>> getPermutation(int[] nums, boolean[] checked, List<Integer> list){

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

    private static List<List<Integer>> permutationRevision1(int[] nums, boolean[] visited, List<Integer> vals){
        if(vals.size() == nums.length){
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(new ArrayList<>(vals));
            return temp;
        }

        List<List<Integer>> finalList = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            vals.add(nums[i]);
            List<List<Integer>> returnData = permutationRevision1(nums, visited, vals);
            visited[i] = false;
            vals.remove(vals.size()-1);

            finalList.addAll(returnData);
        }
        return finalList;
    }

    private static List<List<Integer>> permutationRevisionWithN(int n, boolean[] visited, List<Integer> vals){
        if(vals.size() == n){
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(new ArrayList<>(vals));
            return temp;
        }

        List<List<Integer>> finalList = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            vals.add(i);
            List<List<Integer>> returnData = permutationRevisionWithN(n, visited, vals);
            visited[i] = false;
            vals.remove(vals.size()-1);

            finalList.addAll(returnData);
        }
        return finalList;
    }

    private static List<List<Integer>> permutationRevisionWithNOnlySpecificNumber(int n, boolean[] visited, List<Integer> vals){
        if(vals.size() == n){
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(new ArrayList<>(vals));
            return temp;
        }

        List<List<Integer>> finalList = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(vals.isEmpty() && i!=2) continue;
            if(visited[i]) continue;
            visited[i] = true;
            vals.add(i);
            List<List<Integer>> returnData = permutationRevisionWithNOnlySpecificNumber(n, visited, vals);
            visited[i] = false;
            vals.remove(vals.size()-1);

            finalList.addAll(returnData);
        }
        return finalList;
    }
}
