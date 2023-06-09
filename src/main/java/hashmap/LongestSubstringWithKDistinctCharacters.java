package hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String str = "aabcbcdbca";

        HashMap<Character, Integer> charset = new HashMap<>();
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0, j=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(!charset.containsKey(c)){
                count++;
            }
            charset.put(c, charset.getOrDefault(c, 0)+1);
            if(count >2){
                max = Math.max(max, i-j);
                while(j<i && count>2){
                    char c1 = str.charAt(j);
                    int val = charset.get(c1);
                    if(val>1){
                        charset.put(c1, val-1);
                    }
                    else if(val == 1){
                        count --;
                        charset.remove(c1);
                    }
                    j++;
                }
            }
        }
        System.out.println("max:"+max);
    }
}
