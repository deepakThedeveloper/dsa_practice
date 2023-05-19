package backtracking;

import java.util.HashMap;
import java.util.Map;

public class CryptorithamicAlgorithm {
    public static void main(String[] args) {
        String[] words = {"send", "more", "money"};

        Map<Character, Integer> charValueMap = getMap(words);
        String unique = "";
        for(Character key : charValueMap.keySet()){
            unique += key;
        }

        boolean[] visited = new boolean[10];
        findValues(words[0], words[1], words[2], unique, charValueMap, 0, visited);
    }

    private static int getNum(String str, Map<Character, Integer> map){
        String num = "";
        for(int i=0; i<str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                num += map.get(str.charAt(i));
            }
        }

        return Integer.valueOf(num);
    }
    private static void findValues(String a, String b, String c, String unique, Map<Character, Integer> map, int n,
                                   boolean[] visited) {
        if(n==unique.length()){
            int num1 = getNum(a, map);
            int num2 = getNum(b, map);
            int num3 = getNum(c, map);

            if(num1 + num2 == num3){
                for(int i=0; i<26; i++) {
                    char c2 = (char)('a'+i);
                    if(map.containsKey(c2)) {
                        System.out.print(c2+"-"+map.get(c2)+",");
                    }
                }
                System.out.println();
            }
            return;
        }
        char c1 = unique.charAt(n);
        for(int k=0; k<=9; k++){
            if(!visited[k]){
                visited[k] = true;
                map.put(c1, k);
                findValues(a, b, c, unique, map, n+1, visited);
                map.put(c1, -1);
                visited[k] = false;
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
}
