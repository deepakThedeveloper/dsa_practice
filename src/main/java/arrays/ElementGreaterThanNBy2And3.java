package arrays;

public class ElementGreaterThanNBy2And3 {
    public static void main(String[] args) {
        //int[] a = {7,7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        int[] a = {1, 1, 1, 3, 3, 2, 2, 2};
        int n = a.length;
        findElementWithCountGNBy3(a, n);
        findElementWithCountGNBy2(a, n);
    }

    private static void findElementWithCountGNBy3(int[] a, int n){
        int ele1 = -1, ele2 = -1, count1 = 0, count2 = 0;
        for(int i=0; i<n; i++){
            if(count1 == 0 && a[i] != ele2){
                ele1 = a[i];
                count1 = 1;
            }
            else if(count2 == 0 && a[i] != ele1) {
                ele2 = a[i];
                count2 = 1;
            }
            else if (a[i] == ele1) count1++;
            else if (a[i] == ele2) count2++;
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0; i<n; i++){
            if(a[i] == ele1) count1++;
            if(a[i] == ele2) count2++;
        }
        ele1 = count1 > (n/3) ? ele1 : -1;
        ele2 = count2 > (n/3) ? ele2 : -1;
        System.out.println("ele1:"+ele1+" ele2:"+ele2);
    }

    private static void findElementWithCountGNBy2(int[] a, int n){
        int element = -1, count = 0;
        for(int i=0; i<n; i++){
            if(count == 0){
                element = a[i];
                count=1;
            }
            else if(a[i] == element) count++;
            else count--;

        }
        count = 0;
        for(int i=0; i<n; i++){
            if(a[i] == element) count++;
        }
        element = count > (n/2) ? element : -1;
        System.out.println("element:"+element);
    }
}
