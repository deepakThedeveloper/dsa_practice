package hashmap;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayWithEquals0s1sAnd2s {
    public static void main(String[] args) {
        int[] a = {1,1,2,0,1,0,1,2,1,2,2,0,1};
        int totalSubarray = countSubarray(a);
        System.out.println(totalSubarray);
    }

    private static int countSubarray(int[] a){
        Map<String, Integer> _012DifferenceAndFreqMap = new HashMap<>();
        int i=-1;

        int _0counter = 0, _1Counter=0, _2Counter=0;
        int subarrayCounter = 0;
        while(i<a.length-1){
            i++;
            if(a[i]==0) _0counter++;
            else if(a[i]==1) _1Counter++;
            else _2Counter++;

            String key = (_1Counter-_0counter)+"#"+(_2Counter-_1Counter);
            if(_012DifferenceAndFreqMap.containsKey(key)){
                int newCounter = _012DifferenceAndFreqMap.get(key)+1;
                subarrayCounter += newCounter;
                _012DifferenceAndFreqMap.put(key, newCounter);
            }
            else{
                _012DifferenceAndFreqMap.put(key, 1);
            }
        }

        return subarrayCounter;
    }
}
//0,1,0,1,2,1,2,2,0