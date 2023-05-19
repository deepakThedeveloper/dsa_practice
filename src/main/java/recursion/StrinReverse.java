package recursion;

public class StrinReverse {
    public static void main(String[] args) {
        String s = "deepak agrawal";
        String reversed = reverseString(s);
        System.out.println("reversed:" +reversed);
    }

    private static String reverseString(String s) {
        if(s.length()<2) return s;

        return reverseString(s.substring(1, s.length())) + s.charAt(0);
    }
}
