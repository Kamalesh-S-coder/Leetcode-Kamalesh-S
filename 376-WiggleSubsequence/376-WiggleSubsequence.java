// Last updated: 11/08/2026, 20:53:45
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }

        // Tracks the direction of the previous difference
        // 0 means no direction set yet, positive (>0) means up, negative (<0) means down
        int prevDiff = 0;
        int count = 1; // A single element is trivially a wiggle sequence of length 1

        for (int i = 1; i < nums.length; i++) {
            int currDiff = nums[i] - nums[i - 1];

            // If we found a turning point or the initial direction change
            if ((currDiff > 0 && prevDiff <= 0) || (currDiff < 0 && prevDiff >= 0)) {
                count++;
                prevDiff = currDiff; // Only update prevDiff when a valid direction change occurs
            }
        }

        return count;
    }
}