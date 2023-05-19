package string;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {
    public static void main(String[] args) {
        String s = "ABC";
        /*List<String> permutations = getPermutations(s);
        permutations.forEach(System.out::println);*/
        printPermutn(s, "");
        //printPermutationsIterative(s);
    }

    private static List<String> getPermutations(String s) {
        if(s.length() == 1){
            List<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }
        char c = s.charAt(s.length()-1);
        List<String> list = getPermutations(s.substring(0, s.length()-1));
        List<String> finalList = new ArrayList<>();
        for(String s1 : list){
            for(int i=0; i<=s1.length(); i++){
                String s2 = s1.substring(0, i) + c + s1.substring(i);
                finalList.add(s2);
            }
        }
        return finalList;
    }

    //todo: this is geeksforgeeks solution. need to learn the implementation
    static void printPermutn(String str, String ans)
    {
        System.out.println("str:"+str+" ans:"+ans);
        // If string is empty
        if (str.length() == 0) {
            System.out.println(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.println("inside for. i:"+i + " str:"+str);
            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            printPermutn(ros, ans + ch);
            //System.out.print("");
        }
    }

    // Not working
    static void printPermutationsIterative(String str){
        char[] c = str.toCharArray();
        for(int i=0; i<c.length; i++){
            String s1 = str.substring(0, i)+str.substring(i+1);
            for(int j=0; j<=s1.length(); j++){
                String s2 = s1.substring(0, j) + c[i] + s1.substring(j);
                //System.out.println(s2);
            }
        }
    }
}
