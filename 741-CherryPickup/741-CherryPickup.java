// Last updated: 11/09/2026, 09:29:38
class Solution {
    public int cherryPickup(int[][] grid) {
        int dp[][][] = new int[grid.length][grid[0].length][grid.length];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j,-1);
            }
        }
        return Math.max(0,helper(0,0,0,grid,dp));
    }

    public int helper(int r1,int c1,int r2, int grid[][], int dp[][][]){
        int c2 = r1+c1-r2;
        if(r1>=grid.length || r2>=grid.length || c1>=grid[0].length || c2>=grid[0].length || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return Integer.MIN_VALUE/2;
        }
        if(dp[r1][c1][r2]!=-1){
            return dp[r1][c1][r2];
        }

        if(r1==grid.length-1 && c1==grid[0].length-1){
            return grid[r1][c1];
        }
        int cherry = 0;
        if(r1==r2 && c1==c2){
            cherry = grid[r1][c1];
        }
        else{
            cherry = grid[r1][c1]+grid[r2][c2];
        }

        int opt1 = helper(r1+1,c1,r2+1,grid,dp);//down-down
        int opt2 = helper(r1+1,c1,r2,grid,dp);//down-right
        int opt3 = helper(r1,c1+1,r2+1,grid,dp);//right-down
        int opt4 = helper(r1,c1+1,r2,grid,dp);//right-right

        return dp[r1][c1][r2]=cherry+Math.max(opt1,Math.max(opt2,Math.max(opt3,opt4)));
    }
}