// Last updated: 11/08/2026, 20:56:23
import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashSet to store elements within the sliding window of size k
        HashSet<Integer> set = new HashSet<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element already exists in the set, return true (duplicate found)
            if (set.contains(nums[i])) return true;

            // Add the current element to the set
            set.add(nums[i]);

            // Maintain the sliding window size of at most 'k'
            // If the set size exceeds 'k', remove the element that is out of range
            if (set.size() > k) {
                set.remove(nums[i - k]); // Remove the element at distance 'k' behind the current index
            }
        }
        
        // If no duplicate is found within the given range, return false
        return false;
    }
}
