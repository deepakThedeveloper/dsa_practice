package arrays;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement element = new NextGreaterElement();
        int[] nums = {1,2,3,4,5,4,3,2,1,3,4,5,1,3};
        int[] elements = new int[nums.length];
        Arrays.fill(elements, -1);
        element.nextBiggerElement(nums, elements);
        Arrays.stream(nums).forEach(v-> System.out.print(v+"  "));
        System.out.println();
        Arrays.stream(elements).forEach(v-> System.out.print(v+"  "));
    }
    public void nextBiggerElement(int[] nums, int[] elements){
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        for(int i=length-1; i>=0; i--){
            if(!stack.isEmpty() && nums[i]<stack.peek()) elements[i] = stack.peek();
            else{
                while(!stack.isEmpty()){
                    if(nums[i]>=stack.peek()) stack.pop();
                    else {
                        elements[i] = stack.peek();
                        break;
                    }
                }

            }
            stack.push(nums[i]);
        }
    }
}
