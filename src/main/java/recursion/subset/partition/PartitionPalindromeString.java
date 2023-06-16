package recursion.subset.partition;

import java.util.ArrayList;
import java.util.List;

public class PartitionPalindromeString {
    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> partitions = new ArrayList<>();
        substring(str, new ArrayList<>(), partitions);
        System.out.println(partitions);
    }

    // leetcode tested: https://leetcode.com/problems/palindrome-partitioning/description/
    private static void substring(String ip, List<String> tempOP, List<List<String>> finalOP){
        if(ip.length() == 0){
            finalOP.add(new ArrayList<>(tempOP));
            return;
        }

        for(int i=0; i<ip.length(); i++){
            String prefix = ip.substring(0, i+1);
            if(isPalindrome(prefix)){
                tempOP.add(prefix);
                substring(ip.substring(i+1), tempOP, finalOP);
                tempOP.remove(tempOP.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str){
        for(int i=0, j=str.length()-1; i<j; i++, j--){
            if(str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}
