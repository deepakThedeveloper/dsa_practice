package recursion;

/**
 *  Given a string, find all possible palindromic partitions of given string.
 *  e.g: geeks o/p: ee, g,k,s
 */
//todo
public class FindPalindromicPartitions {
    public static void main(String[] args) {
        String str = "geeks";
        printPalindromicPartitions(str, "");
    }

    private static void printPalindromicPartitions(String s, String op) {

        for(int i=0, j=s.length()-1; i<j;i++, j--){
            if(s.charAt(i) != s.charAt(j)){
            }
        }
    }

    private String getPalindromeString(String s){
        for(int i=0, j=s.length()-1; i<j;i++, j--){
            if(s.charAt(i) != s.charAt(j)){
            }
        }
        return null;
    }
}
