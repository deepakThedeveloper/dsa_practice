package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LargestContinuousSubarray {
    public static void main(String[] args) {
        int[] a = {9,2,7,5,6,23,24,22,23,19,17,16,18,39,0};
        int largestSubarray = largestConSubarray(a);
        System.out.println(largestSubarray);
    }

    private static int largestConSubarray(int[] a){
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int a1 : a){
            countMap.put(a1, -1);
        }

        int maxLen = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> mp : countMap.entrySet()){
            int c = mp.getKey();

            if(mp.getValue() == -1){
                fillInCountPosition(countMap, c);
                maxLen = Math.max(mp.getValue(), maxLen);
            }
        }
        System.out.println(countMap);
        return maxLen;
    }

    private static int fillInCountPosition(Map<Integer, Integer> map, int ele){
        if(!map.containsKey(ele)) return 0;
        if(map.get(ele)!=-1) return map.get(ele);

        int v = fillInCountPosition(map, ele-1)+1;
        map.put(ele, v);
        return v;
    }
}
