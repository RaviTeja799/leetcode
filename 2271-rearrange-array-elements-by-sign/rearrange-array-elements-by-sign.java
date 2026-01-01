class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(nums[i]>0){
                positives.add(nums[i]);
            }
            else{
                negatives.add(nums[i]);
            }
        }
        int j = 0,p = 0,i = 0;
        while(j<n && i <n/2 && j < n/2){
        ans[p]=positives.get(i++);
        p++;
        ans[p]=negatives.get(j++);
        p++;
        }
        return ans;
    }
}