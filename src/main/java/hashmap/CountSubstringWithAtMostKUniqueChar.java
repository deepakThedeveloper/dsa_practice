package hashmap;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringWithAtMostKUniqueChar {
    public static void main(String[] args) {
        String str = "dacbac";
        int k = 2, i=-1, j=-1, substringCount = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        while(true){
            while(i<str.length()-1){
                i++;
                char c = str.charAt(i);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
                if(freqMap.size()<=k) substringCount += i-j;
                else break;
            }
            if(i==str.length()-1 && freqMap.size() == k) break;
            while (j<i){
                j++;
                char c = str.charAt(j);
                if(freqMap.get(c)>1) freqMap.put(c, freqMap.get(c)-1);
                else freqMap.remove(c);
                if(freqMap.size() > k) continue;
                else {
                    substringCount += i - j;
                    break;
                }
            }
        }
        System.out.println("substring count:"+substringCount);
    }
}
