// Last updated: 11/08/2026, 14:17:21
class Solution {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n]; // Create an array of size n
        int xor = 0;             // Initialize result for XOR

        // Fill the array and compute XOR simultaneously
        for (int i = 0; i < nums.length; i++) {
            nums[i] = start + 2 * i; // Generate each element as per the rule
            xor ^= nums[i];         // Apply XOR with current element
        }

        return xor; // Return the final XOR result
    }
}
