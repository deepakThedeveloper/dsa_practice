package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * NOTE: palindromic of string is possible only when the given string has
 * 1. all even length characters    OR
 * 2. all even length characters and one char with odd frequency.
 *
 * e.g: aaabbb  --> not possible as characters have odd frequency
 * e.g.: aaaabbb --> possible as a is having even freq and only b as single char has odd freq
 * e.g: aabbc --> possible as a and b are having even freq and only c as single char has odd freq
 * e.g: aabbcd --> not possible as a and b are having even freq but there are 2 char c and d with odd freq
 *
 * for permutation time complexity is totalChars!. e,g,: String s = ABC.
 * time complexity of s= 3! as total char is 3;
 *
 * how to solve:
 * 1. get frequency map of above char and apply above rules. if satisfy then
 * 2. divide every frequency by 2 and if any odd freq char is remaining keep it aside.
 * 3. find permutations of all the char with half freq.
 * 4. add remaining char the other half in reverse order of permutated string.
 * 5. if any odd char is remaining then put it in between of two join strings
 */
//todo
public class PalindromicStringPermutation {
    public static void main(String[] args) {
        String s = "ababccc";
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0)+1);
        }

        String ip1 = "";
        String ip2 = "";
        int oddChar=0;
        for(Map.Entry<Character, Integer> map : freqMap.entrySet()){

            char c = map.getKey();
            int value = map.getValue();
            if(value % 2 !=0){
                oddChar = c;
                int val = Math.abs(value - value/2);
                for(int i=0; i<val; i++)
                    ip2 += c;
            }
            for(int j=0; j<value/2; j++){
                ip1 += c;
            }
        }
//        ip2 = oddChar!=0 ? ip1.ip1.indexOf(oddChar)+ip2;
//        System.out.println(ip1);
//        System.out.println(ip2);
    }
}
