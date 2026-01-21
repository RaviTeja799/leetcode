class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int arr[] = new int[n];
        for(int i = 0 ; i <  n ; i++){
            int val = nums.get(i);
            if ((val & 1) == 1)
                arr[i] = val & ~(((val + 1) & ~val) >> 1);
            else
                arr[i] = -1;
        }
        return arr;
        }
}