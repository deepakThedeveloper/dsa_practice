package recursion.todo;

/**
 * 000-Pep, 001-Pe1, 010-P1p, 011-p2, 100-1ep, 101-1e1, 110-2p, 111-3
 */
public class StringAbbrevation {
    public static void main(String[] args) {
        String str = "pep";
        printAbbrevation(str, 0, 0, str.length());
    }

    private static void printAbbrevation(String str, int idx, int noOfOnes, int originalSize){
        if(idx==originalSize){
            System.out.println(str);
            return;
        }

        printAbbrevation(str, idx+1, 0, originalSize);
        String suffix = idx >= str.length() ? "" : str.substring(idx+1);
        String newString =  str.substring(0, idx-noOfOnes)+ (1+noOfOnes) + suffix;
        printAbbrevation(newString, idx+1, noOfOnes+1, originalSize);
    }
}
