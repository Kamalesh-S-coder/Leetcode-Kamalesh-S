// Last updated: 11/08/2026, 21:00:00
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int num : nums) {
            if (k < 2 || num != nums[k - 2]) {
                nums[k] = num;
                k++;
            }
        }
        return k;
    }
}