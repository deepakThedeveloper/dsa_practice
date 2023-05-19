package string;

import java.util.HashMap;
import java.util.Map;

public class RomanStringToNumber {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);

        int val = romanToDecimal(map, "LXXXVII");
        System.out.println("value:"+val);
    }
    public static int romanToDecimal(Map<String, Integer> map, String str) {
        int n = str.length();
        if(n==1){
            return map.get(str);
        }
        char[] c = str.toCharArray();

        int sum = 0, val1;
        boolean lastUsedValue = false;
        for(int i=0; i<n-1; i++){
            String temp = ""+c[i]+""+c[i+1];
            if(map.containsKey(temp)){
                if(i+2 == n){
                    lastUsedValue = true;
                }
                val1 = map.get(temp);
                i++;
            }
            else{
                val1 = map.get(""+c[i]);
            }
            sum += val1;
        }
        if(!lastUsedValue && n>1){
            sum+= map.get(""+c[n-1]);
        }
        return sum;
    }
}
