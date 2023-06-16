package recursion.backtracking;

import java.util.Arrays;

/**
 * Permutation means combination + placement. Combination selects any elements and place them anywhere.
 * Placement of elements in these combinations doesn't matter. and so only single way is ok.
 * e.g: [1,2] -- [1,2] || [2,1] is combination. There is orring and not anding. Either it can be [1,2] or [2,1] doesn't matter
 * in permutation the combination and its ordering both matters.
 * so in above example [1,2] -- [1,2] and [2,1]. it means same data set can be represented in how many ways.
 *
 * So, combination time complexity is 2^n then permutation time complexity is n!. it is bigger than combination
 * because permutation first takes 2^n for creating combination and then it takes additional time for doing proper placement
 * which leads to n!.
 *
 * There are couple of approaches for getting permutation. Consider values on which permutation to be done as elements
 * and places where they will fit as blocks. e.g.: ABC are elements and for combination lik ACB, three places are needed
 * where they will get shuffled.
 *
 * So either consider blocks as node and element as edges. e.g. 3 blocks --- can have 3 edges A__, B__, C__.
 * In such cases blocks will create depth of tree. At first level A,B,C,. At second it is AB_, BA_, CA_
 * or the second way is elements create node and blocks as edges like . A is node with edges as A--, -A-, --A.
 * At second level B will create new node and op will AB-, BA-, B-A...
 *
 * Please refer to image permutation_approaches.jpg in resources folder
 */
public class PrintPermutation {
    public static void main(String[] args) {
       // printPermutations("ABC", "");
       // printPermutationsRevision("ABC", "");
        String word = "ABC";
        int blocks  = 3;
        char[] op = new char[blocks];
        Arrays.fill(op,'-');
       // printPermutationElementDepthApproach(0, word, op, blocks);
       // printPermutationElementDepthApproach(word, op, blocks);
        //printPermutationBlockDepthApproach(0, word, op, blocks, new boolean[word.length()]);
        printPermutationBlockDepthApproach(0, word, op, blocks);
    }

    // index forward approach instead of reducing string in every pass
    private static void printPermutationElementDepthApproach(int idx, String str, char[] op, int blocks){
        if(idx == str.length()){
            System.out.println(op);
            return;
        }
        for(int i=0; i<blocks; i++) {
            if(op[i]!='-') continue;
            op[i] = str.charAt(idx);
            printPermutationElementDepthApproach(idx + 1, str, op, blocks);
            op[i]='-';
        }
    }

    // reducing string in every pass
    private static void printPermutationBlockDepthApproach(int idx, String str, char[] op, int blocks){
        if(idx == blocks){
            System.out.println(op);
            return;
        }
        for(int i=0; i<str.length(); i++) {
            op[idx] = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i+1);
            printPermutationBlockDepthApproach(idx + 1, left+right, op, blocks);
            op[idx]='-';
        }
    }

    // index forward approach instead of reducing string in every pass
    private static void printPermutationBlockDepthApproach(int idx, String str, char[] op, int blocks, boolean[] visited){
        if(idx == blocks){
            System.out.println(op);
            return;
        }
        for(int i=0; i<str.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            op[idx] = str.charAt(i);
            printPermutationBlockDepthApproach(idx + 1, str, op, blocks, visited);
            op[idx]='-';
            visited[i] = false;
        }
    }

    // string reduction approach
    private static void printPermutationElementDepthApproach(String str, char[] op, int blocks){
        if(0 == str.length()){
            System.out.println(op);
            return;
        }
        for(int i=0; i<blocks; i++) {
            if(op[i]!='-') continue;
            op[i] = str.charAt(0);
            String newString = str.substring(1);
            printPermutationElementDepthApproach(newString, op, blocks);
            op[i]='-';
        }
    }

    // this approach is block based approach with string reduction. in above block based approach I have represented
    // char[] as blocks. here it is string in place of char[]
    private static void printPermutationsRevision(String s, String op) {
        if(s.length() == 0){
            System.out.println(op);
            return;
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            String s1 = s.substring(0, i) + s.substring(i+1);
            printPermutationsRevision(s1, op+c);
        }
    }
}
