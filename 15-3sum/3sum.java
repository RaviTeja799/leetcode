class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i < n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int val = nums[i]+nums[left]+nums[right];
                    if (val==0){
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[left]);
                        li.add(nums[right]);
                        Collections.sort(li);
                        ans.add(li);  
                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1]) left++;     
                        while(left<right && nums[right]==nums[right+1]) right--;     
                    }
                    else if(val<0) left++;
                    else right--;
            }
        }
        return ans;
    }
}