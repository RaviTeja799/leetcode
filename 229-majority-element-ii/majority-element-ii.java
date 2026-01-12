class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int val = n/3;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }
        for(int i = 0 ; i < n ; i++){
            if(map.get(nums[i])>val && !list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        return list;
    }
}