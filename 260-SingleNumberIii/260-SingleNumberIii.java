// Last updated: 11/08/2026, 20:55:48
class Solution {
    public int[] singleNumber(int[] nums) {

        // Example:
        // nums = [1, 2, 1, 3, 2, 5]
        // Unique numbers = 3 and 5

        int n = nums.length;

        // Step 1: XOR all elements
        // duplicates cancel out → only (a ^ b) remains

        int xorr = 0;

        // Dry run:
        // xorr = 1 ^ 2 ^ 1 ^ 3 ^ 2 ^ 5
        //      = (1^1) ^ (2^2) ^ (3^5)
        //      = 0 ^ 0 ^ (3^5)
        //      = 3 ^ 5 = 6 → (110 in binary)

        for(int num : nums){
            xorr ^= num;
        }

        // Step 2: Find rightmost set bit in (a ^ b)
        // mask isolates a bit where a and b differ

        // xorr = 6 → 110
        // -xorr = two's complement → 010
        // mask = 110 & 010 = 010

        int mask = xorr & (-xorr); // rightmost set bit in (a^b), i.e, the rightmost bit that differs in (a, b)

        // This bit ensures:
        // one number has this bit = 1
        // other has this bit = 0

        int xorr1 = 0; // group where bit is set
        int xorr2 = 0; // group where bit is unset

        // Step 3: divide numbers into 2 groups

        for(int num : nums){

            // Using mask to split:
            // mask = 010 (bit position 1)

            // Grouping:
            // numbers with bit 1 → group1
            // numbers with bit 0 → group2

            // Example grouping:
            // 1 (001) → group2
            // 2 (010) → group1
            // 1 (001) → group2
            // 3 (011) → group1
            // 2 (010) → group1
            // 5 (101) → group2

            if((num & mask) == 0){
                // group2 (bit NOT set)

                // xorr2 = 1 ^ 1 ^ 5
                //       = 0 ^ 5
                //       = 5

                xorr2 = xorr2 ^ num;

            }else{
                // group1 (bit set)

                // xorr1 = 2 ^ 3 ^ 2
                //       = 0 ^ 3
                //       = 3

                xorr1 = xorr1 ^ num;
            }
        }

        // Final:
        // xorr1 = 3
        // xorr2 = 5

        return new int[]{xorr1, xorr2};
    }
}