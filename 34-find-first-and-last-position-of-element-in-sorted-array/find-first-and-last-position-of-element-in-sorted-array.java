class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int ans[] = new int[2];
        ans[0]=-1;
        ans[1]=-1;
        int l = 0,h = n-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m]==target){
                ans[0]=m;
                h=m-1;
            }
            else if(nums[m]>target){
                h = m-1;
            }
            else{
                l = m + 1;
            }
        }
        l = 0;
        h = n-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m]==target){
                ans[1]=m;
                l=m+1;
            }
            else if(nums[m]>target){
                h = m-1;
            }
            else{
                l = m + 1;
            }
        }
        return ans;
    }
}