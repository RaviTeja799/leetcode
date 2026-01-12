class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            int res = 1;
            temp.add(1);
            for (int j = 1; j < i; j++) {
                res *= (i - j);
                res /= (j);
                temp.add(res);
            }
            ans.add(temp);
        }
        return ans;
    }
    // int nCr(int row,int col){
    //     int res =1;
    //     for(int i = 0 ; i < col; i++){
    //         res*=(row-i);
    //         res/=(i+1);
    //     }
    //     return res;
    // }
}