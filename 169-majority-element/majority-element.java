class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }
        int val = nums[0];
        int freq = map.get(val);
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) > freq){
                freq = map.get(nums[i]);
                val = nums[i];
            }
        }
        return val;
    }
}