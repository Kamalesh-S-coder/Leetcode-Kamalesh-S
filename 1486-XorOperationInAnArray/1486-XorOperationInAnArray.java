// Last updated: 11/09/2026, 09:26:43
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
