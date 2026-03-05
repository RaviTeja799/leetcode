class Solution {
    public String removeStars(String s) {
        Stack <Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c!='*'){
                stk.push(c);
            }
            else{
                stk.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stk.size(); i++){
            sb.append(stk.get(i));
        }

        return sb.toString();
    }
}