// Last updated: 11/08/2026, 20:54:42
class Solution {
    public int coinChange(int[] coins, int amount) {
        // i = 0 to n-1 | amount = amoount to 0
        long[][] dp = new long[coins.length][amount+1];
        for(long[] row : dp){
            Arrays.fill(row,-1);
        }
        long ans = coinCount(0,coins,amount,dp);
        if(ans >= Integer.MAX_VALUE) return -1;
        return (int)ans;
    }

    private long coinCount(int i, int[] coins, int amount, long[][] dp){
        if(i == coins.length){
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        long skip = coinCount(i+1,coins,amount,dp);
        if(amount - coins[i] < 0) return dp[i][amount] = skip;
        long pick = 1 + coinCount(i,coins,amount - coins[i],dp);
        return dp[i][amount] = Math.min(pick,skip);
    }
}



// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         // Initialize as long[][]
//         long[][] dp = new long[coins.length][amount + 1];
//         for(long[] row : dp){
//             Arrays.fill(row, -1);
//         }
        
//         // Pass dp directly without any casting
//         long ans = coinCount(0, coins, amount, dp);
        
//         if(ans >= Integer.MAX_VALUE) return -1;
//         return (int) ans;
//     }

//     // Update the parameter here to long[][] dp
//     private long coinCount(int i, int[] coins, int amount, long[][] dp){
//         if(i == coins.length){
//             if(amount == 0) return 0;
//             else return Integer.MAX_VALUE;
//         }
        
//         if(dp[i][amount] != -1) return dp[i][amount];
        
//         long skip = coinCount(i + 1, coins, amount, dp);
//         if(amount - coins[i] < 0) {
//             return dp[i][amount] = skip;
//         }
        
//         long pick = 1 + coinCount(i, coins, amount - coins[i], dp);
//         return dp[i][amount] = Math.min(pick, skip);

//             }
// }