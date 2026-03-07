class Solution {
    public int left(int [] nums, int target){
        int val = -1;
        int low = 0, high = nums.length -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                val = mid;
                high = mid - 1;
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return val;
    }
    public int right(int [] nums, int target){
        int val = -1;
        int low = 0, high = nums.length -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                val = mid;
                low = mid + 1;
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return val;
    }
    public int[] searchRange(int[] nums, int target) {
        int [] ans = new int[2];
        ans[0] = left(nums,target);
        ans[1] = right(nums,target);
        return ans;
    }
}