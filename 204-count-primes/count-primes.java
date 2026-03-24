class Solution {
    // boolean isPrime(int n){
    //     if(n == 2 || n == 3) return true;
    //     if(n%2 == 0 || n %3 == 0) return false;
    //     for(int i = 5; i * i <= n; i++){
    //         if(n%i == 0 || n%(i+2)==0) return false;
    //     }
    //     return true;
    // }
    public int countPrimes(int n) {
        if (n <= 1)
            return 0;

        boolean[] Prime = new boolean[n];
        Arrays.fill(Prime,true);
        Prime[0] = false;
        Prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (Prime[i]) {
                for (int j = 2*i; j < n; j+=i) {
                    Prime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < Prime.length; i++) {
            if (Prime[i])
                count++;
        }
        return count;
    }
}