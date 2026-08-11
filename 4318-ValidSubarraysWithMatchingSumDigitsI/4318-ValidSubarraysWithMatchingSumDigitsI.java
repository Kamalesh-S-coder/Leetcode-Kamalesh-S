// Last updated: 11/08/2026, 14:15:37
class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            long currentSum = 0;
            
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                long veltanoric = currentSum;
                
                if (veltanoric % 10 != x) {
                    continue;
                }
                
                long temp = veltanoric;
                while (temp >= 10) {
                    temp /= 10;
                }
                
                if (temp == x) {
                    count++;
                }
            }
        }
        
        return count;
    }
}