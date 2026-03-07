class Solution {
    public int left(int [] weights, int left, int right,int days){
        int val = right;
        int low = left, high = right;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(weights,mid) <= days){
                val = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return val;
    }
    public long check(int weights[], int mid){
        int temp = mid;
        long cnt = 1;
        for(int i = 0; i < weights.length; i++){
            if(mid<weights[i]) {
                mid = temp;
                cnt++;
            }
            mid-=weights[i];
        }
        return cnt;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = weights[0];
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            left = Math.max(weights[i] , left);
            sum+=weights[i];
        }
        return left(weights, left,sum,days);
    }
}