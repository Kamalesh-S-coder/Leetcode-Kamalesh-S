// Last updated: 11/08/2026, 21:00:10
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (mid <= high) {

            if (nums[mid] == 2) {
                swap(nums, mid, high--);
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, low++, mid++);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}