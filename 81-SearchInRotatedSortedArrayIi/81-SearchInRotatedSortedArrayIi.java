// Last updated: 11/08/2026, 20:59:54
class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) return true;

            // SPECIAL CASE: Handle duplicates where we can't decide the sorted half
            // If nums[start] == nums[mid] == nums[end], we can't tell which side is sorted.
            // We shrink the search space from both ends.
            if ((nums[mid] == nums[start]) && (nums[mid] == nums[end])) {
                start++;
                end--;
            } 
            // Check if Right Side is sorted
            else if (nums[mid] <= nums[end]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } 
            // Left Side must be sorted
            else { // nums[mid] >= nums[start]
                if (target >= nums[start] && nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }  
}