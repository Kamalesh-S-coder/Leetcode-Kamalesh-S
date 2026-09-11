// Last updated: 11/09/2026, 09:32:02
/**
 * Space Optimized Dynamic Programming
 *
 * The first iteration is from top left corner to bottom right. In this
 * iteration we are checking Top and Left neighbors as they have been already
 * solved.
 *
 * The second iteration is from bottom right corner to top left corner. In this
 * iteration we are checking Bottom and Right neighbors and also compare them
 * with the result of the current cell from the previous iteration.
 *
 * Time Complexity: O(2 * M * N)
 *
 * Space Complexity: O(1) - Excluding the result space.
 *
 * M = Number of rows. N = Number of columns.
 */
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return mat;
        }

        int rows = mat.length;
        int cols = mat[0].length;
        if (rows == 1 && cols == 1) {
            return mat;
        }

        int[][] result = new int[rows][cols];
        // (rows + cols - 1) is the maximum possible distance in the matrix. Its the
        // distance been two diagonally opposite corners.
        int maxDistance = rows + cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                result[i][j] = maxDistance;
                if (i > 0) {
                    result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                }
                if (j > 0) {
                    result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    continue;
                }
                if (i < rows - 1) {
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                }
                if (j < cols - 1) {
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                }
            }
        }

        return result;
    }
}