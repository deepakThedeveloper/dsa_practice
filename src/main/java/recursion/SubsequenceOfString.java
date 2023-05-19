package recursion;

import java.util.ArrayList;

public class SubsequenceOfString {
    public static void main(String[] args) {
        String str = "abc";
        /*ArrayList<String> subsequence = new ArrayList<>();
        getSubsequence(str, str.length()-1, subsequence);
        subsequence.forEach(System.out::println);
        */
        ArrayList<String> subsequence = getSubsequence(str, str.length()-1);
        subsequence.forEach(System.out::println);
    }

    //Expectations: Visit all str elements and select first single values, excluding other, then group them in two and likewise
    //Faith: function returns subsequence in arraylist from 0 to n-1.
    //EF: I need to add nth value to all the combinations
    private static void getSubsequence(String str, int n, ArrayList<String> list) {
        if(n==-1){
            list.add("");
            return;
        }
        getSubsequence(str, n-1, list);
        ArrayList<String> list1 = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            list1.add(list.get(i) + str.charAt(n));
        }
        list.addAll(list1);
    }

    //Expectations: Visit all str elements and select first single values, excluding other, then group them in two and likewise
    //Faith: function returns subsequence in arraylist from 0 to n-1.
    //EF: I need to add nth value to all the combinations
    private static ArrayList<String> getSubsequence(String str, int n) {
        if(n==-1){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        ArrayList<String> list = getSubsequence(str, n-1);
        ArrayList<String> list1 = new ArrayList<>();
        for(String s : list) {
            list1.add(s+"");
            list1.add(s+str.charAt(n));
        }
        return list1;
    }

}
