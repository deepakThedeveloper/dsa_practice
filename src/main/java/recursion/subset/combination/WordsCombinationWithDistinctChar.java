package recursion.subset.combination;

import java.util.HashSet;
import java.util.Set;

/**
 * abcabc - distinct char 3. abc. In how many ways it can be printed in k combination. e.g.: k = 2;
 * ab, bc, ac.
 *
 * Using hashset find all distinct char. : abc
 * generate combination of all distinct char: a, ab, ac, bc,abc, b, c
 * print only those whose length is k(2): ab, bc, ac
 */
public class WordsCombinationWithDistinctChar {
    public static void main(String[] args) {
        String str = "aabbbccdde";
        int k = 3;
        Set<String> unique = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            unique.add(""+str.charAt(i));
        }
        String uniqueString = String.join("", unique);
        printCombinationWithKLength(uniqueString, "", 0, k);
//        printCombinationWithKLengthApproach2(uniqueString, "", 0, k);
    }
    private static void printCombinationWithKLength(String str, String op, int i, int k){
        if(op.length()==k){
            System.out.println(op);
            return;
        }
        if(i==str.length())return;

        printCombinationWithKLength(str, op+str.charAt(i), i+1, k);
        printCombinationWithKLength(str, op, i+1, k);
    }

    //this code cannot be used to print all subsequences. it is used only in this case where we need to print
    // subsequence with length limit. The reason it works is, when we print all subsequences, the final values are part of
    // leaf node. With this code at leaf node we will never get all subsequences but they occur at intermediate level
    // and till the time they go down their values is altered. e.g: a at level 1 becomes ab, ac at level 2 and abc at
    // level 3. so if we need to print combinations with length 1 then we need to print a at level 1 itself and can't
    // wait for it to become leaf node because at leaf node it will not be leaf anymore.
    // for tree refer : /resources/word_selection_2_tree.jpg
    private static void printCombinationWithKLengthApproach2(String str, String op, int idx, int k){
        if(op.length() == k){
            System.out.println(op);
            return;
        }
        for(int i=idx; i<str.length(); i++){
            printCombinationWithKLengthApproach2(str, op+str.charAt(i), i+1, k);
        }
    }
}