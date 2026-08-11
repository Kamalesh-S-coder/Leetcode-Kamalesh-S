// Last updated: 11/08/2026, 21:00:32
class Solution {

    public int[] plusOne(int[] digits) {

        // Traverse from last digit
        for (int i = digits.length - 1;
             i >= 0;
             i--) {

            /*
             * If digit is less than 9,
             * increment and return
             */

            if (digits[i] < 9) {

                digits[i]++;

                return digits;
            }

            /*
             * Digit becomes 0
             * due to carry
             */

            digits[i] = 0;
        }

        /*
         * All digits were 9
         * create new array
         */

        int[] ans =
            new int[digits.length + 1];

        ans[0] = 1;

        return ans;
    }
}