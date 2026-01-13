class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long val = (long) target - sum;
                    if (hashset.contains(val)) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], (int) val);
                        Collections.sort(list);
                        if (!ans.contains(list))
                            ans.add(list);
                    }
                    hashset.add((long) nums[k]);

                }
            }
        }
        return ans;
    }
}