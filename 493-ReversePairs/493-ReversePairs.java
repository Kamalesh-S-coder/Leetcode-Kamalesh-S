// Last updated: 11/09/2026, 09:33:08
class Solution {

    int count = 0;

    public int reversePairs(int[] nums) {
        int n = nums.length;

        divide(nums, 0, n-1);

        return count;
    }

    public void conquer(int[] nums, int low, int mid, int high) {

        int[] merged = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int x = 0;

        while(i <= mid) {

            while(j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }

            count += j - (mid + 1);
            i++;
        }

        i = low;
        j = mid + 1;

        while(i <= mid && j <= high) {

            if(nums[i] <= nums[j]) {
                merged[x++] = nums[i++];
            } else {
                merged[x++] = nums[j++];
            }
        }

        while(i <= mid) {
            merged[x++] = nums[i++];
        }

        while(j <= high) {
            merged[x++] = nums[j++];
        }

        for(i = 0, j = low; i < merged.length; i++, j++) {
            nums[j] = merged[i];
        }
    }

    public void divide(int[] nums, int low, int high) {

        if(low >= high) return;

        int mid = low + (high - low) / 2;

        divide(nums, low, mid);
        divide(nums, mid + 1, high);

        conquer(nums, low, mid, high);
    }
}