// Last updated: 11/09/2026, 09:31:43
class Solution {
    public int arrayPairSum(int[] nums) {
       Arrays.sort(nums);
       int sum=0;
       for(int i=0;i<nums.length;i+=2)
       {
        sum+=nums[i];
       }
       return sum;
    }
}