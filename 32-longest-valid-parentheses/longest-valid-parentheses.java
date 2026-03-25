class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == '(')
                stack.push(i);
            else if (ch == ')') {
                if (stack.isEmpty() || sb.charAt(stack.peek()) == ')')
                    stack.push(i);
                else
                    stack.pop();
            }
        }
        int max = 0, n = sb.length();
        while (!stack.isEmpty()) {
            max = Math.max(max, n - stack.peek() - 1);
            n = stack.peek();
            stack.pop();
        }
        return Math.max(max,n);
    }
}