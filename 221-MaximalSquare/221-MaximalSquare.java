// Last updated: 11/08/2026, 20:56:13
class Solution {
    public int maximalSquare(char[][] mat) {
        int ans=0;
        int dp[][]=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            if(mat[i][0]=='1'){
                dp[i][0]=1;
                ans=1;
            }
        }
        for(int i=0;i<mat[0].length;i++){
            if(mat[0][i]=='1'){
                dp[0][i]=1;
                ans=1;
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(mat[i][j]=='1'){
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    ans=Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
}