class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int nge[] = new int[n];
        Arrays.fill(nge,-1);
        for(int i = n-1; i >=0 ; i--){
            while(!stk.isEmpty() && nums[i] >= stk.peek()){
                stk.pop();
            }
            if(!stk.isEmpty()) {
                nge[i]=stk.peek();
            }
            stk.push(nums[i]);
        }
        for(int i = n-1; i >=0 ; i--){
            while(!stk.isEmpty() && nums[i] >= stk.peek()){
                stk.pop();
            }
            if(!stk.isEmpty()) {
                nge[i]=stk.peek();
            }
            stk.push(nums[i]);
        }
        return nge;
    }
}