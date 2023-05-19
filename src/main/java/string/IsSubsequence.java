package string;

public class IsSubsequence {
    public static void main(String[] args) {
        boolean isSubsequence =  isSubsequence("ACE", "ABCDE");
        System.out.println(isSubsequence);
    }
    public static boolean isSubsequence(String str1, String str2) {
        boolean match = false;
        for(int i=0, j=0; i<str1.length() && j<str2.length(); j++){
            if(str1.charAt(i) == str2.charAt(j)){
                if(i == str1.length()-1){
                    match = true;
                }
                i++;
            }
        }
        return match;
    }
}
