class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else if (ch == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else{
                    cnt++;
                }
            }
        }
        // if(stack.isEmpty()) return 0;
        return stack.size()+cnt;
    }
}