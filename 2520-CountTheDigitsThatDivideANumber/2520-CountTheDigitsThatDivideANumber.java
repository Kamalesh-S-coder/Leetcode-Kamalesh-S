// Last updated: 11/09/2026, 09:26:08
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