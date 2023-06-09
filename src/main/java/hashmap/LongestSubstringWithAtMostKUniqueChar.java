package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKUniqueChar {
    public static void main(String[] args) {
        String str = "ddacbbaccdedacebb";
        int k = 3, i=-1, j=-1, max = Integer.MIN_VALUE;
        Map<Character, Integer> freqMap = new HashMap<>();
        boolean f1 = true;
        while(f1){
            f1 = false;
            while(i<str.length()-1){
                f1  = true;
                i++;
                char c = str.charAt(i);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
                if(freqMap.size()<=k) {
                    int len = i - j;
                    max = Math.max(max, len);
                }
                else break;
            }

            while (j<i){
                f1 = true;
                j++;
                char c = str.charAt(j);
                if(freqMap.get(c)>1) freqMap.put(c, freqMap.get(c)-1);
                else freqMap.remove(c);
                if(freqMap.size() > k) {
                    int len = i - j;
                    max = Math.max(max, len);
                }
                else break;
            }
        }
        System.out.println("max:"+max);
    }
}
