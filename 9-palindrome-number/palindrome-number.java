class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int val = 0,i = 0;
        while(temp > 0){
            int rem = temp % 10;
            val = val*10+rem;
            temp/=10;
            i++;
        }
        return x == val;
    }
}