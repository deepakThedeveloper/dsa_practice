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
        String s = "ababc";
        palindromicPermutedString(s);
    }

    private static void palindromicPermutedString(String s){
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0)+1);
        }
        int odd = 0;
        StringBuilder builder = new StringBuilder();
        String oddChar="";
        for(Map.Entry<Character, Integer> mp : freqMap.entrySet()){
            int count = mp.getValue();
            if(count%2!=0) {
                oddChar = ""+mp.getKey();
                odd++;
            }
            StringBuilder local = new StringBuilder();
            char c = mp.getKey();
            for(int i=0; i<count/2; i++){
                local.append(c);
            }
            builder.append(local.toString());
        }
        String stringToBePermuted = builder.toString();
        System.out.println(stringToBePermuted);
        if(odd>1){
            System.out.println("palindromic partition not possible as odd char are more than 1");
        }
        else {
            getPermutation(stringToBePermuted, new boolean[stringToBePermuted.length()], "", oddChar);
        }
    }

    private static void getPermutation(String str, boolean[] visited, String op, String c1){
        if(op.length() == str.length()){
            System.out.println(op+c1+reverse(op));
            return;
        }
        for(int i=0; i<str.length(); i++){
            if(visited[i]) continue;
            visited[i]=true;
            getPermutation(str, visited, op+str.charAt(i), c1);
            visited[i]=false;
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
