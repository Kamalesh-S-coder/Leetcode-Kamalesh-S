// Last updated: 11/08/2026, 20:55:39
class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0, xor2 = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            xor1 = xor1 ^ nums[i];
            xor2 = xor2 ^ i;
        }
        xor2 ^= n;
        return xor1^xor2;
    }
}
