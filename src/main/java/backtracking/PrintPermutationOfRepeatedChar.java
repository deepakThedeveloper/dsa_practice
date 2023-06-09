package backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Generally permutation is n! but when there are duplicate characters in string then its permutation will be n!/duplicate char!
 * e.g.AABB string permutation will be 4! i.e. 24 but as A and B are duplicates therefore 4!/2!*2! = 6.
 * so we need to generate 6 permutations. While doing permutation only we need to remove duplicay.
 * e.g. level 1: ___A and on level 2 again A is present and this A will be sit in any of the first 3 locations so.
 * it will sit at lets say 2 _A_A will be output. similary lets say in first level as all 4 blocks are initially empty so
 * first A will sit at second position _A__ and at 2nd pass second A will sit at any of 3 empty blocks so lets say if it sits
 * at last block so output will be _A_A. now there is duplicacy and in further passes duplicacy will stay.
 * So the approach is while inserting only place new character to next available portion of same char. e.g.: while inserting
 * new A check for next available position of previous A and put it over there and not before it.
 */
public class PrintPermutationOfRepeatedChar {
    public static void main(String[] args) {
        String word = "aabb";
        Map<Character, Integer> lastOccurence = new HashMap<>();
        char[] c =  new char[word.length()];
        for(int i=0; i<word.length(); i++){
            lastOccurence.put(word.charAt(i), -1);
            c[i] = '-';
        }

        printPermutationWithDuplicateChar(0, word, c, lastOccurence);
    }

    private static void printPermutationWithDuplicateChar(int idx, String str, char[] op, Map<Character, Integer> lastOccurence){
        if(idx==str.length()){
            for(int i=0; i<op.length; i++){
                System.out.print(op[i]);
            }
            System.out.println();
            return;
        }

        char ch = str.charAt(idx);
        int lastIdx = lastOccurence.get(ch);

        for(int i=lastIdx+1; i<op.length; i++){
            if(op[i] == '-'){
                op[i] = ch;
                lastOccurence.put(ch, i);
                printPermutationWithDuplicateChar(idx+1, str, op, lastOccurence);
                lastOccurence.put(ch, -1);
                op[i] = '-';
            }
        }

    }
}
