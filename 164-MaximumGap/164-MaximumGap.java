// Last updated: 11/08/2026, 20:58:12
import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            ans = Math.max(ans, diff);  // Update the maximum gap
        }

        return ans;
    }
}