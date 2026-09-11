// Last updated: 11/09/2026, 09:31:08
class Solution {
    public int maxCount(int m, int n, int[][] ops) {

        // Initially, the whole matrix is the overlapping region
        int a = m;
        int b = n;

        // Find the smallest row and column boundaries
        for (int[] ar : ops) {
            a = Math.min(a, ar[0]);
            b = Math.min(b, ar[1]);
        }

        // Cells inside the common intersection have the maximum value
        return a * b;
    }
}