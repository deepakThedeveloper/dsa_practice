package hashmap;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarrayWithSumZero {
    public static void main(String[] args) {
        int[] a = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};
        largestSubarrayWithZeroSum(a);
    }

    public static int largestSubarrayWithZeroSum(int[] a){
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1);

        int sum = 0, max = Integer.MIN_VALUE, start = -1, end=-1;
        for(int i=0; i<a.length; i++){
            sum+=a[i];
            if(sumIndexMap.containsKey(sum)){
                int v = i-sumIndexMap.get(sum);
                if(v>max) {
                    max = v;
                    start = sumIndexMap.get(sum)+1;
                    end = i;
                }
            }
            else{
                sumIndexMap.put(sum, i);
            }
        }
        System.out.println(sumIndexMap);
        System.out.println("max length:"+max+" start:"+start+" end:"+end);
        return max;
    }
}

//-1, -1, 1, -1, 1, -1, 1, 1, -1, -1, 1, 1,
