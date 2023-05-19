package string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> list = getGroupedAnagrams(Arrays.asList("abab", "baba", "aabb", "abbc"),4 );
        System.out.println(list);
    }
    public static ArrayList<ArrayList<String>> getGroupedAnagrams(List<String> input, int n) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String s : input){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            }
            else{
                ArrayList<String> vals = new ArrayList<>();
                vals.add(s);
                map.put(sorted, vals);
            }
        }
        ArrayList<ArrayList<String>> final1 = new ArrayList<>();
        for(ArrayList<String> lst : map.values()){
            final1.add(lst);
        }
        return final1;
    }
}
