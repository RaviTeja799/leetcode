class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            int temp = i;
            int numberOfOnes = 0;
            while(temp > 0){
                if((temp & 1) == 1) {
                    numberOfOnes+=1;
                }
                temp = temp >> 1;
            }
            if(isPrime(numberOfOnes)){
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isPrime(int n) {
        if(n == 0 || n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}