package recursion;

import java.util.ArrayList;
import java.util.List;

/**
We are given a string S, we need to find count of all contiguous substrings starting and ending with same character.
Input  : S = "abcab"
Output : 7
7 substrings : a, abca, b, bcab,
c, a and b.
 */
public class SubstringCount {
    public static void main(String[] args) {
        String s = "abcab";
        for(int i=0; i<s.length(); i++) {
            getSubStrings(s.substring(i), "");
        }

    }

    //not good approach. need to do recursion in better way
    private static void getSubStrings(String s, String op) {
        if (s.length() == 0) {
            return;
        }

        char c = s.charAt(0);
        String s2 = s.substring(1);
        getSubStrings(s2, op + c);
        String temp = op + c;
        if(temp.length() == 1){
            System.out.println(temp);
        }
        if(temp.length()>1 && temp.charAt(0) == temp.charAt(temp.length()-1))
        System.out.println(temp);

    }
}
