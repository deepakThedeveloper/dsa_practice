package arrays;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3,7,5};
        ArrayList<Integer> subarray = subarraySum(arr, arr.length, 12);
        System.out.println(subarray);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        int l = 0, r = 0;
        for(int i=0; i<arr.length; i++){
            if(sum<s){
                sum +=arr[i];
                r=i;
            }
            while(sum > s){
                if(l<r) {
                    sum -= arr[l];
                    l++;
                }
                else if(l==r){
                    sum = 0;
                    l++;
                    r++;
                }
            }
            // System.out.println("sum:"+sum+" l:"+l+" r:"+r);
            if(sum == s){
                list.add(l+1);
                list.add(r+1);
                return list;
            }


        }
        if(sum == s){
            list.add(l+1);
            list.add(r+1);
            return list;
        }
        list.add(-1);
        return list;
    }
}
