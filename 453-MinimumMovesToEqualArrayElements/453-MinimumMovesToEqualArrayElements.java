// Last updated: 11/08/2026, 14:20:54
class Solution {
    public int minMoves(int[] nums) {
        int minNum= nums[0];
        for(int num : nums){
            minNum = Math.min(minNum , num);
        }

        int minimumMoves = 0;
        for(int num : nums){
            minimumMoves += (num - minNum);
        }
        return minimumMoves;
    }
}