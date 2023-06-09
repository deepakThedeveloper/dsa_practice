package hashmap;

import java.util.HashSet;
import java.util.Map;

//abbd = a, ab, b, b, bd, d -- expected output. should not have abb, abbd, bb, bbd
public class CountOfSubstringWithNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abbd";

        HashSet<Character> charSet = new HashSet<>();
        int count = 0;
        for(int j=0; j<str.length(); j++) {
            charSet.clear();
            for (int i = j; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!charSet.contains(c)) {
                    count++;
                    charSet.add(c);
                } else {
                    break;
                }
            }
        }
        System.out.println("unique substring:"+count);
    }
}
