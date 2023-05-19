package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintStringSubset {
    public static void main(String[] args) {
        //printSubset("abc", "");

       /* List<String> subset = new ArrayList<>();
        returnSubset("abc", "", subset);

        subset.forEach(System.out::println);
*/        List<String> subset = returnSubset1("abc", "");

        subset.forEach(System.out::println);
    }

    private static void returnSubset(String s, String op, List<String> subset) {
        if(s.length() == 0){
            subset.add(op);
            return;
        }
        char c = s.charAt(0);
        String s1 = s.substring(1);
        returnSubset(s1, op+c, subset);
        returnSubset(s1, op, subset);
    }

    private static List<String> returnSubset1(String s, String op) {
        List<String> subset = new ArrayList<>();
        if(s.length() == 0){
            subset.add(op);
            return subset;
        }
        char c = s.charAt(0);
        String s1 = s.substring(1);
        List<String> lsubset = returnSubset1(s1, op+c);
        List<String> rsubset = returnSubset1(s1, op);

        subset.addAll(lsubset);
        subset.addAll(rsubset);
        return subset;
    }

    private static void printSubset(String s, String op) {
        if(s.length() == 0){
            System.out.println(op);
            return;
        }
        char c = s.charAt(0);
        String s1 = s.substring(1);
        printSubset(s1, op+c);
        printSubset(s1, op);
    }
}
