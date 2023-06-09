package dynamicProgramming.lis;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HighwayBillboardProblem {
    public static void main(String[] args) {
        int roadLen = 20;
        int boardDis = 3;
        int[] boardPoint = {6,8,12,14,16};
        int[] revenue = {5,8,5,3,1};

        int maxRevenue = maxRevenueApproach1(roadLen, boardDis, boardPoint, revenue);
        System.out.println("max revenue using approach1:"+maxRevenue);

        int maxRevenue1 = maxRevenueApproach2(roadLen, boardDis, boardPoint, revenue);
        System.out.println("max revenue using approach2:"+maxRevenue1);
    }

    //tc: O(n2) -- n is number of boards
    private static int maxRevenueApproach1(int r, int d, int[] p, int[] re){
        int[] dp = new int[re.length];
        dp[0] = re[0];
        int max, finalMax = Integer.MIN_VALUE;
        for(int i=1; i<p.length; i++){
            max  = re[i];
            for(int j=0; j<i; j++){
                if(p[i] - p[j]>d){
                    max = Math.max((re[i] + dp[j]), max);
                }
            }
            dp[i] = max;
            finalMax = Math.max(dp[i], finalMax);
        }
        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        return finalMax;
    }

    //tc: O(m) where m is total miles
    private static int maxRevenueApproach2(int r, int d, int[] p, int[] re){
        Map<Integer, Integer> pointRevenue = new HashMap<>();
        for(int i=0; i<p.length; i++){
            pointRevenue.put(p[i], re[i]);
        }
        int[] dp = new int[r];
        int finalMax = Integer.MIN_VALUE;
        for(int i=0; i<r; i++){
            if(!pointRevenue.containsKey(i)){
                dp[i] = i-1>=0 ? dp[i-1] : 0;
                continue;
            }
            int v = pointRevenue.get(i);
            int pv = i-d>=0 ? dp[i-d]+v : v;
            int max = Math.max(pv, v);
            dp[i] = max;
            finalMax = Math.max(dp[i], finalMax);
        }
        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        return finalMax;
    }
}
