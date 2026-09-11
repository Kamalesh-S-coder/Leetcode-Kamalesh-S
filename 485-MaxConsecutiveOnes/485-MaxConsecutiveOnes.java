// Last updated: 11/09/2026, 09:33:17
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int max_count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max_count = Math.max(max_count, count);
                count = 0;
            } else {
                count++;
            }
        }

        return max_count > count ? max_count : count;
    }
}