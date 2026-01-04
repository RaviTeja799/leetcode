class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;

        for (int n : nums) {
            int count = 2;        // 1 and n
            int sum = 1 + n;

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    if (i == n / i) {
                        count++;
                        sum += i;
                    } else {
                        count += 2;
                        sum += i + (n / i);
                    }
                }
                if (count > 4) break;
            }

            if (count == 4) ans += sum;
        }
        return ans;
    }
}
