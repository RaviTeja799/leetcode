class Solution {
    public int check(int nums[] , int mid){
        int sum = 0;
        int cnt = 1;
        for(int num: nums){
            if(sum + num > mid){
                cnt+=1;
                sum = 0;
            }
            sum+=num;
        }
        return cnt;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        
        int low = weights[0] , high = 0;
        for(int num : weights) {
            high += num;
            low = Math.max(low,num);
        }
        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;
            System.out.println(low + " " + high + " " + mid + " " + check(weights,mid));
            if(check(weights,mid)<=days){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}