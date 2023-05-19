package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] a = {10,5 ,9,1,11,8,6,15,3,12,2};

        getLCS(a, a.length-1);
    }

    private static void getLCS(int[] a, int n) {
        Map<Integer, Boolean> mp = new HashMap<>();
        for(int i=0; i<a.length; i++){
            mp.put(a[i], true);
        }

        for(int i=0; i<n; i++){
            if(mp.containsKey(a[i]-1)){
                mp.put(a[i], false);
            }
        }

        int startPoint = 0;
        int length=0;
        for(Map.Entry<Integer, Boolean> mp1 : mp.entrySet()){
            if(mp1.getValue()){
                int temp = mp1.getKey();
                int i = 1;
                while(mp.containsKey(temp+i)){
                    i++;
                }
                if(i>length){
                    length = i;
                    startPoint = temp;
                }
            }
        }

        for(int i=startPoint; i < startPoint+length; i++){
            System.out.print(i+" ");
        }

    }
}
