package arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] a = new int[]{-10,-40,-25,-12,-25,-10};
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            if(a[i]>secondMax && a[i]!=max){
                if(a[i]>max){
                    secondMax = max;
                    max = a[i];
                }
                else{
                    secondMax = a[i];
                }
            }
        }
        System.out.println(secondMax);
        //System.out.println(max);
    }
}
