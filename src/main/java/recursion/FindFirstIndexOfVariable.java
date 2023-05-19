package recursion;

import java.util.Arrays;

public class FindFirstIndexOfVariable {
    public static void main(String[] args) {
        int[] a = {2,3,6,9,8,3,2,6,2,4};
        //int index = findElement(a, 6, a.length-1);
        //int indexLast = findElementLastIndex(a, 6, 0);
        //System.out.println(index+" "+indexLast);

        //findElementAllIndex(a, 6, 0);
        /*int arr[] = findElementAllIndexAndReturn(a, 6, 0);
        Arrays.stream(arr).forEach(v-> System.out.print(v+" "));
        */
        int arr[] = findElementAllIndexAndReturnLimited(a, 6, 0,0);
        Arrays.stream(arr).forEach(v-> System.out.print(v+" "));
    }

    //Expectations: to search all elements for k in array from 0 - n-1 and return first index
    //Faith: My function searched k in array from 0 - n-2 and returns either -1 if not found else index of k
    // EF: if(index returned == -1) then compare k == a[n-1] and return index n-1 else return index return from faith
    private static int findElement(int[] a, int k, int n) {
        if(n==-1) return -1;

        int index = findElement(a, k, n-1);
        if(index != -1){
            return index;
        }
        return k == a[n] ? n : -1;
    }

    //Expectations: to search all elements for k in array from 0 - n-1 and return first index
    //Faith: My function searched k in array from 1 - n-1 and returns either -1 if not found else index of k
    // EF: if(index returned == -1) then compare k == a[0] and return index 0 else return index return from faith
    private static int findElementLastIndex(int[] a, int k, int n) {
        if(n==a.length) return -1;

        int index = findElementLastIndex(a, k, n+1);
        if(index != -1){
            return index;
        }
        return k == a[n] ? n : -1;
    }

    //Expectations: iterate 0 - n-1 and if k found print index
    //Faith: functions prints all index of array from 1 - n-1 matching with k
    //EF: Compare the 0th value and if found print 0.
    private static void findElementAllIndex(int[] a, int k, int n) {
        if(n==a.length) return;

        findElementAllIndex(a, k, n+1);
        if(k == a[n]){
            System.out.println(n);
        }
    }

    //Expectations: iterate 0 - n-1 and if k found add it to array and at end return array
    //Faith: functions adds all index of array from 1 - n-1 matching with k
    //EF: Compare the 0th value and if found add 0.
    private static int[] findElementAllIndexAndReturn(int[] a, int k, int n) {
        if(n==a.length) return new int[a.length];

        int[] arr = findElementAllIndexAndReturn(a, k, n+1);
        if(k == a[n]){
            arr[n] = n;
        }
        return arr;
    }

    //Expectations: iterate 0 - n-1 and if k found add it to array and at end return array with limited size.
    // For getting limited size array we need to count total elements found in array and create arr of size found
    //Faith: function iterates from 1 to n-1 and one's occurence is found increment the found counter and add values in it
    //EF: Compare the 0th value and if found add 0.
    private static int[] findElementAllIndexAndReturnLimited(int[] a, int k, int n, int found) {
        if(n==a.length) return new int[found];

        if(k == a[n]){
            int[] arr = findElementAllIndexAndReturnLimited(a, k, n+1, found+1);
            arr[found] = n;
            return arr;
        }
        else{
            return findElementAllIndexAndReturnLimited(a, k, n+1, found);
        }
    }
}
