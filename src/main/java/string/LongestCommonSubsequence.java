package string;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "AYGTAB";
        String str2 = "AGXTAYB";

        //int length = lcsGFG(str1, str2, str1.length(), str2.length(), str2.length());
        //System.out.println(length);
//       lcsTest(str1, str2, 0, 0, 0, "");
//        System.out.println(maxLength);
//        System.out.println(op1);
        Value value = lcsTestMemoization(str1, str2, 0, 0, 0, "", new HashMap<>());
        System.out.println(maxLength);
        System.out.println(op1);

    }
    static int maxLength = Integer.MIN_VALUE;
    static String op1 = "";

    static void lcsTest(String s1, String s2, int idx, int idx1, int sum, String op){
        if(idx1 == s2.length()){
            if(sum > maxLength){
                maxLength = sum;
                op1 = op;
            }
            return;
        }
        System.out.println("hello:"+s1.charAt(idx)+" "+s2.charAt(idx1));

        for(int i=idx; i<s1.length(); i++){
            for(int j = idx1; j<s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    lcsTest(s1, s2, i+1, j+1, sum+1, op+s1.charAt(i));
                }
            }
        }
    }

    static Data data = new Data('0','0');
    static Value lcsTestMemoization(String s1, String s2, int idx, int idx1, int sum, String op, Map<Data, Value> map){
        if(idx1 == s2.length()){
            if(sum > maxLength){
                maxLength = sum;
                op1 = op;
            }
            return new Value(op, sum);
        }
        if(!map.isEmpty()){
            System.out.println(map);
            System.out.println(s1.charAt(idx)+" "+s2.charAt(idx1));

            Data data = new Data(s1.charAt(idx), s2.charAt(idx1));
            if(map.containsKey(data)){
                System.out.println("in contains");
                return map.get(data);
            }
        }
        //System.out.println("hello:"+s1.charAt(idx)+" "+s2.charAt(idx1));
        Value value1 = new Value();
        for(int i=idx; i<s1.length(); i++){
            for(int j = idx1; j<s2.length(); j++){
                char c11 = s1.charAt(i);
                char c12 = s2.charAt(j);
                //System.out.println("comparing:"+c11+" "+c12);
                if(s1.charAt(i) == s2.charAt(j)){
                    //System.out.println("match found:"+c11+" "+c12);
                    Value value = lcsTestMemoization(s1, s2, i+1, j+1, sum+1, op+s1.charAt(i),map);
                    //System.out.println("value for:"+c11+" "+c12+" -->"+value);
                    value1.sum = value.sum;
                    value1.op = value.op;
                    map.put(new Data(s1.charAt(i), s2.charAt(j)), value);
                }
            }
            //System.out.println("out of inner for-----------");
        }
        return value1;
    }

    // Returns length of LCS for X[0..m-1], Y[0..n-1]
    static int lcsGFG(String X, String Y, int m, int n, int on)
    {
        if (m == 0 || n == 0)
            return 0;
        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + lcsGFG(X, Y, m - 1, n - 1, on);
        else {
            int v1 = lcsGFG(X, Y, m, n - 1, on);
            int v2 = lcsGFG(X, Y, m-1, on, on);
            return Math.max(v1, v2);
        }
    }

    private static void getMaxLengthByIteration(String str1, char[] c1, char[] c2) {
        int start, temp;
        String op = "";
        int maxLength = Integer.MIN_VALUE;
        int j;
        for(int i=0; i<c2.length; i++){
            temp = i;
            System.out.println("i:"+c2[i]+" maxLength:"+maxLength+" op:"+op);
            start = -1;
            for(j=0; j<c1.length && temp<c2.length; j++){
                if(c2[temp] == c1[j]){
                    if(start == -1){
                        start = j;
                    }
                    temp++;
                }
                else{
                    if(start>-1){
                        int diff = j-start;
                        if(diff>maxLength){
                            maxLength = diff;
                            op = str1.substring(start, j);
                        }
                        start = -1;
                        temp = i;
                    }
                }
            }
            if(start>-1){
                int diff = j-start;
                if(diff>maxLength){
                    maxLength = diff;
                    op = str1.substring(start, j);
                }
            }
        }
        System.out.println("maxLength:"+maxLength+" op:"+op);
    }
}

@AllArgsConstructor
@ToString
class Data{
    char c1;
    char c2;

    @Override
    public boolean equals(Object c1){
        if(this == c1) return true;
        if(c1 == null || c1.getClass() != this.getClass()) return false;

        Data d = (Data) c1;
        return d.c1 == this.c1 && d.c2 == this.c2;
    }

    @Override
    public int hashCode(){
        return Objects.hash(c1, c2);
    }
}

@AllArgsConstructor
@ToString
@NoArgsConstructor
class Value{
    String op;
    int sum;
}
