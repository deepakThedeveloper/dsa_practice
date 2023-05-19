package recursion;

class Data{
    int min;
    int max;
}
public class FindMinAndMax {
    public static void main(String[] args) {
        int[] a = {10,5,2,6,1,30,80,0,9};
        Data data = findMinMax(a, 0);
        System.out.println("max:"+data.max+" min:"+data.min);
    }

    private static Data findMinMax(int[] a, int n) {
        if(n==a.length-1) {
            Data data = new Data();
            data.min = Integer.MAX_VALUE;
            data.max = Integer.MIN_VALUE;
            return data;
        }

        Data data = findMinMax(a, n+1);

        data.max = Math.max(data.max, a[n]);
        data.min = Math.min(data.min, a[n]);

        return data;
    }
}
