package recursion;

import java.util.*;

public class TargetSubset {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60};
        int k = 60;

        printSubset(arr, k, 0, new ArrayList<>());

        Set<String> targetSubsets = new HashSet<>();
        targetSubsetRevision1(arr, k, 0, targetSubsets);
        System.out.println(targetSubsets);
    }

    private static Map<String, Integer> targetSubsetRevision1(int[] a, int k, int i, Set<String> subsets){
          System.out.println("in method:");
        if(i==a.length) {
            Map<String, Integer> map = new HashMap<>();
            map.put("",0);
            return map;
        }
        Map<String,Integer> finalList = new HashMap<>();
        for(int j=i; j<a.length; j++) {
            Map<String, Integer> childSumSubsets = targetSubsetRevision1(a, k,j + 1, subsets);
            for(Map.Entry<String, Integer> mp : childSumSubsets.entrySet()){
                int sum = mp.getValue()+a[i];
                String subset = a[i]+"-"+mp.getKey();
                if(sum == k){
                    subsets.add(subset);
                }
                finalList.put(subset, sum);
            }
            finalList.putAll(childSumSubsets);
        }
        return finalList;
    }

    //todo
    private static void targetSubsetTabRevision1(int[] a, int k, int i, Set<String> subsets){
//        System.out.println("in method:");
//        if(i==a.length) {
//            Map<String, Integer> map = new HashMap<>();
//            map.put("",0);
//            return map;
//        }
//        int[] finalList = new int[a.length];
//        for(int j=0; j<a.length; j++) {
//            Map<String, Integer> childSumSubsets = targetSubsetRevision1(a, k,j + 1, subsets);
//            for(Map.Entry<String, Integer> mp : childSumSubsets.entrySet()){
//                int sum = mp.getValue()+a[i];
//                String subset = a[i]+"-"+mp.getKey();
//                if(sum == k){
//                    subsets.add(subset);
//                }
//                finalList[subset] = sum;
//                finalList.put(subset, sum);
//            }
//            finalList.putAll(childSumSubsets);
//        }
//        return finalList;
    }

    private static void printSubset(int[] arr, int k, int i, ArrayList<Integer> subset) {
        System.out.println("in old method");
        if(k == 0){
            System.out.println(subset);
            return;
        }

        if(k<0 || i == arr.length) return;


        subset.add(arr[i]);
        printSubset(arr, k - arr[i], i+1, subset);
        subset.remove(subset.size()-1);
        printSubset(arr, k, i+1, subset);
    }
}
