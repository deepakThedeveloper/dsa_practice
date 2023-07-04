package dynamicProgramming.string;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

public class StringEncoding {
    public static void main(String[] args) {
        String str = "12123";

        int count2 = printEncodedStringMemo(str, "", new HashMap<>());
        System.out.println(count2);
    }

    private static int printEncodedStringMemo(String str, String op, Map<String, Integer> dp){
        if(str.length()==0){
            System.out.println(op);
            return 1;
        }
        if(dp.containsKey(str)){
            System.out.println("in dp");
            return dp.get(str);
        }
        int count = 0;
        for(int i=0; i<str.length(); i++){
            String newString = str.substring(i+1);
            String temp = str.substring(0, i+1);
            int v = Integer.parseInt(temp);
            if(v>26) continue;
            char c = (char)(v + 96);
            count += printEncodedStringMemo(newString, op+c, dp);
        }
        dp.put(str, count);
        return count;
    }

}
