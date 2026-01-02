class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == (nums.length / 2)) {
                ans = nums[i];
            }
        }
        return ans;
    }
}