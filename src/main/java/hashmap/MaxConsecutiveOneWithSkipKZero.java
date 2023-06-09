package hashmap;

public class MaxConsecutiveOneWithSkipKZero {
    public static void main(String[] args) {
        int[] a = {1,1,0,1,0,0,1,1,0,1,0,1,1};
        int j = -1, count = 0, k=2, max = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            if(a[i] == 0) count++;
            while(count>k){
                j++;
                if(a[j] == 0){
                    count --;
                    break;
                }
            }
            max = Math.max(max, i-j);
        }
        System.out.println("max:"+max);
    }
}
