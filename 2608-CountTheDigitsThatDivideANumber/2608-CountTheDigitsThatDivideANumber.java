// Last updated: 11/08/2026, 14:16:45
class Solution {
    public int countDigits(int num) {
        int tempNum = num;
        int divisors = 0;

        while(tempNum != 0){
            int lastDigit = tempNum % 10;
             if(lastDigit != 0 && num % lastDigit == 0){
                divisors++;
            }
            tempNum /= 10;
        }

        return divisors;
    }
}