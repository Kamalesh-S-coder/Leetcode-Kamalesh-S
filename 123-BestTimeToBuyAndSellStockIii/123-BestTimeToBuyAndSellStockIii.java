// Last updated: 11/08/2026, 20:59:02
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];

        for(int i =0; i< n; i++){
             for(int j =0; j< 2; j++){
                Arrays.fill(dp[i][j],-1);
             }
        } 
        
        return help(prices,0,2,0,dp);
        }
        public int help(int pric[],int idx, int count,int turn, int dp[][][]){
            if(idx >= pric.length || count ==0) return 0;
            if(dp[idx][turn][count] !=- 1) return dp[idx][turn][count];
            int now =0;

            if(turn ==0){
 now = Math.max(help(pric,idx+1,count,1,dp) - pric[idx],help(pric,idx+1,count,0,dp));

            }
            else{
           now =     Math.max(help(pric,idx+1,count - 1,0,dp) + pric[idx],help(pric,idx+1,count,1,dp));

            }

            return dp[idx][turn][count] = now;
        }


}