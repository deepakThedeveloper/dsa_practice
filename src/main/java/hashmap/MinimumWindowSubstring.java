package hashmap;

import recursion.partition.PalindromePartitioning;

import java.util.HashMap;
import java.util.Map;

//todo: summit mallick dsa playlist 2
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s1 = "dbaecbbabdcaafbddcabgba";
        String s2= "abbcdc";

        Map<Character,Integer> s2FreqMap = new HashMap<>();
        for(Character c : s2.toCharArray()){
            s2FreqMap.put(c, s2FreqMap.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> ansMap = new HashMap<>();
        int count = 0;
        for(int i=0, j=0; i<s1.length();){
            if(count == s2.length()) {
                char c = s1.charAt(j);
                if(ansMap.containsKey(c)) {
                    ansMap.put(c, ansMap.get(c)-1);
                }
                j++;
            }
            else if(ansMap.containsKey(s1.charAt(i)))
            {
                char c = s1.charAt(1);
                if(ansMap.get(c) < s2FreqMap.get(c)){
                    count++;
                }
                i++;
                ansMap.put(c, ansMap.getOrDefault(c, 0)+1);
            }
        }
    }
}
