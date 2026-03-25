class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stk.push(i);
            }
            else if(ch == ')'){
                if(stk.isEmpty() || s.charAt(stk.peek()) == ')') stk.push(i);
                else if(s.charAt(stk.peek()) == '(') stk.pop();
            }

        }
        while(!stk.isEmpty()){
            sb.deleteCharAt(stk.pop());
        }
        return sb.toString();
    }
}