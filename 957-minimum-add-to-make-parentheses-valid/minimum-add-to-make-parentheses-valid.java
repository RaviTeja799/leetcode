class Solution {
    public int minAddToMakeValid(String s) {
        // Stack<Character> stack = new Stack<>();
        int n = s.length();
        int Ocnt = 0,Ccnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                Ocnt++;
            }
            else if (ch == ')'){
                if(Ocnt>0){
                    Ocnt--;
                }
                else{
                    Ccnt++;
                }
            }
        }
        return Ocnt+Ccnt;
    }
}