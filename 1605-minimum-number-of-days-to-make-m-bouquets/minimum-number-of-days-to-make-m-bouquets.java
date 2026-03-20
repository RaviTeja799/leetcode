class Solution {
    public boolean check(int[] bloomDay, int m, int k, int day) {
        int flowers = 0,boquet = 0;
        for(int cnt : bloomDay){
            if(cnt<=day){
                flowers++;
                if(flowers == k){
                    boquet++;
                    flowers = 0;
                }
            }
            else{
                flowers = 0;
            }
        }
        return boquet>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n<m*k) return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            low = Math.min(low,bloomDay[i]);
            high = Math.max(high,bloomDay[i]);
        }
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(check(bloomDay,m,k,mid)){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}