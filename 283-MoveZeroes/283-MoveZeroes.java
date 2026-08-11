// Last updated: 11/08/2026, 20:55:30
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0; 
        for (int num:nums){
            if(num != 0){
                nums[i] = num;
                i++;
            }
        }
        while(i<nums.length){
            nums[i] = 0;
            i++;
        }
    }
}