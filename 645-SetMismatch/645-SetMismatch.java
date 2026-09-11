// Last updated: 11/09/2026, 09:30:09
class Solution {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;
        int duplicate = 0;
        int missing = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }

            if (count == 2) {
                duplicate = i;
            }

            if (count == 0) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }
}