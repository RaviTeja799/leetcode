class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.add(nums[i]);
        }
        return map.size()!=nums.length;
    }
}