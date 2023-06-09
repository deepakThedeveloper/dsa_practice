package backtracking;

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
public class SelectKDistinctCharWithoutRepitionCombination {
    public static void main(String[] args) {
        String str = "abcabcdd";
        int k = 3;
        Set<String> unique = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            unique.add(""+str.charAt(i));
        }
        String uniqueString = String.join("", unique);
        //printCombinationWithKLength(uniqueString, "", 0, 2);
        printCombinationWithKLengthApproach2(uniqueString, "", 0, k);
    }
    private static void printCombinationWithKLength(String str, String op, int i, int k){
        if(op.length()==k){
            System.out.println(op);
            return;
        }
        if(i==str.length())return;

        printCombinationWithKLength(str, op, i+1, k);
        printCombinationWithKLength(str, op+str.charAt(i), i+1, k);
    }

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
