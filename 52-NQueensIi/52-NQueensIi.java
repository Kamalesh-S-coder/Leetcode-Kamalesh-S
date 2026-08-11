// Last updated: 11/08/2026, 21:01:01
class Solution {
    String[][] board;
    int c =0;
    
    boolean isValid(int row,int col,int n){
        // upper 
        for(int i = row-1;i>=0;i--)
            if (board[i][col].equals("Q"))
                return false;
        
        // left diagonal 
        for(int i=row-1, j = col-1; i>=0 && j>=0 ; i--,j--)
            if(board[i][j].equals("Q"))
                return false;
        
        // right diagonal
        for(int i=row-1, j = col+1; i>=0 && j<n ; i--,j++)
            if(board[i][j].equals("Q"))
                return false;
                
        return true;
    }
    void back(int row, int n){
        if(row==n){
            c++;
            return;
        }
        for(int col = 0;col < n;col++){
            if(isValid(row,col,n)){ 
                board[row][col] = "Q";
                back(row+1,n);
                board[row][col] = ".";
            }
        }
    }
    public int totalNQueens(int n) {
        board = new String[n][n];
        for(String[] row : board)
            Arrays.fill(row,".");
            
        back(0,n);
        return c;
    }
}