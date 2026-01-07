class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        Arrays.sort(nums);
        int maxLen = 1;
        int len = 0;
        int lastSmaller = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]-lastSmaller == 1){
                len++;
                lastSmaller = nums[i];
            }
            else if (lastSmaller != nums[i]){
                len = 1;
                lastSmaller = nums[i];
            }
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }
}