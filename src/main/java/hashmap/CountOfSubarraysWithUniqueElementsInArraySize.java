package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CountOfSubarraysWithUniqueElementsInArraySize {
    public static void main(String[] args) {
        int[] a = {2,5,3,5,2,4,1,3,1,4};
        Set<Integer> uniqueCount = new HashSet<>();
        for(int a1 : a){
            uniqueCount.add(a1);
        }
        int count = 0;
        int subArrayCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0, j=0; i<a.length; i++){
            if(!map.containsKey(a[i])){
                count++;
            }
            map.put(a[i], map.getOrDefault(a[i], 0)+1);

            if(count == uniqueCount.size()){
                while(j<i && count>=uniqueCount.size()) {
                    subArrayCount += a.length - i;
                    int val = map.get(a[j]);
                    if(val>1) map.put(a[j], val-1);
                    else if(val==1){
                        map.remove(a[j]);
                        count--;
                    }
                    j++;
                }
            }
        }
        System.out.println("subarray count:"+subArrayCount);
    }
}
