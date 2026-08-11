// Last updated: 11/08/2026, 14:16:03
import java.util.Arrays;

class Solution {
    public long maxScore(int[] a, int[] b) {
        long[] dp = new long[4];
        Arrays.fill(dp, (long) -1e15);
        for (int val : b) {
            dp[3] = Math.max(dp[3], dp[2] + (long) a[3] * val);
            dp[2] = Math.max(dp[2], dp[1] + (long) a[2] * val);
            dp[1] = Math.max(dp[1], dp[0] + (long) a[1] * val);
            dp[0] = Math.max(dp[0], (long) a[0] * val);
        }
        return dp[3];
    }
}