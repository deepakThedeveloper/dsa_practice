package hashmap;

import matrix.Util;

import java.util.Map;

public class TwoStringsAreKAnagrams {
    public static void main(String[] args) {
        /*
        // false case
        String s1 = "abbbbddccc";
        String s2 = "aaaaabbbbb";

        */
        // true case
        String s1 = "ababaddccc";
        String s2 = "bcbecabacd";

        int k = 3;

        boolean possible  = are2StringsAnagramByKReplace(s1, s2, k);
        System.out.println(possible);
    }

    private static boolean are2StringsAnagramByKReplace(String s1, String s2, int k){
        if(s1.length() != s2.length())  return false; // for two strings to be anagrams their length should be same
        Map<Character, Integer> freqMap = Util.freqMap(s1);

        for(int i=0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            if(freqMap.getOrDefault(ch, 0) > 0){
               freqMap.put(ch, freqMap.get(ch)-1);
            }
        }

        int sum = 0;
        for(int freq : freqMap.values()){
            sum += freq;
        }
        return !(sum > k);
    }

}
