package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subarray {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> finalList = getSubarrayV1(a);
        System.out.println(finalList);
    }

    private static List<List<Integer>> getSubarrayV1(int[] a){
        List<List<Integer>> finalList = new ArrayList<>();
        for(int i=0; i<a.length; i++){
            finalList.addAll(subarrayOps(a, i, new ArrayList<>()));
        }
        return finalList;
    }

    private static List<List<Integer>> subarrayOps(int[] a, int i, List<Integer> sublist){
        if(i==a.length){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(sublist));
            return list;
        }

        sublist.add(a[i]);
        List<List<Integer>> list = subarrayOps(a, i+1, sublist);
        sublist.remove(sublist.size()-1);
        if(!sublist.isEmpty())
        list.add(new ArrayList<>(sublist));

        return list;
    }
}
