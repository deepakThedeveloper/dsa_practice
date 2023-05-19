package java8;

public class Test {
    public static void main(String[] args) {
       // int i=5;
        Integer i1 = new Integer(7);
        Integer i2 = 8;
        System.out.println(i2);
        test1(i2);
        System.out.println(i2);

    }

    private static void test1(Integer i) {
        System.out.println("before:"+i);
        i++;
        System.out.println("after:"+i);

    }
}
