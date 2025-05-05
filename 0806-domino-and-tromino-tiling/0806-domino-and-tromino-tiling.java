class Solution {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        prefix[0] = dp[0];
        prefix[1] = dp[0] + dp[1];
        prefix[2] = prefix[1] + dp[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * prefix[i - 3]) % MOD;
            prefix[i] = (prefix[i - 1] + dp[i]) % MOD;
        }

        return (int) dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution(); // fixed class name
        System.out.println(solution.numTilings(3)); // Output: 5
        System.out.println(solution.numTilings(1)); // Output: 1
    }
}
