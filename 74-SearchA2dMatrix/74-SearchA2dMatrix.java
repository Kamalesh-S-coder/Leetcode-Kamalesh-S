// Last updated: 11/08/2026, 21:00:15
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int l = 0;
        int h = r * c - 1;

        while (l <= h) {
            int m = (l + h) / 2;

            int row = m / c;
            int col = m % c;

            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] > target) {
                h = m - 1;
            }
            else {
                l = m + 1;
            }
        }

        return false;
    }
}
