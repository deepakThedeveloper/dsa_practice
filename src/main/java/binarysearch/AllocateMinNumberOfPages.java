package binarysearch;

public class AllocateMinNumberOfPages {
    public static void main(String[] args) {
        int[] pages = {10, 20, 30, 40};
        int k = 2;
        int minPages = minPages(pages, k);
        System.out.println(minPages);
    }

    private static int minPages(int[] pages, int k){
        if(pages.length < k || k == 0) return -1; // every student should have atleast one book. if k = 5 and arr.length = 4 books then it can't be allocated
        int totalPages = 0, maxPage = Integer.MIN_VALUE;
        for(int i=0; i<pages.length; i++){
            totalPages += pages[i];
            maxPage = Math.max(maxPage, pages[i]);
        }
        if(k == 1) return totalPages;
        int low = maxPage, high = totalPages;
        int result = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(isMaximumRangeSuited(pages, mid, k)){
                result = mid;
                high = mid-1;
            }
            else low = mid + 1;
        }

        return result;
    }

    private static boolean isMaximumRangeSuited(int[] arr, int max, int k){

        int sum, j = 0;
        for(int i=0; i<k; i++){
            sum = 0;
            for(; j<arr.length; j++){
                sum += arr[j];
                if(sum > max) break;
            }
        }
        return j >= arr.length;
    }
}
