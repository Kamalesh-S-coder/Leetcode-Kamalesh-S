// Last updated: 11/08/2026, 21:00:37
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (grid[0][0] == 1) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        // first row
        for (int j = 1; j < n; j++) {
            if (grid[0][j] == 1) dp[0][j] = 0;
            else dp[0][j] = dp[0][j - 1];
        }

        // first column
        for (int i = 1; i < m; i++) {
            if (grid[i][0] == 1) dp[i][0] = 0;
            else dp[i][0] = dp[i - 1][0];
        }

        // fill rest
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}