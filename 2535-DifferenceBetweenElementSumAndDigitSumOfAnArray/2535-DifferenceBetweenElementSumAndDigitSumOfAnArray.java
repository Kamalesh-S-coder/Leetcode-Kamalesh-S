// Last updated: 11/09/2026, 09:26:05
class Solution {

    public int differenceOfSum(int[] nums) {

        int elementSum = 0;
        int digitSum = 0;

        for (int num : nums) {

            elementSum += num;

            int temp = num;

            while (temp != 0) {
                digitSum += temp % 10;
                temp /= 10;
            }
        }

        return Math.abs(elementSum - digitSum);
    }
}