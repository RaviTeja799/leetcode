class Solution {
    public String minRemoveToMakeValid(String s) {
        // Stack<Integer> stk = new Stack<>();
        int open = 0,close = 0;
        StringBuffer sb = new StringBuffer(s);
        for(int i = 0; i < sb.length(); i++){
            char ch = sb.charAt(i);

            if(ch == '('){
                open++;
            }
            else if(ch == ')'){
                if(open > 0) open--;
                else {sb.deleteCharAt(i);i--;}
            }
        }
        for(int i = sb.length()-1;open >0; i--){
            if(sb.charAt(i)=='(') {
                sb.deleteCharAt(i);
                open--;
            }
        }
        return sb.toString();
    }
}