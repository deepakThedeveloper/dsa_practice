package arrays;

public class LeadersInArray {
    public static void main(String[] args){
        int[] m = {10, 22, 12, 3, 0, 6};
        int max = Integer.MIN_VALUE;
        for(int i=m.length-1; i>=0; i--){
            if(max<m[i]){
                max = m[i];
                System.out.print(max+" ");
            }
        }
    }
}
