package recursion.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * I have implemented
 * 1. printSubsequence with binary tree implementation of take and not take
 * 2. printSubsequenceUsingLoop1 using for loop and printing all subsequences within and outside for loop
 * 3. printSubsequenceUsingLoop2 using for loop and printing all subsequences in base case with n+1 for loop iteration
 * 4. subsequenceReturn where I am returning final List<List>>.
 */
public class ArraySubsequence {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        //printSubsequenceNew(a, 0, new ArrayList<>());
       // printSubsequence(a, 0, new ArrayList<>());
        System.out.println("using loop:=============================");
        //printSubsequenceUsingLoop1(a, 0, new ArrayList<>());

        List<List<Integer>> subsequence = subsequenceReturn(a, 0, new ArrayList<>());
        System.out.println(subsequence);
    }

    private static void printSubsequence(int[] a, int i, List<Integer> list) {
        if (i == a.length) {
            System.out.println(list);
            return;
        }

        list.add(a[i]);
        printSubsequence(a, i + 1, list);
        list.remove(list.size() - 1);

        printSubsequence(a, i + 1, list);
    }

    private static List<List<Integer>> subsequenceReturn(int[] a, int i, List<Integer> vals) {
        if(i==a.length){
            List<List<Integer>> finalList = new ArrayList<>();
            finalList.add(new ArrayList<>(vals));
            return finalList;
        }
        vals.add(a[i]);
        List<List<Integer>> tc = subsequenceReturn(a, i+1, vals);
        vals.remove(vals.size()-1);

        List<List<Integer>> ntc = subsequenceReturn(a, i+1, vals);

        List<List<Integer>> finalList = new ArrayList<>();
        finalList.addAll(tc);
        finalList.addAll(ntc);

        return finalList;
    }

    // to be worked on. additional empty list is getting printed. trying out inorder traversal of tree.
    private static void printSubsequenceNew(int[] a, int i, List<Integer> list) {
        if(i>a.length) {
            //System.out.println(list);
            return;
        }

        if(i<a.length) list.add(a[i]);
        printSubsequenceNew(a, i+1, list);
        System.out.println(list);
        if(!list.isEmpty()) list.remove(list.size()-1);
        printSubsequenceNew(a, i+1, list);
    }

    // in this approach we are printing values of in base case itself.
    // parent will contain child and also one null value 1[2,3], 2[3], 2[null]. in this case with null again we are
    // giving call.Now the point to think is why to give call with null, we need to give call with null because our sout stmt
    // is present in base case and we need to print the stmt. By null call we should imagine it as it is last case or
    // last option where we can print parent node. if we will not give null call then there is no way to print parent nodes
    private static void printSubsequenceUsingLoop1(int[] a, int start, List<Integer> list) {
        if(start>=a.length) {
            System.out.println("in if:"+list);
            return;
        }
        for(int i=start; i<=a.length; i++){
            if(i<a.length) list.add(a[i]);
            printSubsequenceUsingLoop1(a, i+1, list);
            if(i<a.length)list.remove(list.size()-1);
        }
        //System.out.println("out of for:"+list);
    }

    // in this approach we are printing values of parent outside of loop.
    // parent will only contain said child e.g.: 1[2,3], 2[3]  - so in a tree 1 is parent, 1->2 is parent, 1-2-3 is child
    // so we are printing 1-2-3, but if we need to print 1-2 we can't because it is parent and not leaf node,
    // so printing it outside of loop
    private static void printSubsequenceUsingLoop2(int[] a, int start, List<Integer> list) {
        if(start==a.length) {
            System.out.println("in if:"+list);
            return;
        }
        for(int i=start; i<a.length; i++){
            list.add(a[i]);
            printSubsequenceUsingLoop2(a, i+1, list);
            list.remove(list.size()-1);
        }
        System.out.println("out of for:"+list);
    }
}
