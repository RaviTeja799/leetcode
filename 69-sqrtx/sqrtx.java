class Solution {
    public int mySqrt(int x) {
        int low = 1, high = (x/2)+1, res = 0;
        while(low<=high){
            int mid = low + (high - low)/2;
            if((long)mid*mid==x) return mid;
            else if((long)mid*mid > x) high = mid - 1;
            else {
                low = mid + 1;
                res = mid;
            }
        }
        return res;
    }
}