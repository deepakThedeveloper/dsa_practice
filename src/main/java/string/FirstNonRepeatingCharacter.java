package string;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "ybgofbtwhrylqppidnejjkcyiyosqcotfjugqkgvvbblyagmkgakawmthhrdmcfqqospslebhhnvwdym";
        char c = firstNonRepeatingCharacter(s);
        System.out.println(c);
    }
    public static char firstNonRepeatingCharacter(String str) {
        Map<Character, Boolean> v = new LinkedHashMap<>();
        for(char c:str.toCharArray()){
            if(v.containsKey(c)) v.put(c, true);
            else v.put(c, false);
        }

        return v.entrySet().stream()
                .filter(a->!a.getValue())
                .findFirst().get().getKey();
    }
}
