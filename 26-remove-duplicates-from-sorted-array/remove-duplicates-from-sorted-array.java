class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int i = 0, j = i + 1;
        while (j < n) {
            if (nums[i] == nums[j]) {
            } else {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
        return i + 1;
    }
}