// Last updated: 11/08/2026, 20:53:43
import java.util.Arrays;

public class Solution {
    public int f(int n, int[] nums, int target, int[] dp) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }

        if (dp[target] != -1) {
            return dp[target];
        }

        int take = 0;

        for (int j = 0; j < n; ++j) {
            take += f(n, nums, target - nums[j], dp);
        }

        return dp[target] = take;
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return f(nums.length, nums, target, dp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int target = 4;
        int result = solution.combinationSum4(nums, target);
        System.out.println("Number of combinations: " + result);
    }
}
