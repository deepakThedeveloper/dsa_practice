package dynamicProgramming.twoSidesOfMountain;

public class TempleOffering {
    public static void main(String[] args){
        int[] ht = {10, 20, 30, 40, 40, 50, 40, 30, 20, 10, 20, 30, 20, 30, 40, 30, 20, 10};
        int minOfferings = minOfferings(ht);

        System.out.println(minOfferings);
    }

    private static int minOfferings(int[] ht){
        int n = ht.length;
        int[] lftOfferings = new int[n];
        lftOfferings[0] = 1;
        for(int i=1; i<n; i++){
            if(ht[i] > ht[i-1]){
                lftOfferings[i] = lftOfferings[i-1]+1;
            }
            else{
                lftOfferings[i] = 1;
            }
        }
        int[] rgtOfferings = new int[n];
        rgtOfferings[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            if(ht[i] > ht[i+1]){
                rgtOfferings[i] = rgtOfferings[i+1]+1;
            }
            else{
                rgtOfferings[i] = 1;
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += Math.max(lftOfferings[i], rgtOfferings[i]);
        }

        return ans;
    }
}
