package recursion.backtracking;

import java.util.Arrays;
import java.util.Calendar;
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
public class SelectKDistinctCharWithoutRepitionPermutation {
    public static void main(String[] args) {
        String str = "abcabc";
        int k = 2;
        Set<String> unique = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            unique.add(""+str.charAt(i));
        }
        String uniqueString = String.join("", unique);
        Character[] c = new Character[k];
       // printPermutationWithKLengthElementDepth(uniqueString, c, 0,0);
        printPermutationBlockDepthApproach(uniqueString, c, 0,2);
//        printCombinationWithKLengthApproach2(uniqueString, "", 0, k);
    }
    private static void printPermutationWithKLengthElementDepth(String str, Character[] spots, int count, int idx){
        if(str.length() == idx){
            if(count == spots.length) {
                Arrays.stream(spots).forEach(System.out::print);
                System.out.println();
            }
            return;
        }
        char c1 = str.charAt(idx);
        for(int i=0; i<spots.length; i++){
            if(spots[i]==null){
                spots[i] = c1;
                printPermutationWithKLengthElementDepth(str, spots,count+1, idx+1);
                spots[i] = null;
            }
        }
        printPermutationWithKLengthElementDepth(str, spots, count, idx+1);
    }

    private static void printPermutationBlockDepthApproach(String str, Character[] op, int idx, int k){
        if(idx == k){
            Arrays.stream(op).forEach(System.out::print);
            System.out.println();
            return;
        }
        for(int i=0; i<str.length(); i++){
            if(op[idx] == null) {
                op[idx] = str.charAt(i);
                String left = str.substring(0,i);
                String right = str.substring(i+1);
                String newString = left + right;
                printPermutationBlockDepthApproach(newString, op, idx + 1, k);
                op[idx] = null;
            }
        }
    }
}
