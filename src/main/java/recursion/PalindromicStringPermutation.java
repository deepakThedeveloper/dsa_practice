package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class PalindromicStringPermutation {
    public static void main(String[] args) {
        String s = "aabbaabbccc";
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0)+1);
        }

        palindromicPermutation(freqMap);
    }

    // time complexity: aabbaabbccc i.e. a4b4c3, we are doing half of its freq = a2b2c1 for permutation. in that as 'a' and 'b' as duplicates i.e. a2 and b2 its will be divided
    // so a2b2c1 = 5 char so tc: 5!/2!*2! (5 is total char, 2! * 2! is for a2 and b2. it should be considered only once)
    private static void palindromicPermutation(Map<Character, Integer> freqMap){
        Character oddChar = null;
        int oddCharCount = 0;
        int length = 0;
        for(Map.Entry<Character, Integer> map : freqMap.entrySet()){
            int freq = map.getValue();
            if(freq % 2 != 0){
                oddChar = map.getKey();
                oddCharCount ++;
            }
            length += freq/2;
            freqMap.put(map.getKey(), freq / 2);
        }

        if(oddCharCount > 1){
            System.out.println("odd char count is > 1 so palindromic permutation is not possible");
            return;
        }

        List<String> permutation = new ArrayList<>();
        getPalindromicPermutations(oddChar, freqMap, permutation, "", length);

        System.out.println("total permutations:"+permutation.size());
        System.out.println(permutation);
    }

    private static void getPalindromicPermutations(Character oddChar, Map<Character, Integer> freqMap,
                                                   List<String> permutations, String op, int strLen){
        if(op.length() == strLen){
            String reverse = reverse(op);
            permutations.add(op+oddChar+reverse);
            return;
        }

        for(Map.Entry<Character, Integer> map : freqMap.entrySet()){
            int freq = map.getValue();
            Character ch = map.getKey();
            if(freq > 0){
                // no need of carrying string as input. like in case of string for every recursive call we reduce char freq in same way
                // we are reducing char freq. for string aabb for the first time, after first call op = a and input = abb
                freqMap.put(ch, freq - 1);
                // duplicates are avoided via map. aabb we need to find permutation for aabb but with only one a and one b. a(abb). if for second a also we create permutations
                //then it will be duplicate because second a will also generate a(abb). so at same level duplicates should be avoided and this is possible using map as in map
                // for let's suppose level 0 calls for first 'a' and then after computing all permutation for first 'a', when it comes back to level 0 it will not pick second 'a'
                // as map.entry will move to next character as character is used as key and so against a - 2 there will be 2 freq but no two keys as 'a'.
                getPalindromicPermutations(oddChar, freqMap, permutations, op+ch, strLen);
                freqMap.put(ch, freq);
            }
        }
    }

    private static String reverse(String s){
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            char c1 = c[i];
            c[i] = c[j];
            c[j] = c1;
        }
        return String.valueOf(c);
    }
}
