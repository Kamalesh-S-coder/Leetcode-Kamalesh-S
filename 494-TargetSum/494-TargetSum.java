// Last updated: 11/09/2026, 09:33:04
class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Impossible cases
        if (Math.abs(target) > total) {
            return 0;
        }

        if ((total + target) % 2 != 0) {
            return 0;
        }

        int required = (total + target) / 2;

        int[] dp = new int[required + 1];

        // There is 1 way to make sum 0
        dp[0] = 1;

        for (int num : nums) {

            // Go backwards to avoid using same number twice
            for (int sum = required; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }

        return dp[required];
    }
}