package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//todo
public class FriendsPairing {
    public static void main(String[] args){
        int n = 3;
        int count = pairFriends(n, "");
        System.out.println(count);
    }

    private static List<String> pairFriends(String str, String s) {

        List<String> finalPairs = new ArrayList<>();
        for(int i=0; i<str.length(); i++) {
            String temp =  str.substring(i,1);
            String newString = str.substring(1,i) + str.substring(i);

            List<String> pairs = pairFriends(newString, s);
            for(String s1 : pairs){
                finalPairs.add(temp+"_"+s1);
            }
        }
        return finalPairs;
    }


    private static int pairFriends(int n, String op){
        if(n==0) {
            System.out.println(op);
            return 1;
        }
        if(n<0) return 0;


        return pairFriends(n-1, op+"_"+(n-1)) + pairFriends(n-2, op+"_"+(n-2));
    }
}
