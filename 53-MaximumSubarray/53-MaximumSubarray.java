// Last updated: 11/08/2026, 21:00:57
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // max_so_far: overall maximum sum
        int max_so_far = nums[0];
        
        // max_ending_here: max sum of subarray ending at current position
        int max_ending_here = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Core decision: start new or extend previous
            max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);

            // Update overall maximum
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }
}