package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEquals0s1sAnd2s {
    public static void main(String[] args) {
        int[] a = {1,1,2,0,1,0,1,2,1,2,2,0,1};
        int maxLen = longestSubarray(a);
        System.out.println(maxLen);
    }

    private static int longestSubarray(int[] a){
        Map<String, Integer> _012DifferenceAndIndexMap = new HashMap<>();
        int i=-1;
        _012DifferenceAndIndexMap.put("0#0", i); // count(1)-count(0)#count(2)-count(1) as key

        int _0counter = 0, _1Counter=0, _2Counter=0;
        int maxLen = Integer.MIN_VALUE;
        int start = -1, end = -1;
        while(i<a.length-1){
            i++;
            if(a[i]==0) _0counter++;
            else if(a[i]==1) _1Counter++;
            else _2Counter++;

            String key = (_1Counter-_0counter)+"#"+(_2Counter-_1Counter);
            if(_012DifferenceAndIndexMap.containsKey(key)){
                int idx = _012DifferenceAndIndexMap.get(key);
                if(i-idx > maxLen) {
                    maxLen = i - idx;
                    start = idx+1;
                    end = i;
                }
            }
            else{
                _012DifferenceAndIndexMap.put(key, i);
            }
        }

        System.out.println("maxlen for 0 1 and 2:"+maxLen + " start:"+start+ " end:"+end);
        return maxLen;
    }
}
//0,1,0,1,2,1,2,2,0