// Last updated: 11/08/2026, 14:21:39
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        int count = 0;
        if (nums.length < 3) return 0;

        // Fix each starting index i
        for (int i = 0; i < nums.length - 2; i++) {
            int diff = nums[i + 1] - nums[i];

            // Extend the window while the difference matches
            for (int j = i + 1; j < nums.length - 1; j++) {
                if ((nums[j + 1] - nums[j]) == diff) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;

    }
}