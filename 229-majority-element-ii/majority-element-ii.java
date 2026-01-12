class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int val = n/3+1;
        List<Integer> list = new ArrayList<>();
        // HashMap<Integer,Integer> map = new HashMap<>();
        int cnt1 = 0 , cnt2  = 0;
        int eli1 = Integer.MIN_VALUE;
        int eli2 = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(eli2!=nums[i] && cnt1==0){
                cnt1=1;
                eli1=nums[i];
            }
            else if(eli1!=nums[i] && cnt2==0){
                cnt2=1;
                eli2=nums[i];
            }
            else if(nums[i]==eli1){
                cnt1++;
            }
            else if(nums[i]==eli2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0; cnt2 = 0; 
        for (int i = 0; i < n; i++) {
            if (nums[i] == eli1) cnt1++; 
            if (nums[i] == eli2) cnt2++;
        }
        if (cnt1 >= val) list.add(eli1);
        if (cnt2 >= val && eli1 != eli2) list.add(eli2);
        return list;
    }
}