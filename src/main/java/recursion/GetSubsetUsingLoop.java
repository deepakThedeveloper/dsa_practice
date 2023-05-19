package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetSubsetUsingLoop {
    public static void main(String[] args) {
        //getStringSubsets();
        getStringArraySubsets();
    }

    private static void getStringArraySubsets() {
        String[] str = {"abc","def","pqr"};
        List<List<String>> subsets = new ArrayList<>();
        List<String> subset = new ArrayList<>();
        getStringArraysSubsets(str, subsets, subset, 0);
        System.out.println(subsets);
    }

    private static void getStringArraysSubsets(String[] str, List<List<String>> subsets, List<String> op, int idx) {
        if(idx == str.length){
            subsets.add(new ArrayList<>(op));
            return;
        }

        for(int i=idx; i<=str.length; i++){
            if(i==str.length){
                getStringArraysSubsets(str, subsets, op, i);
            }
            else {
                op.add(str[i]);
                getStringArraysSubsets(str, subsets, op, i + 1);
                op.remove(op.size() - 1);
            }
        }
    }

    private static void getStringSubsets(){
        String str = "abcd";
        List<List<String>> subsets = new ArrayList<>();
        getSubsets(str, subsets, "");
        System.out.println(subsets);
    }
    private static void getSubsets(String str, List<List<String>> subsets, String subset) {
        if(str.length()==0){
            List<String> set = new ArrayList<>();
            set.add(subset);
            subsets.add(set);
            return;
        }
        for(int i=0; i<=str.length(); i++){
            if(i==str.length()){
                getSubsets("", subsets, subset);
            }
            else {
                char c = str.charAt(i);
                String s1 = str.substring(i + 1);
                getSubsets(s1, subsets, subset + c);
            }
        }
    }
}
