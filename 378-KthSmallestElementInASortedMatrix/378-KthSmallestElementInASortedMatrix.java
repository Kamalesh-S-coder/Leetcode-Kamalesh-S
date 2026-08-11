// Last updated: 11/08/2026, 20:53:37
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix.length * matrix.length];
        int a = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                arr[a] = matrix[i][j];
                a++;
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
