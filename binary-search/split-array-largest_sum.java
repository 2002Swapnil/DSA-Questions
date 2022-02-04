class Solution {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int arr:nums){
            max = Math.max(arr,max);
            sum+=arr;
        }
        int lo=max;
        int hi=sum;
        int ans =0;
        while(lo<=hi){
            int mid= lo+(hi-lo)/2;
            if(isPossible(nums,m,mid)){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    
    
    public boolean isPossible(int[] nums, int m,int mid){
        int as =1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                as++;
                sum = nums[i];
            }
        }
        return as<=m;
    }
}