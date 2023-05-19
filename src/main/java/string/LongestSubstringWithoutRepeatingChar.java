package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        //String str = "abcabcbb";
        String str = "abcadebgh";
        //int len = longestSubstring(str, str.length());
        //int len = longestSubstringOnline(str);
        int len = longestSubstringOnlineOptimized(str);
        System.out.println("longest sub array length without repeatating char is:"+len);
    }

    //0(n)
    private static int longestSubstringOnlineOptimized(String s) {
        HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    //O(2n)
    private static int longestSubstringOnline(String str) {
        int maxans = Integer.MIN_VALUE;
        Set< Character > set = new HashSet< >();
        int l = 0;
        for (int r = 0; r < str.length(); r++) // outer loop for traversing the string
        {
            if (set.contains(str.charAt(r))) //if duplicate element is found
            {
                while (l < r && set.contains(str.charAt(r))) {
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
    }
    private static int longestSubstring(String str, int length) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> charsMap = new HashMap<>();
        charsMap.put(chars[0], 0);
        int count = 1;
        int max = 1;
        for(int j=1; j<length; j++){
            if(charsMap.containsKey(chars[j])){
                if(max < count){
                    max = count;
                }
                int index = charsMap.get(chars[j]);
                for(int k = index; k>=0; k--){
                    char deleteChar = chars[k];
                    if(charsMap.containsKey(deleteChar)) {
                        charsMap.remove(deleteChar);
                        chars[k] = '0';
                    }
                }
                charsMap.put(str.charAt(j), j);
                count = charsMap.size();
            }
            else {
                charsMap.put(str.charAt(j), j);
                count++;
            }
        }
        return max < count ? count : max;
    }
}
