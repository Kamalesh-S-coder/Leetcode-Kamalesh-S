// Last updated: 11/08/2026, 14:21:24
class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    ans++;
                    if (i == 0 && j == 0)
                        continue;
                    else if (i == 0 && board[i][j - 1] == 'X')
                        ans--;
                    else if (j == 0 && board[i - 1][j] == 'X')
                        ans--;
                    else if (i == 0 || j == 0)
                        continue;
                    else if (board[i - 1][j] == 'X' || board[i][j - 1] == 'X')
                        ans--;
                }
            }
        }
        return ans;
    }
}