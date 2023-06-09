package recursion.partition;

import java.util.ArrayList;
import java.util.List;

public class PartitionPalindromeString {
    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> partitions = new ArrayList<>();
        getPartitions(str, new ArrayList<>(), partitions);
        System.out.println(partitions);
    }

    private static void getPartitions(String str, List<String> val, List<List<String>> finalList){
        if(str.length() == 0){
            finalList.add(new ArrayList<>(val));
            return;
        }

        for(int i=1; i<=str.length(); i++){
            String pal = str.substring(0, i);
            String newStr = str.substring(i);

            if(isPalindrome(pal)){
                val.add(pal);
                getPartitions(newStr, val, finalList);
                val.remove(val.size()-1);
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
