class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int lowr = 0, highr = m - 1;

        // Find the possible row
        while (lowr <= highr) {
            int midr = lowr + (highr - lowr) / 2;

            if (target < matrix[midr][0]) {
                highr = midr - 1;
            } 
            else if (target > matrix[midr][n - 1]) {
                lowr = midr + 1;
            } 
            else {
                // target must be in this row
                int lowc = 0, highc = n - 1;

                while (lowc <= highc) {
                    int midc = lowc + (highc - lowc) / 2;

                    if (matrix[midr][midc] == target) return true;
                    else if (matrix[midr][midc] < target) lowc = midc + 1;
                    else highc = midc - 1;
                }
                return false;
            }
        }

        return false;
    }
}