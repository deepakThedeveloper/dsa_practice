package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// it will work for all k 0-infinity
public class CountAllSubarraysWhoseKDivisibleSum {
    public static void main(String[] args) {
        int[] a = {2, -6, 3, 1, 2, 8, 2, 1};
        int k = 7;

        int subarrayCount = countAllSubarraysWithSumDivisibleByK(a, k);
        System.out.println(subarrayCount);
    }

    private static int countAllSubarraysWithSumDivisibleByK(int[] a, int k){
        int subarrayCount = 0;
        Map<Integer, Integer> remainderFreqMap = new HashMap<>();
        remainderFreqMap.put(0, 1);
        int sum = 0;
        int rem;
        for(int i=0; i<a.length; i++){
            sum += a[i];
            rem = sum % k;
            rem = rem < 0 ? rem + k : rem;
            if(remainderFreqMap.containsKey(rem)){
                subarrayCount += remainderFreqMap.get(rem);
                remainderFreqMap.put(rem, remainderFreqMap.get(rem)+1);
            }
            else{
                remainderFreqMap.put(rem, 1);
            }
        }

        return subarrayCount;
    }
}
