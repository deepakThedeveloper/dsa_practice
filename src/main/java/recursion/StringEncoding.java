package recursion;

import java.util.Arrays;

public class StringEncoding {
    public static void main(String[] args) {
        String str = "123";

        printEncodedString(str, "");
        System.out.println("==========================");
        int total = printEncodedStringApproach2(str, "");
        System.out.println("total encoded strings:"+total);

        System.out.println("==========================");
        int[] dp = new int[str.length()];
        Arrays.fill(dp, -1);
        int totalMemo = printEncodedStringApproach2Memo(str, dp, 0,"");
        Arrays.stream(dp).forEach(v->System.out.print(v+" "));
        System.out.println("total encoded strings memoization:"+totalMemo);
        System.out.println("==========================");
        int totalVal = printEncodedStringApproach2Tabulation(str, 0);
        System.out.println("total encoded strings tabulation:"+totalVal);
    }

    private static int printEncodedStringApproach2Tabulation(String str, int idx){
        int n = str.length();
        int[] dp = new int[n];
        dp[n-1] = 1;

        for(int i=n-2; i>=0; i--){
            int single1 = dp[i+1];
            int double1 = 0;
            if(i - idx >= 2){
                String prefix = str.substring(0,2);
                int number = Integer.parseInt(prefix);
                if(number >=10 && number <=26){
                    double1 = dp[i+1];
                }
            }
            dp[i] = single1 + double1;
        }
        Arrays.stream(dp).forEach(v->System.out.print(v+" "));
        return dp[0];
    }

    private static int printEncodedStringApproach2Memo(String str, int[] dp, int idx, String op){
        if(str.length()==idx){
            System.out.println(op);
            return 1;
        }
        char c1 = (char)((str.charAt(idx) - '0') + 96);
        //if(dp[idx] != -1) return dp[idx];
        int single1 = printEncodedStringApproach2Memo(str, dp, idx+1, op+c1);

        int double1 = 0;
        if(str.length() - idx >= 2){
            String prefix = str.substring(idx, 2);
            int number = Integer.parseInt(prefix);
            if(number >=10 && number <=26){
                double1 = printEncodedStringApproach2Memo(str, dp, idx+1, op+(char)(number+96));
            }
        }
        return dp[idx] = single1 + double1;
    }

    private static int printEncodedStringApproach2(String str, String op){
        if(str.length()==0){
            System.out.println(op);
            return 1;
        }

        char newC = (char)((str.charAt(0) - '0') + 96);
        int single1 = printEncodedStringApproach2(str.substring(1), op+newC);

        int double1 = 0;
        if(str.length() >= 2){
            String prefix = str.substring(0,2);
            int number = Integer.parseInt(prefix);
            if(number >=10 && number <=26){
                char temp = (char) (number + 96);
                double1 = printEncodedStringApproach2(str.substring(2), op+temp);
            }
        }
        return single1 + double1;
    }

    private static void printEncodedString(String str, String op){
        if(str.length()==0){
            System.out.println(op);
            return;
        }

        for(int i=0; i<str.length(); i++){
            String newString = str.substring(i+1);
            String prefix = str.substring(0, i+1);
            int v = Integer.parseInt(prefix);
            if(v>26) continue;
            char c = (char)(v + 96);
            printEncodedString(newString, op+c);
        }
    }
}
