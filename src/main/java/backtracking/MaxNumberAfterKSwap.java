package backtracking;

public class MaxNumberAfterKSwap {
    public static void main(String[] args) {
        String str = "1234567";
        int k = 4;

        getMaxNumber(str, k);
        System.out.println(max);
    }

    static String max = "0";
    private static void getMaxNumber(String str, int k) {

        if(Integer.parseInt(str) > Integer.parseInt(max)){
            max = str;
        }
        if(k==0){
            return;
        }
        for(int i=0; i<str.length()-1; i++) {
            for (int j = i+1; j < str.length(); j++) {
                if(str.charAt(j)>str.charAt(i)){
                    str = swap(str, i, j);
                    getMaxNumber(str, k-1);
                    str = swap(str, i, j);
                }
            }
        }
    }

    private static String swap(String str, int i, int j){
        char ith = str.charAt(i);
        char jth = str.charAt(j);

        String left = str.substring(0, i);
        String middle = str.substring(i+1, j);
        String right = str.substring(j+1);

        return left+jth+middle+ith+right;
    }
}
