// Last updated: 11/08/2026, 20:55:57
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        // Start from Top-Right Corner
        int row = 0;
        int col = matrix[0].length - 1;

        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == target) {
                return true;
            } 
            // If current element is greater than target, 
            // the target cannot be in this column (move left)
            else if (matrix[row][col] > target) {
                col--;
            } 
            // If current element is smaller than target, 
            // the target cannot be in this row (move down)
            else {
                row++;
            }
        }
        return false;
    }
}