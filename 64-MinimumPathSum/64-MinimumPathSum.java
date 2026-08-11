// Last updated: 11/08/2026, 21:00:35
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] cur = new int[m];
        cur[0] = grid[0][0];

        // Initialize the first column
        for (int i = 1; i < m; i++)
            cur[i] = cur[i - 1] + grid[i][0];

        // Process each column
        for (int j = 1; j < n; j++) {
            // Update topmost cell in current column
            cur[0] += grid[0][j];
            // Update the rest of the column
            for (int i = 1; i < m; i++)
                cur[i] = Math.min(cur[i - 1], cur[i]) + grid[i][j];
        }

        return cur[m - 1];
    }
}