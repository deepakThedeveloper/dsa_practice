package arrays;

public class PivotOfSortedArray {
    public static void main(String[] args) {
        int[] a= {50,60,70,80,10,20,30,40};
        int pivot = pivotOfRotatedArray(a, 0, a.length-1);
        System.out.println(pivot);
        int pivot1 = pivotOfRotatedArrayIteration(a);
        System.out.println(pivot1);
    }

    private static int pivotOfRotatedArrayIteration(int[] a){
        int lo = 0;
        int hi = a.length - 1;

        while(lo<hi){
            int mid = (lo+hi)/2;
            if(a[mid]<a[hi]) hi = mid;
            else lo = mid+1;
        }
        return a[hi];
    }


    private static int pivotOfRotatedArray(int[] a, int s, int e){
        if(s>=e) return -1;
        int mid = (s+e)/2;
        if(mid>0 && a[mid-1]>a[mid]) return a[mid];

        if(a[mid] > a[e]) {
            return pivotOfRotatedArray(a, mid+1, e);
        }
        else {
            return pivotOfRotatedArray(a, s, mid);
        }
    }
}
