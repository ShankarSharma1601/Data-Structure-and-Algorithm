// Count Inversion
// Time Complexity : O(nlogn)
// Space Complexity : O(n)


class Solution{
    static long inversionCount(long arr[], long N){
        long temp[] = new long[(int)N];
        return mergeSort(arr, temp , 0 , N-1);
    }
    private static long mergeSort(long arr[] , long temp[] , long left , long right){
        long count = 0;
        if(left < right){
            long mid = left + ( right - left )/ 2;
            count += mergeSort(arr , temp , left , mid);
            count += mergeSort(arr , temp , mid + 1 , right);
            count += merge(arr , temp , left , mid + 1 , right);
        }
        return count;
    }
    private static long merge(long arr[] , long temp[] , long left , long mid , long right){
        long i = left , j = mid , k = left;
        long count = 0;
        
        while((i <= mid - 1) && (j <= right)){
            if(arr[(int)i] <= arr[(int)j]){
                temp[(int)k++] = arr[(int)i++];
            }
            else{
                temp[(int)k++] = arr[(int)j++];
                count += (mid - i);
            }
        }
        
        while(i <= mid - 1 ){
            temp[(int)k++] = arr[(int)i++];
        }
        
        while(j <= right){
            temp[(int)k++] = arr[(int)j++];
        }
        
        for(i = left ; i <= right; i++){
            arr[(int)i] = temp[(int)i];
        }
        
        return count;
    }
}