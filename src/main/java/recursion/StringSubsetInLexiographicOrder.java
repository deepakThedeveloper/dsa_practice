package recursion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Input : abc
 * Output : a ab abc ac b bc c
 */
public class StringSubsetInLexiographicOrder {
    public static void main(String[] args) {
        String str = "abc";

        List<String> list = printSubsetInLexiographicOrder(str, "");
        list.stream().sorted().forEach(System.out::println);
    }

    private static List<String> printSubsetInLexiographicOrder(String str, String op) {
        List<String> list = new ArrayList<>();
        if(str.length() == 0){
            list.add(op);
            return list;
        }

        char c = str.charAt(0);
        String s1 = str.substring(1);
        List<String> list1 =printSubsetInLexiographicOrder(s1, op+c);
        List<String> list2 =printSubsetInLexiographicOrder(s1, op);

        list.addAll(list1);
        list.addAll(list2);
        return list;
    }
}
