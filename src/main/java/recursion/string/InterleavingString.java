package recursion.string;

public class InterleavingString {
     public static void main(String[] args){
         String s1 = "aabcc";
         String s2 = "dbbca";
         String s3 = "aadbbcbcac";

         boolean match =  match(s1, s2, s3, 0, 0);
        System.out.println(match);
     }

     private static boolean match(String s1, String s2, String s3, int i, int j){
         if(i==s1.length() && j==s2.length()) return true;

         if(i<s1.length() && s1.charAt(i) == s3.charAt(i+j)){
             if(match(s1, s2, s3, i+1, j)) return true;
         }
         if(j<s2.length() && s2.charAt(j) == s3.charAt(i+j)){
             if(match(s1, s2, s3, i, j+1)) return true;
         }

         return false;
     }
}
