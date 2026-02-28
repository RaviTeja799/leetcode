class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int MOD = 1000000007;

        for (int i = 1; i <= n; i++) {
            int bits = Integer.toBinaryString(i).length();
            ans = ((ans << bits) + i) % MOD;
        }

        return (int) ans;
    }
}