// Last updated: 11/08/2026, 20:54:58
// ✅ Approach 4 — Space Optimization (Best)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] next = new int[3];

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[3];
            curr[1] = Math.max(-prices[i] + next[0], next[1]);  // buy or skip
            curr[0] = Math.max(prices[i] + next[2], next[0]);   // sell (cooldown) or skip
            curr[2] = next[1];                                   // forced skip → free

            next = curr;
        }
        return next[1];
    }
}

/*
// 🟢 Approach 3 — Tabulation (Bottom-Up DP)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][3];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);  // buy or skip
            dp[i][0] = Math.max(prices[i] + dp[i + 1][2], dp[i + 1][0]);   // sell (cooldown) or skip
            dp[i][2] = dp[i + 1][1];                                        // forced skip → free
        }

        return dp[0][1];
    }
}
*/

/*
// 🟡 Approach 2 — Memoization (Top-Down DP)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return findMax(dp, prices, 0, 1);
    }

    private int findMax(int[][] dp, int[] prices, int i, int canBuy) {
        if (i == prices.length) return 0;

        if (dp[i][canBuy] != -1) return dp[i][canBuy];

        if (canBuy == 1) {
            return dp[i][canBuy] = Math.max(
                -prices[i] + findMax(dp, prices, i + 1, 0),  // buy
                findMax(dp, prices, i + 1, 1)                 // skip
            );
        } else if (canBuy == 0) {
            return dp[i][canBuy] = Math.max(
                prices[i] + findMax(dp, prices, i + 1, 2),   // sell → cooldown
                findMax(dp, prices, i + 1, 0)                 // skip
            );
        } else {
            return dp[i][canBuy] = findMax(dp, prices, i + 1, 1); // forced skip → free
        }
    }
}
*/

/*
// 🔴 Approach 1 — Pure Recursion (TLE @ testcase 208)
class Solution {
    public int maxProfit(int[] prices) {
        return findMax(prices, 0, 1);
    }

    private int findMax(int[] prices, int i, int canBuy) {
        if (i == prices.length) return 0;

        if (canBuy == 1) {
            return Math.max(
                -prices[i] + findMax(prices, i + 1, 0),  // buy
                findMax(prices, i + 1, 1)                  // skip
            );
        } else if (canBuy == 0) {
            return Math.max(
                prices[i] + findMax(prices, i + 1, 2),   // sell → cooldown
                findMax(prices, i + 1, 0)                  // skip
            );
        } else {
            return findMax(prices, i + 1, 1);              // forced skip → free
        }
    }
}
*/