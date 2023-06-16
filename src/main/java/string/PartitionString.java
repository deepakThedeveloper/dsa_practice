package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionString {

    public static void main(String[] args){
        String str = "ababcbacadefegdehijhklij";
        List<Integer> partitionSize = partitionLabels(str);
        System.out.println(partitionSize);
    }

    // leetcode verified: https://leetcode.com/problems/partition-labels/description/
    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> charLastIndexMap = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            charLastIndexMap.put(s.charAt(i), i);
        }

        System.out.println(charLastIndexMap);
        int prev = -1, next = 0;
        List<Integer> partitionSizeList = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            int index = charLastIndexMap.get(s.charAt(i));
            if(next < index){
                next = index;
            }
            if(i == next){
                partitionSizeList.add(next-prev);
                prev = next;
            }
        }
        return partitionSizeList;
    }
}
