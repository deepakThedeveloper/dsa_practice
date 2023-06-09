package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// it will work for all k 0-infinity
public class CountAllSubarraysWithKSum {
    public static void main(String[] args) {
        int[] a = {3, 9, -2, 4, 1, -7, 2, 6, -5, 8, -3, -7, 6, 2, 1};
        int k = 5;

        int subarrayCount = countAllSubarraysWithKSum(a, k);
        System.out.println(subarrayCount);
    }

    private static int countAllSubarraysWithKSum(int[] a, int k){
        int sum = 0;
        int subarrayCount = 0;
        Map<Integer, HashSet<Integer>> sumMap = new HashMap<>();
        for(int i=0; i<a.length; i++){
            sum += a[i];
            if(sumMap.containsKey(sum-k)){
                subarrayCount += sumMap.get(sum-k).size();
            }
            HashSet<Integer> occurences; // repetitve occurences: 10-2, 10-6 which gets override. to avoid override used collection hash set
            if(sumMap.containsKey(sum)){
                occurences = sumMap.get(sum);
            }
            else{
                occurences = new HashSet<>();
            }
            occurences.add(i);
            sumMap.put(sum, occurences);
        }

        System.out.println(sumMap);
        return subarrayCount;
    }
}
