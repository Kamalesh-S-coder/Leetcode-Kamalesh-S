// Last updated: 11/08/2026, 14:16:28
class Solution {
    public int differenceOfSums(int n, int m) {
        // Initialize variables to store the sums
        int divisibleSum = 0;     // Sum of numbers divisible by m
        int nonDivisibleSum = 0;  // Sum of numbers not divisible by m

        // Loop through the numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check if the current number (i) is divisible by m
            if (i % m == 0) {
                // If it's divisible, add it to divisibleSum
                divisibleSum += i;
            } else {
                // If it's not divisible, add it to nonDivisibleSum
                nonDivisibleSum += i;
            }
        }

        // Calculate and return the difference between the two sums
        return nonDivisibleSum - divisibleSum; // The result
    }
}