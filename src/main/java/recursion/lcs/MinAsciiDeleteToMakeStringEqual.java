package recursion.lcs;

import matrix.Util;

public class MinAsciiDeleteToMakeStringEqual {
    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";

        int minAsciiDeletion = minAsciiDeletionToMakeStringEqual(s1.length()-1, s1, s2.length()-1, s2);
        System.out.println("recursion:"+minAsciiDeletion);
    }

    private static int minAsciiDeletionToMakeStringEqual(int i, String s1, int j, String s2){
        if(i==0 && j==0) {;
            return s1.charAt(i) == s2.charAt(j)
                    ? 0
                    : (int)s1.charAt(i) + (int)s2.charAt(j);
        }

        if(i<0 && j>=0){
            int sum = 0;
            while (j>=0){
                sum += (int)s2.charAt(j);
                j--;
            }
            return sum;
        }
        if(j<0 && i>=0){
            int sum = 0;
            while (i>=0){
                sum += (int)s1.charAt(i);
                i--;
            }
            return sum;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return minAsciiDeletionToMakeStringEqual(i-1, s1, j-1, s2);
        }
        else{
            int s1Traverse = minAsciiDeletionToMakeStringEqual(i-1, s1, j, s2) + (int)s1.charAt(i);
            int s2Traverse = minAsciiDeletionToMakeStringEqual(i, s1, j-1, s2) + (int)s2.charAt(j);
            return Math.min(s1Traverse, s2Traverse);
        }
    }
}
