package other;

import java.util.HashMap;
import java.util.Map;

public class RearangeCharacters {
    public static void main (String[] args) {
        args = new String[]{"kkk", "geeksforgeeks"};
        for(String s : args){
            System.out.println(isReplacable(s, s.length()));
        }
    }

    private static int isReplacable(String s, int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        Map<Character, Integer> charCount = new HashMap<>();
        for(Character c : s.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c, 0)+1);
        }
        int max = 0;
        for(Map.Entry<Character, Integer> map:charCount.entrySet()){
            if(max < map.getValue()){
                max = map.getValue();
            }
        }
        int diff = n - max;

        return diff == 0 || diff < max - 1 ? 0 : 1;
    }
}
