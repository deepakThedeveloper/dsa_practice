package recursion;

public class Palindrome {
    public static void main(String[] args) {
        String s = "abccba";
        //boolean isPalindrome = palindrome(s,0, s.length()-1);
        boolean isPalindrome = palindrome1(s,0); //3 may 2023
        System.out.println(isPalindrome);
    }

    private static boolean palindrome1(String s, int start) {
        if(start>=s.length()/2) return true;

        if(s.charAt(start) != s.charAt(s.length()-1-start)) return false;
        if(!palindrome1(s, start+1)) return false;
        return true;
    }

    private static boolean palindrome(String s, int l, int r) {
        if(l>=r) return true;

        if(s.charAt(l) != s.charAt(r)){
            return false;
        }
        return palindrome(s, ++l, --r);
    }
}
