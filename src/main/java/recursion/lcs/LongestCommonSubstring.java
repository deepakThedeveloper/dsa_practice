package recursion.lcs;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "bcpqabcxy";
        String s2 = "xyzabcp";
        int lcSubstring = lcs(s1, s1.length() - 1, s2, s2.length() - 1);
        System.out.println("iteration:"+lcSubstring);
    }

    // approach 1 n*m timecomplexity
    private static int lcs(String s1, int i1, String s2, int i2) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<s1.length(); i++){
           int count = 0;
           boolean match = false;
           int k=i;
           for(int j=0; j<s2.length(); j++){
               if(s1.charAt(k) == s2.charAt(j)){
                   count++;
                   k++;
                   if(k==s1.length()) break;
                   match = true;
               }
               else if(match){
                   max = Math.max(max, count);
                   count = 0;
                   k=i;
                   j--;
                   match = false;
               }
           }
           if(match){
                max = Math.max(max, count);
            }
       }
       return max;
    }
}
