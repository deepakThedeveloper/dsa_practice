package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abbacbedbadbdbbdcb";
        Map<Character, Integer> map = new HashMap<>();

        int j=0;
        int maxLength = Integer.MIN_VALUE;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.get(c)>1) {
                maxLength = Math.max(maxLength, i-j);
                while (j < i && map.get(c) > 1) {
                    char c1 = str.charAt(j);
                    if(c1!=c)map.remove(str.charAt(j));
                    else map.put(c1, map.get(c)-1);
                    j++;
                }
            }
        }
        System.out.println("max length:"+maxLength);
    }
}
