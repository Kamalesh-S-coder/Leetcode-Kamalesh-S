// Last updated: 11/08/2026, 20:58:57
class Solution {
    public void solve(char[][] board) {
        int r=board.length;
        int c=board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if((j==0||i==0||i==r-1||j==c-1)&&board[i][j]=='O') 
                    dfs(board,i,j);
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='O') board[i][j]='X';  
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='#') board[i][j]='O';  
            }
        }
    }
    public void dfs(char[][] board,int i,int j){

        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='X'|| board[i][j] == '#')   
            return;
        board[i][j]='#';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);

    }
}