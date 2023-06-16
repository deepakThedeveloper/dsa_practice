package recursion.backtracking;

import java.util.HashMap;
import java.util.Map;

public class CryptorithamicAlgorithm {
    static Map<Character, Integer> charValueMap;
    static boolean[] allottedNumbers = new boolean[10];

    public static void main(String[] args) {
        String[] words = {"send", "more", "money"};
        charValueMap = getMap(words);
        StringBuilder unique = new StringBuilder();
        for(Character key : charValueMap.keySet()){
            unique.append(key);
        }
        findValues(words[0], words[1], words[2], unique.toString(), 0);
    }

    private static void findValues(String a, String b, String c, String unique, int n) {
        if(n==unique.length()){
            int num1 = getNum(a);
            int num2 = getNum(b);
            int num3 = getNum(c);

            if(num1 + num2 == num3) System.out.println(charValueMap);
            return;
        }
        char c1 = unique.charAt(n);
        for(int k=0; k<=9; k++){
            if(!allottedNumbers[k]){
                allottedNumbers[k] = true;
                charValueMap.put(c1, k);
                findValues(a, b, c, unique, n+1);
                charValueMap.put(c1, -1);
                allottedNumbers[k] = false;
            }
        }
    }

    private static Map<Character, Integer> getMap(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for(String word : words){
            for(int i=0; i<word.length(); i++){
                if(map.containsKey(word.charAt(i))) continue;
                map.put(word.charAt(i), -1);
            }
        }
        return map;
    }

    private static int getNum(String str){
        StringBuilder num = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(charValueMap.containsKey(str.charAt(i))){
                num.append(charValueMap.get(str.charAt(i)));
            }
        }

        return Integer.parseInt(num.toString());
    }
}
