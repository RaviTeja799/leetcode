class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stk = new Stack<>();
        int nse[] = new int[n]; 
        int pse[] = new int[n]; 
        Arrays.fill(pse,-1);
        for(int i = 0; i<n; i++){
            while(!stk.isEmpty() && (heights[stk.peek()] >= heights[i])) stk.pop();
            if(!stk.isEmpty()) pse[i] = stk.peek();
            stk.push(i);
        }
        Arrays.fill(nse,n);
        stk.clear();
        for(int i = n-1; i>=0; i--){
            while(!stk.isEmpty() && (heights[stk.peek()] >= heights[i])) stk.pop();
            if(!stk.isEmpty()) nse[i] = stk.peek();
            stk.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < n; i++){
            int area = heights[i]*(nse[i]-pse[i]-1);
            max = Math.max(max,area);
        }
        return max;
    }
}