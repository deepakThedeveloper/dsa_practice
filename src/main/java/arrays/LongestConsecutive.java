package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public static void main(String[] args) {
        int arr[]={100,200,105,11,15,12,14,13,9,10, 99,98,97,96,95,94,93,92,91,90};
        //int lon= longestConsecutiveReadymadeCode(arr);
       // int lon = bruteForceCode(arr);
        int lon = optimizedSolution(arr);
        System.out.println("The longest consecutive sequence is "+lon);
    }

    //todo
    private static int optimizedSolutionRevision(int[] arr) {return 0;}

    private static int optimizedSolution(int[] arr) {
        Map<Integer, Integer> vals = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            vals.put(arr[i], i);
        }
       int temp = 0, tempMinus, tempPlus;
        boolean found = false;
        int count = 0, max = 0;

       for(int i=0; i<arr.length; i++){
           if(arr[i] == Integer.MIN_VALUE) continue;
           temp = arr[i];
           tempMinus = temp -1;
           tempPlus = temp +1;
           count = 0;
           while(true){
               found = false;
               if(vals.containsKey(tempMinus)){
                   arr[vals.get(tempMinus)] = Integer.MIN_VALUE;
                   tempMinus--;
                   found = true;
                   count ++;
               }
               if(vals.containsKey(tempPlus)){
                   arr[vals.get(tempPlus)] = Integer.MIN_VALUE;
                   tempPlus++;
                   found = true;
                   count++;
               }
                if(!found) break;
           }
           if(max < count){
               max = count;
           }
       }
       return max+1;
    }

    private static int bruteForceCode(int[] arr) {
        Arrays.sort(arr);

        int count = 0;
        int max = 0;
        for(int i =0; i< arr.length-1; i++){
            if (arr[i + 1] - arr[i] == 1) {
                count++;
            }
            else if(max<count){
                max = count;
                count = 0;
            }
        }
        return max+1;
    }

    public static int longestConsecutiveReadymadeCode(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }

        Arrays.sort(nums);

        int ans = 1;
        int prev = nums[0];
        int cur = 1;

        for(int i = 1;i < nums.length;i++){
            if(nums[i] == prev+1){
                cur++;
            }
            else if(nums[i] != prev){
                cur = 1;
            }
            prev = nums[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
