package recursion;

public class PlaindromeNumber {
    public static void main(String[] args) {
        String n = "1235415321";
        boolean isPlaindrome = isPlaindrome(n, 0, n.length()-1);
        System.out.println(isPlaindrome);
    }

    private static boolean isPlaindrome(String s, int start, int end) {
        if(start>=end) return true;
        if(s.charAt(start) != s.charAt(end)){
            return false;
        }
        boolean valid = isPlaindrome(s, start+1, end-1);
        if(!valid) return false;
        return true;
    }
}
