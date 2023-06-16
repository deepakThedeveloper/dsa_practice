package arrays;

import java.util.*;

public class LongestConsecutive {
    public static void main(String[] args) {
        int arr[]={100,200,105,11,15,12,14,13,9,10, 99,98,97,96,95,94,93,92,91,90};
//        int lon = optimizedSolution(arr);
//        System.out.println("The longest consecutive sequence is "+lon);

        int maxCount = findCountOfLargestConsecutiveSequence(arr);
        System.out.println("largest consecutive subsequence count recursive:"+maxCount);

        int maxCount1 = findCountOfLargestConsecutiveSequenceIterative(arr);
        System.out.println("largest consecutive subsequence count iterative:"+maxCount1);
    }

    private static int findCountOfLargestConsecutiveSequence(int[] arr) {
        Map<Integer, Integer> valCountMap = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            valCountMap.put(arr[i], 0);
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> map : valCountMap.entrySet()){
            int count = map.getValue();
            if(map.getValue()==0){
                count = searchAndPopulateSequenceRecursive(map.getKey(), valCountMap);
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private static int searchAndPopulateSequenceRecursive(int ele, Map<Integer, Integer> map){
        if(!map.containsKey(ele)) return 0;
        if(map.get(ele) != 0) return map.get(ele);

        int count =  searchAndPopulateSequenceRecursive(ele+1, map) + 1;
        map.put(ele, count);
        return count;
    }

    private static int findCountOfLargestConsecutiveSequenceIterative(int[] arr) {
        Set<Integer> elements = new HashSet<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            elements.add(arr[i]);
        }
        int max = Integer.MIN_VALUE, count = 0;
        for(Integer ele : elements){
            if(elements.contains(ele-1)) continue;
            int itr = ele;
            count = 0;
            while(elements.contains(itr)){
                count++;
                itr++;
            }
            max = Math.max(max, count);
        }
        return max;
    }


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
