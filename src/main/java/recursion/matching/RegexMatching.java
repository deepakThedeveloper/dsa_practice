package recursion.matching;

/**
 * string s1 contains characters [a-z] and ? or * or both. ? represents exact one char match and * represents 0, or 0--m char match.
 * string s2 will be given and need to compare two strings s1 and s2. if both matches return true else return false;
 */
public class RegexMatching {
    public static void main(String[] args) {
        String s1 = "mis*i.*p*i";
        String s2 = "mississippi";
        boolean matchString = matchString(s1, s1.length(), s2, s2.length());
        System.out.println("recursion:"+matchString);
    }

    private static boolean matchString(String s1, int i1, String s2, int i2) {
        if(i1 == 0 && i2 == 0) return true;
        if(i1==0 && i2 > 0) return false;
        if(i2==0 && i1>0){
            for(int i=i1; i>0; i--){
                if(s1.charAt(i-1)!='*') return false;
            }
            return true;
        }
        if (s1.charAt(i1-1) == s2.charAt(i2-1) || s1.charAt(i1-1)=='.') {
            return matchString(s1, i1 - 1, s2, i2 - 1);
        }
        /**
         * if there is a * i have two options. Either I will consider that * matches with no string in s2 and decrement i
         * or else I will consider * will match with j----0 character os keeping i constant at * and decrementing j.
         *
         */
        if(s1.charAt(i1-1) == '*'){
            if(i1-2>=0 && s1.charAt(i1-2) == '.' || s1.charAt(i1-2) == s2.charAt(i2-1)){
                return matchString(s1, i1-1, s2, i2) || matchString(s1, i1, s2, i2-1);
            }
        }
        return false;
    }
}
