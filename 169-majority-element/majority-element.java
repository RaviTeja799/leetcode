class Solution {
    public int majorityElement(int[] nums) {
        // HashMap
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i = 0; i < nums.length; i++){
        //     map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        // }
        // int val = nums[0];
        // int freq = map.get(val);
        // for(int i = 0; i < nums.length; i++){
        //     if(map.get(nums[i]) > nums.length/2){
        //         val = nums[i];
        //     }
        // }

        // Sorting
        // Arrays.sort(nums);
        // int val = nums[nums.length/2];
        // return val;

        // Boyer Moore 
        int ele = nums[0],cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(cnt<=0){
                cnt++;
                ele = nums[i];
            }
            else if (nums[i]==ele) cnt++;
            else cnt--;
        }
        for(int i = 0; i < nums.length; i++){
            if (nums[i]==ele) cnt++;
        }
        return ele;
    }
}