package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSubstring {
    public static void main(String[] args) {
        //String s = "aabb"; // expected op:[[a, a, b, b], [a, a, bb], [aa, b, b], [aa, bb]]
        String s = "aab"; // expected op:[[a, a, b, b], [a, a, bb], [aa, b, b], [aa, bb]]
        List<List<String>> palindromes = new ArrayList<>();
        getPalindromeSubstring(s,palindromes, new ArrayList<>());
        System.out.println(palindromes);
    }

    private static void getPalindromeSubstring(String s, List<List<String>> palindromes, List<String> data) {
        if(s.length()==0){
            palindromes.add(new ArrayList<>(data));
        }
        for(int i=0; i<s.length(); i++){
            String s1 = s.substring(0, i+1);
            if(isPalindrome(s1)){
                data.add(s1);
                String s2 = s.substring(i+1);
                getPalindromeSubstring(s2,  palindromes, data);
                data.remove(data.size()-1);

            }
        }
    }

    private static boolean isPalindrome(String op){
        if(op.length()==0) return false;
        if(op.length() ==1) return true;

        for(int i=0, j=op.length()-1; i<j; i++, j--){
            if(op.charAt(i) != op.charAt(j)) return false;
        }
        return true;
    }
}
