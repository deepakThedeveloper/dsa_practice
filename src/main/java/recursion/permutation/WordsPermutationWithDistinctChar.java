package recursion.permutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * abcabc - distinct char 3. abc.
 * print only those whose words permutationlength is k(2): ab, bc, ac, ba, cb, ca
 * Observations:
 * 1. find distinct char
 * 2. ab, ac -- means combination of words i.e. take or not take
 * 3. ac, ca -- reverse means permutation of the selected word
 *
 * Means: Combination with permutation
 */
public class WordsPermutationWithDistinctChar {
    public static void main(String[] args) {
        String str = "abcabc";
        int k = 2;
        Set<String> unique = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            unique.add(""+str.charAt(i));
        }
        String uniqueString = String.join("", unique);
     //   combinationWordsPermutationResultCombinationApproach(new Character[k], uniqueString, 0, k);
        combinationWordsPermutationResultLevelsOptionsApproach(new Character[k], uniqueString, k, 0);
    }

    // distinct letter for abcabc = abc. Means 3 items. 2 length word to be created. k = 2. so 2 boxes and 3 items.
    // combination approach: boxes are less than items, box1 at level 1 has to either select a, b, c.
    //box2 at level 2 has to select of the items from abc excluding item selected by box1 at level 1
    // for tree dia refer: /resources/permutation_of_combination_distinct_letter.jpg
    private static void combinationWordsPermutationResultCombinationApproach(Character[] boxes, String str, int idx, int k){
        if(idx == k){
            Arrays.stream(boxes).forEach(v-> System.out.print(v+" "));
            System.out.println();
            return;
        }

        for(int i=0; i<str.length(); i++){
            if(boxes[idx] == null){
                boxes[idx] = str.charAt(i);
                String suffix = str.substring(0, i)+str.substring(i+1);
                combinationWordsPermutationResultCombinationApproach(boxes, suffix, idx+1, k);
                boxes[idx] = null;
            }
        }
    }


    // for tree refer: /resources/permutation_of_combination_distinct_letter_approach2.jpg
    private static void combinationWordsPermutationResultLevelsOptionsApproach(Character[] boxes, String str, int length, int itemSoFar){
        if(str.length() == 0){
            if(itemSoFar == length) {
                Arrays.stream(boxes).forEach(v-> System.out.print(v+" "));
                System.out.println();
            }
            return;
        }
        for(int i=0; i<boxes.length; i++){
            if(boxes[i] == null){
                boxes[i] = str.charAt(0);
                String suffix = str.substring(1);
                combinationWordsPermutationResultLevelsOptionsApproach(boxes, suffix, length, itemSoFar+1);
                boxes[i] = null;
            }
        }
        combinationWordsPermutationResultLevelsOptionsApproach(boxes, str.substring(1), length, itemSoFar);
    }
}