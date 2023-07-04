package recursion.string;
// s1 = pepcoder, s2 = peerdcop.
//s1 is splitted into binary string. when merging back some nodes under non-leaf nodes are swapped and a new string returned
// need to find the new string returned by s1 == s2;
public class ScrambledString1 {
    public static void main(String[] args){
//        String s1 = "great", s2 = "aregt";
        String s1 = "pepcoder", s2 = "peerdcop";
        boolean isScrambled = isScrambled(s1, s2);
        System.out.println(isScrambled);

        boolean isScrambled2 = isScrambled2(s1, s2, 0, s1.length()-1, 0, s2.length()-1);
        System.out.println(isScrambled2);

        boolean isScrambled3 = isScrambled3(s1, s2, 0,0, s2.length());
        System.out.println(isScrambled3);
    }

    private static boolean isScrambled3(String s1, String s2, int s1i, int s2i, int len){
        if(s1.substring(s1i, s1i+len).equals(s2.substring(s2i, s2i+len  ))) return true;

        for(int i=1; i<len; i++){
            if(isScrambled3(s1, s2, s1i, s2i, i) && isScrambled3(s1, s2, s1i+i, s2i+i, len-i) ||
                    isScrambled3(s1, s2, s1i,s2i+len-i, i) && isScrambled3(s1, s2, s1i+i, s2i, len-i)){
                return true;
            }
        }
        return false;
    }

    private static boolean isScrambled2(String s1, String s2, int s1i, int e1i, int s2i, int e2i){
        if(s1.substring(s1i, e1i+1).equals(s2.substring(s2i, e2i+1))) return true;

        for(int i=0; i<e1i - s1i; i++){
            if(isScrambled2(s1, s2, s1i, s1i+i, s2i, s2i+i) && isScrambled2(s1, s2, s1i+i+1, e1i, s2i+i+1, e2i) ||
                    isScrambled2(s1, s2, s1i, s1i+i, e2i-i, e2i) && isScrambled2(s1, s2, s1i+i+1, e1i, s2i, e2i-i-1)){
                return true;
            }
        }
        return false;
    }

    private static boolean isScrambled(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;

        for(int i=1; i<s1.length(); i++){
            String s1Left = s1.substring(0, i);
            String s1Right = s1.substring(i);

            String s2Left1 = s2.substring(0, i);
            String s2Right1 = s2.substring(i);
            String s2Left2 = s2.substring(0, s2.length()-i);
            String s2Right2 = s2.substring(s2.length()-i);

            // (s1 left = s2 left && s1 right = s2 right) || (s1 left = s2 right && s1 right = s2 left)
            if(isScrambled(s1Left, s2Left1) && isScrambled(s1Right, s2Right1) ||
                    isScrambled(s1Left, s2Right2) && isScrambled(s1Right, s2Left2))
                return true;
        }
        return false;
    }
}
