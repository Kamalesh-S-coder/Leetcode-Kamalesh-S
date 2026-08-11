// Last updated: 11/08/2026, 21:02:11
import java.util.*;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        // Stores all unique quadruplets
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        // Need at least 4 elements
        if (n < 4) {
            return result;
        }

        // Sort the array
        Arrays.sort(nums);

        // Fix the first element
        for (int first = 0; first < n - 3; first++) {

            // Skip duplicate first elements
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            // Fix the second element
            for (int second = first + 1; second < n - 2; second++) {

                // Skip duplicate second elements
                if (second > first + 1 &&
                    nums[second] == nums[second - 1]) {
                    continue;
                }

                // Two pointers for the remaining two elements
                int left = second + 1;
                int right = n - 1;

                while (left < right) {

                    // Use long to prevent integer overflow
                    long sum = (long) nums[first]
                             + nums[second]
                             + nums[left]
                             + nums[right];

                    // Quadruplet found
                    if (sum == target) {

                        result.add(Arrays.asList(
                                nums[first],
                                nums[second],
                                nums[left],
                                nums[right]
                        ));

                        // Move both pointers inward
                        left++;
                        right--;

                        // Skip duplicate third elements
                        while (left < right &&
                               nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicate fourth elements
                        while (left < right &&
                               nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }

                    // Need a larger sum
                    else if (sum < target) {
                        left++;
                    }

                    // Need a smaller sum
                    else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}