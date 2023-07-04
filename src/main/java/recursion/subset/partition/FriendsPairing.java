package recursion.subset.partition;

import java.util.ArrayList;
import java.util.List;

// partition in subsets with length of every partition is at most 2
public class FriendsPairing {
    public static void main(String[] args){
        int n = 3;
        pairFriendsBetterApproach(n, "", 1, new boolean[n+1]);

        int count  = findPairingCombinationsCount(n, "", 1);
        System.out.println(count);
        int sum = findPairingCombinationsSum(n, 0);
        System.out.println(sum);
    }

    private static void pairFriendsBetterApproach(int n, String op, int idx, boolean[] visited){
        if(idx > n){
            System.out.println(op);
            return;
        }
        if(visited[idx]){
            pairFriendsBetterApproach(n, op, idx+1, visited);
        }
        else {
            visited[idx] = true;
            pairFriendsBetterApproach(n, op + "(" + idx + ")", idx + 1, visited);
            for (int i = idx + 1; i <= n; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                pairFriendsBetterApproach(n, op + "(" + idx + i + ")", idx + 1, visited);
                visited[i] = false;
            }
            visited[idx] = false;
        }
    }

    private static int findPairingCombinationsCount(int n, String op, int i) {
        if(op.length()==2){
            System.out.println(op);
            return 1;
        }
        if(op.length()>2 || i>n){
            return 0;
        }

        int count1 =  findPairingCombinationsCount(n, op+i, i+1);
        int count2 = findPairingCombinationsCount(n, op, i+1);

        if(i==1) return count1 + count2 + 1;
        return count1 + count2 ;
    }

    private static int findPairingCombinationsSum(int n, int count) {
        if(count == 2){
            return 1;
        }
        if(n<0){
            return 0;
        }

        int sum = 0;
        for(int i=1; i<=n; i++){
            sum +=findPairingCombinationsSum(n-i, count+1);
        }

        if(count == 0) return sum+1;
        return sum;
    }
}
