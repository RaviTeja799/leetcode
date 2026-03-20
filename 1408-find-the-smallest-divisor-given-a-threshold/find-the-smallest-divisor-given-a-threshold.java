class Solution {
    public int check(int nums[] , int mid){
        int sum = 0;
        for(int num: nums){
            sum+=(num+mid-1)/mid;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = nums[0];
        for(int num : nums) max = Math.max(num,max);
        int low = 1,high = max,ans = max;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(nums,mid)<=threshold){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}