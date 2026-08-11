// Last updated: 11/08/2026, 20:56:42
class Solution {
    public int robHouse(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        if(n==1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        int n  = nums.length;
        if(n<2) return nums[0];
        int [] FirstHouse_Skip = new int[n-1];
        int [] LastHouse_Skip = new int[n-1];

        for(int i=0;i<n-1;i++){
            FirstHouse_Skip[i] = nums[i];
            LastHouse_Skip[i] = nums[i+1];
        }

        int firstLoot = robHouse(FirstHouse_Skip);

        int LastLoot = robHouse(LastHouse_Skip);

        return Math.max(firstLoot,LastLoot);

    }
}