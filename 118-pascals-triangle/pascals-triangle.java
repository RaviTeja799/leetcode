class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows ; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 1 ; j <= i ; j++){
                temp.add(nCr(i-1,j-1));
            }
            ans.add(temp);
        }
        return ans;
    }
    int nCr(int row,int col){
        int res =1;
        for(int i = 0 ; i < col; i++){
            res*=(row-i);
            res/=(i+1);
        }
        return res;
    }
}