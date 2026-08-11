// Last updated: 11/08/2026, 14:21:09
class Solution {
    static final int LEN = 100_001; // Max possible value in nums

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int[] freq = new int[LEN]; // Frequency array to count occurrences

        // Step 1: Count frequency of each number
        for (int num : nums) {
            freq[num]++;
        }

        // Step 2: Find numbers that appear exactly twice
        for (int num : nums) {
            if (freq[num] == 2) {   // If number appears twice
                res.add(num);       // Add to result
            }
            freq[num]--; // Decrease count to avoid adding duplicates again
        }

        return res; // Return list of duplicates
    }
}