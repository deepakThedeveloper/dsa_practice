package recursion;

import java.util.*;

public class RecursionPractice {
    public static void main(String[] args) {
        int[] a = {2,5,6};
        Map<String, Integer> subsetSumList = printSumOfEachSubset(a, 0);
        System.out.println(subsetSumList);
        Set<Integer> subsetSumList1 = printSumOfEachSubsetMemoization(a, 0, new HashMap<>());
        System.out.println(subsetSumList1);

        Set<String> subsets = subset(a, 0, new ArrayList<>());
        System.out.println(subsets);
    }

    private static Map<String, Integer> printSumOfEachSubset(int[] a, int i){
      //  System.out.println("in method:");
        if(i==a.length) {
            Map<String, Integer> map = new HashMap<>();
            map.put("",0);
            return map;
        }
        Map<String,Integer> finalList = new HashMap<>();
        for(int j=i; j<a.length; j++) {
            Map<String, Integer> childSumSubsets = printSumOfEachSubset(a, j + 1);
            for(Map.Entry<String, Integer> mp : childSumSubsets.entrySet()){
                finalList.put(a[i]+mp.getKey(), mp.getValue()+a[i]);
            }
            finalList.putAll(childSumSubsets);
        }
        return finalList;
    }

    private static Set<String> subset(int[] a, int i, List<Integer> list1){
        if(i==a.length) {
            Set<String> list = new HashSet<>();
            list.add("");
            return list;
        }

        Set<String> finalList = new HashSet<>();
        for(int j=i; j<a.length; j++) {
            Set<String> childSumSubsets = subset(a, j + 1, list1);
            finalList.addAll(childSumSubsets);

            Set<String> temp = new HashSet<>();
            for(String str : childSumSubsets){
                temp.add(a[j]+str);
            }
            finalList.addAll(temp);
        }

        return finalList;
    }

    private static Set<Integer> printSumOfEachSubsetMemoization(int[] a, int i, Map<Integer, Set<Integer>> dp){
        if(i==a.length) {
            Set<Integer> list = new HashSet<>();
            list.add(0);
            return list;
        }
        if(dp.containsKey(a[i])) return dp.get(a[i]);

        System.out.println("in method::"+a[i]);

        Set<Integer> finalList = new HashSet<>();
        for(int j=i; j<a.length; j++) {
            Set<Integer> childSumSubsets = printSumOfEachSubsetMemoization(a, j + 1, dp);
            for(Integer v : childSumSubsets){
                finalList.add(v+a[j]);
            }
            finalList.addAll(childSumSubsets);
        }
        dp.put(a[i], finalList);
        return finalList;
    }
}
