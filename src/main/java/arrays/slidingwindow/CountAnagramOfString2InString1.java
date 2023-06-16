package arrays.slidingwindow;

import matrix.Util;

import java.util.HashMap;
import java.util.Map;

public class CountAnagramOfString2InString1 {
    public static void main(String[] args) {
        String s1 = "aabaabaa";
        String s2 = "aaba";

        int count = 0, substringCount = 0;
        Map<Character, Integer> freqMap = Util.freqMap(s2);
        Map<Character, Integer> map = new HashMap<>();

        for(int i=-1, j=0; j<s1.length(); j++){
            char c = s1.charAt(j);
            if(!freqMap.containsKey(c)) {
                while(i<j) {
                    i++;
                    char c1 = s1.charAt(i);
                    map.remove(c1);
                }
                continue;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.get(c) <= freqMap.get(c)) count++;
            else {
                if(map.get(c)>1) map.put(c, map.get(c)-1);
                else map.remove(c);
                i++;
            }

            if(count == s2.length()){
                substringCount++;
                i++;
                char c1 = s1.charAt(i);
                if(map.get(c1)>1) map.put(c1, map.get(c1)-1);
                else map.remove(c1);
                count--;
            }
        }
        System.out.println("substring count:"+substringCount);
    }
}
