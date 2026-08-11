// Last updated: 11/08/2026, 20:59:07
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0; // to find the total profit
        int n = prices.length;

        // checking if previous element is less than current,  just add the difference
        for( int i = 1 ; i< n; i++){
            if(prices[i] >  prices[i-1]){
                res += (prices[i] - prices[i-1]);
            }
        }
        return res;
    }

}