class Solution {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 1;i<=numRows;i++){
            result.add(row(i));
        }

        return result;
       
    }

    public List<Integer> row(int row) {

        List<Integer> temp = new ArrayList<>();

        int ans = 1;
        temp.add(1);

        for(int col = 1;col<row;col++){
            ans = ans * (row - col);
            ans /= col;
            temp.add(ans);
        }

        return temp;
       
    }

}