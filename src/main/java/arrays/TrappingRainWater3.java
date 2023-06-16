package arrays;

import java.util.Arrays;
import java.util.Stack;

//10210132121
public class TrappingRainWater3 {
    public static void main(String[] args) {
        //int[] ht = {1,0,1,2,2,3,0,2,0,0,1,2,0,1,3};
        int[] ht = {1,0,2,1,0,1,3,2,1,2,1};
        int water = new TrappingRainWater3().trapOtherApproachLeetcodeWorking2(ht);
        System.out.println("water:"+water);

        int water1 = trap3rdApproachLeetcodeWorking3(ht);
        System.out.println("water1:"+water1);
    }

    private static int trap3rdApproachLeetcodeWorking3(int[] ht){
        int n = ht.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        Arrays.fill(prefix, Integer.MAX_VALUE);
        Arrays.fill(suffix, Integer.MAX_VALUE);

        int max = Integer.MIN_VALUE;
        for(int i=n-2; i>=0; i--){
            if(ht[i] < ht[i+1]){
                max = Math.max(max, ht[i+1]);
            }
            if(max != Integer.MIN_VALUE && ht[i]<max) prefix[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            if(ht[i] < ht[i-1]){
                max = Math.max(max, ht[i-1]);
            }
            if(max != Integer.MIN_VALUE && ht[i]<max) suffix[i] = max;
        }
        Arrays.stream(prefix).forEach(v->System.out.print(v+" "));
        System.out.println();
        Arrays.stream(suffix).forEach(v->System.out.print(v+" "));
        System.out.println();

        int sum = 0;
        for(int i=0; i<n; i++){
            if(prefix[i] == Integer.MAX_VALUE || suffix[i] == Integer.MAX_VALUE) continue;
            sum += Math.min(prefix[i], suffix[i]) - ht[i];
        }
        return sum;
    }

    public int trapOtherApproachLeetcodeWorking2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0; int right = height.length - 1; // Pointers to both ends of the array.
        int maxLeft = 0; int maxRight = 0;
        //{1,0,2,1,0,1,3,2,1,2,1};
        int totalWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    public static int trapLeetcodeWorkingWithStack(int[] height) {
        int n = height.length;
        if(n<=2){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(height[n-1]);

        int bottom = height[n-1];
        int sum = 0;
        for(int i=height.length-2; i>=0; i--){
            if(height[i]>=bottom){
                if(stack.size()==1){
                    stack.pop();
                    bottom = height[i];
                }
                else{
                    while(!stack.isEmpty()){
                        sum += (bottom - stack.pop());
                    }
                    bottom = height[i];
                }
            }
            stack.push(height[i]);
        }
        System.out.println("size:"+stack.size());
        int temp = 0;
        if(stack.size()>1){
            temp = stack.pop();
        }
        while(stack.size()>1){
            int nextTemp = stack.pop();
            if(temp<nextTemp){
                temp = nextTemp;
            }
            else{
                sum += (temp - nextTemp);
            }
        }
        return sum;
    }
}
