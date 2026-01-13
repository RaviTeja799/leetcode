class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        // ArrayList<Integer> lis = new ArrayList<>(Arrays.asList(nums));
        int n = nums.length;
        for(int i = 0 ; i < n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i+1 ; j < n; j++){
                int val = -(nums[i]+nums[j]);
                    if (set.contains(val)){
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(val);
                        Collections.sort(li);
                        list.add(li);       
                    }
                    set.add(nums[j]);
            }
        }
        return new ArrayList<>(list);
    }
}