// Last updated: 11/08/2026, 20:55:21
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow != fast);
        slow=nums[0];
        while(slow != fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}