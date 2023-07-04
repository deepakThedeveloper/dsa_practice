package recursion.subset.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Substring {
    public static void main(String[] args) {
        String str = "abc";
        substring(str, 0);
        System.out.println("===================");
        List<List<String>> substring = substring2(str, 0);
        System.out.println(substring);
    }

    private static void substring(String str, int i){
        if(str.length() == i) return;

        System.out.println(str.substring(0, i+1));
        substring(str, i+1);
        if(i==0){
            substring(str.substring(i+1), i);
        }
    }

    private static List<List<String>> substring2(String str, int i){
        if(str.length()-1 == i){
            return Arrays.asList(Arrays.asList(str.substring(i)));
        }

        List<List<String>> temp = substring2(str, i+1);
        List<List<String>> newList = new ArrayList<>();
        List<String> temp1 = new ArrayList<>();
        temp1.add(str.charAt(i)+"");
        for(String str1 : temp.get(0)){
            temp1.add(str.charAt(i)+str1);
        }
        newList.add(temp1);
        newList.addAll(temp);
        return newList;
    }
}
