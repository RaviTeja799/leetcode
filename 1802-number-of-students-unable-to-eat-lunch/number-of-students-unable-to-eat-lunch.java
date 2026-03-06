class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stk = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < students.length; i++){
            q.add(students[i]);
        }
        for(int i = sandwiches.length-1; i >=0; i--){
            stk.add(sandwiches[i]);
        }
        int cnt = 0;
        while(cnt != q.size()){
            if(stk.peek() == q.peek()){
                stk.pop();
                q.remove();
                cnt = 0;
            }
            else{
                q.add(q.remove());
                cnt+=1;
            }
        }
        return cnt;
    }
}