class Solution {
    int binarySearch(int piles[], int h,int max){
        int low = 1,high = max , ans = max;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(check(piles,mid)<=(long)h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public long check(int[] piles, int mid) {
        int n = piles.length;
        long count = 0;
        for(int i = 0; i < n; i++){
            count+= (piles[i]+mid-1)/mid;
        }
        return count;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];
        for(int i = 0; i < n; i++){
            max = Math.max(piles[i],max);
        }
        return binarySearch(piles,h,max);
    }
}