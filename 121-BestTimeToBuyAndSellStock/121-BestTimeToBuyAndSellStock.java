// Last updated: 11/08/2026, 20:59:11
class Solution {
    public int maxProfit(int[] prices) {
            int maxprofit = 0;
            int buy = prices[0];
            for(int i=1;i<prices.length;i++){
                if(prices[i]<buy){
                    buy = prices[i];
                }else if(prices[i]-buy > maxprofit){
                    maxprofit = prices[i]-buy;
                }
            }
            return maxprofit;
    }
}
