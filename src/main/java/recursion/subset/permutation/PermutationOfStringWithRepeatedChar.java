package recursion.subset.permutation;

import java.util.HashMap;
import java.util.Map;

//refer: /resources/permutation_approaches_example.jpg
public class PermutationOfStringWithRepeatedChar {
    public static void main(String[] args){
        String str = "aabb";
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        //findPermutationCombinationApproach(freqMap, "", str.length());

        findPermutationLevelsOptionApproach(new Character[str.length()], str, new HashMap<>());
    }

    // 4! as string length is 4. but as 'a' and 'b' are duplicate it is 4!/2! * 2!. here 2! is duplicate of a and b;
    // total permutations = 6
    // for recursive tree. refer: /resources/permutation_duplicate_approach1_tree.jpg
    private static void findPermutationLevelsOptionApproach(Character[] boxes, String str,
                                                            Map<Character, Integer> charIndex){
        if(str.length() == 0){
            for(char c : boxes){
                System.out.print(c+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<boxes.length; i++){
            char ch = str.charAt(0);
            if(boxes[i] != null || charIndex.containsKey(ch) && charIndex.get(ch) > i) continue;
            boxes[i] = ch;
            int prevIndex = charIndex.getOrDefault(ch, 0);
            charIndex.put(ch, i);
            String suffix = str.substring(1);
            findPermutationLevelsOptionApproach(boxes, suffix, charIndex);
            if(prevIndex == 0) charIndex.remove(ch);
            else charIndex.put(ch, prevIndex);
            boxes[i] = null;
        }
    }

     //4! as string length is 4. but as 'a' and 'b' are duplicate it is 4!/2! * 2!. here 2! is duplicate of a and b;
     // total permutations = 6
     // In combination approach we uses hashmap for generating permutations with duplicate char as in hashmap
    // even if characters are duplicate but its key will be unigue and so while traversal, when items/ characters
    // are duplicate then duplicate result will be generated so, because of hashmap char in single key so only
    // one edge/ path is generated for that character
    // for recursive tree. refer: /resources/permutation_duplicate_hashmap_tree.jpg
    private static void findPermutationCombinationApproach(Map<Character, Integer> freqMap, String op, int len){
        if(op.length() == len){
            System.out.println(op);
            return;
        }

        for(Map.Entry<Character, Integer> map : freqMap.entrySet()){
            int freq = map.getValue();
            char ch = map.getKey();
            if(freq > 0){
                freqMap.put(ch, freq-1);
                findPermutationCombinationApproach(freqMap, op+ch, len);
                freqMap.put(ch, freq);
            }
        }
    }
}
