class Solution {
        public int left(int [] piles, int max , int h){
        int val = max;
        int low = 1, high = max;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(piles,mid) <= h){
                val = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return val;
    }
    public long check(int piles[] , int mid){
        long cnt = 0;
        for(int i = 0; i < piles.length; i++){
            cnt += (piles[i] + mid - 1) / mid;
        }
        return cnt;
    }       
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max,piles[i]);
        }
        return left(piles,max,h);

    }
}