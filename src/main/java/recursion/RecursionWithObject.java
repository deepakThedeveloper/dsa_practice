package recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionWithObject {
    public static void main(String[] args) {
        test(new ArrayList<>(),0);
        System.out.println("=====================================");
        test1(new ArrayList<>(),0);
        System.out.println("=====================================");
        test3(0);
    }

    // here new reference is being created in call so, value set in last call will be for only last reference variable and
    // not for previous two
    private static void test1(ArrayList<Integer> list, int n) {
        if(n==3){
            list.add(23);
        }
        else{
            ArrayList<Integer> integerList = new ArrayList<>();
            test1(integerList, n+1);
            System.out.println("call:"+n+" "+integerList);
        }
    }

    // here same reference variable is used in every call. for one reference variable a object is created, so value set in any
    // call will show value in all previous calls.
    private static void test(ArrayList<Object> list, int n) {
        if(n==3){
            list.add(23);
        }
        else{
            test(list, n+1);
            System.out.println("call:"+n+" "+(list));
        }
    }

    // here same output as test but with return value and no list. this helps us understand that if from any next recursive call
    // you need to get value then there are two ways. either use an object and set value in object in next/last recursive call
    // and keep same reference. or if don't want to go with object then return value.
    // object approach helps in cases when from a recursive calls two or more values are needed. eg. height of tree at every level
    // and every node value. in that case one object can be used for setting height and values of node can be returned in calls.
    private static int test3(int n) {
        if(n==3){
            return 23;
        }
        else{
            int val = test3(n+1);
            System.out.println("call:"+n+" "+val);
            return val;
        }
    }
}
