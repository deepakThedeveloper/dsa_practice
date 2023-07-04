package recursion.jump;

// frog jumps 1 or 2 places and need to go from 0-n. at every level he needs to spend some energy. find min energy jumps
public class FrogJumpMinEnergy {
    public static void main(String[] args) {
        //int[] a = {7,4,4,2,6,6,3,4};
        int[] a = {30,10,60,10,60,50};
        int minEnergy = minEnergyJumps(a, a.length-1);
        System.out.println(minEnergy);
        int minEnergy1 = striverCode(a, a.length-1);
        System.out.println(minEnergy1);
    }

    private static int minEnergyJumps(int[] a, int n){
        if(n==0) {
            return 0;
        }

        int left = minEnergyJumps(a, n - 1) +Math.abs(a[n] - a[n - 1]);
        int right = n-2 >=0 ? minEnergyJumps(a, n-2) + Math.abs(a[n] - a[n-2]) : Integer.MAX_VALUE;

        return Math.min(left, right);
    }

    private static int striverCode(int[] a, int ind){
        if(ind == 0) return 0;

        int left = striverCode(a, ind-1) + Math.abs(a[ind] - a[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind>1) right = striverCode(a, ind-2) + Math.abs(a[ind] - a[ind-2]);

        return Math.min(left, right);
    }
}
