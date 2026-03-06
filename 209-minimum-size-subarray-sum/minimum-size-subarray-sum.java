class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0,j = 0,n = nums.length;
        int sum = 0;
        int mini = Integer.MAX_VALUE;
        while(j<n){
            sum+=nums[j];
            while(sum>=target){
                mini = Math.min(j-i+1,mini);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return mini==Integer.MAX_VALUE?0:mini;
    }
}