package dynamicProgramming;

/**
 * there are n number of friends. to find total combinations in which a person can remain alone or pair up with other person.
 */
public class FriendsPairingProblem {
    public static void main(String[] args) {
        int n = 3;
        int count  = findPairingCombinationsCount(n, "", 1);
        System.out.println(count);
//        int sum = findPairingCombinationsSum(n, 0);
//        System.out.println(sum);
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
