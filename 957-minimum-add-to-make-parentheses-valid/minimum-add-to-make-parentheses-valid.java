class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int cnt = 0;
        for(char ch : s.toCharArray()){
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
        return stack.size()+cnt;
    }
}