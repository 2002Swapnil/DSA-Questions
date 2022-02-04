class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int r = binarySearchForRow(arr,target);
        if(r==-1){
            return false;
        }
        
        int lo = 0;
        int hi= arr[0].length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(arr[r][mid]==target){
                return true;
            }
            else if(arr[r][mid]>target){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return false;
    }
    
    
    
     public int binarySearchForRow(int[][] arr, int target) {
        int lo = 0;
        int hi = arr.length-1;
         while(lo<=hi){
             int mid = (lo+hi)/2;
             if(arr[mid][0]<=target && arr[mid][arr[0].length-1]>=target){
                 return mid;
             }
             else if(arr[mid][0]>target){
                 hi= mid-1;
             }
             else if(arr[mid][0]<target){
                 lo = mid+1;
             }
         }
         return -1;
    }
}